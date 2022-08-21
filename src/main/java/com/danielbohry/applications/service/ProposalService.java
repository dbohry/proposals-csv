package com.danielbohry.applications.service;

import com.danielbohry.applications.domain.Proposal;
import com.danielbohry.applications.repository.ProposalRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProposalService {

  private final ProposalRepository repository;

  public List<Proposal> get(Pageable pageable) {
    return repository.find(pageable);
  }

  public List<Proposal> getDenied(Pageable pageable) {
    return repository.findDenied(pageable);
  }

  public Proposal get(String id) {
    return repository.findById(id);
  }

  public Long count() {
    return repository.count();
  }

}
