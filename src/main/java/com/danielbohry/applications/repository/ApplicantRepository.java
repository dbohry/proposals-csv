package com.danielbohry.applications.repository;

import com.danielbohry.applications.domain.Applicant;
import com.danielbohry.applications.exception.CsvException;
import com.danielbohry.applications.exception.NotFoundException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class ApplicantRepository {

  private final ApplicantDAO dao;

  public ApplicantRepository(ApplicantDAO dao) {
    this.dao = dao;
    this.dao.saveAll(importCsv());
  }

  public Iterable<Applicant> find(Pageable pageable) {
    return dao.findAll(pageable);
  }

  public Applicant findById(String id) {
    return dao.findById(id)
        .orElseThrow(() -> new NotFoundException("Not found"));
  }

  public Long count() {
    return dao.count();
  }

  private List<Applicant> importCsv() {
    try {
      final CsvMapper mapper = new CsvMapper();
      final CsvSchema schema = CsvSchema.emptySchema().withHeader();

      MappingIterator<Applicant> data = mapper.readerFor(Applicant.class)
          .with(schema)
          .readValues(new File("./src/main/resources/data.csv"));

      return data.readAll();
    } catch (IOException e) {
      throw new CsvException("Failed to import csv", e);
    }
  }

}
