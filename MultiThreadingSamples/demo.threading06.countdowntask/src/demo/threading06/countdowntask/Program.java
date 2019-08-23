package demo.threading06.countdowntask;

public class Program {


	public static void main(String[] args) {
		
		CountDownTask c1=new CountDownTask(200);	//auto start	
		CountDownTask c2=new CountDownTask(100,false); //manual start
		CountDownTask c3=new CountDownTask(300); //autostart
		
		c2.start(); //c2.thread.start()
		
		c3.start(); //ignored as thread is already running
		
		System.out.println("end of main program");
	
	
	}

}
