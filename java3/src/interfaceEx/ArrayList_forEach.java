package interfaceEx;

import java.util.ArrayList;

public class ArrayList_forEach {

	public static void main(String[] args) {
		 
		
		ArrayList<String> list =new ArrayList<>();
		
		list.add("서울");
		list.add("대전");		
		list.add("부산");
		
		//반복하는함수  =>반복하면서 해야할 일을 알려줘
		//    
		//list.forEach();
		list.forEach( item -> System.out.println( item));		
		
	}

}
