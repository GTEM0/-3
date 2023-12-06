package ch14.lamda.매서드참조.실습;

import java.util.function.Function;

interface Fuction<T, R>{
	R apply(T t);
}

/*
interface Function2{
	String apply(Integer t);	
}

interface Function3{
	Integer apply(Integer t);
}

interface Function4{
	Integer apply(String[] t);
}
*/

public class Ex01 {

	public static void main(String[] args) {
		// 인터페이스를 구현하는 방법
		//1. 클래스
		//2. 익명
		//3. 람다식(함수형 인터페이스만 가능)
		//4. 매서드참조

		
		//지역내부클래스
		class B implements Function<String, Integer>{

			@Override
			public Integer apply(String t) {	//"12" -> 12
				
				return Integer.parseInt(t);
			}
			
		}
		
		B b = new B();
		int result = b.apply("12");
		System.out.println(result);
		
		
//		Function f = new Function<String, Integer>(){};
		Function f = new Function<String, Integer>(){
			
			
			@Override
			public Integer apply(String t) {
				
				return Integer.parseInt(t);
				
			}};
		
//		int result2 = f.apply("24");
		
		
		//람다식
		//함수형인터페이스(구현해야할 매서드가 한개인 경우)
		Function<String, Integer> f2 = t -> Integer.parseInt(t);
		
		int result3 = f2.apply("36");
		
		//매서드참조
		Function<String, Integer> f3 = Integer::parseInt;
		int result4 = f3.apply("48");
		
		System.out.println(result4);
		
		
		
	}
	
	
	
	

}
