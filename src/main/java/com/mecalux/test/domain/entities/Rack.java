package com.mecalux.test.domain.entities;

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
import lombok.Setter;

@Entity
@Table(name = "RACKS")
@Getter
@Setter
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

	public Rack(String uuid, String type, Warehouse warehouse) {
		this.uuid = uuid;
		this.type = type;
		this.warehouse = warehouse;
	}
}
