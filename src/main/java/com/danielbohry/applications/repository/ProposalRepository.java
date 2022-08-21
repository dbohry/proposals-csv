package com.danielbohry.applications.repository;

import com.danielbohry.applications.domain.Proposal;
import com.danielbohry.applications.exception.CsvException;
import com.danielbohry.applications.exception.NotFoundException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.danielbohry.applications.repository.ProposalConverter.toBo;

@Repository
public class ProposalRepository {

  private final ProposalDAO dao;

  public ProposalRepository(ProposalDAO dao) {
    this.dao = dao;
    this.dao.saveAll(importCsv());
  }

  public List<Proposal> find(Pageable pageable) {
    List<Proposal> proposals = new ArrayList<>();
    dao.findAllByEthnicityNotLike(pageable, "Not applicable")
        .forEach(entity -> proposals.add(toBo(entity)));

    return proposals;
  }

  public List<Proposal> findDenied(Pageable pageable) {
    List<Proposal> proposals = new ArrayList<>();
    dao.findAllByWasProposalDenied(pageable, Boolean.TRUE)
        .forEach(entity -> proposals.add(toBo(entity)));

    return proposals;
  }

  public Proposal findById(String id) {
    ProposalEntity proposal = dao.findById(id)
        .orElseThrow(() -> new NotFoundException("Not found"));

    return toBo(proposal);
  }

  public Long count() {
    return dao.count();
  }

  private List<ProposalEntity> importCsv() {
    try {
      final CsvMapper mapper = new CsvMapper();
      final CsvSchema schema = CsvSchema.emptySchema().withHeader();

      MappingIterator<ProposalEntity> data = mapper.readerFor(ProposalEntity.class)
          .with(schema)
          .readValues(new File("./data.csv"));

      return data.readAll();
    } catch (IOException e) {
      throw new CsvException("Failed to import csv", e);
    }
  }

}
