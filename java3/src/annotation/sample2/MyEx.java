package annotation.sample2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MyEx {

	// 전화번호와 이메일 필드(속성)에  MaxLen 애너테이션 붙이기
	// MaxLen 붙은 필드 검증하기
	// sample코드 참조해서 풀어보기
	
	@MaxLen(length = 14)
	String tel;
	
 

	public MyEx(String tel ) {
		super();
		this.tel = tel;
		 
	}

}
