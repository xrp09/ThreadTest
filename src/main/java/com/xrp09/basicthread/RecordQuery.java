package com.xrp09.basicthread;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * 
 * @author xrp09
 *
 */
public class RecordQuery {

	public static void main(String[] args) {

	}
	
	private final Connection connection;
	
	public RecordQuery(Connection connection) {
		this.connection=connection;
	}
	
	/**
	 * 只负责查询获取数据，RowHandler数据加工，职责分明
	 * @param handler
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public <T>T query (RowHandler<T> handler,String sql,Object...objects)throws Exception{
		PreparedStatement ps = connection.prepareStatement(sql);
			
			int index = 1;
			for (Object param : objects) {
				ps.setObject(index++, param);
			}
			ResultSet resultSet = ps.executeQuery();
			return handler.hanle(resultSet); //调用RowHandler
	}

}
