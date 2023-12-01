package interfaceEx;

interface SomethingDoI {
	public void doing();
}

public class LibA {

	public void forStart() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("★");
		}

	}

	public void forCharacter(char something) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(something);
		}
	}

	// 수행할 코드를 매개변수로 받고 싶다면 매서드, 함수 생각할 수 있다
	// 인터페이스로 구현해야 할 매서드만 정한다
	public void forSomethingDo(SomethingDoI a) {

		for (int i = 1; i <= 5; i++) {
			System.out.println(5 + " * " + i + " = " + (5 * i));
			a.doing();
			
		}
	}

}
