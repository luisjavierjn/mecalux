package com.mecalux.test.domain.dto;

import lombok.Data;

@Data
public class RackDTO {
  private Integer id;
  private WarehouseDTO warehouseDTO;
  private String uuid;
  private String type;
}
