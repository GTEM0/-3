package interfaceEx;

import java.util.Scanner;

public class 문제연습 {
	public static void main(String[] args) {
		LibA li = new LibA();

		li.forStart();

		li.forCharacter('1');

		li.forSomethingDo(new SomethingDoI() {

			@Override
			public void doing() {
				System.out.println("뭐든 해봐");
			}
		});

		li.forSomethingDo(new SomethingDoI() {
			@Override
			public void doing() {
				System.out.println("원하는 단을 입력하세요 : ");
				Scanner sc = new Scanner(System.in);
				int a = sc.nextInt();

				System.out.println(a + "단 입니다 : ");

				sc.close();
			}
		});

	}
}
