package com.danielbohry.applications.api;

import com.danielbohry.applications.domain.Applicant;
import com.danielbohry.applications.service.ApplicantService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.danielbohry.applications.api.ApplicantDTO.toDto;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("applicants")
@AllArgsConstructor
public class ApplicantController {

  private final ApplicantService service;

  @GetMapping
  public ResponseEntity<List<ApplicantDTO>> get(Pageable pageable) {
    List<ApplicantDTO> result = service.getAll(pageable).stream()
        .map(ApplicantDTO::toDto)
        .collect(toList());

    return ResponseEntity.ok(result);
  }

  @GetMapping("{id}")
  public ResponseEntity<ApplicantDTO> get(@PathVariable String id) {
    ApplicantDTO result = toDto(service.get(id));
    return ResponseEntity.ok(result);
  }

  @GetMapping("count")
  public ResponseEntity<Long> count() {
    return ResponseEntity.ok(service.count());
  }

}
