package com.mecalux.test.domain.entities;

import com.mecalux.test.domain.enums.RackType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

//public class Rack {
//  private final UUID uuid;
//  @Getter
//  private final RackType type;
//  public Rack(RackType type) {
//    this.uuid = UUID.randomUUID();
//    this.type = type;
//  }
//}

import jakarta.persistence.*;
        import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "RACKS")
@Getter
@NoArgsConstructor
public class Rack {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "WAREHOUSE_ID", nullable = false)
  private Warehouse warehouse;

  @Column(name = "UUID", nullable = false, length = 36)
  private String uuid;

  @Column(name = "TYPE", nullable = false, length = 1)
  private String type;

  public Rack(String uuid, RackType type, Warehouse warehouse) {
    this.uuid = uuid;
    this.type = type.name();
    this.warehouse = warehouse;
  }
}
