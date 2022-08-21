package com.danielbohry.applications.api;

import com.danielbohry.applications.domain.Applicant;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(NON_NULL)
public class ApplicantDTO {

  private String id;
  private String ethnicity;
  private String race;
  private String sex;
  private Long income;
  private String county;
  private boolean hasCoApplicant;
  private boolean wasProposalDenied;
  private String denialReason;

  public static ApplicantDTO toDto(Applicant bo) {
    return ApplicantDTO.builder()
        .id(bo.getId())
        .ethnicity(bo.getEthnicity())
        .race(bo.getRace())
        .sex(bo.getSex())
        .income(bo.getIncome())
        .county(bo.getCounty())
        .hasCoApplicant(bo.getHasCoApplicant())
        .wasProposalDenied(bo.getWasProposalDenied())
        .denialReason(bo.getDenialReason())
        .build();
  }

}
