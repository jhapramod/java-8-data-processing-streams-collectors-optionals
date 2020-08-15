package com.pramod.java8.streams.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreams {

	public static void main(String[] args) {
		
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
		
//		List<String> list = new ArrayList<String>();
		List<String> list = new CopyOnWriteArrayList<>();
		
		List<String> collect = Stream.iterate("+", s -> s + "+")
				.parallel()
				.limit(1000)
//				.peek(s -> System.out.println(s + "processed in the Thread : " + Thread.currentThread().getName()))
//				.forEach(s -> list.add(s));
				.collect(Collectors.toList());
		
		System.out.println("# : " + collect.size());

	}

}
