package in.conceptarchitect.util.collection.primitives;

import in.conceptarchitect.util.collection.StackOverFlowException;
import in.conceptarchitect.util.collection.StackUnderFlowException;

public class FixedStringStack {
	//boolean empty=true;
	int top=0;
	//int size;
	String values[];
	public FixedStringStack(int size) {
		// TODO Auto-generated constructor stub
		//this.size=size;
		values=new String[size];
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==0;
	}

	public void push(String i) {
		// TODO Auto-generated method stub
		//empty=false;
		if(isFull())
			throw new StackOverFlowException(0);
		values[top]=i;
		top++;
		
	}

	public boolean isFull() {
		// TODO Auto-generated method stub
		return top>=values.length;
	}

	public String pop() {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new StackUnderFlowException();
		
		top--;
		
		return values[top];
		
	}

}
