package com.mecalux.test;

import com.mecalux.test.domain.enums.FamilyType;
import com.mecalux.test.services.factories.EstRackFactory;
import com.mecalux.test.services.factories.RackFactory;
import com.mecalux.test.services.factories.RobRackFactory;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.EnumMap;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Bean
	public EnumMap<FamilyType, RackFactory> rackFactories() {
		final EnumMap<FamilyType, RackFactory> rackFactories;
		rackFactories = new EnumMap<>(FamilyType.class);
		rackFactories.put(FamilyType.EST, new EstRackFactory());
		rackFactories.put(FamilyType.ROB, new RobRackFactory());
		return rackFactories;
	}

}
