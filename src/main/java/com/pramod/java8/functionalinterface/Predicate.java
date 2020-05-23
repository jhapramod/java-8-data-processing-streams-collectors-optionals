package com.pramod.java8.functionalinterface;

@FunctionalInterface
public interface Predicate<T> {
	public boolean test(T t);

	default Predicate<T> and(Predicate<T> other) {
		return t -> test(t) && other.test(t);
	}

	public default Predicate<T> or(Predicate<T> other) {
		return t -> test(t) || other.test(t);
	}

	public static <T> Predicate<T> isEqualsTo(T t) {
		return s -> s.equals(t);
	}
}
