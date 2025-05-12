package com.mecalux.test.services.factories;

import com.mecalux.test.domain.entities.Rack;
import com.mecalux.test.domain.entities.Warehouse;
import com.mecalux.test.domain.enums.RackType;

public interface RackFactory {
  Rack createRack(String uuid, RackType type, Warehouse warehouse);
}
