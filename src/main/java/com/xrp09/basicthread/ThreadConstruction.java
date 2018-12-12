package com.xrp09.basicthread;

/**
 * 线程组测试
 * @author xrp09
 *
 */
public class ThreadConstruction {

	
	public static void main(String[] args) {
		//①
		Thread t1 = new Thread("t1");
		//②
		ThreadGroup group = new ThreadGroup("TestGroup");
		Thread t2 = new Thread(group,"t2");
		
		ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
		
		System.out.println("main the thread belong group : "+mainThreadGroup.getName());
		System.out.println("t1 and mian belong the same group :"+(mainThreadGroup==t1.getThreadGroup()));
		System.err.println("t2 thread not belong main group :"+(mainThreadGroup==t2.getThreadGroup()));
		System.out.println("t2 thread belong mian test group :"+(group==t2.getThreadGroup()));
	}
}
