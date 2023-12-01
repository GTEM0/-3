package annotation.basic;

import java.lang.reflect.Field;
import java.util.Arrays;

public class MyClass {

	
 //소스까지만
	@RetSource
	int  retSource;
	
//클래스까지	
	@RetClass
	int retClass;
	
//실행까지	
	@RetRuntime 
	int retRuntime;
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		
		Class myclass = Class.forName("annotation.basic.MyClass");
		for(   Field f : myclass.getDeclaredFields()) {		
			
			//Runtime 애너테이션만 확인되는것을 볼 수 있다
			if( f.getAnnotations().length >0) {				
				Arrays.stream(f.getAnnotations() ).forEach( s ->System.out.println(s));				 
			} 
			
		}
			
	}
}

/*
 * class ->  디컴파일 해보면  소스에붙여지는 애너테이션이 없어진걸 확인 할 수 있다
 * jd-gui-1.6.6-min.jar  다운로드 *
 * package aa.bb.zz;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class MyClass {
                  ==> source 레벨의 애너테이션이 사라진것을 확인 함 
  int retSource;
  
  @RetClass
  int retClass;
  
  @RetRuntime
  int retRuntime;
  
  public static void main(String[] args) throws ClassNotFoundException {
    Class<?> myclass = Class.forName("aa.bb.zz.MyClass");
    byte b;
    int i;
    Field[] arrayOfField;
    for (i = (arrayOfField = myclass.getDeclaredFields()).length, b = 0; b < i; ) {
      Field f = arrayOfField[b];
      if ((f.getAnnotations()).length > 0)
        Arrays.<Annotation>stream(f.getAnnotations()).forEach(s -> System.out.println(s)); 
      b++;
    } 
  }
}

 * 
*/