package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnPro {
	
	public static Connection getConn()
	{
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "shaikh sadi", "01960171418");
		}catch(Exception ex)
		{
			System.out.println("Error In Connection :"+ex);
		}
		return con; ////
	}

}
