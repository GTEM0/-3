package ch14.stream;

import java.io.*;
import java.util.stream.*;

class StreamEx2 {
	public static void main(String[] args) {
		File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1"),
				new File("Ex1.txt") };

		Stream<File> fileStream = Stream.of(fileArr);

		// map()으로 Stream<File>을 Stream<String>으로 변환
		Stream<String> filenameStream = fileStream.map(File::getName);
		filenameStream.forEach(System.out::println); // 모든 파일의 이름을 출력

		fileStream = Stream.of(fileArr); // 스트림을 다시 생성

		System.out.println("파일의 확장자를 대문자로 출력하기 ");

		fileStream.map(File::getName) // Stream<File> → Stream<String>
				.filter(s -> s.indexOf('.') != -1) // 확장자가 없는 것은 제외
				.map(s -> s.substring(s.indexOf('.') + 1)) // 확장자만 추출
				.map(String::toUpperCase) // 모두 대문자로 변환
				.distinct() // 중복 제거
				.forEach(System.out::print); // JAVABAKTXT

		System.out.println();

		fileStream = Stream.of(fileArr); // 스트림을 다시 생성

		System.out.println("파일의 확장자를 대문자로 출력하기 ");

		Stream<String> extStream = fileStream.map(File::getName) // Stream<File> → Stream<String>
				.filter(s -> s.indexOf('.') != -1) // 확장자가 없는 것은 제외
				.map(s -> s.substring(s.indexOf('.') + 1)) // 확장자만 추출
				.map(String::toUpperCase); // 모두 대문자로 변환
		
		
		System.out.println("확장자 출력");
	//	extStream.forEach( str ->System.out.println(str));  //람다식
		extStream.forEach(  System.out::println );  //매서드 참조

	}
}
