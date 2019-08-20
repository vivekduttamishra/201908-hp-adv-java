package in.conceptarchitect.util.collection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	IntLinkedList list;
	int initialSize;
	
	@Before  //this code executes before every test
	public void arrange() {
		list=new IntLinkedList();
//		list.add(10);
//		list.add(20);
//		list.add(30);
		
		initialSize= list
						.add(10)
						.add(20)
						.add(30)
						.size();
		
		//initialSize=list.size();
		//System.out.println("arrange called");
	}
	
	
	
	@Test	
	public void new_listIsEmpty() {
		IntLinkedList list=new IntLinkedList();
		//System.out.println("new_listIsEmpty called");
		assertEquals(0, list.size());
	}
	
	
	
	
	@Test
	public void add_toEmptyListAddsAtTheBegining() {
		//A --- Arrange ---> prepare to test
		IntLinkedList list=new IntLinkedList();
		//A --- Act	--> perform the required action that is being tested	
		list.add(1);
		//A ---> Assert that expectations are met	
		//System.out.println("add_toEmptylist called");
		assertNotNull(list.first);
		assertEquals(1,list.first.value);
	}
	@Test
	public void add_toNonEmptyListAddsAtTheEnd() {
		IntLinkedList list=new IntLinkedList();
		list.add(2);
		list.add(5);
		//assertEquals(5, list.get(1));
		assertEquals(5,list.last.value);
	}
	@Test public void add_increasesListSize() {
		list.add(11);
		//System.out.println("add_toNonEmptyList called");
		assertEquals(initialSize+1, list.size());		
	}
	
	@Test public void get_canGetLastItem() {
		//System.out.println("get_canGetLastItem called");
		assertEquals(30, list.get(list.size()-1));
	}

	@Test
	public void get_0ReturnsFirstItem() {
		assertEquals(10, list.get(0));	
	}
	
	@Test
	public void get_returnsValueForValidIndex() {
		IntLinkedList list=new IntLinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		
		int [] expected= {10,20,30};
		
		for(int i=0;i<expected.length;i++)
			assertEquals("failed at index "+i,expected[i],list.get(i));
		
		
	}
	
	@Test
	public void get_minusOneIndexReturnsLastValue() {
		int minusIndexOneValue= list.get(-1);
		int lastIndexValue=list.get(initialSize-1);
		
		assertEquals(lastIndexValue, minusIndexOneValue);
	}
	
	@Test
	public void get_throwsIndexOutOfRangeForInvalidIndex() {
		try {
			list.get(initialSize);
			//Oh! the execpted exception was not thrown
			fail("expected exception IndexOutOfRange was not thrown");
		} catch(IndexOutOfBoundsException ex) {
			//Good! Test Passed
		}
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void set_throwsIndexOutOfBoundsExceptionForIndvalidIndex() {
		list.set(100, 1); //should throw exception
	}

	
	
	@Test
	public void set_updatesValueAtCurrentIndex() {
		list.set(0, 100);
		
		assertEquals(100, list.get(0));
	}
	
	@Test
	public void set_doesntAddNewItem() {
		list.set(1, 100);
		
		assertEquals(initialSize,list.size());
	}
	
	//@Test(expected = IndexOutOfBoundsException.class)
	public void remove_throwsIndexOutOfBoundsForInvalidIndex() {
		list.remove(100);
	}
	
	@Test
	public void remove_canRemoveFirstItem() {
		list.remove(0);
		assertEquals(initialSize-1, list.size());
	}
	
	@Test
	public void remove_removesTheItemFromAValidIndex() {
		int currentItem=list.get(1);
		list.remove(1);
		
		assertNotEquals(currentItem, list.get(1));
	}
	
	@Test
	public void remove_reducesListSize() {
		list.remove(1);
		
		assertEquals(initialSize-1, list.size());
	}
	
	@Test
	public void remove_returnsTheRemovedItem() {
		int index=1;
		int itemToBeRemoved= list.get(index);
		int itemRemoved= list.remove(index);
		
		assertEquals(itemToBeRemoved, itemRemoved);
	}
	
	//@Test
	public void toString_returnsSpecificStringForEmptyList() {
		IntLinkedList list=new IntLinkedList();
		
		assertEquals("LinkedList(\t)",list.toString());
		
	}
	
	@Test
	public void toString_returnsTabSeparatedValuesForNonEmptyList() {
		
		assertEquals("LinkedList(\t10\t20\t30\t)",list.toString());
	}
	
		
	
	
}
