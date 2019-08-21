package in.conceptarchitect.util;

import static org.junit.Assert.assertEquals;

import in.conceptarchitect.util.collection.IndexedList;

public class JUnitAsserts {

	public static <T> void assertListSequence(IndexedList<T> list, T ... expected) {
		
		for(int i=0;i<list.size();i++)
			assertEquals("Sequence Mismatch at Index "+i,expected[i],list.get(i));
	}
	
	public static <T> void assertSequenceEquals(IndexedList<T> original, IndexedList<T> other) {
		
		assertEquals("Sequences Differ in Size", original.size(), other.size() );
		
		for(int i=0;i<original.size();i++)
			assertEquals("Error at Index "+i, original.get(i),other.get(i));
	}
	
	
	public static <T> void assertContainsAll(IndexedList<T> list, T ...expected) {
		for(T value: expected){
			if(list.indexOf(value)==-1)
				throw new AssertionError("Not Found In Sequence :"+value);
		}
	}
	
	
}
