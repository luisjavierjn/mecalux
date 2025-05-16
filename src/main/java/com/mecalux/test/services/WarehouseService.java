package com.mecalux.test.services;

import com.mecalux.test.domain.dto.WarehouseDTO;
import com.mecalux.test.domain.entities.Warehouse;
import com.mecalux.test.domain.enums.FamilyType;
import com.mecalux.test.domain.requests.WarehouseRequest;
import com.mecalux.test.repositories.WarehouseRepository;
import com.mecalux.test.services.factories.permutation.PermutationFactory;
import com.mecalux.test.services.mappers.WarehouseMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class WarehouseService {
	private final WarehouseRepository warehouseRepository;
	private final WarehouseMapper warehouseMapper;
	private final EnumMap<FamilyType, PermutationFactory> permutationFactories;

	public WarehouseDTO add(WarehouseRequest request) {
		final Warehouse warehouse = this.warehouseMapper.toEntity(request);
		final Warehouse retWarehouse = this.warehouseRepository.save(warehouse);
		return this.warehouseMapper.toDTO(retWarehouse);
	}

	public List<WarehouseDTO> getAll() {
		return StreamSupport.stream(this.warehouseRepository.findAll().spliterator(), false)
				.map(this.warehouseMapper::toDTO).collect(Collectors.toList());
	}

	public Page<WarehouseDTO> getAll(int page, int size) {
		return this.warehouseRepository.findAll(PageRequest.of(page, size)).map(this.warehouseMapper::toDTO);
	}

	public WarehouseDTO getById(Integer id) {
		return this.warehouseRepository.findById(id).map(this.warehouseMapper::toDTO)
				.orElseThrow(() -> new EntityNotFoundException("Warehouse not found"));
	}

	public List<String> getPermutations(Integer id) {
		return this.warehouseRepository.findById(id).map(w -> {
			final String family = w.getFamily();
			final PermutationFactory factory = this.permutationFactories.get(FamilyType.fromString(family));
			return factory.generate(w.getSize());
		}).orElseThrow(() -> new EntityNotFoundException("Warehouse not found"));
	}

	public WarehouseDTO update(Integer id, @Valid WarehouseRequest request) {
		final Warehouse warehouse = this.warehouseRepository.findById(id).map(w -> {
			w.setUuid(request.getUuid());
			w.setClient(request.getClient());
			w.setFamily(request.getFamilyType().name());
			w.setSize(request.getSize());
			return w;
		}).orElseThrow(() -> new EntityNotFoundException("Warehouse not found"));
		final Warehouse retWarehouse = this.warehouseRepository.save(warehouse);
		return this.warehouseMapper.toDTO(retWarehouse);
	}

	public void delete(Integer id) {
		this.warehouseRepository.deleteById(id);
	}

}
