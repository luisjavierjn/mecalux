package com.mecalux.test.services.factories.permutation;

import com.mecalux.test.domain.enums.RackType;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface PermutationFactory {

	default List<String> transformToList(Set<RackType> allowed) {
		return allowed.stream().map(Enum::name).collect(Collectors.toList());
	}

	List<String> generate(int size);
}
