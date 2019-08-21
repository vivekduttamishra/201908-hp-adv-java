package in.conceptarchitect.util;

import static in.conceptarchitect.util.JUnitAsserts.assertListSequence;

import org.hamcrest.core.SubstringMatcher;
import org.junit.Test;

import in.conceptarchitect.testdata.Book;
import in.conceptarchitect.testdata.BookAuthorAndTitleComparator;
import in.conceptarchitect.testdata.BookTitleComparator;
import in.conceptarchitect.util.collection.Comparator;
import in.conceptarchitect.util.collection.SortedLinkedList;

public class SortedLinkedListTest {

	Book b1=new Book("Title1", "Author9", 200, 4.1);
	Book b2=new Book("title3", "Author4", 300, 4.9);
	Book b3=new Book("Title2", "Author2", 400, 3.7);
	Book b4=new Book("title5", "Author4", 500, 4.6);
	Book b5=new Book("title4", "Author4", 600, 4.2);
	SortedLinkedList<Book> books;
	
	
	private SortedLinkedList<Book> createList(Comparator<Book> comparator) {
		books=new SortedLinkedList<Book>(comparator);
		books.addMany(b1,b2,b3);
		return books;
	}
	
	
	
	@Test
	public void canSortAListOfBooks() {
		createList(new BookTitleComparator());
		assertListSequence(books, b1,b3,b2);
	}

	@Test
	public void canSortOnAuthorAndTitle() {
		createList(new BookAuthorAndTitleComparator());
		books.addMany(b4,b5);
		assertListSequence(books, b3, b2, b5, b4,b1);
	}
	
	@Test
	public void canSortOnPrice() {
		
		Comparator<Book> priceComparator = new Comparator<Book>() {
			public double compare(Book b1, Book b2) {
				return b1.getPrice()-b2.getPrice();
			}
		};
		
		createList(priceComparator);
		
		assertListSequence(books, b1,b2,b3);
		
	}

	
	@Test
	public void canSortOnReviews() {
		Comparator<Book> ratingComparator= (b1, b2) -> {
			return b1.getRating()-b2.getRating();
		};
		createList(ratingComparator);
		assertListSequence(books, b3,b1,b2);
	}
	
	@Test
	public void canSortOnReviewDesc() {
		
		Comparator<Book> ratingComparator= (b1, b2) -> b2.getRating() - b1.getRating();
		
		
		createList(ratingComparator);
		
		assertListSequence(books, b2,b1,b3);
	}

	@Test
	public void canSortStringIgnoringCase() {
		
		Comparator<String> c= (s1,s2) -> s1.compareToIgnoreCase(s2);
		
		SortedLinkedList<String> list=new SortedLinkedList<>(c);
		list.addMany("MMM","CCCC","a","ZZ");
		
		assertListSequence(list, "a","CCCC","MMM","ZZ");
		
		
	}
	
	@Test
	public void canSortStringOnLengthDesc() {
		
		SortedLinkedList<String> list=new SortedLinkedList<>((s1,s2) -> s2.length()-s1.length());
		list.addMany("MMM","CCCC","a","ZZ");
		
		assertListSequence(list, "CCCC","MMM","ZZ","a");
		
		
	}
	
	
	
	
	

}
