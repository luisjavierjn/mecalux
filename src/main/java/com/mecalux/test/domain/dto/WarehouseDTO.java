package com.mecalux.test.domain.dto;

import lombok.Data;
@Data
public class WarehouseDTO {
  private Integer id;
  private String uuid;
  private String client;
  private String family;
  private Integer size;
}
