package com.xrp09.basicthread;

public class ThreadPriority {

	public static void main(String[] args) {
		Thread thread = create();
		thread.setPriority(6);
		System.out.println(thread.getPriority());
		System.out.println(Thread.currentThread().getId());

	}
	
	private static Thread create() {
		return new Thread(()->{
			System.out.println("name1");
		});

	}

}
