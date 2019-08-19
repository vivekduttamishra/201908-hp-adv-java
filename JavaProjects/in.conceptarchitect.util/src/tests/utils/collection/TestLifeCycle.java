package tests.utils.collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLifeCycle {
	
	public TestLifeCycle() {
		// TODO Auto-generated constructor stub
		System.out.println("constructor");
	}
	
	@Before
	public void before() {
		System.out.println("before called");
	}
	
	@After
	public void after() {
		System.out.println("after called\n");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class\n\n");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("\nafter class");
	}
	
	@Test 
	public void test1() {
		System.out.println("test1");	
	}
	
	@Test 
	public void secondTest() {
		System.out.println("second test");	
	}
	
	@Test 
	public void anotherTest() {
		System.out.println("another test");	
	}
	
	@Test 
	public void yetAnotherTest() {
		System.out.println("yet another test");	
	}

}























