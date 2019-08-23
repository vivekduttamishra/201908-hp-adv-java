package in.conceptarchitect.animalkingdom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Speciality {

	String name();
	
	String requires() default("");
	
	String follows() default("");

}
