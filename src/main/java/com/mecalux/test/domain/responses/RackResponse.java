package com.mecalux.test.domain.responses;

import lombok.Data;

@Data
public class RackResponse {
  private Integer id;
  private Integer warehouseId;
  private String uuid;
  private String type;
}
