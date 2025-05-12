package com.mecalux.test.domain.requests;

import com.mecalux.test.domain.enums.FamilyType;
import lombok.Data;

@Data
public class WarehouseRequest {
  private String uuid;
  private String client;
  private FamilyType familyType;
  private Integer size;
}
