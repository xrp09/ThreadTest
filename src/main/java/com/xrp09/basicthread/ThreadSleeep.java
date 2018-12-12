package com.xrp09.basicthread;

import java.util.concurrent.TimeUnit;

public class ThreadSleeep {
	
	public static void main(String[] args) {
		Thread thread = new Thread(()->{
			long startTime = System.currentTimeMillis();
			sleep(2_000L);
			long endTime = System.currentTimeMillis();
			System.out.println(String.format("Total spend %d ms",(endTime-startTime)));
			
		});
		thread.start();
		
		long startTime = System.currentTimeMillis();
		sleep(3_000L);
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Main thread total spend %d ms",(endTime-startTime)));
		
		
		
		
	}

//	private static void sleep(long l) {
//		try {
//			Thread.sleep(l);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
private static void sleep(long l) {
	try {
//		TimeUnit.HOURS.sleep(1);
//		TimeUnit.MINUTES.sleep(1);
//		TimeUnit.SECONDS.sleep(l);
		TimeUnit.MILLISECONDS.sleep(l);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

}
	

}
