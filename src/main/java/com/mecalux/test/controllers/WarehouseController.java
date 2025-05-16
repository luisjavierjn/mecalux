package com.mecalux.test.controllers;

import com.mecalux.test.domain.requests.WarehouseRequest;
import com.mecalux.test.services.WarehouseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/all/paged")
	public ResponseEntity<?> getAll(@RequestParam int page, @RequestParam int size) {
		log.debug("{} Getting paged warehouses", LOG_PREFIX);
		return ResponseEntity.ok(this.warehouseService.getAll(page, size));
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

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid WarehouseRequest request) {
		log.debug("{} Updating warehouse with id: {} and request: {}", LOG_PREFIX, id, request);
		return ResponseEntity.ok(this.warehouseService.update(id, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		log.debug("{} Deleting warehouse with id: {}", LOG_PREFIX, id);
		this.warehouseService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
