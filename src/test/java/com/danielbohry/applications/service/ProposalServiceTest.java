package com.danielbohry.applications.service;

import com.danielbohry.applications.domain.Proposal;
import com.danielbohry.applications.repository.ProposalRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.util.Assert.isTrue;

@TestInstance(PER_CLASS)
public class ProposalServiceTest {

  private static final String ERROR_MESSAGE = "result is different than expected";
  private ProposalRepository repository;
  private ProposalService service;

  @BeforeAll
  void setup() {
    repository = mock(ProposalRepository.class);
    service = new ProposalService(repository);
  }

  @Test
  void shouldGetCountOfProposals() {
    //given
    when(repository.count()).thenReturn(1000L);

    //when
    Long result = service.count();

    //then
    isTrue(result == 1000L, ERROR_MESSAGE);
  }

  @Test
  void shouldGetProposalById() {
    //given
    String id = "1";
    Proposal proposal = Proposal.builder()
        .id(id)
        .build();
    when(repository.findById(id)).thenReturn(proposal);

    //when
    Proposal result = service.get(id);

    //then
    isTrue(result == proposal, ERROR_MESSAGE);
  }

}
