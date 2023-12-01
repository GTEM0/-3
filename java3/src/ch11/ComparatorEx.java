package ch11;
import java.util.*;

class ComparatorEx {
	public static void main(String[] args) {
		String[] strArr = {"cat", "Dog", "lion", "tiger"};

		Arrays.sort(strArr); // String의 Comparable구현에 의한 정렬
		System.out.println("strArr=" + Arrays.toString(strArr));
	 
	 	//Arrays.sort(strArr, new Descending()); // 역순 정렬
		//System.out.println("strArr=" + Arrays.toString(strArr));
		
		
		Arrays.sort(strArr,   new Comparator<>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return  o2.compareTo(o1);
			}}); // 역순 정렬
		System.out.println("strArr=" + Arrays.toString(strArr));
	}
}


//https://docs.oracle.com/javase/8/docs/api/
//String   클래스 

class Descending implements Comparator { 
	public int compare(Object o1, Object o2){
		if( o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			return c1.compareTo(c2) * -1 ; // -1을 곱해서 기본 정렬방식의 역으로 변경한다.
										   // 또는 c2.compareTo(c1)와 같이 순서를 바꿔도 된다.

		}
		return -1;
	} 
} 
