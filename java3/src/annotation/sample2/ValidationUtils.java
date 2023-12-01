package annotation.sample2;

import java.lang.reflect.Field;

public class ValidationUtils {	
	public static void main(String[] args) throws IllegalAccessException {		
		MyEx  myex = new MyEx("010-1111-222211" );		
		필드검증하기( myex);			
	}

	                
    public static void 필드검증하기(Object obj) throws IllegalAccessException {    	
    	
    	//객체의 정보가져오기
        Class  clazz = obj.getClass();
        
        //객체의 정보로 부터 선언된 필드가져오기
        Field[] fields = clazz.getDeclaredFields();

        
        for (Field field : fields) {
        	//field에 대한 애너테이션정보 얻어오기
        	MaxLen annotation = field.getAnnotation(MaxLen.class);

            if (annotation != null) {
                field.setAccessible(true);  // private 이어도 접근가능하도록 한다 . 리플렉션은 객체의 캡슐을 깰 수 있다.
                Object value = field.get(obj);  //객체정보 제공 => 필드 정보 얻어오기

                if (value != null && value instanceof String) {
                    int expectedValue = annotation.length();   //애너테이션에 설정한 값
                    String fieldValue = (String) value;             //실제 변수값

                      
                    if (fieldValue.length() >  expectedValue) {
                        throw new IllegalArgumentException(
                                  field.getName() + "항목은  "+ expectedValue+ " 길이를 넘었어 ! !! " );
                    }
                }
            }
        }
    }
}
