package ch12.enum_;

//Enum 선언

//Enum :관련있는 상수들을 묶어 놓은 것
// jdk 1.5이후 부터 지원
// 상수표현  final 
// enum사용시 가독성과 실수로 인한 프로그램오류를 막을 수 있다.

enum Day {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class Enum사용 {
	public static void main(String[] args) {

		Day today = Day.WEDNESDAY;  // Day type의 변수에 정해진 값이 아닌 다른 값이 들어 올 수 없다
		System.out.println("오늘은 " + today);

		switch (today) {
		case MONDAY:
			System.out.println("월요일 스케쥴 ");
			break;
		case WEDNESDAY:
			System.out.println("수요일 스케쥴");
			break;
		case FRIDAY:
			System.out.println("금요일 스케쥴");
			break;
		default:
			System.out.println("잘못된 입력");
		}

		System.out.println("요일정보");
		for (Day day : Day.values()) {
			System.out.println(day);
		}
	}
}
