package in.conceptarchitect.util.collection;

public class ComparableSortedLinkedList<T extends Comparable<T>> extends AbstractLinkedList<T> {

	@Override
	public ComparableSortedLinkedList<T> add(T value) {
		// TODO Auto-generated method stub
		Node newNode=new Node();
		newNode.value=value;
		
		if(first==null) {
			first=newNode;
			last=newNode;
			
		}else {
			//find a node with value greater than  current node
			Node n=first;
			//while(n!=null && n.value<=value)    // n.value - value <=0
			while(n!=null && n.value.compareTo(value)<=0)
				n=n.next;
			
			if(n==null) { //we got the value larger than any other in list
				newNode.previous=last;
				newNode.next=null;
				last.next=newNode;
				last=newNode;
				
			} else {
				//we must insert newNode before n
				newNode.next=n; //newNode comes before n
				newNode.previous=n.previous; //newNode is inserted here
				
				if(n==first)
					first=newNode;
				else
					n.previous.next=newNode;
				
				n.previous=newNode;
			}
		}
		
		count++;
		return this;
	}

}
