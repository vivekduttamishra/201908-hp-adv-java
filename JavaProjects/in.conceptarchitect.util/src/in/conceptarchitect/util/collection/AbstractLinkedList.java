package in.conceptarchitect.util.collection;

public abstract class AbstractLinkedList {
	class Node {
	
		public int value;
		public Node next;
		public Node previous;
	}
	Node first;
	int count;
	Node last;
	
	public int size() {
		
//		int count=0;
//		for(Node n=first;n!=null;n=n.next)
//			count++;
		
		return count;
		
	}
	
	public abstract AbstractLinkedList add(int value);
	
	
	public String toString() {
		
		if(size()==0)
			return "LinkedList()";
		
		String str="LinkedList(\t";
		
		for(Node n=first; n!=null;n=n.next)
			str+=n.value+"\t";
		
		str+=")";
		
		return str;
	}
	
	public int get(int index) {
//		if(index>=size())
//			return -1;
		Node n = _locate(index);
			
		return n.value;
	}
	private Node _locate(int index) {
		if(size()>0 && (index==-1 || index==size()-1) )
			return last;
		if(index<0 || index>=size())
			throw new IndexOutOfBoundsException(index);
			//return last;
		
		Node n=first;
		for(int i=0;i<index;i++)
			n=n.next;
		return n;
	}
	
	
	public void set(int index, int value) {
		
		Node n = _locate(index);
		
		n.value=value;
		
	}
	public int remove(int index) {
		
		Node n= _locate(index);
		
		if(n==first)
			first=n.next;
		else
			n.previous.next=n.next;
		
		if(n.next!=null) //not the last node
			n.next.previous=n.previous;
			
		//BUG FIXED: Missing count adjustment added
		count--;
		//del n; //--> java gc will claim it
		return n.value;
	}
	
	
	
	
	
}
