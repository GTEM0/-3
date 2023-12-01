package annotation.실습;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//
@Retention(RetentionPolicy.RUNTIME)
public @interface Count {
	int count();	//int value();	//생략할 수 있다
}
