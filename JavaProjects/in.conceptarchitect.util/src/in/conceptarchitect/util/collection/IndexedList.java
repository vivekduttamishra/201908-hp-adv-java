package in.conceptarchitect.util.collection;

public interface IndexedList<E> {

	int size();

	IndexedList<E> add(E value);

	E get(int index);

	IndexedList<E> set(int index, E value);
	
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
	/*
	default boolean isSorted() {
		if(size()<2)
			return true;
		
		for(int i=2;i<size();i++) {
			if(get(i)<get(i-1))
				return false;
		}
		reutrn true;
	}*/
	
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
	
}