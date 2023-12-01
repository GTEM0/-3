package annotation.실습;

import java.lang.reflect.Field;

public class 검증 {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		MyEx myex = new MyEx(3);
		검증하기(myex);
		
		
		
	}
	
	public static void 검증하기(Object obj) throws IllegalArgumentException, IllegalAccessException {
		
		Class clazz = obj.getClass();		
		Field[] fields = clazz.getDeclaredFields();		
		for(Field field : fields) {			
			Count annotation = field.getDeclaredAnnotation(Count.class);			
			if(annotation != null) {
				field.setAccessible(true);
				Object value = field.get(obj);
				
				if(value != null & value instanceof Integer) {
					int expectedValue = annotation.count();
					int fieldValue = (int)value;
					
					if(fieldValue != expectedValue) {
						throw new IllegalArgumentException(field.getName() + "필드는" + expectedValue + "값이여야해!");
						
						
					}
					
					
					
				}
				
				
				
			}
			
		}
		
		
	}
	
	
	
}
