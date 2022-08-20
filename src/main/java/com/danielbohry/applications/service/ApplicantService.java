package com.danielbohry.applications.service;

import com.danielbohry.applications.domain.Applicant;
import com.danielbohry.applications.repository.ApplicantRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ApplicantService {

  private final ApplicantRepository repository;

  public List<Applicant> getAll(Pageable pageable) {
    List<Applicant> applicants = new ArrayList<>();
    repository.find(pageable)
        .forEach(applicants::add);
    return applicants;
  }

  public Applicant get(String id) {
    return repository.findById(id);
  }

  public Long count() {
    return repository.count();
  }

}
