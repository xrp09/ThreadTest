package com.xrp09.basicthread;

import java.util.concurrent.TimeUnit;

public class InterruptThreadExit {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(){
			@Override
			public void run() {
				System.out.println(" I will start work");
//				1 while(!isInterrupted()){
//					//working
//				}
				for(;;){
					//working
					try {
						TimeUnit.MICROSECONDS.sleep(1);
					} catch (InterruptedException e) {
//						e.printStackTrace(); 捕获到了中断异常
						break;//结束！2
					}
				}
				System.out.println("I will be exiting");
			}
		};
		thread.start();
		TimeUnit.MINUTES.sleep(1);
		System.out.println("system will shhutdown");
		thread.interrupt();//自己去中断
		
		

	}

}
