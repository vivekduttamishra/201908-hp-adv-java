package in.conceptarchitect.testdata;

import in.conceptarchitect.util.collection.Comparator;

public class BookAuthorAndTitleComparator implements Comparator<Book> {

	@Override
	public double compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		int diff= o1.getAuthor().compareToIgnoreCase(o2.getAuthor());
		if(diff==0)
			diff= o1.getTitle().compareToIgnoreCase(o2.getTitle());
		
		return diff;
	}

	
	
}
