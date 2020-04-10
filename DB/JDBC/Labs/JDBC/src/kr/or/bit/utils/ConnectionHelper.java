package kr.or.bit.utils;
/*
 * ��ü ������Ʈ(ȸ��: ��ü ��ȸ, ���� ��ȸ, ����, ����.. ���� ������ ���� ����)
 * ������ �������� ���������� �ʿ��� ���...
 * (�ݺ����� �ڵ�)
 * 1. ����̹� �ε�
 * 2. ����, ��ü, �ڿ�����
 * 3. �ݺ����� �ڵ�� ... ����
 * 4. Oracle, Mysql ��� ����
 * 5. ���� ���赵 
 * 6. ConnectionHelper Ŭ���� >> ���(method) ����  >> static >> overloading >> ������
 * 7. ���� >> �ϳ��� ��ü ���� >> singleton
*/

import java.sql.*;


public class ConnectionHelper {
	 //oracle, mysql �ϳ��� �Լ�... dsn > oracle, mysql
	
	
	//���� ����
	public static Connection getConnection(String dsn) {
		Connection conn=null; 		
		try {
			if(dsn.equals("Oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bit","1004");
			}else if(dsn.equals("mysql")) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","bit","1004");
			}
		
		} catch (Exception e) {
		}
		
		return conn;
	
	}	
	public static Connection getConnection(String dsn, String id, String pwd) {
		Connection conn=null; 	
				try {
			if(dsn.equals("Oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",id,pwd);
			}else if(dsn.equals("mysql")) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","bit","1004");
			}
		
		} catch (Exception e) {
		
		
		}return conn;
	}
	
	//��������
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void close(Statement stmt) {
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	

	
	
}
