package ch11.hashmap;
import java.util.*;

class HashMapEx1 {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);	 

		//키와값의 쌍의 형태로 데이터를 저장한다
		//검색이 빠르다
	  
		
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234");

	
		while(true) {
			System.out.println("id와 password를 입력해주세요.");
			System.out.print("id :");
			String id = s.nextLine().trim();

			System.out.print("password :");
			String password = s.nextLine().trim();
			System.out.println();

			// map에서 id를 키로 가진것이 있는지 !! 
			if(!map.containsKey(id)) {
				System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
				continue;  //아래코드를 수행하지 않고 다음 반복으로 진행
			} else {
				if(!(map.get(id)).equals(password)) {
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
				} else {
					System.out.println("id와 비밀번호가 일치합니다.");						
					break;  //반복문 종료
				}
			}
		} // while
	} // main의 끝
}


/*
 * 1.회원정보준비
 * 2.반복  (아이디와 비밀번호가 일치하면 종료합니다)
 *    2.1 아이디,비번입력
 *    2.2 아디가 존재하는지 판단
 *        -있는경우 비빌번호 판단
 *             -일치  :  아디디비번일치  !!! 성공 (종료)
 *             -비일치 :  비밀번호 불일치
 *        -없는경우
 *             -아이디 존재하지않음 *             
 * 3.종료       
 * 
 * 
 * 
 * 
 * 
 * 
 */
