package com.mecalux.test.domain.enums;

public enum FamilyType {
	EST, ROB;

	public static FamilyType fromString(String type) {
		if (type == null) {
			throw new IllegalArgumentException("WarehouseType cannot be null");
		}
		try {
			return FamilyType.valueOf(type.trim().toUpperCase());
		} catch (final IllegalArgumentException e) {
			throw new IllegalArgumentException("Warehouse type invalid: " + type, e);
		}
	}
}
