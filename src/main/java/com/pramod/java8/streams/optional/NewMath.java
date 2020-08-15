package com.pramod.java8.streams.optional;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class NewMath {
	
	public static Optional<Double> sqrt(Double d) {
		return d > 0 
				? Optional.of(Math.sqrt(d))
				: Optional.empty();
	}
	
	public static Optional<Double> inv(Double d) {
		return d != 0d 
				? Optional.of(1d/d)
				: Optional.empty();

	}
	
//	private Optional<Double> invSqrt(Double doub) {
//		Function<Double, Stream<Double>> invSqrt = 
//				d -> inv(d)
//				.flatMap(du -> sqrt(d))
//				.map(Stream::of)
//				.orElseGet(Stream::empty);
//		
//
//	}
	
}
