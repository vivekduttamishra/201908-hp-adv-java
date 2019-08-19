package com.client.linkedlistapp;

import in.conceptarchitect.util.collection.LinkedList;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list=new LinkedList();
		
		testGetAllSpeed(list);
		
		
//		testAdd(list);
//		
//		testGet(list);
//		
//		testSet(list);
//		//2 1 4 3
//		testRemove(list);
	}

	private static void testGetAllSpeed(LinkedList list) {
		// TODO Auto-generated method stub
		System.out.println("testing time taken...");
		long start=System.currentTimeMillis();
		for(int i=0;i<1000000;i++)
			list.add(i);
		
		long end=System.currentTimeMillis();
		System.out.println("items added to list in "+(end-start)+" ms ");
		System.out.println("now finding the sum");
		int sum=0;
		for(int i=0;i<list.size();i++)
			sum+=list.get(i);
		System.out.println("sum is "+sum);
		long end2=System.currentTimeMillis();
		System.out.println("Total time taken is "+(end2-end)+" ms");
	}

	private static void testRemove(LinkedList list) {
		list.remove(2); //should remove 4 
		list.remove(0); //should remove 2
		list.remove(1); //should remove 3
		
		System.out.println("after remove :"+ list);
	}

	private static void testSet(LinkedList list) {
		// TODO Auto-generated method stub
		
		list.set(0, 20);
		list.set(2, 100);
		
		System.out.println("list after set:"+list);
		
	}

	private static void testGet(LinkedList list) {
		int sum=0;
		
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i);
			
		}
		System.out.println("sum is "+sum);
	}

	private static void testAdd(LinkedList list) {
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(3);
		
		System.out.println("values added to the list  : "+list );
	}

}




















