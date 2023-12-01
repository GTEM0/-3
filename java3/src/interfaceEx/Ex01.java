package interfaceEx;

interface SomethingDoI2 {

	public void doI();
}

public class Ex01 implements SomethingDoI2 {

	public void forStart() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i <= 10 / 2) {
					if (j >= 10 / 2 - i && j <= 10 / 2 + i)
						System.out.print("*");
					else
						System.out.print(" ");
				} else {
					if (j >= i - 10 / 2 && j <= 10 - i + 10 / 2 - 1)
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public void forCharacter(char something) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(something);
		}
	}

	public void forSomethingDo(SomethingDoI2 somethingDo) {
		for (int i = 1; i <= 5; i++) {

			somethingDo.doI();
		}
	}

	@Override
	public void doI() {
		System.out.println("d=====(￣▽￣*)b");

	}

}
