package ch14.stream;

import java.util.Arrays;
import java.util.List;

public class ReduceEx {

	public static void main(String[] args) {
		//reduce 
		//스트림의 요소를 하나의 값으로 줄이는 연산을 담당		
		
		//배열을 리스트로 반환함 
	    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
	    
	    
        // 초기값 0, 덧셈 연산자로 모든 요소의 합을 구함
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);        
        /*내부동작 
         * a= identity;
         *             
         * for( int b : stream)    
         *    a=a+b; 
         * 
         */ 
        System.out.println("Sum: " + sum);
	}

}
