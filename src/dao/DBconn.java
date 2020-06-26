package dao;

import java.sql.*;

public class DBconn {
	static Connection conn;

	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		if(conn == null){//单例模式
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/xwfb?useUnicode=true&characterEncoding=gbk"; //数据库名 
	        String username="root";  //数据库用户名
	        String password="root";  //数据库用户密码
			 conn = DriverManager.getConnection(url, username, password);  //连接状态
			}
		return conn;
		
//		if(conn == null){//单例模式
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://39.106.22.85:32810/news?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true"; //数据库名 
//	        String username="root";  //数据库用户名
//	        String password="root";  //数据库用户密码
//			 conn = DriverManager.getConnection(url, username, password);  //连接状态
//			}
//		return conn;
	}

}
