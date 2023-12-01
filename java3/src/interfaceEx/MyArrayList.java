package interfaceEx;

import java.util.function.Consumer;

public class MyArrayList {
	
	
	Object[] items =new Object[5];
	int index=0;
	
	
	void add( Object obj) {
		items[index]=obj;
		index++;
	} 
	
	Object get( int index) {
		return items[index];
	}
	
	
	void forEach(   Consumer  c ) {		
		for( int i=0; i< index ;i++) {			  //
			c.accept( get(i));  // 호출시 값이 전달됨
		} 
	} 
	
	
	public static void main(String[] args) {
		MyArrayList m = new MyArrayList();
		m.add("java");
		m.add("like");
		
		m.forEach( item ->  System.out.println( item) );
	}
}
