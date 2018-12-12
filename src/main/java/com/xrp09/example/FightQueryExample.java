package com.xrp09.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FightQueryExample {

	private static List<String> fightCompany = Arrays.asList("CSA","CEA","HNA");
	
	
	
	public static void main(String[] args) {
		List<String> results=search("SH","BJ");
	}
	//流编程和链式编程都是java8开始支持的，可以参考下
	private static List<String> search(String origin, String dest) {
		final List <String> result = new ArrayList<String>();
		List<FightQueryTask> tasks = fightCompany.stream()
				.map(f->createSearchTask(f,origin,dest)).collect(toList());
		tasks.forEach(Thread::start);
		tasks.forEach(t ->{
			try {
				t.join();
				
			} catch (InterruptedException e) {
			}
		});
		tasks.stream().map(FightQuery::get).forEach(result::addAll);
		return result;
	}

	private static FightQueryTask createSearchTask(String fight,String original,String dest) {
		
		return new FightQueryTask(fight, original, dest);
	}

}
