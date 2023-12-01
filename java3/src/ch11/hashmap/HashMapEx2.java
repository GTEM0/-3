package ch11.hashmap;
import java.util.*;

class HashMapEx2 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("김자바",  90);
		map.put("김자바", 100);
		map.put("이자바", 100);
		map.put("강자바", 80);
		map.put("안자바", 90);

		 
		//map의 모든 키-값 쌍을 포함하는 Set을 얻기 위해 entrySet() 메소드를 사용
		Set set = map.entrySet();
		Iterator it = set.iterator();

		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println("이름 : "+ e.getKey() + ", 점수 : " + e.getValue());
		}

		// ★ 키값만 얻어오기
		Set keySet = map.keySet();
		System.out.println("참가자 명단 : " + keySet);

		//★ 값만 얻어오기
		Collection values = map.values();
		
		//Collection의 요소를 반복하는 방법
		it = values.iterator();   // iterator는 반복자의 의미 가짐

		int total = 0;
		while(it.hasNext()) {
			Integer i = (Integer)it.next();
			total += i.intValue();
		}

		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)total/set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최저점수 : " + Collections.min(values));
	}
}
