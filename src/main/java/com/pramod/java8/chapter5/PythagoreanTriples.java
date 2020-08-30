package com.pramod.java8.chapter5;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriples {

	public static void main(String[] args) {
		Stream<double[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
					.flatMap(a -> 
								IntStream.rangeClosed(a,  100)
											.mapToObj(
													b -> new double[] {a, b, Math.sqrt(a*a + b*b)})
											.filter(t -> t[2] %1 == 0));
		
		pythagoreanTriples.forEach(
				t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
	}

}
