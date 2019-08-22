package in.conceptarchitect.util;

import in.conceptarchitect.util.collection.ElasticArray;
import in.conceptarchitect.util.collection.LinkedList;

public class PrimeUtils {

	public static boolean isPrime(int number) {
		if(number<2)
			return false;
		
		for(int i=2;i<number;i++)
			if(number%i==0)
				return false;
		
		return true;
	}
	
	public static LinkedList<Integer> primeRange(int min,int max){
		LinkedList<Integer> primes=new LinkedList<Integer>();
		
		for(int i=min;i<max;i++)
			if(isPrime(i))
				primes.add(i);
		
		return primes;
			
	}
}
