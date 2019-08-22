package in.conceptarchitect.util;

public class PerformanceResult<R> {
	
	R result;
	long timeTaken;
	String message;
	
	long startTime;
	long endTime;
	
	public void start() {
		startTime=System.currentTimeMillis();
	}
	public void end(R result) {
		endTime=System.currentTimeMillis();
		timeTaken=endTime-startTime;
		this.result=result;
	}
	
	public PerformanceResult(String message) {
		super();		
		this.message = message;
	}

	public PerformanceResult() {
		super();
	}

	public R getResult() {
		return result;
	}

	public void setResult(R result) {
		this.result = result;
	}

	public long getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(long timeTaken) {
		this.timeTaken = timeTaken;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

	@Override
	public String toString() {
		return "PerformanceResult [" + message + ": result=" + result + ", timeTaken:" + timeTaken + " ms]";
	}
	
	
	

}
