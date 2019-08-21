package in.conceptarchitect.util.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Test;

public class ElasicArraySpecs {

	/**
	 * Elasic Array is like (ArrayList). It is a list of values
	 * stored in an array (continous memory location)
	 * The array could expand anytime it needs to have more element
	 * there should be an additional method: capacity()
	 */
	
	ElasticArray<Integer> arr;
	int growFactor=3;
	
	@Before
	public void setup() {
		arr=new ElasticArray<Integer>(growFactor);
	}
	
	@Test
	public void new_shouldCreateArrayWithInitalGrowFactor() {
		assertEquals( 0, arr.size());
		assertEquals(3, arr.capacity());
	}
	
	@Test
	public void add_increasesArraySize() {
		arr.add(1).add(2);
		assertEquals(2,arr.size());
		assertEquals(3,arr.capacity());
	}
	
	@Test
	public void add_shouldReturnTheCurrentObject() {
		Object result=arr.add(1);
		
		assertSame(arr, result);
	}
	
	@Test
	public void add_equalToCapacityMakesArrayFull() {
		arr.add(1).add(2).add(3);
		
		assertEquals(3,arr.size());
		assertEquals(3,arr.capacity());
		assertTrue(arr.isFull());
	}
	
	@Test
	public void add_toAFullArrayIncreasesCapacityByGrowFactor() {
		arr.add(1);
		arr.add(2);
		arr.add(3);
		assumeTrue(arr.isFull());
		
		arr.add(4);
		assertEquals(4, arr.size());
		assertEquals(6, arr.capacity());
		assertFalse(arr.isFull());
		
		arr.add(5);
		arr.add(6);
		assumeTrue(arr.isFull());
		
		arr.add(7);
		assertEquals(7, arr.size());
		assertEquals(9, arr.capacity());
		assertFalse(arr.isFull());
		
	}
	
	
	/**
	 * Should have common methods like
	 * add ( X value)  // to the end of the list
	 * size() // to return the size of the list
	 * get(int index) //get value from index
	 * set(int index,value) //set at the index
	 * toString() //represent string form
	 * doesn't support remove()
	 * Write the test cases as per the LinkedList design
	 */
	
	 @Test
	public void get_canGetValueFromValidIndex() {
		arr.add(1);
		arr.add(2);
		arr.add(3);
		
		assertEquals(2,(int) arr.get(1));
		
	}
	
	 @Test(expected = IndexOutOfBoundsException.class)
	public void get_shouldThrowIndexOfOfBoundsExceptionForInvalidIndex() {
		
		 arr
		 	.add(1)
		 	.get(20);
	}
	
	 @Test
	public void get_shouldReturnLastItemForIndexMinusOne() {
		int value=arr
					.add(1)
					.add(2)
					.get(-1);
		
		assertEquals(2, value);
	}
	
	 @Test
	public void set_canSetValueOnAValidIndex() {
		int value=	arr
						.add(1)
						.set(0,20)
						.get(0);
		
		assertEquals(20, value);
	}
	
	 @Test(expected = IndexOutOfBoundsException.class)
	public void set_shouldThrowIndexOfOfBoundsExceptionForInvalidIndex() {
		arr.add(1).set(1, 2);
		
	}
	
	 @Test
	public void set_shouldSetLastItemForIndexMinusOne() {
		int value = arr.add(1).add(2).set(-1, 20).get(1);
		
		
		assertEquals(20,(int) arr.get(1));
	}
	
	 @Test
	public void toString_ShouldReturnValidStringForEmptyArray() {
		assertEquals("ElasticArray(empty)",arr.toString());
	}
	
	 @Test
	public void toString_shouldShouldUseParenthesesForNonFullArray() {
		arr.add(1);
		assertTrue(arr.toString().contains("("));
	}
	
	 @Test
	public void toString_shouldUseBracketForFullArray() {
		String str=arr.add(1).add(2).add(3).toString();
		
		assertTrue(str.contains("["));
	}
	
	
	
}
