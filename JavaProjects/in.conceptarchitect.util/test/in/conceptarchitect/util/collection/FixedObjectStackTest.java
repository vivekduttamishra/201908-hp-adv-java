package in.conceptarchitect.util.collection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FixedObjectStackTest {

	int size=3;
	FixedObjectStack stack;
	
	@Before
	public void setUp() throws Exception {
		stack=new FixedObjectStack(size);
	}

	@Test
	public void toString_returnEmptyStringForEmptyStack() {
		
		assertEquals("FixedStack()",stack.toString());
	}
	
	
	
	@Test
	public void problem_push_doesntCareAboutDataBeingAdded() {
		stack.push("String Value");
		stack.push(29);
		stack.push(false);

		assertEquals("FixedStack[\tfalse\t29\tString Value\t]",stack.toString());
		
	}
	
	@Test
	public void problem_stack_popValuesNeedToBeTypecast() {
		
		stack.push(2);
		stack.push(3); //stack.push(new Integer(3))
		stack.push(5);
		
		
		
		
		int sum=0;
		while(!stack.isEmpty()) {
			sum+=(int) stack.pop();
		}
		
		assertEquals(10, sum);
	}
	
	@Test
	public void autoBoxUnboxTest() {
		Object o=20; // Object o=new Integer(20); //auto box
		
		assertEquals("Integer", o.getClass().getSimpleName());
		
		int n= (int) o; //int n= o.intValue() //auto ubox
		
		assertEquals(20, n);
	}
	
	
	@Test
	public void problem_stack_mayThrowExceptionAtWrongPlace() {

		//I WANT TO CREATE A STACK OF NUMBERS
		//BUT JAVA DOESN'T KNOW MY INTENTION
		FixedObjectStack numbers=new FixedObjectStack(4);
		numbers.push(2);
		numbers.push(3);
		numbers.push("india"); //PROBLEM 1: java allows you to add non-numeric value
		numbers.push(5);
		
		int sum=0;
		while(!numbers.isEmpty()) {
			
			//PROBLEM 2: NEED TO TYPECAST BEFORE WE CAN USE	
			sum+=(int) numbers.pop(); //PROBLEM 3: MAY THROW CAST EXCEPTION
		}
		
		assertEquals(10, sum);
	}


}
