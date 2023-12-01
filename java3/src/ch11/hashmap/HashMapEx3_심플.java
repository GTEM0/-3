package ch11.hashmap;

import java.util.*;

class HashMapEx3_심플 {

	public static void main(String[] args) {

		HashMap phoneBook = new HashMap();

		HashMap 친구리스트 = new HashMap();
		phoneBook.put("친구", 친구리스트);

		친구리스트.put("010-111-1111", "이자바");
		친구리스트.put("010-222-2222", "김자바");
		친구리스트.put("010-333-3333", "김자바");

		HashMap 회사리스트 = new HashMap();
		phoneBook.put("회사", 친구리스트);

		회사리스트.put("010-444-4444", "김대리");
		회사리스트.put("010-555-5555", "김대리");
		회사리스트.put("010-666-6666", "박대리");
		회사리스트.put("010-777-7777", "이과장");

		HashMap 기타리스트 = new HashMap();
		phoneBook.put("기타", 기타리스트);

		기타리스트.put("010-888-8888", "세탁");
		

		Set<Map.Entry<String, HashMap<String, String>>> entrySet = phoneBook.entrySet();
		Iterator<Map.Entry<String, HashMap<String, String>>> iterator = entrySet.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, HashMap<String, String>> entry = iterator.next();
			
			
			String category = entry.getKey();
			HashMap<String, String> categoryList = entry.getValue();

			System.out.println("[" + category + "]");

			Set<Map.Entry<String, String>> subEntrySet = categoryList.entrySet();
			Iterator<Map.Entry<String, String>> subIterator = subEntrySet.iterator();

			while (subIterator.hasNext()) {
				Map.Entry<String, String> subEntry = subIterator.next();
				String phoneNumber = subEntry.getKey();
				String name = subEntry.getValue();

				System.out.println(phoneNumber + " - " + name);
			}

			System.out.println(); // 카테고리 간 구분을 위한 빈 줄 출력
		}
	}
} // main
