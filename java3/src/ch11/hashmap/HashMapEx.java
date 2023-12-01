package ch11.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;

public class HashMapEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("김자바",  90);
		map.put("김자바", 100);
		map.put("이자바", 100);
		map.put("강자바", 80);
		map.put("안자바", 90);
		
		
		
	 Set set =	map.entrySet();
	  
	 Iterator it  =set.iterator();
	 
	 while( it.hasNext()) {
		 Map.Entry e = ( Map.Entry) it.next();
		 System.out.println( "키" +  e.getKey()  +  "값:" +  e.getKey());
	 }
	 
	 // 1.8 람다식 	 
	 map.forEach(  ( key, value) -> System.out.println(  "키:" + key   + "값:"+ value));

	 
	 
	 map.forEach(  new BiConsumer<>() {
		@Override
		public void accept(String t, Integer u) {		 
			System.out.println( "키" +  t  + "값" + u);			
		}});
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
		
		
		
		
		
	 		
	}

}
