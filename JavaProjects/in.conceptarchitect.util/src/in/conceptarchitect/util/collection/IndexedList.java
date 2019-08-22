package in.conceptarchitect.util.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

import in.conceptarchitect.util.Action;
import in.conceptarchitect.util.Condition;

public interface IndexedList<E> extends Iterable<E>{
	
			

	int size();

	IndexedList<E> add(E value);

	E get(int index);

	IndexedList<E> set(int index, E value);
	
	
	
	// The interface defaults
	
	default Iterator<E> iterator(){
		return new IndexedListIterator<E>(this);
	}
	
	default void each(Action<E> action) {
		
		for(int i=0;i<size();i++) {
			E value=get(i);
			action.perform(value);
		}
	}
	
	default LinkedList<E > search(Condition<E> condition){
		
		LinkedList<E> result=new LinkedList<>();

		each( value ->{
			if(condition.isTrue(value))
				result.add(value);
		});
		
		return result;
		
	}

	
	
	
	default boolean isEmpty() {
		return size()==0;
	}
	
	default IndexedList<E> addMany(E ...values){
		for(E value : values)
			add(value);
		
		return this;
	}
	
	default int indexOf(E item) {
		for(int i=0;i<size();i++)
			if(get(i).equals(item))
				return i;
		
		return -1;
	}

	default boolean containsAny(IndexedList<E> other) {
		for(int i=0;i<other.size();i++) {
			if(indexOf(other.get(i))!=-1)
				return true;
		}
		return false;
	}
	
	
	
	
	default boolean containsAll(IndexedList<E> other) {
		for(int i=0;i<other.size();i++) {
			if(indexOf(other.get(i))==-1)
				return false;
		}
		return true;
	}
	
	default boolean isSorted(Comparator<E> c) {
		if(size()<2)
			return true;
		
		for(int i=2;i<size();i++) {
			if(c.compare(get(i), get(i-1))<0)
				return false;
		}
		
		return true;
	}
	
	
	
	
	
	static <T> LinkedList<T> createLinkedList(T...values){
		LinkedList<T> list=new LinkedList<T>();
		for(T value : values)
			list.add(value);
		return list;
	}
	
	static <T> ElasticArray<T> createArray(T...values){
		ElasticArray<T> array=new ElasticArray<T>(values.length);
		for(T value : values)
			array.add(value);
		return array;
	}
	
	
	//Implementing default Iterator for the Interface
	
	
	
	class IndexedListIterator<E> implements Iterator<E>{

		IndexedList<E> list;
		int count=0;
		public IndexedListIterator(IndexedList<E> list) {
			// TODO Auto-generated constructor stub
			this.list=list;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return count<list.size();
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if(!hasNext())
				throw new NoSuchElementException();
			return list.get(count++);
		}
	}

	
	
	
	
	
}