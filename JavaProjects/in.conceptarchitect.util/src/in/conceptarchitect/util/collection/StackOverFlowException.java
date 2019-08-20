package in.conceptarchitect.util.collection;

public class StackOverFlowException extends StackException {
	Object value;
	
	
	
	public Object getValue() {
		return value;
	}



	public StackOverFlowException(Object value) {
		super("Stack OverFlow while pushing "+value);
		this.value=value;
		
	}
}
