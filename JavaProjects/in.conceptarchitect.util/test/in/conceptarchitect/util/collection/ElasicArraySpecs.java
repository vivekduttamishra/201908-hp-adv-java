package in.conceptarchitect.util.collection;

import static org.junit.Assume.assumeTrue;

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
		arr=new ElasticArray<>(growFactor);
	}
	
	@Test
	public void new_shouldCreateArrayWithInitalGrowFactor() {
		assertEquals( 0, arr.size());
		assertEquals(3, arr.capacity());
	}
	
	@Test
	public void add_increasesArraySize() {
		arr.add(1);
		arr.add(2);
		assertEquals(2,arr.size());
		assertEquals(3,arr.capacity());
	}
	
	@Test
	public void add_equalToCapacityMakesArrayFull() {
		arr.add(1);
		arr.add(2);
		arr.add(3);
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
	
	
	
	
}
