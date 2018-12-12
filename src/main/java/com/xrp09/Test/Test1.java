package com.xrp09.Test;

import com.xrp09.example.TicketWindow;
import com.xrp09.example.TicketWindowRunnable;

public class Test1 {

	public static void main(String[] args) {
		/*第一种方式Thread
		TicketWindow ticket1 = new TicketWindow("一号出号机");
		ticket1.start();
		
		TicketWindow ticket2 = new TicketWindow("二号出号机");
		ticket2.start();
		
		TicketWindow ticket3 = new TicketWindow("三号出号机");
		ticket3.start();
		
		TicketWindow ticket4 = new TicketWindow("四号出号机");
		ticket4.start();*/
		
		final TicketWindowRunnable task = new TicketWindowRunnable();
		
		Thread windowThread1 = new Thread(task,"一号出号机");
		Thread windowThread2 = new Thread(task,"二号出号机");
		Thread windowThread3 = new Thread(task,"三号出号机");
		Thread windowThread4 = new Thread(task,"四号出号机");
		
		windowThread1.setName("修改的名称");
		windowThread1.start();
		windowThread2.start();
		windowThread3.start();
		windowThread4.start();

	}

}
