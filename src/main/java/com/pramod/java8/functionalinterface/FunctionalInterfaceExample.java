package com.pramod.java8.functionalinterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.pramod.java8.model.Person;

public class FunctionalInterfaceExample {

	public static void main(String[] args) {
		consumerExample();
		supplierExample();
		functionaExample();
		predicateExample();

	}

	private static void predicateExample() {
		Predicate<Person> ageGT20 = p -> p.getAge() > 20;
		
	}

	private static void functionaExample() {
//		Function<Person, Integer> ageMapper = person -> person.getAge();
		Function<Person, Integer> ageMapper = Person::getAge;
		
	}

	private static void supplierExample() {
		Supplier<Person> supplier = Person::new;
		
	}

	private static void consumerExample() {
		Consumer<String> consumer = System.out::println;
		
	}

}
