package in.conceptarchitect.util.collection;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class ListIterableSpecs {

	AbstractLinkedList<Integer> list;
	
	@Before
	public void setup() {
		list=new LinkedList<Integer>();
		list.addMany(1,2,3,4,5);
	}
	
	@Test
	public void list_shouldSupportForEachLoop() {
		
		
		
		int sum=0;
		for(int value: list)
			sum+=value;
		
		assertEquals(15,sum);
		
	}
	
	@Test
	public void list_isIterable() {
		int count=0;
		int sum=0;
		Iterator<Integer> it=list.iterator();
		
		while(it.hasNext()) {
			sum+=it.next();
		}
		
		assertEquals(15, sum);
		
	}
	
}
