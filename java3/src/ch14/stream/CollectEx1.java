package ch14.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;

public class CollectEx1 {

    public static void main(String[] args) {
        // 학생 객체를 담고 있는 리스트 생성
        List<Customer> Customers = Arrays.asList(
                new Customer("철수", 23),
                new Customer("영희", 27),
                new Customer("동희", 22),
                new Customer("민수", 30)
        );

        
        // 나이가 23 이상인 학생들을 이름을 키로 하는 맵으로 수집하는 람다식
        Map<String, Integer> olderStudentsMap = Customers.stream()
                .filter(student -> student.getAge() >= 23)
                .collect(Collectors.toMap(customer -> customer.getName(), customer -> customer.getAge()));
             
        
        
        /*
         *     Map<String, Integer> olderStudentsMap = Customers.stream()
                  .filter(student -> student.getAge() >= 23)
                  .collect(Collectors.toMap(Customer::getName, Customer::getAge)); 
         */

        // 결과 출력
        System.out.println(olderStudentsMap);
    }

    // 학생 클래스 정의
    static class Customer {
        private String name;
        private int age;

        public Customer(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
