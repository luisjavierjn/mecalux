package com.mecalux.test.services;

import com.mecalux.test.domain.dto.RackDTO;
import com.mecalux.test.domain.entities.Rack;
import com.mecalux.test.domain.entities.Warehouse;
import com.mecalux.test.domain.enums.FamilyType;
import com.mecalux.test.domain.requests.RackRequest;
import com.mecalux.test.repositories.RackRepository;
import com.mecalux.test.repositories.WarehouseRepository;
import com.mecalux.test.services.factories.RackFactory;
import com.mecalux.test.services.mappers.RackMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class RackService {
  private final RackRepository rackRepository;
  private final WarehouseRepository warehouseRepository;
  private final EnumMap<FamilyType, RackFactory> rackFactories;
  private final RackMapper rackMapper;
  private final ModelMapper modelMapper;

  public RackDTO add(RackRequest request) {
    final Optional<Warehouse> warehouseOpt = this.warehouseRepository.findById(request.getWarehouseId());
    final RackFactory factory = warehouseOpt
            .map(Warehouse::getFamily)
            .map(FamilyType::fromString)
            .map(this.rackFactories::get)
            .orElseThrow(() -> new IllegalArgumentException(
                    "Familia no soportada: " + warehouseOpt.map(Warehouse::getFamily).orElse("unknown")
            ));
    final Rack rack = factory.createRack(request.getUuid(), request.getRackType(), warehouseOpt.get());
    final Rack retRack = this.rackRepository.save(rack);
    return this.rackMapper.toDTO(retRack);
  }

  public List<RackDTO> getAll() {
    return StreamSupport.stream(this.rackRepository.findAll().spliterator(), false)
            .map(this.rackMapper::toDTO)
            .collect(Collectors.toList());
  }
}
