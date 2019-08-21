package in.conceptarchitect.testdata;

import in.conceptarchitect.util.collection.IndexedList;

public class BookDataSource {

	public static void Fill(IndexedList<Book> books) {
		books.addMany(
				new Book("The Count of Monte Cristo","Alexandre Dumas",350, 4.8),
				new Book("Rashmirathi","Ramdhari Singh Dinkar",99, 4.7),
				new Book("Brethren","John Grisham",250, 4.2),
				new Book("Summons","John Grisham",300, 4.1),
				new Book("Kurukshetra","Ramdhari Singh Dinkar",140, 4.5),
				new Book("Sins of Father","Jeffrey Archer",300, 4.1)
				);
	}
	
}
