package com.pramod.java8.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.pramod.java8.model.Person;

public class CreatingSpliterator {

	public static void main(String[] args) {
		Path path = Paths.get(".", "/src/main/resources/files/people.txt");
		
		try(Stream<String> lines = Files.lines(path);) {
			
			Spliterator<String> lineSpliterator = lines.spliterator();
			Spliterator<Person> peopleSpliterator = new PersonSplitrator(lineSpliterator);
			
			Stream<Person> people = StreamSupport.stream(peopleSpliterator, false);
			people.forEach(System.out::println);
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
