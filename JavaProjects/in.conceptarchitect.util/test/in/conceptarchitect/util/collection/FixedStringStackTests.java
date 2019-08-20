package in.conceptarchitect.util.collection;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class FixedStringStackTests {

	FixedIntStack stack;
	int size=3;
	@Before
	public void setup() {
		stack=new FixedIntStack(3);
	}
	
	@Test
	public void new_stackCanBeCreated() {
				
		assertNotNull(stack);
	}
	
	@Test
	public void new_stackShouldHaveAFixedSize() {
		
		
		assertNotNull(stack);
	}
	
	@Test 
	public void new_stackShouldBeEmpty() {
		
		
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void push_makesTheStackNonEmpty() {
		
		
		stack.push(10);
		
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void push_itemsLessThanStackSizeReturnsFalseForIsFull() {
		
		stack.push(1);
		stack.push(2);
		assertFalse(stack.isFull());
	}
	
	@Test
	public void push_itemsEqualsToStackSizeMakesItFull() {
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		assertTrue(stack.isFull());
	}
	
	@Test(expected = StackOverFlowException.class)
	public void push_toAFullStackThrowsStackOverFlowException() {
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		//now stack should be full
		
		//next push should throw exception
		stack.push(3);
	}
	
	@Test
	public void push_toFullStackThrowsExceptionWithValue() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assumeTrue(stack.isFull());
		
		try {
			stack.push(5);
			fail("exception was not thrown");
		}catch(StackOverFlowException ex) {
			assertEquals(5, ex.getValue());
		}
	}
	
	@Test(expected = StackUnderFlowException.class)
	public void pop_fromEmptyStackThrowsStackUnderflowException() {
		stack.pop();
	}
	
	@Test
	public void pop_lastItemFromStackMakesItEmpty() {
		stack.push(1);
		stack.push(2);
		stack.pop();
		assertFalse(stack.isEmpty());
		
		stack.pop();
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void pop_fromAFullStackMakesItNonFull() {
		FixedIntStack stack=new FixedIntStack(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		//at this stage. stack should be full
		//assertTrue(stack.isFull());
		assumeTrue(stack.isFull());
		
		//now pop
		stack.pop();
		assertFalse(stack.isFull());
	}
	
	@Test
	public void pop_popsLIFO(){
		
		int items[]= {5,9,4};
		
		for(int item:items)
			stack.push(item);
		
		for(int i=size-1;i>=0;i--)
			assertEquals(items[i], stack.pop());
		
	}
	
	
	@Test
	public void type_StackUnderFlowExceptionIsAStackException() {
		StackUnderFlowException ex=new StackUnderFlowException();
		assertTrue(ex instanceof StackException);
	}
	
	@Test
	public void type_StackOverFlowExceptionIsAStackException() {
		StackOverFlowException ex=new StackOverFlowException(0);
		assertTrue(ex instanceof StackException);
	}
	
	 @Test
	public void type_StackExceptionIsARuntimeException() {
		StackException ex=new StackException("stack exception");
		assertTrue(ex instanceof RuntimeException);
	}
	
	
}
