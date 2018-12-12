package com.xrp09.basicthread;

import java.util.concurrent.TimeUnit;

public class TryConcurrency {

	public static void main(String[] args) {
		/*new Thread(){//匿名内部类的方式创建线程
			@Override
			public void run (){
				browseNews();
			}
		}.start();*/
		
//		Lambda写法
		new Thread(TryConcurrency::browseNews).start();
		//启动一个新的线程，只有调用了Thread的start方法，才代表派生了一个新的新的线程，否则Thread和其他对象是一样。
		
		enjoyMusic();
	}
	
	/**
	 * 浏览新闻
	 */
	private static void browseNews() {
		for(;;){
			System.out.println("huhu , the good news.");
			sleep(1);
			
		}

	}
	
	/**
	 * 浏览新闻
	 */
	private static void enjoyMusic() {
		for(;;){
			System.out.println("haha , the good music.");
			sleep(1);
			
		}

	}

	private static void sleep(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
