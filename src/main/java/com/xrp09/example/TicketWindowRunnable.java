package com.xrp09.example;

public class TicketWindowRunnable implements Runnable {

	
	//受理的序号
	private  int index=1;  //不做修饰static
	
	//最多受理50笔业务
	private static final int MAX = 50;
	
	private final static Object MUTEX = new Object();//互斥机制
	
	//static
	public synchronized void sync() {

		
	}
		
		
	@Override
	public void run() {
		synchronized(MUTEX){//monitor锁
			while(index <= MAX){
				System.out.println(Thread.currentThread().getName()+"的号码是："+(index++));
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}

			
			
			
		}
	
	}

}
