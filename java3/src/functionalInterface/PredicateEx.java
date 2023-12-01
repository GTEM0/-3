package functionalInterface;

import java.util.function.Predicate;

public class PredicateEx {

	public static void main(String[] args) {		 
	  
        Predicate<Integer> isEven = number -> number % 2 == 0;
        
        System.out.println(isEven.test(4));   
        System.out.println(isEven.test(7));   
        System.out.println(isEven.test(10));  
	}
}


/*

람다식은 인터페이스를 익명으로 만든 익명클래스의 객체이다


public class PredicateEx2 {
    public static void main(String[] args) {
        
        Predicate<Integer> isEven = new Predicate<>() {
            @Override
            public boolean test(Integer number) {
                boolean result ;
                result  = number % 2 == 0;
                return result;
            }
        };

      
        System.out.println(isEven.test(4));   
        System.out.println(isEven.test(7));   
        System.out.println(isEven.test(10));  
    }
}




*/