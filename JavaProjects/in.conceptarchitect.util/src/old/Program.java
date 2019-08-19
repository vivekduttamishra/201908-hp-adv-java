package old;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list=new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println(list);
		
		for(int i=0;i<list.size();i++){
			int x= list.get(i)*10;
			list.set(i, x);
		}
		
		System.out.println(list);
		
		list.remove(1);
		System.out.println(list);
	}

}
