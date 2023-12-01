package ch11.hashset;
import java.util.*;

class HashSetEx출력하기 {
	public static void main(String args[]) {
		HashSet set    = new HashSet();
		 
		set.add("1");		set.add("2");
		set.add("3");		set.add("4");
		set.add("5");
	 
	 
		System.out.println("Iterator 반복자 사용하기");
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			
			//setB의 내용이 SetA에 포함되는가?
			Object tmp = it.next();
			System.out.print( tmp + " , ");			 
		}
		
		
		System.out.println("\n향상된 for 사용하기");
		for( Object  tmp : set) {
			System.out.print( tmp +",");
		}

		
		System.out.println("\n forEach");
		set.forEach( tmp -> System.out.print( tmp + ", "));
	 
	}
}
