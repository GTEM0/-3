package ch14.stream;

import java.util.*;
import java.util.stream.*;

class StreamEx4 {
	public static void main(String[] args) {

		Stream<String[]> strArrStrm = Stream.of(
			new String[]{"abc", "def", "jkl"},
			new String[]{"ABC", "GHI", "JKL"}
		);

//		Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
		
		// 두 개의  String[]스트림을 하나로 만들어 줌 
		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);

		
		strStrm.map(String::toLowerCase)
			   //.distinct()
			   .sorted()
			   .forEach(System.out::println);
		System.out.println("======================");

		String[] lineArr = {
			"Believe or not It is true",
			"Do or do not There is no try",
		};

		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" ")))    
				  .map(String::toLowerCase)
				  .distinct()
				  .sorted()
				  .forEach(System.out::println);
		System.out.println();

		Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
		Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");

		Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);

		
		Stream<String> strStream = strStrmStrm
									.map(s -> s.toArray(String[]::new))  
		    						.flatMap(Arrays::stream);
		
		strStream.map(String::toLowerCase)
				 .distinct()
				 .forEach(System.out::println);
		
		
		
		
		///스트림 출력
		System.out.println("=======> ");		
		Stream<String> nstrStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
		Stream<String> nstrStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");

		Stream<Stream<String>> nstrStrmStrm = Stream.of(nstrStrm1, nstrStrm2);

		// 각 문자열 스트림을 출력
		nstrStrmStrm.forEach(stream -> {
		    stream.forEach(System.out::println);
		    System.out.println(); // 각 문자열 스트림 사이에 빈 줄 추가
		});

		
	}
}
