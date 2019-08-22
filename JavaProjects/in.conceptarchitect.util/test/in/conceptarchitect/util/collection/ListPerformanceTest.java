package in.conceptarchitect.util.collection;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import in.conceptarchitect.util.Performance;
import in.conceptarchitect.util.PerformanceResult;

public class ListPerformanceTest {
	
	int count=200000;
	
	
	@Test
	public void linkedListPerformanceTest() {
		LinkedList<Integer> list= new LinkedList<>();
		testListPerformance(list,"LinkedList");
	}
	
	
	@Test public void linkedListPerformanceTestUsingIterator() {
		String message="linkedList.for-each addTime";
		LinkedList<Integer> list=new LinkedList<Integer>();
		
		System.out.println("wait for "+message);
		
		PerformanceResult<?> result= Performance.measure(message, () ->{
			for(int i=1;i<=count;i++)
				list.add(i);
			return count;
		});
		System.out.println(result);
		
		message="linkedlist for-each accessTime";
		
		System.out.println("wait for "+message);
		
		PerformanceResult<?> result2= Performance.measure(message,()->{
			long sum=0;
			
			for(Integer value : list)
				sum+=value;
			
			return sum;
			
		});
		
		System.out.println(result2);
	
	}
	
	

	private void testListPerformance(IndexedList<Integer> list,String testType) {
		
		String message=testType+" addTime";
		
		System.out.println("wait for "+message);
		
		PerformanceResult<?> result= Performance.measure(message, () ->{
			for(int i=1;i<=count;i++)
				list.add(i);
			return count;
		});
		System.out.println(result);
		
		message=testType+" accessTime";
		
		System.out.println("wait for "+message);
		
		PerformanceResult<?> result2= Performance.measure(message,()->{
			long sum[]= {0};
			
			list.each(v-> sum[0]+=v);
			
			return sum[0];
			
		});
		
		System.out.println(result2);
		//assertEquals((long)(count*(count+1)/2), result2.getResult());
	}
	
	@Test
	public void elasticListWithGrowFactor100PerformanceTest() {
		ElasticArray<Integer> array=new  ElasticArray<Integer>(100);
		testListPerformance(array, "ElasticArray(100)");
	}
	
	@Test
	public void elasticListWithGrowFactor1000PerformanceTest() {
		ElasticArray<Integer> array=new  ElasticArray<Integer>(1000);
		testListPerformance(array,"ElasticArray(1000)");
	}
	

}
