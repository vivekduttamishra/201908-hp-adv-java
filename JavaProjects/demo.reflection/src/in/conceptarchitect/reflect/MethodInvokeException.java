package in.conceptarchitect.reflect;

public class MethodInvokeException extends RuntimeException {

	String methodName;
	
	public MethodInvokeException() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	public MethodInvokeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
		
	}

	public MethodInvokeException(String methodName,String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
		this.methodName=methodName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public MethodInvokeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MethodInvokeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
