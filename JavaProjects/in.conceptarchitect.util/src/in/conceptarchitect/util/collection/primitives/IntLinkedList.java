package in.conceptarchitect.util.collection.primitives;

import in.conceptarchitect.util.collection.primitives.AbstractIntLinkedList.Node;

public class IntLinkedList extends AbstractIntLinkedList{

	@Override
	public AbstractIntLinkedList add(int value) {
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

}
