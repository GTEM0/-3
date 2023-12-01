package ch11.stack_queue;
import java.util.*;

class PriorityQueueEx1 {
	
	//선입선출 구조이기 때문에 먼저 들어간 데이터가 먼저 꺼내짐	
	//넣기 (담기) 입력 ==> offer
	//꺼내기  삭제=> poll
	
	
	
	public static void main(String[] args) {
		Queue pq = new PriorityQueue();
		
		//큐에 넣기
		pq.offer(3);  // pq.offer(new Integer(3)); 오토박싱
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);

		System.out.println(pq); // pq의 내부 배열을 출력

		Object obj = null;

		// PriorityQueue에 저장된 요소를 하나씩 꺼낸다.
		while (!pq.isEmpty()) {
			
			//큐에서 꺼내기 
		    Object o = pq.poll();
		    System.out.println(o);
		}
	}
}
