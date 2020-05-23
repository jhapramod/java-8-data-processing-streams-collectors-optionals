package com.pramod.java8.functionalinterface;

public class PredicateDemo {

	public static void main(String[] args) {
		Predicate<String> p1 = s -> s.length() < 20;
		Predicate<String> p2 = s -> s.length() >= 5;
		
		boolean result = p1.test("Hello");
		
		System.out.println("Hello length is smaller than 20 : " + result);
		
		Predicate<String> p3 = p1.and(p2);
		System.out.println("P3 for Yes : " + p3.test("Yes"));
		System.out.println("P3 for Hello : " + p3.test("Hello"));
		
		Predicate<String> p4 = p1.or(p2);
		System.out.println("P4 for Yes : " + p4.test("Yes"));
		System.out.println("P4 for Hello : " + p4.test("Hello"));
		
		Predicate<String> p5 = Predicate.isEqualsTo("Yes");
		System.out.println("P5 for Yes : " + p5.test("Yes"));

	}

}
