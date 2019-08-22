package in.conceptarchitect.util;

import java.util.stream.Stream;

public class Streams {

	public static Stream<Integer> range(int min,int max){
		return new Range(min,max).stream();
	}
	
	public static Stream<Integer> range(int max){
		return range(0,max);
	}
	
	public static Stream<Integer> infiniteRange(int min){
		return range(min,-1);
	}
	
	public static Stream<Integer> infiniteRange(){
		return infiniteRange(0);
	}
	
	public static Stream<Integer> primes(int min,int max,int count){
		
		Stream<Integer> stream= range(min,max).filter(PrimeUtils::isPrime);
		
		if(count>0)
			stream=stream.limit(count);
		
		return stream;
		
		
	}
	
	
	
}
