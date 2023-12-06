package ch14.comparator;

public class B요리사  implements 한식요리가능한 {

	@Override
	public void 구절판만들기() {
		System.out.println( " B 구절판 만든다");
		
	}

	@Override
	public void 불고기전골만들기() {
		System.out.println( " B 불고기 만든다");
		
	}

	@Override
	public String 김치만들기() {		 
		return  "B요리사 김치 ";
	}
	

}
