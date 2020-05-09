package com.pramod.java8.lambda;

import java.util.function.Function;

import com.pramod.java8.model.Person;

public class MainComparator {

	public static void main(String[] args) {
		Comparator<Person> ageComparator = (p1, p2) -> p2.getAge() - p1.getAge();
		Comparator<Person> nameComparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
		Comparator<Person> cityComparator = (p1, p2) -> p1.getCity().compareTo(p2.getCity());
		
		Function<Person, Integer> f1 = p -> p.getAge();
		Function<Person, String> f2 = Person::getName;
		Function<Person, String> f3 = Person::getCity;
		
//		Comparator<Person> personComparator1 = Comparator.comparing(f1);
//		Comparator<Person> personComparator2 = Comparator.comparing(p -> p.getAge());
		Comparator<Person> personAgeComparator = Comparator.comparing(Person::getAge);
		Comparator<Person> personNameComparator = Comparator.comparing(Person::getName);
		
		Comparator<Person> comp = personAgeComparator.thenCompare(personAgeComparator);
		
		Comparator<Person> cmp = Comparator.comparing(Person::getCity)
											.thenCompare(Person::getName)
											.thenCompare(Person::getAge);
	}

}
