package com.mecalux.test.domain.enums;

public enum RackType {
  A, B, C, D;

  public static RackType fromString(String type) {
    if (type == null) {
      throw new IllegalArgumentException("RackType no puede ser null");
    }
    try {
      return RackType.valueOf(type.trim().toUpperCase());
    } catch (final IllegalArgumentException e) {
      throw new IllegalArgumentException("Tipo de Rack inválido: " + type, e);
    }
  }
}
