package com.mecalux.test.services;

import com.mecalux.test.domain.dto.WarehouseDTO;
import com.mecalux.test.domain.entities.Warehouse;
import com.mecalux.test.domain.enums.FamilyType;
import com.mecalux.test.domain.requests.WarehouseRequest;
import com.mecalux.test.repositories.WarehouseRepository;
import com.mecalux.test.services.factories.permutation.PermutationFactory;
import com.mecalux.test.services.mappers.WarehouseMapper;
import lombok.RequiredArgsConstructor;
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

	public WarehouseDTO getById(Integer id) {
		return this.warehouseRepository.findById(id).map(this.warehouseMapper::toDTO)
				.orElseThrow(() -> new IllegalArgumentException("Rack no encontrado"));
	}

	public List<String> getPermutations(Integer id) {
		return this.warehouseRepository.findById(id).map(w -> {
			final String family = w.getFamily();
			final PermutationFactory factory = this.permutationFactories.get(FamilyType.fromString(family));
			return factory.generate(w.getSize());
		}).orElseThrow(() -> new IllegalArgumentException("Familia no soportada"));
	}
}
