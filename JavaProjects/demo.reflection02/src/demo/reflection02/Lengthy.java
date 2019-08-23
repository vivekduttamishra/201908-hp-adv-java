package demo.reflection02;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;

public interface Lengthy {
	int length();
	
	static int length(Object o) {
		Class<?> cls=o.getClass();
		try {
			
			Method lengthMethod= cls.getMethod("length");
			int len= (int) lengthMethod.invoke(o); //o.length()
			return len;
		} catch(Exception ex) {
			throw new NoSuchElementException(cls+" doesn't have length()");
		}
	}
}
