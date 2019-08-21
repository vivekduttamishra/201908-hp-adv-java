package in.conceptarchitect.util.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DefaultInterfaceFunctionsTest {

	LinkedList<Integer> list;
	@Before
	public void setup() {
		list=new LinkedList<Integer>();
		list.addMany(1,2,3,4,5);
	}
	
	@Test
	public void itemsAreAdded() {
		assertEquals(5,list.size());
	}
	
	@Test
	public void IsEmptyIsSupportedForElasticArray() {
		ElasticArray<String> str=new ElasticArray<>(5);
		assertTrue(str.isEmpty());
		str.add("india");
		assertFalse(str.isEmpty());
	}
	
	@Test(expected = RuntimeException.class)
	public void IsEmptyIsNotSupportedForLinkedList() {
		list.isEmpty();
	}
	
	
	
	@Test
	public void containsAny_returnsTrueForAnyMatchingItem() {
		ElasticArray<Integer> match=new ElasticArray<>(2);
		match.addMany(9,3);
		
		assertTrue(list.containsAny(match));
	}
	
	@Test
	public void containsAny_returnsFAlseForNoMatchingItem() {
		ElasticArray<Integer> match=new ElasticArray<>(2);
		match.addMany(9,8);
		
		assertFalse(list.containsAny(match));
	}

	
	@Test
	public void containsAll_returnsTrueForAllMatchingItem() {
		ElasticArray<Integer> match=new ElasticArray<>(2);
		match.addMany(5,2,1,4,3);
		
		assertTrue(list.containsAll(match));
	}
	
	@Test
	public void containsAll_returnsFalseForEvenSingleNonMatchingItem() {
		ElasticArray<Integer> match=new ElasticArray<>(2);
		match.addMany(5,2,3,4,7);
		
		assertFalse(list.containsAll(match));
	}
	
	@Test
	public void staticListCreateTest() {
		ElasticArray<Integer> arr= IndexedList.createArray(1,2,3,4,5);
		
		assertEquals(5,arr.size());
		assertEquals(5,arr.capacity());
		
		assertTrue(arr
						.containsAll(
								new LinkedList<Integer>().addMany(5,3,2,1,4)
								)
						);
	}

	
	
}
