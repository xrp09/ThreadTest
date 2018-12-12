package com.xrp09.basicthread;

import java.util.concurrent.TimeUnit;

public class Mutex {

	private final static Object MUTEX=  new Object();
	
	public void accessResource(){
		synchronized (MUTEX) {
			try {
				TimeUnit.SECONDS.sleep(1000);
				System.out.println("mutex");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		final Mutex mutex = new Mutex();
		for (int i = 0; i < 5; i++) {
			new Thread(mutex::accessResource).start();
		}
		

	}

}
