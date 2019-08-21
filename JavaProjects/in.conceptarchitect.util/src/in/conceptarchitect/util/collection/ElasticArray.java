package in.conceptarchitect.util.collection;

import java.util.Arrays;

public class ElasticArray<T> 
	implements IndexedList<T>{

	T[] array;
	private int growFactor;
	private int count;
	
	public ElasticArray(int growFactor) {
		// TODO Auto-generated constructor stub
		array=(T [])new Object[growFactor];
		this.growFactor=growFactor;
		this.count=0;
	}

	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	public int capacity() {
		// TODO Auto-generated method stub
		return array.length;
	}

	public ElasticArray<T> add(T value) {
		// TODO Auto-generated method stub
		ensureCapacity();
		array[count++] = value;
		return this;
	}

	private void ensureCapacity() {
		// TODO Auto-generated method stub
		if(isFull()) {
			array=Arrays.copyOf(array, capacity()+growFactor);
		}
	}

	public boolean isFull() {
		// TODO Auto-generated method stub
		return size()==capacity();
	}

	public T get(int i) {
		// TODO Auto-generated method stub
		i=validateIndex(i);
		return array[i];
	}

	private int validateIndex(int i) {
		// TODO Auto-generated method stub
		if(i==-1)
			i=count-1;
		if(i<0 || i>=count)
			throw new IndexOutOfBoundsException("Invalid Index "+i);

		return i;
	}

	public ElasticArray<T> set(int index, T value) {
		// TODO Auto-generated method stub
		index=validateIndex(index);
		
		array[index]=value;
		return this;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(size()==0)
			return "ElasticArray(empty)";
		
		String str="ElasticArray";
		str+= isFull()?"[\t":"(\t";
		
		for(int i=0;i<size();i++)
			str+= array[i]+"\t";
		
		str+= isFull()?"]":")";
		
		return str;
	}

}
