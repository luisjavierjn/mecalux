package com.mecalux.test.controllers;

import com.mecalux.test.domain.requests.WarehouseRequest;
import com.mecalux.test.services.WarehouseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouse")
@RequiredArgsConstructor
public class WarehouseController {
  private final WarehouseService warehouseService;

  @PostMapping
  public ResponseEntity<?> add(@RequestBody @Valid WarehouseRequest request) {
    return ResponseEntity.ok(this.warehouseService.add(request));
  }
}
