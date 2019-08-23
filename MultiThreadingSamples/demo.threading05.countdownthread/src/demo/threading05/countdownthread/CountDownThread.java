package demo.threading05.countdownthread;

import in.conceptarchitect.threading.ThreadUtils;

//TODO: Convert This class To a Thread Class

public class CountDownThread extends Thread {
	
	private int max;

	@Override
	public void run() {
		
		
		Thread me=Thread.currentThread();
		//System.out.println("Thread #"+me.getId()+" starts...");
		ThreadUtils.print("starts");
		
		
		
		
		
		while(max>=0){
			
			ThreadUtils.print("counts %d", max);
			max--;
			
		}
		
		ThreadUtils.print("finishes...");
		
		

	}

	public CountDownThread(int max) {
		super();
		this.max = max;
	}

}
