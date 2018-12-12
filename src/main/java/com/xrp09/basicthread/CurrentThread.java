package com.xrp09.basicthread;

public class CurrentThread {

	public static void main(String[] args) {
		Thread thread = new Thread(){
				@Override
				public void run() {
					//always true
					System.out.println(Thread.currentThread()==this);
				}
		};
		thread.start();
		thread.getContextClassLoader();
		thread.setContextClassLoader(new ClassLoader() {
		});
		thread.interrupt();
		thread.isInterrupted();
		thread.interrupted();
		
		String name = Thread.currentThread().getName();
		System.out.println("main".equals(name));
				

	}

}
