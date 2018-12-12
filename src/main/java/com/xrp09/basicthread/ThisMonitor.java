package com.xrp09.basicthread;

import static java.lang.Thread.currentThread;

import java.util.concurrent.TimeUnit;
public class ThisMonitor {

	
	public synchronized void method1() {
		System.out.println(currentThread().getName()+" enter to method1");
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void method2() {
		System.out.println(currentThread().getName()+" enter to method2");
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ThisMonitor tm = new ThisMonitor();
		new Thread(tm::method1,"T1").start();
		new Thread(tm::method2,"T2").start();

	}

}
