package com.mecalux.test.controllers;

import com.mecalux.test.domain.requests.RackRequest;
import com.mecalux.test.services.RackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rack")
@RequiredArgsConstructor
public class RackController {
  private final RackService rackService;

  @PostMapping
  public ResponseEntity<?> add(@RequestBody @Valid RackRequest request) {
      return ResponseEntity.ok(this.rackService.add(request));
  }
}
