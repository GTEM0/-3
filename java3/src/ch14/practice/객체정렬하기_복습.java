package ch14.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//사용자 포인트 순 으로 정렬
//사용자 포인트가 같은 경우 나이순으로 정렬 


// 정렬뽀개기 (너무 중요 !! 이 부분 완전히 소화되도록 무한 반복 함 )
// Comparable 인터페이스      하나의 매서드를 가짐    int compareTo( Object o)     //양수의 값이 전달되면 자리바꿈 됨  => 전체적으로 정렬완성 
// Comparator 인터페이스      하나의 매서드를 가짐    int compare( Object o1, Object o2)  // 양수의 값이 전달되면 자리바꿈 됨



public class 객체정렬하기_복습 {	
	public static void main(String[] args) {		
		ArrayList<Acorn> list  = new ArrayList<>();		
		
		list.add( new Acorn( "a" , 20, 13000 ));
		list.add( new Acorn( "b" , 21, 15000 ));
		list.add( new Acorn( "c" , 24, 15000 ));
		list.add( new Acorn( "d" , 23, 14000 ));
		list.add( new Acorn( "e" , 22, 15000 ));
	
	
		
		Collections.sort(list);
		
		
		//System.out.println(  list );
		
		System.out.println( "포인트순 정렬");
		list.forEach( item  -> System.out.println( item));
		
		
		Collections.sort( list,  new Comparator<>() {    // 포인트정렬 같은 포인트 나이순으로 오름차순
			@Override
			public int compare(Acorn o1, Acorn o2) {
				// TODO Auto-generated method stub
				int result  = o1.getPoint()  - o2.getPoint();
				return  (result ==0 ) ? o2.getAge()  - o1.getAge() : result;
			}});
		
		
		//System.out.println(  list );		
		System.out.println ( "포인트순 나이가 높은 순 정렬");
		list.forEach( item -> System.out.println(item));
		
		
	}

}


class Acorn  implements Comparable<Acorn>{
	
	String name;
	int age; 
	int point ;
	public Acorn(String name, int age, int point) {
		super();
		this.name = name;
		this.age = age;
		this.point = point;
	}
	
	public Acorn() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Acorn o) {
		// TODO Auto-generated method stub
		return  this.point - o.point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Acorn [name=" + name + ", age=" + age + ", point=" + point + "]";
	} 
	
	
}
