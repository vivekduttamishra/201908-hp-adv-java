package demo.threading07.threadlifecontrols;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {

	public static  void countDown(int max) {
		
		Thread me=Thread.currentThread();
		//System.out.println("Thread #"+me.getId()+" starts...");
		ThreadUtils.print("starts");

		while(max>=0){
			
			ThreadUtils.print("counts %d", max);
			max--;
			
		}
		
		ThreadUtils.print("finishes...");

	}


	public static void main(String[] args) {
		
		Thread c1=new Thread(()->countDown(200));
		Thread c2=new Thread(()->countDown(100));
		Thread c3=new Thread(()->countDown(300));

		c1.start();
		c2.start();
		c3.start();
		
		//COMMENT ONLY ONE OF THE BELOW BLOCK AT A TIME
		
		//TODO-1A: HANDLE THREAD CODE 
		//waitLoop();
		
		//TODO-2A: Let Main Thread Sleep for sometime
		
		//Thread.sleep(5000); //the current thread shall sleep
		
		//ThreadUtils.sleep(5000); //the current thread shall sleep
		
		
		
		//TODO-3A: Use Is Alive To Make Sure thread is running
		//waitTillTasksAreAlive(c1,c2,c3);
		
		//TODO-4A: Use join to make sure thread is running
		waitForThreadsToJoin(c1,c2,c3);
		
		
		
		
		//GOAL: This should be the last output message
		System.out.println("end of main program");
	
	
	}
	
	private static void waitLoop() {
		// TODO-1A :   loop long enough for others tasks to end
		long count=12000; //adjust value
		
		for(long i=0;i<count;i++)
			System.out.println(" + ");
		
	}

	private static void waitTillTasksAreAlive(Thread t1, Thread t2, Thread t3) {
		// TODO-2A check the is alive condition
		while(t1.isAlive() || t2.isAlive() || t3.isAlive()) {
			System.out.print("+");
		}
	}

	private static void waitForThreadsToJoin(Thread t1, Thread t2, Thread t3) {
		// TODO-3A Auto-generated method stub
		
//		t1.join(); //current thread sleeps till t1 finishes and joins
//		t2.join();
//		t3.join();
		
		ThreadUtils.waitFor(t1,t2,t3);
	}


}











