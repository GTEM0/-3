package annotation.실습;

public class MyEx {

	@Count(count = 2)
	private int apples;

	public MyEx(int apples) {
		super();
		this.apples = apples;
	}

	@Override
	public String toString() {
		return "MyEx [apples=" + apples + "]";
	}
	
	
}
