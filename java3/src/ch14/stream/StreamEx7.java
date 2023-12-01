package ch14.stream;


import java.util.*;

import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Score {
	String name;
	boolean isMale; // 성별
	int hak;		    // 학년
	int ban;		    // 반
	int score;

	Score(String name, boolean isMale, int hak, int ban, int score) { 
		this.name	= name;
		this.isMale	= isMale;
		this.hak	= hak;
		this.ban	= ban;
		this.score  = score;
	}
	String	getName()  { return name;}
	boolean isMale()    { return isMale;}
	int		getHak()   { return hak;}
	int		getBan()   { return ban;}
	int		getScore() { return score;}

	public String toString() { 
		return String.format("[%s, %s, %d학년 %d반, %3d점]",
			name, isMale ? "남":"여", hak, ban, score); 
	}
   // groupingBy()에서 사용
	enum Level { HIGH, MID, LOW }  // 성적을 상, 중, 하 세 단계로 분류
}

class StreamEx7 {
	public static void main(String[] args) {
		Score[] stuArr = {
			new Score("나자바", true,  1, 1, 69),	
			new Score("김지미", false, 1, 1, 98),	
			new Score("김자바", true,  1, 1, 90),	
			new Score("이지미", false, 1, 2, 99),	
			new Score("남자바", true,  1, 2, 100),	
			new Score("안지미", false, 1, 2,  50),	
			new Score("황지미", false, 1, 3, 40),	
			new Score("강지미", false, 1, 3, 80),	
			new Score("이자바", true,  1, 3, 90),	

			new Score("나자바", true,  2, 1, 100),	
			new Score("김지미", false, 2, 1, 99),	
			new Score("김자바", true,  2, 1, 70),	
			new Score("이지미", false, 2, 2, 80),	
			new Score("남자바", true,  2, 2, 90),	
			new Score("안지미", false, 2, 2,  50),	
			new Score("황지미", false, 2, 3, 90),	
			new Score("강지미", false, 2, 3, 80),	
			new Score("이자바", true,  2, 3, 90)	
		};

		System.out.printf("1. 단순분할(성별로 분할)%n");
		
		
	
		Map<Boolean, List<Score>> stuBySex =  Stream.of(stuArr)
				.collect(partitioningBy(Score::isMale));
		
		
		//남성여부에 따라  true, false  두 그룹생성됨
		List<Score> maleStudent   = stuBySex.get(true);
		List<Score> femaleStudent = stuBySex.get(false);

		// 두 그룹 출력
		for(Score s : maleStudent)   System.out.println(s);
		for(Score s : femaleStudent) System.out.println(s);

		
		// 키    값
		//ture, 10
		//false ,5 
		System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
		Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
				.collect(partitioningBy(Score::isMale, counting()));

		System.out.println("남학생 수 :"+ stuNumBySex.get(true));
		System.out.println("여학생 수 :"+ stuNumBySex.get(false));

		

		
		//성별 1등 조회	  	
		System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
		 
		Map<Boolean, Optional<Score>> topScoreBySex = Stream.of(stuArr)    //정렬기준제공해줘야 함 
				.collect(partitioningBy(Score::isMale, maxBy( (s1, s2) ->  s1.getScore() - s2.getScore() )));
		 
	 
		 
		System.out.println("남학생 1등 :"+ topScoreBySex.get(true));
		System.out.println("여학생 1등 :"+ topScoreBySex.get(false));

		
		//Comparator 디폴트매서드를 (구현이 되어있는 매서드 ) : 인터페이스는 구현된 매서드를 가질 수 없지만 
		// default 매서드 문법을 제공하면서 구현된 매서드를 가질 수 있게 되었다 .! 
		//Comparator.comparngInt 매서드 이용하여 비교함 
		Map<Boolean, Optional<Score>> topScoreBySex2 = Stream.of(stuArr)
				.collect(partitioningBy(Score::isMale, maxBy(Comparator.comparingInt(Score::getScore))
		 ));
		 
		
		  
		System.out.println("남학생 1등 :"+ topScoreBySex.get(true));
		System.out.println("여학생 1등 :"+ topScoreBySex.get(false));

	 		 
		 
		System.out.println("남학생 1등 :"+ topScoreBySex.get(true));
		System.out.println("여학생 1등 :"+ topScoreBySex.get(false));

	 
		
		// 성별 100점이하
		System.out.printf("%n4. 다중분할(성별 불합격자, 70점 미만 )%n");
		Map<Boolean, Map<Boolean, List<Score>>> failedStuBySex = 
			Stream.of(stuArr).collect(partitioningBy(Score::isMale, partitioningBy(s -> s.getScore() < 70))
			); 
		List<Score> failedMaleStu   = failedStuBySex.get(true).get(true);
		List<Score> failedFemaleStu = failedStuBySex.get(false).get(true);

		for(Score s : failedMaleStu)   System.out.println(s);
		for(Score s : failedFemaleStu) System.out.println(s);
	}
}
