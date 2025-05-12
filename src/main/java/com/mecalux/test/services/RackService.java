package com.mecalux.test.services;

import com.mecalux.test.domain.dto.RackDTO;
import com.mecalux.test.domain.entities.Rack;
import com.mecalux.test.domain.entities.Warehouse;
import com.mecalux.test.domain.enums.FamilyType;
import com.mecalux.test.domain.requests.RackRequest;
import com.mecalux.test.repositories.RackRepository;
import com.mecalux.test.repositories.WarehouseRepository;
import com.mecalux.test.services.factories.RackFactory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.EnumMap;

@Service
@RequiredArgsConstructor
public class RackService {
  private final RackRepository rackRepository;
  private final WarehouseRepository warehouseRepository;
  private final EnumMap<FamilyType, RackFactory> rackFactories;
  private final ModelMapper modelMapper;

  public RackDTO add(RackRequest rackRequest) {
    final Warehouse warehouse = this.warehouseRepository.getReferenceById(rackRequest.getWarehouseId());
    final RackFactory factory = this.rackFactories.get(FamilyType.fromString(warehouse.getFamily()));
    final Rack rack = factory.createRack(rackRequest.getRackType(), warehouse);
    final Rack retRack = this.rackRepository.save(rack);
    return this.modelMapper.map(retRack, RackDTO.class);
  }
}
