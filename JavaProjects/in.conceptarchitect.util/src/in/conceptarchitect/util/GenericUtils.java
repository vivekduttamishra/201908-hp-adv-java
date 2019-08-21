package in.conceptarchitect.util;

import in.conceptarchitect.util.collection.IndexedList;
import in.conceptarchitect.util.collection.LinkedList;

public class GenericUtils {
	
	public <T> LinkedList<T> createLinkedList(T ...values){
		LinkedList<T> list=new LinkedList<>();
		for(T value : values)
			list.add(value);
		return list;
	}
	
	public <T> String info(T value) {
		return value.toString();
	}
	
	public <T> int id(T value) {
		return value.hashCode();
	}
	
	
	public  int indexOf( IndexedList<?> list, Object value) {
		for(int i=0;i<list.size();i++)
			if(list.get(i).equals(value))
				return i;
		//list.add(20); //can't modify a list of wildcard ?
		return -1;
	}
	
	
	//? extends Number says a non-modifiable readonly list of anything
	//that extends Number
	//List<?> list is same as List<? extends Object> 
	public double average(IndexedList<? extends Number> numbers) {
		double sum=0;
		
		for(int i=0;i<numbers.size();i++) {
			sum+= numbers.get(i).doubleValue();
		}
		//numbers.add(20); //can't modify the list
		return sum/numbers.size();
		
	}
	
	//Producer Extends  Consumer Super [PECS]
	// GEMS  --> Get Extends Modify Super
	public <T> void conact(IndexedList<? extends T> source, 
							IndexedList<? super T> target) 
	{
		
		for(int i=0; i<source.size(); i++) {
			T value = source.get(i);
			target.add(value);
		}
			
	}
	

}
