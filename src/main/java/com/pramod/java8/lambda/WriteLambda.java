package com.pramod.java8.lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class WriteLambda {

	public static void main(String[] args) {
		writeComparator();
		writeRunnable();
		sum();
		consumerExample();

	}

	private static void consumerExample() {
		Consumer<String> consumer = s -> System.out.println(s);
		
		Consumer<String> lambdaConsumer = System.out::println;
		
	}

	private static void sum() {
		BinaryOperator<Integer> sum = (i1, i2) -> Integer.sum(i1, i2);
		
		BinaryOperator<Integer> sumlambda = Integer::sum;
		
	}

	private static void writeRunnable() {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("It Works !");
				}

			}
		};

		Runnable runLambda = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("It Works !");
			}
		};

	}

	private static void writeComparator() {
		Comparator<String> simpleComparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		};

		Comparator<String> lambdaComparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());

	}

}
