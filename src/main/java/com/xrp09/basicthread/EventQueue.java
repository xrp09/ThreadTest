package com.xrp09.basicthread;
import static java.lang.Thread.currentThread;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
public class EventQueue {

	private final int max;

	static class Event{
		
	}
	/*QUEUE 3种状态1.队列满-队列的容量是多少  2.队列空 当所有被处理，没有新的提交 3.有event但没有满 */
	private final LinkedList<Event> eventQueue = new LinkedList<>();
	private final static int DEFAULT_MAX_EVENT=10;
	public EventQueue(){
		this(DEFAULT_MAX_EVENT);
	}
	public EventQueue(int max){
		this.max=max;
	}
	public void offer(Event event){
		synchronized (eventQueue) {
			if(eventQueue.size()>=max){
				try {
					console(" the queue is full");
					eventQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			console("the new event is submited");
			eventQueue.addLast(event);
			eventQueue.notify();
		}
	}
	public Event take (){
		synchronized (eventQueue) {
			if(eventQueue.isEmpty()){
				try {
					console("the queue is empty");
					eventQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Event event = eventQueue.removeFirst();
			this.eventQueue.notify();
			console("the event "+event+"is handled");
			return event;
		}}
	private void console(String string) {
		System.out.printf("%s:%s\n",currentThread().getName(),string);
	}
	public static void main(String[] args) {
		final EventQueue eventQueue = new EventQueue();
		new Thread(()->{
			for(;;){
				eventQueue.offer(new EventQueue.Event());
			}
		},"Producer").start();;
//		new Thread(()->{
//			for(;;){
//				eventQueue.take();
//				try {
//					TimeUnit.MILLISECONDS.sleep(10);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		},"Consumer").start();

	}
}
