package com.mecalux.test.services.mappers;

import com.mecalux.test.domain.dto.RackDTO;
import com.mecalux.test.domain.entities.Rack;
import com.mecalux.test.domain.responses.RackResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RackMapper {

  @Mapping(source = "warehouse", target = "warehouseDTO")
  RackDTO toDTO(Rack rack);

  @Mapping(source = "warehouse.id", target = "warehouseId")
  RackResponse toResponse(Rack rack);
}
