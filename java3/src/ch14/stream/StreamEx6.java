package ch14.stream;


import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class StreamEx6 {
	public static void main(String[] args) {
		Student1[] stuArr = {
			new Student1("이자바", 3, 300),
			new Student1("김자바", 1, 200),
			new Student1("안자바", 2, 100),
			new Student1("박자바", 2, 150),
			new Student1("소자바", 1, 200),
			new Student1("나자바", 3, 290),
			new Student1("감자바", 3, 180)	
		};

		// 학생 이름만 뽑아서 List<String>에 저장
		List<String> names = Stream.of(stuArr).map(Student1::getName)
									          .collect(Collectors.toList());
		
		
		 
		/*람다식으로 변경
		 * 
		 * List<String> names = Stream.of(stuArr)
			    .map(student -> student.getName())
			    .collect(Collectors.toList());
		*/		
			
		
		System.out.println(names);
	 
		// 스트림을 배열로 변환
		//Student1[] stuArr2 = Stream.of(stuArr).toArray(Student1[]::new);
		
		Student1[] stuArr2 = Stream.of(stuArr)
			    .toArray(size -> new Student1[size]);


		
		System.out.println( " 스트림을 배열로 변환");
		for(Student1 s : stuArr2)
			System.out.println(s);

		// 스트림을 Map<String, Student>로 변환. 학생 이름이 key 
		Map<String,Student1> stuMap = Stream.of(stuArr)
						                   .collect(Collectors.toMap(s->s.getName(), p->p));
		for(String name : stuMap.keySet())
			System.out.println(name +"-"+stuMap.get(name));
		
		long count = Stream.of(stuArr).collect(Collectors.counting());
		long totalScore = Stream.of(stuArr)
                                .collect(summingInt(Student1::getTotalScore));
		System.out.println("count="+count);
		System.out.println("totalScore="+totalScore);

		totalScore = Stream.of(stuArr)
			               .collect(reducing(0, Student1::getTotalScore, Integer::sum));
		System.out.println("totalScore="+totalScore);

		Optional<Student1> topStudent = Stream.of(stuArr)
		                                     .collect(maxBy(Comparator.comparingInt(Student1::getTotalScore)));
		System.out.println("topStudent="+topStudent.get());

		IntSummaryStatistics stat = Stream.of(stuArr)
					                      .collect(Collectors.summarizingInt(Student1::getTotalScore));
		System.out.println(stat);

		
		
		String stuNames = Stream.of(stuArr)
							    .map(Student1::getName)
							    .collect(Collectors.joining(",", "{", "}"));
		
		
		/*
		 *  1. stuArr배열로부터 스트림을 생성
		 *  2. getName매서드를 사용하여 학생의 이름만을 추출한 스트림으로반환
		 * 
		 */
		System.out.println(stuNames);
	}
}


class Student1 implements Comparable<Student> {
	String name;
	int ban;
	int totalScore;

	Student1(String name, int ban, int totalScore) { 
		this.name =name;
		this.ban =ban;
		this.totalScore =totalScore;
	}

	public String toString() { 
	   return String.format("[%s, %d, %d]", name, ban, totalScore).toString(); 
	}

	String getName() { return name;}
	int getBan() { return ban;}
	int getTotalScore() { return totalScore;}

	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}
