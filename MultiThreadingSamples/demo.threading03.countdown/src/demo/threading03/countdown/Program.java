package demo.threading03.countdown;

public class Program {


	public static void main(String[] args) {
		// TODO Create Two Object of Count Down Thread
		
		// STEP 1: Create Two CountDownTask
		CountDownTask task1=new CountDownTask();
		CountDownTask task2=new CountDownTask();
		
		// STEP 2: Create Threads one for each Task
		Thread t1=new Thread(task1);
		Thread t2=new Thread(task2);
		
		// STEP 3: Start The Threads
		t1.start();
		t2.start();
		
		
		System.out.println("end of main program");
	
	
	}

}
