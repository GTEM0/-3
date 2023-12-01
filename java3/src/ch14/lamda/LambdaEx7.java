package ch14.lamda;

import java.util.function.*;

class LambdaEx7 {
	
	public static void main(String[] args) {
		
		Function<String, Integer>	f  = (s) -> Integer.parseInt(s, 16);
		Function<Integer, String>	g  = (i) -> Integer.toBinaryString(i);
		
		
		Function<String, String>	h  = f.andThen(g);   // f (실행) 의 반환값이  g의 입력값으로 사용됨
		Function<Integer, Integer>  h2 = f.compose(g);   // g (실행) 의 반환값이  f의 입력값으로 사용됨 
		

		System.out.println(h.apply("FF")); // "FF" → 255 → "11111111"
		System.out.println(h2.apply(2));   // 2 → "10" → 16


		Function<String, String> f2 = x -> x; // 항등 함수(identity function)
		System.out.println(f2.apply("AAA"));  // AAA가 그대로 출력됨

		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i%2 == 0;
		
		// p의 부정(Not)을 나타내는 조건을 만든다.
		Predicate<Integer> notP = p.negate(); // i >= 100

		
		 //                              false   &&   true       =>false
		 // notP.and(q).or(r)   => notP.test(90) && q.test(90)   =>false
		
		// false.or(r)   =>  false.or(  r.test(90) ) 
		//  false.or( true )  
		//  false || true  = > true !!!!
		Predicate<Integer> all = notP.and(q).or(r);
		
		
		//test호출시 값을 150에서 여러개 바꿔보면서 결과값을 예상하자 !		
		System.out.println("결과 =" + all.test(150)); //true
		System.out.println("결과="+ all.test(90));    //true
		System.out.println("결과="+ all.test(91));    //false
				 

		String str1 = "abc";
		String str2 = "abc";
		
		// str1과 str2가 같은지 비교한 결과를 반환
		Predicate<String> p2 = Predicate.isEqual(str1); 
		boolean result = p2.test(str2);   
		System.out.println(result);
	}
}
