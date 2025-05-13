package com.mecalux.test.controllers;

import com.mecalux.test.domain.requests.RackRequest;
import com.mecalux.test.services.RackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/all")
  public ResponseEntity<?> getAll() {
    return ResponseEntity.ok(this.rackService.getAll());
  }

  @GetMapping("/warehouse/{warehouseId}")
  public ResponseEntity<?> getByWarehouseId(@PathVariable Integer warehouseId) {
    return ResponseEntity.ok(this.rackService.getByWarehouseId(warehouseId));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Integer id) {
    return ResponseEntity.ok(this.rackService.getById(id));
  }
}
