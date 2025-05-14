package com.mecalux.test.controllers;

import com.mecalux.test.domain.requests.RackRequest;
import com.mecalux.test.services.RackService;
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
@RequestMapping("/rack")
@RequiredArgsConstructor
@Slf4j
public class RackController {
	private static final String LOG_PREFIX = "[RACK REST CONTROLLER]";

	private final RackService rackService;

	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Valid RackRequest request) {
		log.debug("{} Adding rack with request: {}", LOG_PREFIX, request);
		return ResponseEntity.ok(this.rackService.add(request));
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		log.debug("{} Getting racks", LOG_PREFIX);
		return ResponseEntity.ok(this.rackService.getAll());
	}

	@GetMapping("/warehouse/{warehouseId}/paged")
	public ResponseEntity<?> getByWarehouseId(@PathVariable Integer warehouseId, @RequestParam int page,
			@RequestParam int size) {
		log.debug("{} Getting paged racks by warehouse id: {}, page: {}, size: {}", LOG_PREFIX, warehouseId, page,
				size);
		return ResponseEntity.ok(this.rackService.getByWarehouseId(warehouseId, page, size));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		log.debug("{} Getting rack with id: {}", LOG_PREFIX, id);
		return ResponseEntity.ok(this.rackService.getById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid RackRequest request) {
		log.debug("{} Updating rack with id: {} and request: {}", LOG_PREFIX, id, request);
		return ResponseEntity.ok(this.rackService.update(id, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		log.debug("{} Deleting rack with id: {}", LOG_PREFIX, id);
		this.rackService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
