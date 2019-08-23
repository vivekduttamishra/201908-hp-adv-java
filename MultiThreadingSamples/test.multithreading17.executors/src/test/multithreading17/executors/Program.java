package test.multithreading17.executors;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {

	

	public static void main(String[] args) throws InterruptedException {

		
		// TODO-1 Create the Executors		
		ExecutorService executor= Executors.newFixedThreadPool(3);
		
		
		
		for(int i=0;i<10;i++) {
			final int id=i;
			executor.submit(()->task(id));
		}
		
		
		//TODO-2 shutdown executor
		executor.shutdown(); //take no more task. stop once current works are over
		//TODO-3 wait for termination of current task
		executor.awaitTermination(8, TimeUnit.SECONDS);
		System.out.println("force stop...");
		List<Runnable> pending=executor.shutdownNow();
		
		System.out.println("total pending works "+pending.size());
		
		
		System.out.println("Program Ends");
	}
	
	static void task(int id) {
		int max=5;
		ThreadUtils.print("task %d starts\n",id);
		while(max>=0) {
			ThreadUtils.print("task %d counts %d\n",id,max);
			max--;
			ThreadUtils.sleep(1000);
		}
		ThreadUtils.print("task %d ends\n",id);
	}

}
