package annotation.sample1;

import java.lang.reflect.Field;

public class ValidationUtils {	
	public static void main(String[] args) throws IllegalAccessException {		
		MyEx  myex = new MyEx(3,5);		
		필드검증하기( myex);			
	}

	                
    public static void 필드검증하기(Object obj) throws IllegalAccessException {    
    	
    	//객체의 정보가져오기
        Class  clazz = obj.getClass();
        
        //객체의 정보로 부터 선언된 필드가져오기
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
        	//field에 대한 애너테이션정보 얻어오기
            Count annotation = field.getAnnotation(Count.class);

            if (annotation != null) {
                field.setAccessible(true);  // private 이어도 접근가능하도록 한다
                Object value = field.get(obj);  //객체정보 제공 => 필드의 값얻어오기

                if (value != null && value instanceof Integer) {
                    int expectedValue = annotation.value();   //애너테이션에 설정한 값
                    int fieldValue = (int) value;             //실제 변수값

                    if (fieldValue != expectedValue) {
                        throw new IllegalArgumentException(
                                  field.getName() + "항목은  "+ expectedValue+ " 값이어야 해 !! " );
                    }
                }
            }
        }
    }
}
