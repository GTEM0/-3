package annotation.sample3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//아무값이 없는 애너테이션 마커 애너테이션 
@Target( ElementType.FIELD)
@Retention( RetentionPolicy.RUNTIME)
public @interface Blind {}
