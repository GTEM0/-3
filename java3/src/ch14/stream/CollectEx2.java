package ch14.stream;
 

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Arrays;


//학생 클래스 정의
class Customer {
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
public class CollectEx2 {

    public static void main(String[] args) {
        // 학생 객체를 담고 있는 리스트 생성
        List<Customer> Customers = Arrays.asList(
                new Customer("철수", 23),
                new Customer("영희", 27),
                new Customer("영희", 22),
                new Customer("민수", 30)
        );

        // 나이가 23 이상인 학생들의 이름을 수집하여 Set으로 만드는 람다식
        Set<String> 학생이름 = Customers.stream()                
                .map(Customer::getName)
                .collect(Collectors.toSet());

        // 결과 출력
        System.out.println(학생이름);
    } 
}
