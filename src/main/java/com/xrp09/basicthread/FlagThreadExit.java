package com.xrp09.basicthread;

import java.util.concurrent.TimeUnit;

public class FlagThreadExit {
	
	static class MyTask extends Thread {
		private volatile boolean closed = false;
		@Override
		public void run() {
			System.out.println("I will start work");
			while(!closed && !isInterrupted()){//双层校验
				//working
				System.out.println("--working");
			}
			System.out.println("I will be exiting");
		}
		public void closed() {
			this.closed=true;
			this.interrupt();
			//双层关闭
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyTask t= new MyTask();
		t.start();
		TimeUnit.MICROSECONDS.sleep(1);
		t.closed();

	}

}
