package in.conceptarchitect.util.collection;

public class FixedStack<X> {
	//boolean empty=true;
	int top=0;
	//int size;
	X values[]; //creatijng a
	public FixedStack(int size) {
		// TODO Auto-generated constructor stub
		//this.size=size;
		//values= new X[size]; //java doesn't allow to create generic array
		
		values=(X[]) new Object[size]; //hack solution
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==0;
	}

	public void push(X i) {
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

	public X pop() {
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
