package in.conceptarchitect.testdata;

public class Book implements Comparable<Book>{
	String title;
	String author;
	int price;
	double rating;
	
	/**
	 * return 
	 * 	0 ---> this==other
	 *  >0 ---> this>other
	 *  <0 ---> this<other
	 */
	@Override
	public int compareTo(Book other) {
		// TODO Auto-generated method stub
		return this.title.compareTo(other.title);
	}
	
	
	public Book(String title, String author, int price, double rating) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.rating = rating;
	}
	public Book() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
	public double getRating() {
		return rating;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + ", rating=" + rating + "]";
	}
	
	
}
