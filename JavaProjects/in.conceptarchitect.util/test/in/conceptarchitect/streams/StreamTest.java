package in.conceptarchitect.streams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.util.Performance;
import in.conceptarchitect.util.PerformanceResult;
import in.conceptarchitect.util.PrimeUtils;
import in.conceptarchitect.util.Streams;

public class StreamTest {

	List<Integer> source;
	
	@Before
	public void setUp() throws Exception {
		source=Arrays.asList(1,2,3,4);
	}

	@Test
	public void stream_canBeCreatedFromACollection() {
		
		Stream<?> stream= source.stream();
		assertNotNull(stream);
		
	}
	
	@Test
	public void stream_isCountable() {
		Stream<?> stream=source.stream();
		long count=stream.count();
		assertEquals(source.size(), count);
	}
	
	@Test
	public void stream_supportsForEach() {
		Stream<?> stream=source.stream();
		
		source.forEach(System.out::println);
		
		stream.forEach(System.out::println);
	}
	
	@Test
	public void directory_stream() throws IOException {
		String path="C:\\MyWorks\\Corporate\\201908-hp-advjava";
		
							Files
								.list( Paths.get(path)) //Stream<Path>	
								.filter(p->! (new File(p.toString()).isDirectory()) )
								.map(p->p.getFileName()) //Stream<Path>
								.map(p-> p.toString())  //Stream<String>
								.filter(s->s.endsWith(".png"))
								.map(s->s.toUpperCase())
								.skip(10)
								.limit(5)
								.forEach(System.out::println);
								
	}
	
	
	@Test
	public void fileContant_Stream() throws IOException {
		String path="C:\\MyWorks\\Corporate\\201908-hp-advjava\\numbers.txt";
		System.out.println("fileContsntStream Test");
		List<?> result= Files
							.lines(Paths.get(path)) //line by line file
							.map(str->Integer.parseInt(str)) //Stream<Integer>
							.distinct()
							.filter(PrimeUtils::isPrime)
							.sorted((x,y)->y-x)
							
							.collect(Collectors.toList());
		
		result.forEach(System.out::println);
		System.out.println("-----------------");
	}
	
	
	
	@Test
	public void stream_testRange() {
		Streams.range(10,20).filter(n->n%2==0).forEach(System.out::println);
		//assertEquals(5,count);
	}
	
	
	@Test(timeout = 2000)
	public void infiniteStreamNeverEnds() {
		
		Streams.infiniteRange(100).limit(1000).count();
		
	}
	
	int max=10000;
	@Test
	public void useInfiniteStreamToFindFirst1000PrimesEndingWith7_Version1() {
		String message="First "+max+" primes ending with 7 Version 1";
		System.out.println(message);
		
		PerformanceResult<Integer> result= Performance.measure(message, ()->{
			
					return Streams
								.infiniteRange(2)
								.filter(PrimeUtils::isPrime)
								.filter(n->n%10==7)
								.skip(max-1)
								.findFirst().get();
			
			
		});
		
		
		System.out.println(result);
	}
	
	
	@Test
	public void useInfiniteStreamToFindFirst1000PrimesEndingWith7_Version2() {
		String message="First "+max+" primes ending with 7 Version 2";
		System.out.println(message);
		
		PerformanceResult<Integer> result= Performance.measure(message, ()->{
			
					return Streams
								.infiniteRange(2)
								.filter(n->n%10==7)
								.filter(PrimeUtils::isPrime)
								.skip(max-1)
								.findFirst().get();
			
			
		});
		
		
		System.out.println(result);
	}
	
	
	
	

}
