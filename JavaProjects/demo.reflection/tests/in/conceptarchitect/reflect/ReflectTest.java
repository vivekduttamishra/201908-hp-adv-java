package in.conceptarchitect.reflect;

import static in.conceptarchitect.reflect.Reflect.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static in.conceptarchitect.testing.JunitAsserts.*;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.animalkingdom.Tiger;
public class ReflectTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void invokeCanInvokeMethodsWithoutArgument() {
		String s1="Hello World";
		
		//invoke(s1,"length"); is same as s1.length()
		assertThat( invoke(s1, "length"), is(11));
	}
	
	@Test
	public void canIvokeMethodsWithArgumentAndReturn() {
		String s1="Hello World";
		
		//invoke(s1, "compareTo", "Hello world") is same as s1.compareTo("Hello world")
		assertThat( invoke(s1, "compareTo", "Hello world"), is(-32));
	}
	
	@Test
	public void canInvokeMethodFromUserDefinedClass() {
		Tiger tiger=new Tiger();
		
		assertThat( invoke(tiger,"hunt").toString(), 
					both(containsString("hunt"))
					.and(containsString("Tiger")));
	}
	
	
	@Test
	public void invokingNonAvailableMethodShouldThrowMethodInvokeExceptionWithMethodName() {
		
		Tiger tiger=new Tiger();
		MethodInvokeException ex= assertThrows(MethodInvokeException.class, ()->{
			invoke(tiger,"ride");
		});
		
		assertThat(ex.getMethodName(), is("ride"));
	}

	@Test
	public void invokeDefault_returnsActualResultInCaseOfSuccess() {
		
		String str="Hello World";
		assertThat(invokeDefault(str,"length",100), is(11));
	}
	
	@Test
	public void invokeDefault_returnsADefaultResultInCaseOfError() {
		String str="Hello World";
		assertThat(invokeDefault(str,"width",-1), is(-1));
	}
	
	
	
	
	
}
