package demo.reflection02.tests;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demo.reflection02.Lengthy;
import demo.reflection02.Road;

class LengthTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void stringHasALength() {
		String str="Hello World";
		
		assertThat(Lengthy.length(str), is(str.length()));
		
	}
	
	@Test
	public void roadHasLength() {
		Road road=new Road("Mysore",160,"Bangalore");
		
		assertThat(Lengthy.length(road), is(road.length()));
	}
	
	@Test
	public void throwsNoSuchElementExceptionForObjectsWithoutLengthMethod() {
		final int number=20;
		
		NoSuchElementException ex= assertThrows(NoSuchElementException.class, ()->{
			Lengthy.length(20);
		});
		
		
		
		assertThat(	ex.getMessage(),  
					both(containsString("Integer"))
					.and(containsString("length"))				
				);
		
		
	}

}
