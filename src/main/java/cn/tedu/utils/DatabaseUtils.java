package cn.tedu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DatabaseUtils {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	private static String initialSize;
	private static String maxActive;
	
	private static BasicDataSource dataSource;
	
	static {
		
		Properties pro = new Properties();
		InputStream is = DatabaseUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			pro.load(is);
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			initialSize = pro.getProperty("initialSize");
			maxActive = pro.getProperty("maxActive");
			
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setInitialSize(Integer.parseInt(initialSize));
			dataSource.setMaxActive(Integer.parseInt(maxActive));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/** 创建连接 */
	public static Connection getConnection () throws SQLException {
		Connection conn = dataSource.getConnection();
		return conn;
	}
	
	
	/** 关闭资源 */
	public static void close (Connection conn, Statement stat, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stat != null) {
				stat.close();
			}
			if (conn != null) {
				conn.setAutoCommit(true); // 还回连接池的连接要都是自动提交true的（关闭由手动操作）
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
