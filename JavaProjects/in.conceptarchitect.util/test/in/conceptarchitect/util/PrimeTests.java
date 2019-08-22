package in.conceptarchitect.util;

import static in.conceptarchitect.util.JUnitAsserts.assertListSequence;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.util.collection.LinkedList;
public class PrimeTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void primerange_thereAre25PrimesUnder100() {
		LinkedList<Integer> primes=PrimeUtils.primeRange(0, 100);
		assertEquals(25,(int) primes.size());
		assertEquals(97,(int) primes.get(-1));
	}
	
	@Test
	public void primerange_primesUnder10() {
		LinkedList<Integer> primes=PrimeUtils.primeRange(0, 10);
		assertListSequence(primes, 2,3,5,7);
		
	}
	
	@Ignore @Test
	public void performanceMeasureForPrimesBetween2And500000() {
		System.out.println("finding Primes between 2 and 500000...");
		PerformanceResult<LinkedList<Integer>> result=
				Performance.measure("Primes between 2 and 500000", ()->PrimeUtils.primeRange(2, 500000));
	
		System.out.println("Total Time Taken :"+result.getTimeTaken());
		System.out.println("Total Primes :"+result.getResult().size());
		
		
	}
	
	
	
	@Test
	public void canFind1000thPrimeEndingWith7() {
		
		String message="1000th Prime Using PrimeUtils.primeRange";
		System.out.println(message);
		PerformanceResult<Integer> result=Performance.measure(message, ()->{
		
			int count=0;
			
			LinkedList<Integer> primes= PrimeUtils.primeRange(0, 500000);
			Iterator<Integer> pi=primes.iterator();
			
			while(pi.hasNext())
			{
				int prime=pi.next();
				if(prime%10==7) {
					
					count++;
					
					if(count==1000)
						return prime;
					
				}
			}
			
			return 0;
			
		});
		
		
		System.out.println(result);
		
	}
	
	
	@Test
	public void canFind1000thPrimeEndingWith7UsingPrimeRange() {
		
		String message="1000th Prime Using new PrimeRange()";
		System.out.println(message);
		PerformanceResult<Integer> result=Performance.measure(message, ()->{
		
			int count=0;
			
			//LinkedList<Integer> primes= PrimeUtils.primeRange(0, 500000);
			PrimeRange range=new PrimeRange(0,50000);
			Iterator<Integer> pi=range.iterator();
			
			while(pi.hasNext())
			{
				int prime=pi.next();
				if(prime%10==7) {
					
					count++;
					
					if(count==1000)
						return prime;
					
				}
			}
			
			return 0;
			
		});
		
		
		System.out.println(result);
		
	}
	
	@Test
	public void find1000thprimesEndingWith7() {
		System.out.println("PrimeStream");
		PerformanceResult<?> result= Performance.measure("PrimeStream", ()->{
			
			return   new PrimeRange(2, 500000)  //Iterable of all primes in range 2-500000
							.stream()			//Stream of all primes in range 2-500000
							.filter(n->n%10==7)  //Stream of all primes ending with 7
							.skip(999)		     //Stream starting with 1000th item
							.findFirst()		 //Terminal: Optional<Integer>
							.get();				// Integer or null
		});
		
		System.out.println(result);
		
		
		
	}
	
	
	

}
