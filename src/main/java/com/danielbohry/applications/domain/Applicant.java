package com.danielbohry.applications.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Applicant {

  @Id
  private String id = UUID.randomUUID().toString();

  @JsonProperty("applicant_ethnicity_name")
  private String ethnicity;
  @JsonProperty("applicant_race_name_1")
  private String race;
  @JsonProperty("applicant_sex_name")
  private String sex;
  @JsonProperty("applicant_income_000s")
  private Long income;

  @JsonProperty("county_name")
  private String county;

  @JsonProperty("co_applicant_ethnicity_name")
  private Boolean hasCoApplicant;

  @JsonProperty("denial_reason_name_1")
  private Boolean wasProposalDenied;

  public void setIncome(String income) {
    this.income = Objects.equals(income, "NA")
        ? 0L
        : Long.parseLong(income);
  }

  public void setHasCoApplicant(String coApplicant) {
    this.hasCoApplicant = coApplicant.contains("No co-applicant");
  }

  public void setWasProposalDenied(String reason) {
    this.wasProposalDenied = Objects.equals(reason, "NA");
  }

}
