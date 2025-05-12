package com.mecalux.test.domain.enums;

public enum FamilyType {
  EST, ROB;

  public static FamilyType fromString(String type) {
    if (type == null) {
      throw new IllegalArgumentException("WarehouseType no puede ser null");
    }
    try {
      return FamilyType.valueOf(type.trim().toUpperCase());
    } catch (final IllegalArgumentException e) {
      throw new IllegalArgumentException("Tipo de Warehouse inválido: " + type, e);
    }
  }
}
