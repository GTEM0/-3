package 날짜;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateEx {

	public static void main(String[] args) {
        // java.time의 클래스들은 생성자 대신 필요에 따라 적합한 클래스 메소드로 인스턴스 생성

        //현재 날짜 LocalDate
        LocalDate today = LocalDate.now();
        System.out.println( "현재날짜 ="+ today);

        //현재 시간 LocalTime
        LocalTime thisTime = LocalTime.now();
        System.out.println("현재시간="+ thisTime);

        //현재 시간과 날짜 LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        System.out.println("현재날짜와 시간="+ now);
        
        //now 메서드 : 현재의 시간/날짜 정보를 가진  해당 클래스의 인스턴스를 반환   시스템(컴퓨터)의 시계를 기준으로 함
        System.out.println("\n- - - - -\n");

        
        //특정날짜로 날짜 생성하기
        LocalDate christmas23 = LocalDate.of(2023, 12, 25);
        System.out.println("christmas23="+ christmas23);

        LocalTime lunchTime = LocalTime.of(12, 30);
        System.out.println( "lunchTime="  + lunchTime);
      

        LocalDateTime familyDinner = LocalDateTime.of(  2023, 12, 25, 18, 00  );
        System.out.println(familyDinner);
        //  LocalDateTime 인스턴스는 LocalDate와 LocalTime 인스턴스의 조합으로
        //  만들어짐 클래스 코드에서 확인 (of 메소드)
        
        
		System.out.println("\n- - - - -\n");

        //  ⭐️ java.time의  Local... 클래스 인스턴스들은 불변
        //  - 생성자 사용이 금지된 것은 인스턴스 생성을 제한하기 위함
        //  - of 메소드를 사용하여, 적절할 때만 생성된 것을 받도록

        //  주어진 차이만큼의 시간이나 날짜를 '새로 만들어' 반환
        today.plusDays(1);     // ⭐️ 기존 인스턴스는 변하지 않음
        LocalDate tomorrow = today.plusDays(1);
        LocalDate yesterday = today.minusDays(1);

        LocalDate[]  days   = new LocalDate[] {today, tomorrow, yesterday} ;
        
        for (LocalDate day : days) {
            System.out.println(day);
        }
        
        //3개월 후
        LocalDate threeMonthsLater = today.plusMonths(3);
        System.out.println(threeMonthsLater ); 
        
        //10년전
        LocalDate tenYearsBefore = today.minusYears(10);
        System.out.println(tenYearsBefore );
        

        //  시간차이 구하기
        //   Period 클래스 : 두 날짜 사이의 간격을 다루는 클래스
        LocalDate childrensDay30 = LocalDate.of(2030, 5, 5);
        Period toChldDay30 = Period.between(today, childrensDay30);
        int[] toChldDay30inUnits = {
                toChldDay30.getYears(),
                toChldDay30.getMonths(),
                toChldDay30.getDays()
        }; // 연, 월, 일 부분 각각 표시
        
        
        System.out.println( " 2025년 5월 5일과 현재날짜사이의 간격 , 차이 구함 " );
        for( int  unit : toChldDay30inUnits) {
        	System.out.println("==>"+ unit);
        }
         
        
        //  - DateTimeFormatter 클래스의 ofPattern 메소드 사용
        DateTimeFormatter formatter1 =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        DateTimeFormatter formatter2 =
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        DateTimeFormatter formatter3 =
                DateTimeFormatter.ofPattern("yy.MM.dd");

        DateTimeFormatter formatter4 =
                DateTimeFormatter.ofPattern("dd/MM/yyyy hh a");

        DateTimeFormatter formatter5 =
                DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시");

        //  DateTimeFormatter 클래스의 코드에서 각 형식 요소 확인

        
        DateTimeFormatter[] formatters  =  new DateTimeFormatter [] {formatter1,formatter2,formatter3,formatter4,formatter5 };
        
        
        for (DateTimeFormatter  formatter : formatters ) {
            //   형식에 따라 시간을 문자열로 
            System.out.println("****=>"+now.format(formatter));
        }
		 
        
        //역 : 문자열에서 시간 인스턴스로
        String christmas = "2025-12-25";
        DateTimeFormatter df1 =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate christmas25 = LocalDate
                .parse(christmas , df1);
        
        
        System.out.println( "christmas25"+ christmas25);
        
          // 시간 정보는 있는 경우 LocalDateTime사용해야 함
        String christmas_dinner = "2025/12/25 18:00:00";
        DateTimeFormatter formatterB =
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime christmas25dinner = LocalDateTime
                .parse(christmas_dinner, formatterB);
        
        
        System.out.println("christmas25dinner"+ christmas25dinner);

	}

}
