package ch14.comparator;

public class A요리사   implements 한식요리가능한 {

	@Override
	public void 구절판만들기() {
		System.out.println( "구절판 만든다");
		
	}

	@Override
	public void 불고기전골만들기() {
		System.out.println( "불고기 만든다");
		
	}

	@Override
	public String 김치만들기() {
		 
		return  "A요리사 김치 새우젓갈";
	}

}
