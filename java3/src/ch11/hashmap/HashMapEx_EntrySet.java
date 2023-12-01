package ch11.hashmap;
import java.util.*;

class HashMapEx_EntrySet {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("김자바",  90);
		map.put("김자바", 100);
		map.put("이자바", 100);
		map.put("강자바", 80);
		map.put("안자바", 90);
		
		
		/*class HashMap {		
		 *  Object[] key 
		 *  Object[] value
		 */
		
		
		 /*class HashMap{  
		  *    Entry table[];
		  *    
		  *    class Entry {         //innerClass  ( Entry는 HashMap과 깊은 관련 !!)
		  *       Object key ;
		  *       Object value;		    
		  *    }		   
		  } */

		 
		//map의 모든 키-값 쌍을 포함하는 Set을 얻기 위해 entrySet() 메소드를 사용
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println("이름 : "+ e.getKey() + ", 점수 : " + e.getValue());
		} 		
		
		//  map 요소 출력하기
		map.forEach( ( key,value) -> System.out.println( "이름:" + key + " ,  점수:" + value));

	 
	}
}
