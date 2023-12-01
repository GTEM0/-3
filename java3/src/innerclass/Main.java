package innerclass;

public class Main {
	
	  public static void main(String[] args) {
		  
		//  Outer클래스의 정적멤버클래스를 사용한 객체 생성
	        Outer.InnerSttcMember staticMember = new Outer.InnerSttcMember();
	        staticMember.func();

	        System.out.println("\n- - - - -\n");

	        Outer outer = new Outer();
	        outer.innerFuncs();

	        System.out.println("\n- - - - -\n"); 
	     
	        //    인스턴스 내부 클래스는 이렇게 얻을 수 있음
	        Outer.InnerInstMember innerInstMember = outer.getInnerInstMember();
	        innerInstMember.func();

	        System.out.println("\n- - - - -\n");

	        outer.memberFunc();
	}

}
