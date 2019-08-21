package in.conceptarchitect.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.util.collection.ElasticArray;
import in.conceptarchitect.util.collection.IndexedList;

public class GenericUtilsTest {

	GenericUtils utils=new GenericUtils();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void genericClassParameterDefaultsToObject() {
		GenericWrapper wrapper1=new GenericWrapper(29);
		wrapper1.setValue("hello world"); //it is allows
	}
	
	@Test
	public void genericClassParameterShouldBeSpecifiedExplicitlyToAvoidBug() {
		GenericWrapper<Integer> wrapper1=new GenericWrapper<Integer>(29);
		//wrapper1.setValue("hello world"); //it not allows
		assertEquals(29, (int) wrapper1.getValue());
	}
	
	@Test
	public void genericMethodParameterIsImplictlyDetectedBasedOnArgument() {
		GenericWrapper<Integer> wrapper1=GenericWrapper.create(29); //detects the type from supplied argument
		//wrapper1.setValue("hello world"); 
		
	}
	
	@Test
	public void info_returnsToString() {
		GenericWrapper<Integer> iw= new GenericWrapper<>(29);
		
		String info= utils.info(iw);
		assertEquals(iw.toString(), info);
		
		int x=29;
		
		String info2=utils.info(x);
		
		assertEquals("29", info2);
		
	}
	
	public void id_returnsHashCode() {
		String str="hello world";
		
		//explicit parameter specification for a generic method
		int x = utils.<String>id(str);
		
		assertEquals(str.hashCode(),x);
		
	}
	
	@Test
	public void indexOf_returnsIndexOfMatchingItem() {
		IndexedList<Integer> list=new ElasticArray<Integer>(5).add(20).add(30).add(40);
		
		int index=utils.indexOf(list, 30);
		
		assertEquals(1, index);
	}

	@Test
	public void indexOf_returnsMinusOneForNonMatchingItem() {
		IndexedList<Integer> list=new ElasticArray<Integer>(5).add(20).add(30).add(40);
		
		IndexedList<?> objects=list; //A list of Integer can't be considered as a List of Object
		
		int index=utils.indexOf(list, 300);
		assertEquals(-1, index);
	}

	
	@Test
	public void average_canFindAverage() {
		IndexedList<Integer> numbers= new ElasticArray<Integer>(5).add(1).add(2).add(3).add(4);
		assertEquals(2.5, utils.average(numbers), 0.01 );
		
		IndexedList<Double> doubles=new ElasticArray<Double>(5).add(1.8).add(4.2).add(3.0);
		assertEquals(3.0, utils.average(doubles),0.01);
	}
	
	@Test
	public void concat_canAddValueFromOneListToAnotherListOfSameType() {
		IndexedList<Integer> list1=utils.createLinkedList(1,2,3,4);
		IndexedList<Integer> list2=utils.createLinkedList(5,6);
		
		utils.conact(list2, list1);
		System.out.println(list1);
		assertEquals(6, list1.size());
		assertEquals(6,(int) list1.get(-1));
		
		IndexedList<String> source= utils.createLinkedList("a","b","c");
		ElasticArray<String> target=new ElasticArray<>(2);
		utils.conact(source, target);
		
		assertEquals(3, target.size());
		assertEquals(4, target.capacity());
		System.out.println(target);
		
	}
	
	@Test
	public void concat_canAddValueFromASourceToSuperCollection() {
		
		IndexedList<Integer> source= utils.createLinkedList(1,2,3,4);
		ElasticArray<Number> target=new ElasticArray<Number>(5);
		
		utils.conact(source, target);
		ElasticArray<String> str=new ElasticArray<String>(5);
		//not allowed
		//utils.concat(source, str); //no super relationship
		
	}
	
	
}
