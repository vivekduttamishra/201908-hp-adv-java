package test.multithreading18.futureandcallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Program {

	

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		
		
		//TODO: 1. create a ThreadPool object
		ExecutorService executor=Executors.newCachedThreadPool();	
		
		//This is three rang of prime finding Job
		int [] ranges= {100000,50000,200000};
		
		
		//TODO: 2. Create a List of Future Objects returning PrimeResult
		List<Future<PrimeResult>> results=new ArrayList<>();
		
		
		for(int max:ranges) {
			
			final int m=max;
			//TODO: 3. Create a Future Object returning prime result by calling executor.sumit
			Future<PrimeResult> result= executor.submit(()->countPrimes(2,m));
			
			//TODO: 4. Add the result to the List			
			results.add(result);
			
		}
		
		System.out.println("waiting for responses");
		
		//TODO: 5. loop through the result to find the answers
		for(Future<PrimeResult> result :results)
			System.out.println(result.get()); //automatically wait for result to come
		
		
		//TODO: 6. Shutdown Executor
		executor.shutdown();
		
		//TODO: 7. Wait for Current Jobs to terminate
		executor.awaitTermination(1, TimeUnit.MILLISECONDS);
			
	}
	
	static PrimeResult countPrimes(int min,int max) {
		PrimeResult result=new PrimeResult(min, max);
		for(int i=min;i<max;i++) {
			if(isPrime(i))
				result.addPrime();
			
		
		}
		return result;
	}

	private static boolean isPrime(int x) {
		
		x=Math.abs(x);
		if(x<2)
			return false;
		
		for(int i=2;i<x;i++)
			if(x%i==0)
				return false;
		
		return true;
	}

}
