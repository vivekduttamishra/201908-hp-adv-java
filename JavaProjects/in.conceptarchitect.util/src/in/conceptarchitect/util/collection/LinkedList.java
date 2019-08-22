package in.conceptarchitect.util.collection;

import java.util.Iterator;

public class LinkedList<E> extends AbstractLinkedList<E>{

	@Override
	public LinkedList<E> add(E value) {
		// TODO Auto-generated method stub
		Node newNode=new Node();
		newNode.value=value;
		newNode.next=null; //this will be the last node
		
		newNode.previous=last; //current last will come before newNode
		if(first==null) //list is currently empty
			first=newNode; 
		else
			last.next=newNode; //newNode comes next to last Node
		
		last=newNode;
		count++;
		
		return this;
	}	
	
	
	
//	@Override
//	public boolean isEmpty() {
//		// TODO Auto-generated method stub
//		throw new RuntimeException("isEmpty is not supported");
//	}
	

}
