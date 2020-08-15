package com.pramod.java8.streams.flatmap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String[] args) throws IOException {
		
//		System.out.println(System.getProperty("user.dir"));
		
		Stream<String> stream1 = Files.lines(Paths.get("src/main/resources/files/TomSawyer_01.txt"));
		Stream<String> stream2 = Files.lines(Paths.get("src/main/resources/files/TomSawyer_02.txt"));
		Stream<String> stream3 = Files.lines(Paths.get("src/main/resources/files/TomSawyer_03.txt"));
		Stream<String> stream4 = Files.lines(Paths.get("src/main/resources/files/TomSawyer_04.txt"));
		
//		System.out.println("Stream 1 : " + stream1.count());
//		System.out.println("Stream 2 : " + stream2.count());
//		System.out.println("Stream 3 : " + stream3.count());
//		System.out.println("Stream 4 : " + stream4.count());
		
		Stream<Stream<String>> streamOfStreams = Stream.of(stream1, stream2, stream3, stream4);
//		streamOfStreams.flatMap(stream -> stream);
		Stream<String> streamOfLines = 
				streamOfStreams.flatMap(Function.identity());
		
//		System.out.println("# of lines : " + streamOfLines.count());
		
		Function<String, Stream<String>> lineSplitter =
				line -> Pattern.compile(" ").splitAsStream(line);
				
		Stream<String> wordStream =
				streamOfLines.flatMap(lineSplitter)
				.map(word -> word.toLowerCase())
				.distinct();
		
		System.out.println("# words : " + wordStream.count());

		
	}

}
