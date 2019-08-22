package in.conceptarchitect.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class PrimeRange implements Iterable<Integer> {

	private int min;
	private int max;

	public PrimeRange(int min, int max) {
		// TODO Auto-generated constructor stub
		this.min=min;
		this.max=max;
				
	}

	public Stream<Integer> stream(){
		return StreamSupport.stream(this.spliterator(), true);
	}
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new PrimeIterator();
	}

	class PrimeIterator implements Iterator<Integer>{

		int prime;
		public PrimeIterator() {
			prime=nextPrime(min);
		}
		
		
		private int nextPrime(int x) {
			// TODO Auto-generated method stub
			while(!PrimeUtils.isPrime(x))
				x++;
			return x;
		}


		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return prime<max;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			if(!hasNext())
				throw new NoSuchElementException();
			
			int current=prime;
			prime= nextPrime(prime+1);			
			return current;
		}
		
	}
	
	
	
	
}
