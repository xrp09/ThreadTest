package com.xrp09.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static java.lang.Thread.currentThread;
import static java.lang.System.currentTimeMillis;

public class BooleanLock implements Lock{

	private Thread currentThread;//获得锁的当前线程
	
	private boolean locked=false; //锁未被获得或已释放
	
	private final List<Thread> blockedList = new ArrayList(); //获取锁时阻塞的线程集合
	

	@Override
	public void lock() throws InterruptedException {
		synchronized (this) {	//同步代码块的锁
			//暂存当前线程
			final Thread tempThread = currentThread();
			while(locked){		//如果当前锁已经被某个线程得到，则该线程加入阻塞队列，并且使当前线程wait释放monitor所有权
				try {
					if(!blockedList.contains(tempThread))
						blockedList.add(currentThread());
					this.wait();
				} catch (InterruptedException e) {
					//如果当前线程被中断，则懂列表中移除
					blockedList.remove(tempThread);
					throw e;
				}
			}
			blockedList.remove(currentThread());//当前线程获得了锁，则尝试从阻塞队列删除自己（被唤醒的），如果从未加入过阻塞队列，不会有影响，
			this.locked=true; //locked开关孩指定为true
			this.currentThread=currentThread();//记录获得锁的线程
		}
	}

	@Override
	public void lock(long mills) throws InterruptedException, TimeoutException {
		synchronized (this) {
			if(mills<=0){
				this.lock();//如果mills不合法，默认调用lock，也可以抛出参数非法的异常，抛出异常也是较好的做法。
			}else{
				long remainingmills=mills;
				long endMills=currentTimeMillis()+remainingmills;
				while(locked){
					if(remainingmills<=0)//如果小于0，意味着当前被某个线程唤醒和时间到了还没获得锁，应该抛出超时异常
						throw new TimeoutException("can not get the lock during"+mills+"ms.");
					if(blockedList.contains(currentThread()))
						blockedList.add(currentThread());
					this.wait(remainingmills);//等待的毫秒数，某个线程传入的，在多次wait等待以后会重新计算
					remainingmills=endMills-currentTimeMillis();//重新计算remainingmills等待的时间
				}
				blockedList.remove(currentThread());//获取锁，block列表删除，刷新locked状态，指定当前线程
				this.locked=true;
				this.currentThread=currentThread();
			}
		}
	}

	@Override
	public void unlock() {//如果某个线程解锁，就需要唤醒wait set中所有线程继续争抢monitor锁资源。
		synchronized (this) {
			if(currentThread==currentThread()){//哪个线程加的锁需要哪个线程解锁
				this.locked=false;
				System.out.println(currentThread().getName()+"  release the lock");
				this.notifyAll();//唤醒wait set中所有线程
			}
		}
	}
	@Override
	public List<Thread> getBlockedThreads() {
		return Collections.unmodifiableList(blockedList);//返回一个不可修改的list
	}

}
