package ch11.hashset;
import java.util.*;

class HashSetEx4 {
	public static void main(String[] args) {
		HashSet set = new HashSet();

		
		// David 객체 두 개가 같은 객체인가?
		// Object의 equals는  객체의 주소를 비교한다. 즉 다르다고 인식함
		// equals  , hashCode 오버라이딩 해야함 
		// 이름과 나이가 같은 경우 같은 객체로 인식하겠다
		
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person2("David",10));
		set.add(new Person2("David",10));

		System.out.println(set);
	}
}

class Person2 {
	String name;
	int age;

	Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean equals(Object obj) {
		if(obj instanceof Person2) {
			Person2 tmp = (Person2)obj;
			return name.equals(tmp.name) && age==tmp.age;
		}

		return false;
	}

	
	//같은  hash코드를 가지게 한다. 객체의 고유번호 같은것이라고 생각하면 된다. 
	public int hashCode() {
		int result  = (name+age).hashCode();
		//System.out.println(result);
		return result;
	}

	public String toString() {
		return name +":"+ age;
	}
}
