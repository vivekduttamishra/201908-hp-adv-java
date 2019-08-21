package in.conceptarchitect.testdata;

import in.conceptarchitect.util.collection.Comparator;

public class BookTitleComparator implements Comparator<Book> {

	@Override
	public double compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.getTitle().compareToIgnoreCase(o2.getTitle());
	}

}
