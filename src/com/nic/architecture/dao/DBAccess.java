package com.nic.architecture.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAccess implements DAOConstants {

	private static Connection conn;

	public static Connection getConnection() throws ClassNotFoundException, DAOException {
		try {
		Class.forName(JBDC_DRIVER);
		conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		conn.setAutoCommit(false);
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return conn;
	}

	public static void closeConnection() throws DAOException {
		try{
			if (conn != null)
				conn.close();
		} catch (SQLException sql){
			throw new DAOException(sql);			
		}
			
	}
}
