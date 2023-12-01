package ch14.comparator;

public interface 한식요리가능한 {

	
	void 구절판만들기();
	void 불고기전골만들기();	 
	String  김치만들기();
	
	
	//모든 한식요리가능한 인터페이스를 구현하는 클래스들이 모두 똑같은 기능을 구현해야 한다면
	//개별적으로 implements 하는것이 아니라 하나의 구현을 제공할 수 있다.
	//default 매서드
	default void 김치만두만들기() {
		String result =김치만들기();		
		System.out.println( "만두피 만들기");
		System.out.println( "김치넣기");
		System.out.println( "대파및 당면 양념한거 섞기");
		System.out.println( "중불에 15분 찌기");	
		
	}
	
	 
}
