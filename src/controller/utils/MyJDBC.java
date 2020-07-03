package controller.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.google.gson.Gson;
import com.mysql.cj.jdbc.Driver;

public class MyJDBC{
	private static String username = "root";
	private static String password = "root";
	private static String jdbcdriver = "com.mysql.cj.jdbc.Driver";
	private static String server = "127.0.0.1";
	protected static Connection connection;
	protected static Statement statement;
	protected static ResultSet resultSet;
	protected static Gson gson = new Gson();
	protected static Properties properties = new Properties();
	static{
		System.out.println("正在初始化JDBC...");
		System.out.println("寻找JDBC配置文件...");
		InputStream jdbcconfig = Thread.currentThread().getContextClassLoader().getResourceAsStream("JDBC_config.properties");
		
		try {
			System.out.println("正在读取JDBC配置文件...");
			properties.load(jdbcconfig);
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			jdbcdriver = properties.getProperty("driver");
			server = properties.getProperty("server");
			System.out.println("正在尝试连接...");
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://"+server+":3306/data?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8",username,password);
			System.out.println("连接数据库成功...");
			statement = connection.createStatement();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL异常: " + e.getMessage());
		    System.out.println("SQL状态: " + e.getSQLState());
		    System.out.println("供应商错误: " + e.getErrorCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(resultSet != null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				resultSet = null;
			}
			if(statement != null){
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				statement = null;
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				connection = null;
			}
		}
	}
	//连接数据库
	public void ConnectDatabase(){
		try {
			connection = DriverManager.getConnection("jdbc:mysql://"+server+":3306/data?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8",username,password);
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("打开数据库连接");
	}
	
	
	//关闭数据库
	public void CloseDatabseConnect(){
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultSet = null;
		}
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			statement = null;
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = null;
		}
		System.out.println("关闭数据库连接");
	}
}
