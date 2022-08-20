package com.danielbohry.applications.api;

import com.danielbohry.applications.domain.Applicant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicantDTO {

  private String id;
  private String ethnicity;
  private String race;
  private String sex;
  private Long income;
  private String county;

  public static ApplicantDTO toDto(Applicant bo) {
    return ApplicantDTO.builder()
        .id(bo.getId())
        .ethnicity(bo.getEthnicity())
        .race(bo.getRace())
        .sex(bo.getSex())
        .income(bo.getIncome())
        .county(bo.getCounty())
        .build();
  }

}
