package com.pramod.java8.streams.collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainUsingCollectors {

	public static void main(String[] args) throws IOException {
		Set<String> shakespeareWords = Files.lines(Paths.get("src/main/resources/files/words.shakespeare.txt"))
				.map(word -> word.toLowerCase())
				.collect(Collectors.toSet());

		Set<String> scrabbleWords = Files.lines(Paths.get("src/main/resources/files/ospd.txt"))
				.map(word -> word.toLowerCase())
				.collect(Collectors.toSet());

		System.out.println("# Words of Shakespeare : " + shakespeareWords.size());
		System.out.println("# Words of Scrabble : " + scrabbleWords.size());

		final int[] scrabbleENScore = { 
			//  a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r,  s, t, u, v, w, x, y, z
				1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };

		Function<String, Integer> score = 
				word -> word.toLowerCase().chars()
							.map(letter -> scrabbleENScore[letter - 'a'])
							.sum();
				

		Map<Integer, List<String>> histogramWordsByScore =
				shakespeareWords.stream()
						.filter(scrabbleWords::contains)
						.collect(Collectors.groupingBy(score));
		
		System.out.println("# histogram words by score : " + histogramWordsByScore.size());
		
		histogramWordsByScore.entrySet()
				.stream()
				.sorted(
					Comparator.comparing(
							entry -> -entry.getKey()
					)
				)
				.limit(3)
				.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
				
	}

}
