package com.danielbohry.applications.repository;

import com.danielbohry.applications.domain.Applicant;
import com.danielbohry.applications.domain.Proposal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.springframework.util.Assert.isTrue;

@TestInstance(PER_CLASS)
public class ProposalConverterTest {

  @Test
  void shouldConvertEntityToBO() {
    //given
    ProposalEntity entity = new ProposalEntity();
    entity.setId("1");
    entity.setEthnicity("ethnicity");
    entity.setRace("race");
    entity.setSex("sex");
    entity.setIncome("90");

    Proposal expected = Proposal.builder()
        .id("1")
        .applicant(Applicant.builder().ethnicity("ethnicity").race("race").sex("sex").build())
        .coApplicant(null)
        .income(90000L)
        .build();

    //when
    Proposal result = ProposalConverter.toBo(entity);

    //then
    isTrue(result.equals(expected), "received: " + result + " expected: " + expected.toString());
  }

}
