package com.mecalux.test.services.factories;

import com.mecalux.test.domain.entities.Rack;
import com.mecalux.test.domain.entities.Warehouse;
import com.mecalux.test.domain.enums.RackType;

import java.util.EnumSet;
import java.util.Set;

public class EstRackFactory implements RackFactory {
  private static final Set<RackType> ALLOWED =
          EnumSet.of(RackType.A, RackType.B, RackType.C);

  @Override
  public Rack createRack(String uuid, RackType type, Warehouse warehouse) {
    if (!ALLOWED.contains(type)) {
      throw new IllegalArgumentException("Tipo no permitido en EST: " + type);
    }
    return new Rack(uuid, type.name(), warehouse);
  }
}
