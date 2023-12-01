package annotation.sample3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	
	public static void main(String[] args) {		 
		Introduction[] objsToVerify = {
                new Introduction(
                        "한효주", 36, "배우",
                        "무빙 , 독전, 뷰티인사이드" , WeekDay.THU ),
                new Introduction(
                        "울트라", 4, "책",
                        "울트라러닝 ****** 세계 0.1%가 지식을 얻는 방법   2020년 출간"  , WeekDay.MON),             
                new Introduction(
                        "피카소", 0, "화가",
                        "마드리드왕립미술학교 , 이비뇽의 처녀들, 게르니카 ,파블로 루이스 피카소(스페인어: Pablo Ruiz Picasso, 1881년 10월 25일 ~ 1973년 4월 8일)는 스페인 말라가에서 태어나 주로 프랑스에서 미술활동을 한 20세기의 대표적 큐비즘 작가다. 대표작으로 《아비뇽의 처녀들》, 《게르니카》 등이 있다. " , WeekDay.WED),
                new Introduction(
                        "조지", 90, "하버드 교수",
                        " 조지베일런트 75년간  평생 연구결과  =>>1. 좋은배우자, 2. 어려움에 대처하는 자세 (정신건강)  , 3. 금연 , 4. 절주,  5.적당한체중  6. 규칙적인 운동습관 ,  7.공부 (지적호기심, 앎을 확장해 나아가는 것 ) " , WeekDay.MON)
                
               
        };

		
        List<Introduction> objsVerified = new ArrayList<>();
        for (Introduction obj : objsToVerify) {
            try {
            	//통과한 객체만 검증된 목록에 담긴다
                objsVerified.add(  객체검즘하기(obj) );
                System.out.println("✅ 통과");
            } catch (Exception e) {
                System.out.println("🛑 반려 : " + e.getMessage());
                e.printStackTrace();
            } finally { // ⭐️
                System.out.println("- - - - -");
            }
        }
        
        
        System.out.println("통과개수=" + objsVerified.size());
	}
	
	
	public static Introduction 객체검즘하기 (Introduction obj) throws Exception {
        Class  objClass = obj.getClass(); 

        for (Field f : objClass.getDeclaredFields()) {
            f.setAccessible(true);

            Object val = f.get(obj);
           
            for (Annotation a : f.getAnnotations()) {
                //  첫 글자 외 *으로
                if (a instanceof Blind) {
                    var s = (String) val;
                    f.set(obj, s.substring(0, 1) + "*".repeat(s.length() - 1));
                }

                //  최대 길이 검증
                if (a instanceof MaxLength) {
                    int maxLen = ((MaxLength) a).value();
                    if (((String) val).length() > maxLen) {
                        throw new Exception(
                                "%s 최대 길이(%d) 초과" + f.getName() +  maxLen);                        
                    }
                }

                

                //  가용 요일 검증
                if (a instanceof WeekDaysAvail) {
                	WeekDaysAvail wda = (WeekDaysAvail) a;
                    WeekDay wd = (WeekDay) f.get(obj);
                    WeekDay[] availables = wda.value();
                    var available = false;
                    for (var inAvail : availables) {
                        if (wd == inAvail) available = true;
                    }
                    if (!available) throw new Exception(
                            "해당 요일(%s) 불가 (해당 요일은 쉴수 없어요 !) : "  + wd.getName());
                }
            }
        }

        //  테스트해야 할 메소드 실행
        for ( Method   m : objClass.getDeclaredMethods()) {
            for (Annotation a : m.getAnnotations()) {
                if (a instanceof TestAndPrint) {
                	TestAndPrint tp = (TestAndPrint) a;
                    String printBefore = tp.before();
                    String printAfter = tp.after();

                    if (!printBefore.isBlank())
                        System.out.println(printBefore);
                    m.invoke(obj);
                    if (!printAfter.isBlank())
                        System.out.println(printAfter);
                }
            }

        }

        return obj;
    }

   

}
