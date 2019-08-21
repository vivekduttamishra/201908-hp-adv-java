package in.conceptarchitect.util.collection.primitives;

import in.conceptarchitect.util.collection.StackOverFlowException;
import in.conceptarchitect.util.collection.StackUnderFlowException;

public class FixedObjectStack {
	//boolean empty=true;
	int top=0;
	//int size;
	Object values[];
	public FixedObjectStack(int size) {
		// TODO Auto-generated constructor stub
		//this.size=size;
		values=new Object[size];
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==0;
	}

	public void push(Object i) {
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

	public Object pop() {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new StackUnderFlowException();
		
		top--;
		
		return values[top];
		
	}
	
	public String toString() {
		if(isEmpty())
			return "FixedStack()";
		String str="FixedStack";
		if(isFull())
			str+="[\t";
		else
			str+="(\t";
		
		for(int i=top-1;i>=0;i--)
			str+= values[i]+"\t";
		
		if(isFull())
			str+="]";
		else
			str+=")";
		
		return str;
		
	}

}
