package tests.utils.collection;

import org.junit.Test;

public class SimpleMathTest {

	@Test
	public void test1() {
		int result=SimpleMath.plus(10, 5);
		//System.out.println("plus(10,5)="+result);
		int expected=15;
		
		expectToBeEqual(expected, result);
	}
	private void expectToBeEqual(int expected, int actual) {
		if(actual!=expected)
			//throw new RuntimeException("test1 failed. expected "+expected+" actual was "+actual);
			throw new AssertionError("test1 failed. expected "+expected+" actual was "+actual);
	}
	
	@Test
	public void test2() {
		int result=SimpleMath.minus(10, 5);
		//System.out.println("minus(10,5)="+result);
		
		expectToBeEqual(10-5, result);
	}
	
	@Test
	public void test3() {
		int result=SimpleMath.multiply(10, 5);
		//System.out.println("multiply(10,5)="+result);
		//expectToBeEqual(10*5, result);
		if(result!=10*5)
			throw new RuntimeException("somehting gone wrong");
	}
	
	@Test
	public void test4() {
		int result=SimpleMath.divide(10, 5);
		//System.out.println("divde(10,5)="+result);
		expectToBeEqual(10-5, result);
	}
	
}
