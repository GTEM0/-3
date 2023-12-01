package ch11.hashset;
import java.util.*;

class HashSetEx5 {
	public static void main(String args[]) {
		HashSet setA    = new HashSet();
		HashSet setB    = new HashSet();
		
		HashSet setHab = new HashSet();
		HashSet setKyo = new HashSet();
		HashSet setCha = new HashSet();

		setA.add("1");		setA.add("2");
		setA.add("3");		setA.add("4");
		setA.add("5");
		System.out.println("A = "+setA);

		setB.add("4");		setB.add("5");
		setB.add("6");		setB.add("7");
		setB.add("8");
		System.out.println("B = "+setB);

		
		//set을 반복하기 위해서 Itertor를 사용한다. 반복자의 의미를 가졌음 
		//set을 반복하기 위한 방법이라고 생각하면된다
		
		Iterator it = setB.iterator();
		while(it.hasNext()) {
			
			//setB의 내용이 SetA에 포함되는가?
			Object tmp = it.next();
			if(setA.contains(tmp))
				setKyo.add(tmp);  // 교집합
		}

		it = setA.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(!setB.contains(tmp))
				setCha.add(tmp);  // 차집합
		}

		it = setA.iterator();
		while(it.hasNext())
			setHab.add(it.next());  // A를 다 담음

		it = setB.iterator();
		while(it.hasNext())         // B를 다 담음
			setHab.add(it.next());  // 합집합

		System.out.println("A  B 교집합 = "+setKyo);  
		System.out.println("A  B 합집합 = "+setHab);   
		System.out.println("A - B = "+setCha); 
	}
}
