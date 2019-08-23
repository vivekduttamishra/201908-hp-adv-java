package demo.threading07.threadlifecontrols;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {


	public static void main(String[] args) {
		
		CountDownTask c1=new CountDownTask(200);	
		
		CountDownTask c2=new CountDownTask(150);
		
		CountDownTask c3=new CountDownTask(300);
		

		c1.start();
		c2.start();
		c3.start();
		
		//COMMENT ONLY ONE OF THE BELOW BLOCK AT A TIME
		
		//TODO-1A: HANDLE THREAD CODE 
		//waitLoop();
		
		//TODO-2A: Use Is Alive To Make Sure thread is running
		//waitTillTasksAreAlive(c1.getThread(),c2.getThread(),c3.getThread());
		
		//TODO-3A: Use join to make sure thread is running
		//waitForThreadsToJoin(c1.getThread(),c2.getThread(),c3.getThread());
		
		
		
		
		//GOAL: This should be the last output message
		System.out.println("end of main program");
	
	
	}
	
	private static void waitLoop() {
		// TODO-1A :   loop long enough for others tasks to end
		int count=100; //adjust value
		
		for(int i=0;i<count;i++)
			;
		
	}

	private static void waitTillTasksAreAlive(Thread thread, Thread thread2, Thread thread3) {
		// TODO-2A check the is alive condition
		while(true) {
			System.out.println(".");
		}
	}

	private static void waitForThreadsToJoin(Thread thread, Thread thread2, Thread thread3) {
		// TODO-3A Auto-generated method stub
		
	}


	

	

}
