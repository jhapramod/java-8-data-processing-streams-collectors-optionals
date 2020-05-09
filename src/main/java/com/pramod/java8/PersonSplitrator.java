package com.pramod.java8;

import java.util.Spliterator;
import java.util.function.Consumer;

import com.pramod.java8.model.Person;

public class PersonSplitrator implements Spliterator<Person> {

	private Spliterator<String> lineSpliterator;
	private String name;
	private int age;
	private String city;

	public PersonSplitrator(Spliterator<String> lineSpliterator) {
		this.lineSpliterator = lineSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Person> action) {
		if(this.lineSpliterator.tryAdvance(line -> this.name = line) &&
		this.lineSpliterator.tryAdvance(line -> this.age = Integer.parseInt(line)) &&
		this.lineSpliterator.tryAdvance(line -> this.city = line)) {
			
			Person p = new Person(name, age, city);
			action.accept(p);
			
			return true;
		}
		
		return false;
		
	}

	@Override
	public Spliterator<Person> trySplit() {
		return null;
	}

	@Override
	public long estimateSize() {
		return lineSpliterator.estimateSize() / 3;
	}

	@Override
	public int characteristics() {
		return lineSpliterator.characteristics();
	}

}
