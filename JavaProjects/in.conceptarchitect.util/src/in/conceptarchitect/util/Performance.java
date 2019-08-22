package in.conceptarchitect.util;

public class Performance {
	
	public static <R> PerformanceResult<R> measure(String message, Function<R> function ){
		PerformanceResult<R> result=new PerformanceResult<>(message);
		result.start();
		R answer= function.execute();
		result.end(answer);
		
		return result;
		
	}

}
