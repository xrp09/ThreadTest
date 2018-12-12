package com.xrp09.basicthread;

import java.sql.ResultSet;

/**
 * 策略模式
 * 数据的封装部分抽取成一个策略接口
 * 数据封装接口RowHandler ： 只负责对数据库查询出来的结果集进行操作，最终返回什么样的数据结构，需要自己去实现；
 *
 * @author xrp09
 *
 * @param <T>
 */
public interface RowHandler<T> {
	
	T hanle(ResultSet rs);
	
}
