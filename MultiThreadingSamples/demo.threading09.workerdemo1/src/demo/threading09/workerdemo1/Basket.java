package demo.threading09.workerdemo1;

public class Basket {
	long items;

	//TODO-1: Add Lock Code
	
	public synchronized  void addItem(){
		//synchronized(this) {
			long item=items;
			item++;
			items=item;
		//}
	}

	public long getItems() {
		return items;
	}

}
