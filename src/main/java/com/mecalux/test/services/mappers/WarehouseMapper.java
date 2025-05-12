package com.mecalux.test.services.mappers;

import com.mecalux.test.domain.dto.WarehouseDTO;
import com.mecalux.test.domain.entities.Warehouse;
import com.mecalux.test.domain.enums.FamilyType;
import com.mecalux.test.domain.requests.WarehouseRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WarehouseMapper {

  @Mapping(source = "familyType", target = "family", qualifiedByName = "familyTypeToString")
  Warehouse toEntity(WarehouseRequest warehouseRequest);

  @Named("familyTypeToString")
  static String familyTypeToString(FamilyType familyType) {
    return Optional.ofNullable(familyType)
            .map(FamilyType::name)
            .orElse(null);
  }

  WarehouseDTO toDTO(Warehouse warehouse);

}
