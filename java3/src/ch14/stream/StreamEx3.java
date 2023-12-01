package ch14.stream;

import java.util.*;
import java.util.stream.*;

class StreamEx3 {
	 public static void main(String[] args) {
		Student3[] stuArr = {
			new Student3("이자바", 3, 90),
			new Student3("김자바", 1, 100),
			new Student3("안자바", 2, 70),
			new Student3("박자바", 2, 90),
			new Student3("소자바", 1, 100),
			new Student3("나자바", 3, 80),
			new Student3("감자바", 3, 88)	
		};

		Stream<Student3> stuStream = Stream.of(stuArr);

		
		//Comparator 인터페이스에는  default 매서드가 존재한다 
		//comparing매서드제공함  
		//가볍게 보고 넘어가도록 한다 
		stuStream.sorted(Comparator.comparing(Student3::getBan)
				 .thenComparing(Comparator.naturalOrder()))  //기본 정렬기준으로 정렬해줌 
				 .forEach(System.out::println);

		stuStream = Stream.of(stuArr); // 스트림을 다시 생성한다. 
	    IntStream stuScoreStream= stuStream.mapToInt(Student3::getTotalScore);

		IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
		
		//summaryStatistics 메서드를 사용하여 stuScoreStream에서 
		//통계 정보(개수, 합계, 최소값, 평균 및 최대값)를 수집합니다. 
		//IntSummaryStatistics 클래스는 이러한 통계를 검색하는 데 사용되는 메서드를 제공합니다.
		
		
		System.out.println("count="+stat.getCount());
		System.out.println("sum="+stat.getSum());
		System.out.printf("average=%.2f%n", stat.getAverage());
		System.out.println("min="+stat.getMin());
		System.out.println("max="+stat.getMax());
	}
}

class Student3 implements Comparable<Student3> {
	String name;
	int ban;
	int totalScore;
	Student3(String name, int ban, int totalScore) { 
		this.name = name;
		this.ban  = ban;
		this.totalScore = totalScore;
	}

	public String toString() { 
	   return String.format("[%s, %d, %d]", name, ban, totalScore).toString(); 
	}

	String getName()	{ return name;}
	int getBan()		{ return ban;}
	int getTotalScore() { return totalScore;}

	public int compareTo(Student3 s) {
		return s.totalScore - this.totalScore;
	}
	 
}
