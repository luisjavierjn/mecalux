package com.mecalux.test.services.factories;

import com.mecalux.test.domain.entities.Rack;
import com.mecalux.test.domain.entities.Warehouse;
import com.mecalux.test.domain.enums.RackType;

import java.util.EnumSet;
import java.util.Set;

public class RobRackFactory implements RackFactory {
  private static final Set<RackType> ALLOWED =
          EnumSet.of(RackType.A, RackType.C, RackType.D);

  @Override
  public Rack createRack(RackType type, Warehouse warehouse) {
    if (!ALLOWED.contains(type)) {
      throw new IllegalArgumentException("Tipo no permitido en ROB: " + type);
    }
    return new Rack(type, warehouse);
  }
}