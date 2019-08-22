package in.conceptarchitect.util;

@FunctionalInterface  //annotation suggests its a function interface [OPTIONAL]
public interface Condition<T> {

	//A functional interface must have only one abstract method
	boolean isTrue(T value);
	
	//default methods don't make or break functional interface
	default boolean isFalse(T value) {
		return !isTrue(value);
	}
}
