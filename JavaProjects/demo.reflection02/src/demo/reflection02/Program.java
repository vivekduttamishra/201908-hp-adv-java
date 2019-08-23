package demo.reflection02;

import java.util.NoSuchElementException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r1=new Rectangle(3,4);
		Road r2=new Road("Bangalore", 160, "Mysore");
		String str="hello world";
		
		//str.length();
		
		//printRectangleInfo(r1);
		
		//printRoadInfo(r2);
		
		printInfo(r1);
		printInfo(r2);
		
		//str.length(); //functional capability exists
		//printInfo(str); //but can't work as interface is not implemented
		System.out.println("Testing printLengthInfo");
		printLengthInfo(r1);
		printLengthInfo(r2);
		printLengthInfo(str);
		printLengthInfo(29);
		printLengthInfo("This is another String");
	}
	
	static void printLengthInfo(Object obj) {
		try {
		System.out.println("object is "+obj);
		System.out.println("length is "+Lengthy.length(obj));
		
		}catch(NoSuchElementException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println();
		
	}

	private static <T extends Lengthy> void printInfo(T obj) {
		System.out.println("object is "+obj);
		System.out.println("length is "+obj.length());
		System.out.println();
	}
	
	
	private static void printRoadInfo(Road r2) {
		System.out.println("object is "+r2);
		System.out.println("length is "+r2.length());
		System.out.println();
	}

	private static void printRectangleInfo(Rectangle r1) {
		System.out.println("object is "+r1);
		System.out.println("length is "+r1.length());
		System.out.println();
	}

}
