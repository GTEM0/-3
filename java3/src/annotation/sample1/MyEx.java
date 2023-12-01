package annotation.sample1;

  

public class MyEx {	
	@Count(value=3)
	private int apples;
	
	@Count(5)
	private int bananas;
	
	
	private int tomato;

	public MyEx(int apples, int bananas) {
		super();
		this.apples = apples;
		this.bananas = bananas;
	}
}
