package tests.utils.collection;

import  static org.junit.Assert.*;

import org.junit.Test;

public class SimpleMathTest2 {

	@Test
	public void testPlus() {
		int result=SimpleMath.plus(10, 5);
	
		assertEquals(15, result);
	}
	
	
	@Test
	public void testMinus() {
		int result=SimpleMath.minus(10, 5);
		//System.out.println("minus(10,5)="+result);
		
		assertEquals(10-5,  result);
	}
	
	@Test
	public void testMultiply() {
		
		assertEquals(50, SimpleMath.multiply(10, 5));
	}
	
	@Test
	public void testDivide() {
		int result=SimpleMath.divide(10, 5);
		//System.out.println("divde(10,5)="+result);
		assertEquals(2, result);
	}
	
}
