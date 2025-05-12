package com.mecalux.test.domain.dto;

import com.mecalux.test.domain.entities.Warehouse;
import lombok.Data;

@Data
public class RackDTO {
  private Integer id;
  private Warehouse warehouse;
  private String uuid;
  private String type;
}
