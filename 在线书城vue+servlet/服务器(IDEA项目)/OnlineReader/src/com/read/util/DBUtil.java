package com.read.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 	DBUtil - ���ݿ����ӹ�������
 * 		�ٴ����� getConnection()
 * 		�ڹر����� closeConnection(...)
 */
public class DBUtil {	

	//�������ݿ��������
	Connection conn=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	//���������ַ���
    private  static final String url="jdbc:mysql://106.55.7.79:9999/bookcool?"+"serverTimezone=GMT%2B8";
    private  static final String user="root";
    private  static final String password="HYXhyx123456.";
	
	//������Ƽ�������jar��
	static {
		
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  getConnection() - ������Ӷ���
	 */
	public Connection getConnection() {
		Connection con=null;
		try{
//			System.out.println("׼����ȡ����");
//			System.out.println("����dbUrl=" + url);
//			System.out.println("����dbUser=" + user);
//			System.out.println("����dbPassword=" + password);
			con=DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 	closeDatabaseObject(Connection conn) 
	 * 	closeDatabaseObject(PreparedStatement pstat)
	 * 	closeDatabaseObject(ResultSet rs)
	 * 	- �ر�JDBC��ض��� [ֻ���ڲ�����]�����أ�
	 */
	private void closeDatabaseObject(Connection conn) {
		try{
			conn.close();
		}catch(SQLException e) { }
	}
	private void closeDatabaseObject(PreparedStatement pstat) {
		try{
			pstat.close();
		}catch(SQLException e) { }
	}
	private void closeDatabaseObject(ResultSet rs) {
		try{
			rs.close();
		}catch(SQLException e) { }
	}
	
	/**
	 * 	closeConnection(Connection conn)
	 * 	closeConnection(Connection conn, PreparedStatement pstat) - ��������ɾ��
	 * 	closeConnection(Connection conn, PreparedStatement pstat, ResultSet rs) - �����ڲ�
	 * 	- �ⲿ���ùر�JDBC����ĺ��ķ���
	 */
	public void closeConnection(Connection conn) {
		if(conn!=null) {
			closeDatabaseObject(conn);
		}
	}
	public void closeConnection(Connection conn, PreparedStatement pstat) {
		try {
			if(pstat!=null) {
				closeDatabaseObject(pstat);
			}
		}finally {
			if(conn!=null) {
				closeDatabaseObject(conn);
			}
		}
	}
	public void closeConnection(Connection conn, PreparedStatement pstat, ResultSet rs) {
		try {
			if(rs!=null) {
				closeDatabaseObject(rs);
			}
		}finally {
			try {
				if(pstat!=null) {
					closeDatabaseObject(pstat);
				}
			}finally {
				if(conn!=null) {
					closeDatabaseObject(conn);
				}
			}
		}
	}
	
}
