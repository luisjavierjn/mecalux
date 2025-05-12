package com.mecalux.test.domain.requests;

import com.mecalux.test.domain.enums.RackType;
import lombok.Data;

@Data
public class RackRequest {
  private Integer id;
  private Integer warehouseId;
  private String uuid;
  private RackType rackType;
}
