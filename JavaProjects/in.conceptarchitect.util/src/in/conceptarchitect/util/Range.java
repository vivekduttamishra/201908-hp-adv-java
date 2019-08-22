package in.conceptarchitect.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Range implements Iterable<Integer>,Iterator<Integer>{
	int min,max;
	int count;

	public Range(int min, int max) {
		super();
		this.min = min;
		this.max = max;
		count=min-1;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return max==-1 || count<max-1;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		if(!hasNext())
			throw new NoSuchElementException();
		count++;
		return count;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return this;
	}
	
	public Stream<Integer> stream(){
		return StreamSupport.stream(this.spliterator(), true);
	}
	
}
