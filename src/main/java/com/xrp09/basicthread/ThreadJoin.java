package com.xrp09.basicthread;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class ThreadJoin {
	public static void main(String[] args) throws InterruptedException {
		//1定义2个线程，保存在threads
		List<Thread> threads=IntStream.range(1, 3).mapToObj(ThreadJoin::create).collect(toList());
		//2启动着2个线程
		threads.forEach(Thread::start);
		//3执行线程的join方法
		for (Thread thread : threads) {
			thread.join();//可中断方法
		}
		//mian线程循环输出
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"#"+i);
			shortSleep();
		}
	}
	private static Thread create(int seq) {
		return new Thread(()->{
			for(int i=0;i<10;i++){
				System.out.println(Thread.currentThread().getName()+"#"+i);
				shortSleep();
			}
		},String.valueOf(seq));
	}

	private static void shortSleep() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
