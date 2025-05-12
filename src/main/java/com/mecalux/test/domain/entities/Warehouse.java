package com.mecalux.test.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "WAREHOUSES")
@Getter
@Setter
@NoArgsConstructor
public class Warehouse {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "UUID", nullable = false, length = 36)
  private String uuid; // = UUID.randomUUID().toString();

  @Column(name = "CLIENT", nullable = false, length = 50)
  private String client;

  @Column(name = "FAMILY", nullable = false, length = 3)
  private String family;

  @Column(name = "SIZE", nullable = false)
  private Integer size;
}
