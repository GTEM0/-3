package ch11.treeset;
import java.util.*;

class TreeSetEx1 {
	public static void main(String[] args) {
	
		
		
		/*
		 * 범위탐색, 정렬에 유리함
		 * 이진트리는 모든 노드가  최대 2개의 하위노드를 갖음
		 * 클래스 객체를 저장할 때는  Comparable 인터페이스를 구현해야 한다. !!
		 */
		TreeSet set = new TreeSet();

		String from = "b";
		String to	= "d";

		set.add("abc");
		set.add("alien");
		set.add("bat");
		set.add("car");
		set.add("Car");
		set.add("disc");
		set.add("dance");
		set.add("dZZZZ");
		set.add("dzzzz");
		set.add("elephant");
		set.add("elevator");
		set.add("fan");
		set.add("flower");

		System.out.println(set);
		System.out.println("range search : from " + from  +" to "+ to);
		
		System.out.println("result1 : " + set.subSet(from, to));
		System.out.println("result2 : " + set.subSet(from, to + "zzz"));
		 
		
	}
}
