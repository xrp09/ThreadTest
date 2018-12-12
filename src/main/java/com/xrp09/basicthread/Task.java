package com.xrp09.basicthread;

public class Task{

	private final static Object read_Mutex = new Object();
	private final static Object write_Mutex = new Object();
	
	
	public  void read() {
		// TODO Auto-generated method stub
		synchronized (read_Mutex) {
			synchronized (write_Mutex) {
				
			}
		}
	}
	
	public  void write() {
		// TODO Auto-generated method stub
		synchronized (write_Mutex) {
			synchronized (read_Mutex) {
				
			}
		}
	}
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(Task::new).start();
		}
	}

}
