package demo.threading06.countdowntask;

import java.lang.Thread.State;

import in.conceptarchitect.threading.ThreadUtils;

public class CountDownTask implements Runnable {

	//TODO-1: Add max and Thread field
	
	public CountDownTask(int max,boolean autoStart) {
		//TODO-2: initialize max and create Thread

		
		//TODO-3: start the thread if autoStart is true
	}
	
	public CountDownTask(int max) {
		 
		this(max,true);
	}
	
	public void start(){
		//TODO-4: start thread only if state is NEW (Not yet started)
		
	}
	
	@Override
	public void run() {
		// TODO-5 Remove Next Line of code to make it work
		int max=10;
		
		
		Thread me=Thread.currentThread();
		//System.out.println("Thread #"+me.getId()+" starts...");
		ThreadUtils.print("starts");

		while(max>=0){
			
			ThreadUtils.print("counts %d", max);
			max--;
			
		}
		
		ThreadUtils.print("finishes...");
		
		

	}

}
