package com.mecalux.test.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RackDTO {
  private Integer id;
  @JsonProperty("warehouse")
  private WarehouseDTO warehouseDTO;
  private String uuid;
  private String type;
}
