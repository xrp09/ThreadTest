package com.xrp09.basicthread;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {

	public static void main(String[] args) {
		//1
		System.out.println("Main thread is interrupt? "+Thread.interrupted());
		//2
		Thread.currentThread().interrupt();//设置中断标识
		//3判断当前线程是否被中断
		System.out.println("Main thread is interrupt? "+Thread.currentThread().isInterrupted());
		try {//4 当前线程执行可中断方法
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("I will be interrupt still");
		}
		//如果一个线程设置了中断标识，那么之后执行可中断方法时会立即中断，所以也会捕获到异常信号
	}

}
