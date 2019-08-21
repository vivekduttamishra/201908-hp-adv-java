package in.conceptarchitect.util.collection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static in.conceptarchitect.util.JUnitAsserts.*;

public class ListExecuteTest {

	LinkedList<Integer> values=IndexedList.createLinkedList(1,2,3,4,5);
	
	@Test
	public void canPrintAllListItem() {
		
		values.execute( value-> System.out.print(value+"\t"));
	}
	
	
	@Test
	public void canDuplicateList() {
		
		ElasticArray<Integer> array=new ElasticArray<Integer>(1);
		
		values.execute( value -> array.add(value));
		
		assertSequenceEquals(values, array);
	}
	
	
	@Test
	public void canSumList() {
		
		int []sum= {0};
		
		values.execute(value-> sum[0]+=value);
		
		assertEquals(15, sum[0]);
	}
	
	@Test
	public void canPrintList() {
		System.out.println("\ncanPrintList test started");
		
		
		//values.execute( v -> System.out.println(v));
		
		values.execute(System.out::println);
		
		
		
		System.out.println("canPrintList test finished");
		
	}
	
	static <X> void printTab(X x) {
		System.out.print(x+"\t");
	}
	@Test
	public void canPrintInALine() {
		values.execute(ListExecuteTest::printTab);
	}
	
	
	
	
	
	
	
}

