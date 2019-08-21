package in.conceptarchitect.util.collection.primitives;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.util.collection.primitives.AbstractIntLinkedList;
import in.conceptarchitect.util.collection.primitives.SortedIntLinkedList;

public class SortedIntLinkedListSpecs {
	SortedIntLinkedList list;
	int initialSize;
	
	@Before  //this code executes before every test
	public void arrange() {
		list=new SortedIntLinkedList();

	}
	
	@Test
	public void type_SortedLinkedListIsATypeOfAbstractLinkedList() {
		assertTrue( list instanceof AbstractIntLinkedList);
	}
	
	@Test
	public void add_toEmptyListAddsAtTheBegining() {
		list.add(20);
		assertEquals(20, list.first.value);
	}
	
	@Test
	public void add_addsHigestItemAtTheEnd() {
		list.add(5);		
		list.add(15);
		list.add(4);
		
		assertEquals(15,list.last.value);
		
	}
	
	@Test
	public void add_addsIntermediateItemInBeteween() {
		list.add(5);
		list.add(11);
		list.add(9);
		
		assertEquals(9, list.get(1));
	}
	
	@Test 
	public void add_addsItemSorted() {
		int inputValues[]= {2,9,8,14,5};
		int expectedOrder[]= {2,5,8,9,14};
		
		for(int value:inputValues)
			list.add(value);
		
		assumeTrue(list.size()==inputValues.length);
		
		for(int i=0;i<list.size();i++)
			assertEquals("failed at index "+i,expectedOrder[i], list.get(i));
		
		
	}
}
