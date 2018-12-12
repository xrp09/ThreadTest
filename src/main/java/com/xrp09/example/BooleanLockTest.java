package com.xrp09.example;
import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class BooleanLockTest {

	private final Lock lock = new BooleanLock();
	
	public void syncMethod(){//finally 确保每次可以释放
		try {
			lock.lock();//加锁
			
			int randomInt = current().nextInt(10);
			System.out.println(currentThread()+"  get the lock ");
			TimeUnit.SECONDS.sleep(randomInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	
	
	//使用显示锁（可中断被阻塞的线程）时，务必使用 try finally确保每次获取锁都能正常释放。
	public static void main(String[] args) {
		BooleanLockTest blt = new BooleanLockTest();
		//定义一个线程并启动
		IntStream.range(0, 10).mapToObj(i -> new Thread(blt::syncMethod)).forEach(Thread::start);
		
	}

}
