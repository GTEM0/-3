package ch11.hashset;

import java.util.Objects;


//객체가 같다는 것의 의미는  객체마다 다르다.
//재정의 해줘야 함 !! equals, hash 재정의  
public class User {
	
	String id;
	String pw;
	@Override
	public int hashCode() {
		return Objects.hash(id, pw);
	}
	
	
	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)  //내자신과 비교
			return true;
		if (obj == null) //당연히 거짓
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(pw, other.pw);
	}
	
	
	public static void main(String[] args) {
		User user= new User("victoai" , "1234");
		User user2= new User("victoai" , "1234");
		// 해시코드  => 객체의 고유한 정수 표현
		
		System.out.println(user.hashCode());
		System.out.println(user2.hashCode());
		
		
	}
	

}
