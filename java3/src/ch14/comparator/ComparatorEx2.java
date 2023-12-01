package ch14.comparator;

import java.util.Comparator; 
import java.util.stream.Stream;

class ComparatorEx2 {
	
	public static void main(String[] args) {
		
	     Stream<Student> a = Stream.of(
							new Student("이자바", 3, 300),
							new Student("김자바", 1, 200),
							new Student("안자바", 2, 100),
							new Student("박자바", 2, 150),
							new Student("소자바", 1, 200),
							new Student("나자바", 3, 290),
							new Student("감자바", 3, 180)
						);
	     
	    
	     //객체의  기본정렬
	     // a.sorted().forEach( student ->   System.out.println( student));	   
	     
	     //반별 오름차순
	     // a.sorted( ( o1, o2) ->  o1.getBan() - o2.getBan()).forEach( student -> System.out.println( student));
	    
	     
	     //감각적으로 사용하기
	     //Comparator.comparing( Function f)
	     //a.sorted( Comparator.comparing(Student::getBan).thenComparing( Comparator.naturalOrder())).forEach( System.out::println);
	     a.sorted(Comparator.comparing( s ->  s.getBan() )).forEach( s ->System.out.println(s));
	     
	     /*
	     a.sorted( Comparator.comparing( new Function() {

			@Override
			public Object apply(Object t) {
				// TODO Auto-generated method stub
				Student s = (Student) t;
				return s.getBan();
			}})).forEach( new Consumer() {
				@Override
				public void accept(Object t) {
					System.out.println( t);
					
				}}); 
				
			 */
		} 
	}
	

 

 
