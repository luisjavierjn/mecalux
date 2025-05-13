package com.mecalux.test.controllers;

import com.mecalux.test.domain.requests.WarehouseRequest;
import com.mecalux.test.services.WarehouseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouse")
@RequiredArgsConstructor
@Slf4j
public class WarehouseController {
	private static final String LOG_PREFIX = "[WAREHOUSE REST CONTROLLER]";

	private final WarehouseService warehouseService;

	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Valid WarehouseRequest request) {
		log.debug("{} Adding warehouse with request: {}", LOG_PREFIX, request);
		return ResponseEntity.ok(this.warehouseService.add(request));
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		log.debug("{} Getting warehouses", LOG_PREFIX);
		return ResponseEntity.ok(this.warehouseService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		log.debug("{} Getting warehouse with id: {}", LOG_PREFIX, id);
		return ResponseEntity.ok(this.warehouseService.getById(id));
	}

	@GetMapping("/{id}/permutations")
	public ResponseEntity<?> getPermutations(@PathVariable Integer id) {
		log.debug("{} Getting permutations for warehouse with id: {}", LOG_PREFIX, id);
		return ResponseEntity.ok(this.warehouseService.getPermutations(id));
	}
}
