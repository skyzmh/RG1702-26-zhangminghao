package dao;

import java.sql.*;

public class DBconn {
	static Connection conn;

	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		if(conn == null){//����ģʽ
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/xwfb?useUnicode=true&characterEncoding=gbk"; //���ݿ��� 
	        String username="root";  //���ݿ��û���
	        String password="root";  //���ݿ��û�����
			 conn = DriverManager.getConnection(url, username, password);  //����״̬
			}
		return conn;
		
//		if(conn == null){//����ģʽ
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://39.106.22.85:32810/news?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true"; //���ݿ��� 
//	        String username="root";  //���ݿ��û���
//	        String password="root";  //���ݿ��û�����
//			 conn = DriverManager.getConnection(url, username, password);  //����״̬
//			}
//		return conn;
	}

}
