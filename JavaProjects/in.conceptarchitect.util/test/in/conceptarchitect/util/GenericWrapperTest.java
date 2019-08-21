package in.conceptarchitect.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GenericWrapperTest {

	@Test
	public void new_genericWrapper() {
		Integer x=20;
		GenericWrapper<Integer> i=new GenericWrapper<>(x);
		
		assertEquals(x, i.getValue());
	}
	
	@Test
	public void create_genericWrapper() {
		Integer x=20;
		GenericWrapper<Integer> i=GenericWrapper.create(20);
		assertEquals(x, i.getValue());
	}
}
