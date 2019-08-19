package old;

public class LinkedList {
	
	class Node{
		public int value;
		public Node next;
		public Node previous;
	}
	
	Node first;
	
	public void add(int value) {
		Node n=new Node();
		n.value=value;
		n.next=null;
		
		Node last=first;
		if(last!=null) {
			while(last.next!=null)
				last=last.next;
		}
		n.previous=last;
		
		if(first==null)
			first=n;
		else
			last.next=n;
		
	}
	
	public int get(int pos) {

		if(pos<0 || pos>=size())
			throw new IndexOutOfBoundsException(pos);
		
		Node n= first;
		int count=0;
		while(count<pos) {
			count++;
			n=n.next;
		}
		
		return n.value;			
	}
	
	public void set(int pos,int value) {
		
		if(pos<0 || pos>=size())
			throw new IndexOutOfBoundsException(pos);
		
		Node n= first;
		int count=0;
		while(count<pos) {
			count++;
			n=n.next;
		}		
		n.value=value;
		
	}
	
	public void remove(int pos) {
		
		
		if(pos<0 || pos>=size())
			throw new IndexOutOfBoundsException(pos);
		
		int prev=pos-1; //locate pos
		
		Node n= first;
		int count=0;
		while(count<prev) {
			count++;
			n=n.next;
		}
		
		if(pos==0) {
			first=first.next;
		}
		else {
			if(n.next!=null) //there is atleast one more node
				n.next=n.next.next;
			else
				first=null; //deleted the only node
		}
			
		
	}
	
	public int size() {
		int c=0;
		for(Node n=first;n!=null;n=n.next) {
			c++;
		}
		
		return c;
	}
	
	public String toString() {
		String s="LinkedList(\t";
		for(Node n=first;n!=null;n=n.next)
			s+=n.value+"\t";
		
		s+=")";
		
		return s;
	}

}
