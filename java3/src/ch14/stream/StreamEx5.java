package  ch14.stream;

import java.util.*;
import java.util.stream.*;

class StreamEx5 {
	public static void main(String[] args) {
		String[] strArr = {
			"Inheritance", "Java", "Lambda", "stream",
			"OptionalDouble", "IntStream", "count", "sum"
		};

		Stream.of(strArr).forEach(System.out::println);

		boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length()==0);
		Optional<String> sWord = Stream.of(strArr)
							           .filter(s->s.charAt(0)=='s').findFirst();

		
		System.out.println("noEmptyStr="+noEmptyStr);
		System.out.println("sWord="+ sWord.get());

		// Stream<String[]>을 IntStream으로 변환
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		//IntStream intStream1 = Stream.of(strArr).mapToInt(str -> str.length());
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

		int count = intStream1.reduce(0, (a,b) -> a + 1);   // a 변수에 1값을 누적한다
		int sum   = intStream2.reduce(0, (a,b) -> a + b);   // a 변수에 b(즉 스트림의 요소값)을 누적한다

		
		
		/*
		 * 
		 * @FunctionalInterface
			public interface IntBinaryOperator {			   
			     * 두 개의 int 값을 받아서 연산을 수행하고 결과를 반환합니다.			     *
			     * @param left  첫 번째 int 값
			     * @param right 두 번째 int 값
			     * @return 연산 결과			      
			    int applyAsInt(int left, int right);
			}			
		*/
  
		
		OptionalInt max = intStream3.reduce(Integer::max);  
		//OptionalInt max = intStream3.reduce((x, y) -> Integer.max(x, y));

		OptionalInt min = intStream4.reduce(Integer::min);
		//OptionalInt min = intStream4.reduce((x, y) -> Integer.min(x, y));

		System.out.println("count="+count);
		System.out.println("sum="+sum);
		System.out.println("max="+ max.getAsInt());
		System.out.println("min="+ min.getAsInt());
	}
}
