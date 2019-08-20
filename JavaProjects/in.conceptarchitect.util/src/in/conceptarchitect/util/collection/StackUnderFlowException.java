package in.conceptarchitect.util.collection;

public class StackUnderFlowException extends StackException {

	public StackUnderFlowException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public StackUnderFlowException() {
		super("Stack Underflow");
	}

}
