package com.danielbohry.applications.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@JsonInclude(NON_NULL)
public class Proposal {

  private String id;
  private Applicant applicant;
  private Applicant coApplicant;
  private Long income;
  private String county;
  private String denialReason;
  private Boolean wasProposalDenied;

}
