package in.conceptarchitect.util.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

import in.conceptarchitect.util.Action;

public abstract class AbstractLinkedList<E> 
		implements IndexedList<E> {
	
	@Override
	public void each(Action<E> action) {
		
		for(Node n=first;n!=null;n=n.next)
			action.perform(n.value);
	}
	
	class Node {
	
		public E value;
		public Node next;
		public Node previous;
	}
	Node first;
	int count;
	Node last;
	
	@Override
	public int size() {
		return count;
	}
	
	@Override
	public abstract IndexedList<E> add(E value);
	
	
	public String toString() {
		
		if(size()==0)
			return "LinkedList()";
		
		String str="LinkedList(\t";
		
		for(Node n=first; n!=null;n=n.next)
			str+=n.value+"\t";
		
		str+=")";
		
		return str;
	}
	
	@Override
	public E get(int index) {
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
	
	
	@Override
	public AbstractLinkedList<E> set(int index, E value) {
		
		Node n = _locate(index);		
		n.value=value;
		return this;
		
	}
	public E remove(int index) {
		
		Node n= _locate(index);
		
		if(n==first)
			first=n.next;
		else
			n.previous.next=n.next;
		
		if(n.next!=null) //not the last node
			n.next.previous=n.previous;
			
		count--;

		return n.value;
	}

	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator();
	}
	
	class MyIterator implements Iterator<E>{

		Node current=first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if(!hasNext())
				throw new NoSuchElementException();
			E value= current.value;
			current=current.next;
			return value;
		}
		
	}
	
	
	
}
