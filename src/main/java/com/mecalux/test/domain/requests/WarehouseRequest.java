package com.mecalux.test.domain.requests;

import com.mecalux.test.domain.enums.FamilyType;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class WarehouseRequest {
	private String uuid;
	private String client;
	private FamilyType familyType;
	@Min(value = 1, message = "The size must be greater than zero")
	private Integer size;
}
