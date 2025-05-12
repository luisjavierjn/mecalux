package com.mecalux.test.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

  @OneToMany(
          mappedBy = "warehouse",
          cascade = CascadeType.ALL,
          orphanRemoval = true,
          fetch = FetchType.LAZY
  )
  private final List<Rack> racks = new ArrayList<>();
}
