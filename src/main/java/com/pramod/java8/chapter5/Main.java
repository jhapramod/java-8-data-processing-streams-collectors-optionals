package com.pramod.java8.chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.pramod.java8.chapter5.domain.Trader;
import com.pramod.java8.chapter5.domain.Transaction;

public class Main {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), 
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950));
		
		//1.
		transactions.stream()
					.filter(tran -> tran.getYear() == 2011)
					.sorted(Comparator.comparing(Transaction::getValue))
					.forEach(System.out::println);
		
		printDash();

		//2.
		transactions.stream()
					.map(t -> t.getTrader().getCity())
					.distinct()
					.forEach(System.out::println);
		printDash();
		
		
		//3.
		transactions.stream()
					.map(tran -> tran.getTrader())
					.filter(tran -> "Cambridge".equals(tran.getCity()))
					.distinct()
					.sorted(Comparator.comparing(Trader::getName))
					.forEach(System.out::println);
					
		printDash();
					
					
		//4.
		String traderName = transactions.stream()
					.map(tran -> tran.getTrader().getName())
					.distinct()
					.sorted()
					.reduce("", (n1, n2) -> n1 + n2);
		System.out.println(traderName);
							
		printDash();
		
		//5.
		Optional<Transaction> findAny = transactions.stream()
					.filter(tran -> "Milan".equals(tran.getTrader().getCity()))
					.findAny();
		System.out.println(findAny.get());
		
		System.out.println();
		
		boolean anyMatch = transactions.stream()
					.anyMatch(tran -> "Milan".equals(tran.getTrader().getCity()));
		System.out.println(anyMatch);
					
		
		printDash();
		
		//6.
		transactions.stream()
					.filter(tran -> "Cambridge".equals(tran.getTrader().getCity()))
					.forEach(System.out::println);
		printDash();
		
		//7.
		Optional<Integer> maxValue = 
				transactions.stream()
					.max(Comparator.comparing(Transaction::getValue))
					.map(tran -> tran.getValue());
		System.out.println(maxValue.get());
		
		//8.
		Optional<Integer> minValue = transactions.stream()
					.min(Comparator.comparing(Transaction::getValue))
					.map(tran -> tran.getValue());;
		System.out.println(minValue.get());
	}

	private static void printDash() {
		System.err.println();
		System.out.println("--------------------------------------------------------------------------------------------------------");
		System.out.println();
	}

}
