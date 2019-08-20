package in.conceptarchitect.util.collection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FixedStackTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void new_canCreateStackForString() {
		
		FixedStack<String> stack=new FixedStack<String>(3);
		
		stack.push("hello world");
		//stack.push(20); //PROBLEM SOLVED: can't enter a wrong value
	}
	
	@Test
	public void problem_canCreateStackWithoutSpecifyingType() {
		FixedStack stack=new FixedStack(3);
		
		stack.push(20);
		stack.push("hello");
		stack.push(true);
		
	}
	
	public void bestPractice_shouldSpecifyObjectTypeIfYouNeed() {
		
		FixedStack<Object> stack=new FixedStack<>(3);
		
		stack.push(20);
		stack.push("hello");
		stack.push(true);
		
	}
	
	@Test
	public void new_primitiveStackType() {
		//FixedStack<int> stack=new FixedStack<>(3);
		FixedStack<Integer> stack=new FixedStack<>(3);
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
	}
	
	
	
	
	

}
