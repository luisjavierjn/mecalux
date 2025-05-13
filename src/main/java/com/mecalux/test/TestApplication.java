package com.mecalux.test;

import com.mecalux.test.domain.enums.FamilyType;
import com.mecalux.test.domain.enums.RackType;
import com.mecalux.test.services.factories.permutation.EstPermutationFactory;
import com.mecalux.test.services.factories.permutation.PermutationFactory;
import com.mecalux.test.services.factories.permutation.RobPermutationFactory;
import com.mecalux.test.services.factories.rack.EstRackFactory;
import com.mecalux.test.services.factories.rack.RackFactory;
import com.mecalux.test.services.factories.rack.RobRackFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Bean("allowedEstAllowed")
	public Set<RackType> allowedEstAllowed() {
		return EnumSet.of(RackType.A, RackType.B, RackType.C);
	}

	@Bean("allowedRobAllowed")
	public Set<RackType> allowedRobAllowed() {
		return EnumSet.of(RackType.A, RackType.C, RackType.D);
	}

	@Bean
	public EstRackFactory estRackFactory(@Qualifier("allowedEstAllowed") Set<RackType> allowed) {
		return new EstRackFactory(allowed);
	}

	@Bean
	public RobRackFactory robRackFactory(@Qualifier("allowedRobAllowed") Set<RackType> allowed) {
		return new RobRackFactory(allowed);
	}

	@Bean
	public EnumMap<FamilyType, RackFactory> rackFactories(EstRackFactory est, RobRackFactory rob) {
		final EnumMap<FamilyType, RackFactory> rackFactories;
		rackFactories = new EnumMap<>(FamilyType.class);
		rackFactories.put(FamilyType.EST, est);
		rackFactories.put(FamilyType.ROB, rob);
		return rackFactories;
	}

	@Bean
	public EstPermutationFactory estPermFactory(@Qualifier("allowedEstAllowed") Set<RackType> allowed) {
		return new EstPermutationFactory(allowed);
	}

	@Bean
	public RobPermutationFactory robPermFactory(@Qualifier("allowedRobAllowed") Set<RackType> allowed) {
		return new RobPermutationFactory(allowed);
	}

	@Bean
	public EnumMap<FamilyType, PermutationFactory> permFactories(EstPermutationFactory est, RobPermutationFactory rob) {
		final EnumMap<FamilyType, PermutationFactory> permFactories;
		permFactories = new EnumMap<>(FamilyType.class);
		permFactories.put(FamilyType.EST, est);
		permFactories.put(FamilyType.ROB, rob);
		return permFactories;
	}

}
