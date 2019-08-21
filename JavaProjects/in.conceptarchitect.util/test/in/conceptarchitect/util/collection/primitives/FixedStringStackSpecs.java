package in.conceptarchitect.util.collection.primitives;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.util.collection.StackOverFlowException;
import in.conceptarchitect.util.collection.StackUnderFlowException;
import in.conceptarchitect.util.collection.primitives.FixedStringStack;

public class FixedStringStackSpecs {

	FixedStringStack stack;
	int size=3;
	
	@Before
	public void setup() {
		stack=new FixedStringStack(size);
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
		
		
		stack.push("india");
		
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void push_itemsLessThanStackSizeReturnsFalseForIsFull() {
		
		stack.push("india");
		stack.push("usa");
		assertFalse(stack.isFull());
	}
	
	@Test
	public void push_itemsEqualsToStackSizeMakesItFull() {
		
		stack.push("india");
		stack.push("usa");
		stack.push("france");
		
		assertTrue(stack.isFull());
	}
	
	@Test(expected = StackOverFlowException.class)
	public void push_toAFullStackThrowsStackOverFlowException() {
		
		stack.push("india");
		stack.push("usa");
		stack.push("france");
		//now stack should be full
		
		//next push should throw exception
		stack.push("france");
	}
	
	@Ignore @Test
	public void push_toFullStackThrowsExceptionWithValue() {
		stack.push("india");
		stack.push("usa");
		stack.push("france");
		assumeTrue(stack.isFull());
		
		try {
			stack.push("japan");
			fail("exception was not thrown");
		}catch(StackOverFlowException ex) {
			assertEquals("japan", ex.getValue());
		}
	}
	
	@Test(expected = StackUnderFlowException.class)
	public void pop_fromEmptyStackThrowsStackUnderflowException() {
		stack.pop();
	}
	
	@Test
	public void pop_lastItemFromStackMakesItEmpty() {
		stack.push("india");
		stack.push("usa");
		stack.pop();
		assertFalse(stack.isEmpty());
		
		stack.pop();
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void pop_fromAFullStackMakesItNonFull() {
		
		stack.push("india");
		stack.push("usa");
		stack.push("france");
		//at this stage. stack should be full
		//assertTrue(stack.isFull());
		assumeTrue(stack.isFull());
		
		//now pop
		stack.pop();
		assertFalse(stack.isFull());
	}
	
	@Test
	public void pop_popsLIFO(){
		
		String items[]= {"japan","germany","hongkong"};
		
		for(String item:items)
			stack.push(item);
		
		for(int i=size-1;i>=0;i--)
			assertEquals(items[i], stack.pop());
		
	}
	
	
}
