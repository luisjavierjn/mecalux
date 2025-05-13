package com.mecalux.test.services.factories.rack;

import com.mecalux.test.domain.entities.Rack;
import com.mecalux.test.domain.entities.Warehouse;
import com.mecalux.test.domain.enums.RackType;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Set;

public class EstRackFactory implements RackFactory {
	private final Set<RackType> allowed;

	public EstRackFactory(@Qualifier("allowedEstAllowed") Set<RackType> allowed) {
		this.allowed = allowed;
	}

	@Override
	public Rack createRack(String uuid, RackType type, Warehouse warehouse) {
		if (!this.allowed.contains(type)) {
			throw new IllegalArgumentException("Tipo no permitido en EST: " + type);
		}
		return new Rack(uuid, type.name(), warehouse);
	}
}
