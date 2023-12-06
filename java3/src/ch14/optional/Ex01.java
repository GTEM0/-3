package ch14.optional;

import java.util.ArrayList;
import java.util.Optional;

public class Ex01 {

	public static void main(String[] args) {

		String id = "hong";
		User user = searchUser(id);
		System.out.println("당신의 비번 : " + user.getPw());
		
		
		Optional<User> user2 = searchUserOptional(id);
		user2.ifPresentOrElse(value -> System.out.println(value), () -> System.out.println("검색결과없음"));
		
		

	}

	public static User searchUser(String id) {

		ArrayList<User> users = new ArrayList<>();

		users.add(new User("hong", "0000"));
		users.add(new User("kim", "9999"));
		users.add(new User("lee", "2222"));

		User result = null;

		for (User user : users) {

			if (user.getId().equals(id)) {
				result = user;

			}
		}
		return result;
	}

	public static Optional<User> searchUserOptional(String id) {

		ArrayList<User> users = new ArrayList<>();
		users.add(new User("hong", "0000"));
		users.add(new User("kim", "9999"));
		users.add(new User("lee", "222"));

		Optional<User> result = users.stream().filter(user -> user.getId().equals(id)).findFirst();
		return result;

	}

}
