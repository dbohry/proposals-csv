package com.danielbohry.applications.repository;

import com.danielbohry.applications.domain.Applicant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicantDAO extends PagingAndSortingRepository<Applicant, String> {

  Page<Applicant> findAllByWasProposalDenied(Pageable pageable, Boolean wasProposalDenied);

}
