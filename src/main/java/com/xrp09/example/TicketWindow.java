package com.xrp09.example;

/**
 * 营业大厅叫号机程序
 * @author xrp09
 *
 */
public class TicketWindow extends Thread{

	
	
	//柜台名称
	private final String name;
	
	//最多受理50笔业务
	private static final int MAX = 50;
	
	//受理的序号
	private static int index=1; /* 多线程下共享资源唯一性需要保证index号码是唯一的一个+static
	 							   如果共享资源很多呢、如果资源需要经过一些复杂的运算呢，使用static会
	 							  使变量生命周期变得很长，所以应该使用Runnable分离线程的控制和业务逻辑*/
	
	public TicketWindow(String name) {
		this.name=name;
	}
	
	@Override
	public void run() {
		while(index <= MAX){
			System.out.println("柜台："+name+"当前受理的号码是："+(index++));
		}
	}
}
