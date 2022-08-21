package com.danielbohry.applications.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProposalDAO extends PagingAndSortingRepository<ProposalEntity, String> {

  Page<ProposalEntity> findAllByWasProposalDenied(Pageable pageable, Boolean wasProposalDenied);

  Page<ProposalEntity> findAllByEthnicityNot(Pageable pageable, String a);

}
