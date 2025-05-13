package com.mecalux.test.services.factories.permutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationStrategy {

	private final List<String> allowed;

	public PermutationStrategy(List<String> allowed) {
		this.allowed = allowed;
	}

	public List<String> generate(int size) {
		final List<String> result = new ArrayList<>();
		this.backtrack(new StringBuilder(), size, result);
		return result;
	}

	private void backtrack(StringBuilder prefix, int size, List<String> result) {
		if (prefix.length() == size) {
			result.add(prefix.toString());
			return;
		}
		for (final String t : this.allowed) {
			prefix.append(t);
			this.backtrack(prefix, size, result);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}
}
