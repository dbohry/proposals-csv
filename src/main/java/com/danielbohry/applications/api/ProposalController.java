package com.danielbohry.applications.api;

import com.danielbohry.applications.domain.Proposal;
import com.danielbohry.applications.service.ProposalService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("proposals")
@AllArgsConstructor
public class ProposalController {

  private final ProposalService service;

  @GetMapping
  public ResponseEntity<List<Proposal>> get(Pageable pageable) {
    List<Proposal> result = service.get(pageable);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/denied")
  public ResponseEntity<List<Proposal>> getDenied(Pageable pageable) {
    List<Proposal> result = service.getDenied(pageable);
    return ResponseEntity.ok(result);
  }

  @GetMapping("{id}")
  public ResponseEntity<Proposal> get(@PathVariable String id) {
    Proposal result = service.get(id);
    return ResponseEntity.ok(result);
  }

  @GetMapping("count")
  public ResponseEntity<Long> count() {
    return ResponseEntity.ok(service.count());
  }

}
