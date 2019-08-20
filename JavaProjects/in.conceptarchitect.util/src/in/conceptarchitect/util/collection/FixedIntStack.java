package in.conceptarchitect.util.collection;

public class FixedIntStack {
	//boolean empty=true;
	int top=0;
	//int size;
	int values[];
	public FixedIntStack(int size) {
		// TODO Auto-generated constructor stub
		//this.size=size;
		values=new int[size];
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==0;
	}

	public void push(int value) {
		// TODO Auto-generated method stub
		//empty=false;
		if(isFull())
			throw new StackOverFlowException(value);
		values[top]=value;
		top++;
		
	}

	public boolean isFull() {
		// TODO Auto-generated method stub
		return top>=values.length;
	}

	public int pop() {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new StackUnderFlowException();
		
		top--;
		
		return values[top];
		
	}

}
