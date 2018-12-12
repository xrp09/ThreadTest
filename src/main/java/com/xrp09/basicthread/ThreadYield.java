package com.xrp09.basicthread;

import java.util.stream.IntStream;

public class ThreadYield {

	public static void main(String[] args) {
		//迭代创建线程2次
//		IntStream.range(0, 2).mapToObj(ThreadYield::create).forEach(Thread::start);
		IntStream.range(2, 4)//<=
	    .forEach(System.out::println);//方法引用和表达式是2中变化体
		IntStream.range(0, 10).forEach(value -> System.out.println(value));
	}
	
	private static Thread create(int index) {
		
		return new Thread(()->{
			//test
			if(index==0)
				Thread.yield();
			System.out.println(index);
		});
		
	}

}
