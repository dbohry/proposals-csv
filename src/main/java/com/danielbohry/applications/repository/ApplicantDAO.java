package com.danielbohry.applications.repository;

import com.danielbohry.applications.domain.Applicant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicantDAO extends PagingAndSortingRepository<Applicant, String> {
}
