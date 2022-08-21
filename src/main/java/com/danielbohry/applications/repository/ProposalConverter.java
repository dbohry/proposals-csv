package com.danielbohry.applications.repository;

import com.danielbohry.applications.domain.Applicant;
import com.danielbohry.applications.domain.Proposal;

public class ProposalConverter {

  public static Proposal toBo(ProposalEntity entity) {
    return Proposal.builder()
        .id(entity.getId())
        .applicant(buildApplicant(entity))
        .coApplicant(buildCoApplicant(entity))
        .income(entity.getIncome() != 0 ? entity.getIncome() * 1000 : 0)
        .county(entity.getCounty())
        .wasProposalDenied(entity.getWasProposalDenied())
        .denialReason(entity.getDenialReason())
        .build();
  }

  private static Applicant buildApplicant(ProposalEntity entity) {
    return Applicant.builder()
        .ethnicity(entity.getEthnicity())
        .race(entity.getRace())
        .sex(entity.getSex())
        .build();
  }

  private static Applicant buildCoApplicant(ProposalEntity entity) {
    if (entity.getCoEthnicity().equals("No co-applicant")) {
      return null;
    }

    return Applicant.builder()
        .ethnicity(entity.getCoEthnicity())
        .race(entity.getCoRace())
        .sex(entity.getCoSex())
        .build();
  }

}
