package com.xrp09.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FightQueryTask extends Thread implements FightQuery {
	
	private final String origin;
	private final String destination;
	private final List<String> fightList= new ArrayList<>();	
	
	public FightQueryTask(String airline,String origin, String destination) {
		super("["+airline+"]");
		this.origin = origin;
		this.destination = destination;
	}

	@Override
	public List<String> get() {
		return fightList;
	}
	
	@Override
	public void run() {
		//java 延用了C语言中的格式化输出
		System.out.printf("s-query from %s to %s \n",getName(),origin,destination);
		int randomVal= ThreadLocalRandom.current().nextInt(10);
		try {
			TimeUnit.SECONDS.sleep(randomVal);
			this.fightList.add(getName()+"-"+randomVal);
			System.out.printf("The fight:%s list query successful\n",getName());
		} catch (InterruptedException e) {
		}
	}

}
