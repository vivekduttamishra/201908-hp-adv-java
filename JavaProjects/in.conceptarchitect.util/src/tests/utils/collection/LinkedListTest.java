package tests.utils.collection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.util.collection.LinkedList;

public class LinkedListTest {
	LinkedList list;
	int initialSize;
	
	@Before  //this code executes before every test
	public void arrange() {
		list=new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		
		initialSize=list.size();
		System.out.println("arrange called");
	}
	
	
	
	@Test	
	public void new_listIsEmpty() {
		LinkedList list=new LinkedList();
		System.out.println("new_listIsEmpty called");
		assertEquals(0, list.size());
	}
	@Test
	public void add_toEmptyListAddsAtTheBegining() {
		//A --- Arrange ---> prepare to test
		LinkedList list=new LinkedList();
		
		//A --- Act	--> perform the required action that is being tested	
		list.add(1);
		
		//A ---> Assert that expectations are met	
		System.out.println("add_toEmptylist called");
		assertEquals(1, list.get(0));
	}
	@Test
	public void add_toNonEmptyListAddsAtTheEnd() {
		
		LinkedList list=new LinkedList();
		
			
		list.add(2);
		list.add(5);
		
		assertEquals(5, list.get(1));
	}
	@Test public void add_increasesListSize() {
		list.add(11);
		System.out.println("add_toNonEmptyList called");
		assertEquals(initialSize+1, list.size());		
	}
	
	@Test public void get_canGetLastItem() {
		System.out.println("get_canGetLastItem called");
		assertEquals(30, list.get(list.size()-1));
	}

	@Test
	public void get_0ReturnsFirstItem() {
		assertEquals(10, list.get(0));	
	}
	
	@Test
	public void get_returnsValueForValidIndex() {
		LinkedList list=new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		
		int [] expected= {10,20,30};
		
		for(int i=0;i<expected.length;i++)
			assertEquals("failed at index "+i,expected[i],list.get(i));
		
		
	}
	
}
