package com.mecalux.test.services;

import com.mecalux.test.domain.dto.WarehouseDTO;
import com.mecalux.test.domain.entities.Warehouse;
import com.mecalux.test.domain.requests.WarehouseRequest;
import com.mecalux.test.repositories.WarehouseRepository;
import com.mecalux.test.services.mappers.WarehouseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarehouseService {
  private final WarehouseRepository warehouseRepository;
  private final WarehouseMapper warehouseMapper;

  public WarehouseDTO add(WarehouseRequest request) {
    final Warehouse warehouse = this.warehouseMapper.toEntity(request);
    final Warehouse retWarehouse = this.warehouseRepository.save(warehouse);
    return this.warehouseMapper.toDTO(retWarehouse);
  }
}
