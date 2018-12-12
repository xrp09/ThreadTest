package com.xrp09.basicthread;

import java.util.concurrent.TimeUnit;

/**
 * 模板方法示例
 * @author xrp09
 *
 */
public class TemplateMethod {
	
	//模板设计  类似于Thread中start与run方法
	//父类规定代码结构
	public final  void print(String message) {
		System.out.println("##################");
		wrapPrint(message);
		System.out.println("##################");
	}
	public void wrapPrint(String message) {
	}
	
	//子类实现逻辑细节
	public static void main(String[] args) throws InterruptedException {
		TemplateMethod t1 = new TemplateMethod(){
			@Override
			public void wrapPrint(String message) {
				System.out.println("0"+message+"0");
			}
		};
		t1.print("hello world");
		
		TemplateMethod t2 = new TemplateMethod(){
			@Override
			public void wrapPrint(String message) {
				System.out.println("1"+message+"1");
			}
		};
		t2.print("hello world");
		
		
		
		
		/*测试重复启动异常
		Thread thread = new Thread(){//匿名内部类的方式创建线程
			@Override
			public void run (){
				try {
					TimeUnit.SECONDS.sleep(1);//睡眠java.util.concurrent 可读性好
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		TimeUnit.SECONDS.sleep(2);
		thread.start();*/
	}

}
