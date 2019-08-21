package in.conceptarchitect.util.collection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.testdata.Book;
import in.conceptarchitect.testdata.BookDataSource;

public class ListSearchSpecs {

	ElasticArray<Book> books;
	
	@Before
	public void setup() {
		books=new ElasticArray<Book>(5);
		
		BookDataSource.Fill(books);
	}
	
	@Test
	public void listHas6Items() {
		assertEquals(6, books.size());
	}
	
	@Test
	public void canSearchBooksByAuthor() {
		//find all books by Ramdhari Singh Dinkar
		LinkedList<Book> result=null; //do search here
		
		assertEquals(2, result.size());
		assertEquals("Rashmirathi", result.get(0).getTitle());
		
		
	}
	
	@Test
	public void canSearchBooksOnPriceRange() {
		//find all books in price range 100-300
		LinkedList<Book> result=null; //do search here
		
		assertEquals(2, result.size());
		
		
		
	}
	
	@Test
	public void returnsEmptyListForNotFound() {
		//find book titled The Accursed God
		LinkedList<Book> result=null; //do search here
		
		assertEquals(0, result.size());
		
		
		
	}
	
	
}
