package ch14.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectEx {

    public static void main(String[] args) {
    	
    	//스트림의 결과를 Collection으로 받고 싶을 때 사용함     	
        String[] strArray = {"apple", "banana", "kiwi", "orange", "grape"};

        // 문자열 길이가 5 이상인 요소들을 리스트로 수집하는 람다식
        List<String> result = Stream.of(strArray)
                .filter(s -> s.length() >= 5)
                .collect(Collectors.toList());   // Collections  객체로 반환함 

        // 결과 출력
        System.out.println(result);
        
             
        
    }
}
