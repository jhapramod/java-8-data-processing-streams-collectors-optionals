package com.pramod.java8.streams.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainUsingOptional {

	public static void main(String[] args) {
		List<Double> list = new ArrayList<Double>();
		
//		ThreadLocalRandom.current()
//						.doubles(10_000).parallel()
//						.forEach(
//								d -> NewMath.inv(d)
//											.ifPresent(
//														inv -> NewMath.sqrt(inv)
//																		.ifPresent(
//																				sqrt -> list.add(sqrt)
//																		)
//											)
//						);
//		
//		System.out.println("# : " + list.size());

		
		Function<Double, Stream<Double>> flatMapper =
				d -> NewMath.inv(d)
							.flatMap(NewMath::sqrt)
							.map(sqrt -> Stream.of(sqrt))
							.orElseGet(Stream::empty);
				
		List<Double> righResult = ThreadLocalRandom.current()
						.doubles(10_000).parallel()
						.map(d -> d*20 - 10)
						.boxed()
						.flatMap(flatMapper)
						.collect(Collectors.toList());
		
		System.out.println("right result : " + righResult.size());
	}

}
