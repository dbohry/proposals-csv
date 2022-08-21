package com.danielbohry.applications.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Applicant {

  private String ethnicity;
  private String race;
  private String sex;

}
