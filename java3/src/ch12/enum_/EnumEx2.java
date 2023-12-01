package ch12.enum_;

//Enum 정의
//Enum 상수에 값을 다르게 지정하려면 인스턴스 변수와 생성자 필요함
enum Transportation {
	 BUS(100),	 TRAIN(150),	 SHIP(100),	 AIRPLANE(300);
	
	//인스턴스 변수추가
	 final int BASIC_FARE; 
	
	 // 생성자 필요함
	 Transportation(int basicFare) {
	     BASIC_FARE = basicFare;
	 }	
	 
	 int fare(int distance) {
	     return distance * BASIC_FARE;
	 }
	 
	 public int getBasicFare() { return BASIC_FARE; }
}

//메인 클래스
public class EnumEx2 {
 public static void main(String[] args) {
     // Enum 사용
     System.out.println("bus fare=" + Transportation.BUS.fare(100));
     System.out.println("train fare=" + Transportation.TRAIN.fare(100));
     System.out.println("ship fare=" + Transportation.SHIP.fare(100));
     System.out.println("airplane fare=" + Transportation.AIRPLANE.fare(100));     
     System.out.println("airplane basic fare=" + Transportation.AIRPLANE.getBasicFare());
 }
}
