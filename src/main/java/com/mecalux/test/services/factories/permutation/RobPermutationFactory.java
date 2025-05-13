package com.mecalux.test.services.factories.permutation;

import com.mecalux.test.domain.enums.RackType;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Set;

public class RobPermutationFactory implements PermutationFactory {
	private final PermutationStrategy permutationStrategy;

	public RobPermutationFactory(@Qualifier("allowedRobAllowed") Set<RackType> allowed) {
		this.permutationStrategy = new PermutationStrategy(this.transformToList(allowed));
	}

	@Override
	public List<String> generate(int size) {
		return this.permutationStrategy.generate(size);
	}
}
