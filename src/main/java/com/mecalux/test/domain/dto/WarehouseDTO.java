package com.mecalux.test.domain.dto;

import com.mecalux.test.domain.entities.Rack;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class WarehouseDTO {
  private Integer id;
  private String uuid;
  private String client;
  private String family;
  private Integer size;
//  private final List<Rack> racks = new ArrayList<>();
}
