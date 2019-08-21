package in.conceptarchitect.util;

import static in.conceptarchitect.util.JUnitAsserts.assertListSequence;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.testdata.Book;
import in.conceptarchitect.util.collection.ComparableSortedLinkedList;

public class ComparableSortedLinkedListTest {

	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void canSortAListOfInteger() {
		ComparableSortedLinkedList<Integer> ints=new ComparableSortedLinkedList<>();
		ints.addMany(2,9,4,3,7);
		
		assertListSequence(ints, 2,3,4,7,9);
		
	}
	
	@Test
	public void canSortAListOfStrings() {
		ComparableSortedLinkedList<String> names=new ComparableSortedLinkedList<>();
		names.addMany("a","ZZ", "PPP");
		
		assertListSequence(names, "PPP","ZZ","a");
		
	}
	
	@Test
	public void canSortAListOfBooks() {
		Book b1=new Book("Title1", "Author1", 200, 5.2);
		Book b2=new Book("Title3", "Author1", 200, 5.2);
		Book b3=new Book("Title2", "Author1", 200, 5.2);
		ComparableSortedLinkedList<Book> books=new ComparableSortedLinkedList<Book>();
		
		books.addMany(b1,b2,b3);
		
		assertListSequence(books, b1,b3,b2);
		
	}
	

}
