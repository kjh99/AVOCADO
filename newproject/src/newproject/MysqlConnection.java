package newproject;

import java.sql.Connection;
import java.sql.DriverManager;


public class MysqlConnection {
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://new-db.crnbwzhpnodx.ap-northeast-2.rds.amazonaws.com/newdb";
	private static final String DB_USERNAME = "admin";
	private static final String DB_PASSWORD = "OOPproject_10";
	
			
	public static Connection getConnection(){
		Connection conn = null;
		try{
			//Register the JDBC driver
			Class.forName(DB_DRIVER);
 
			//Open the connection
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
 
			if(conn != null){
			   System.out.println("Successfully connected.");
			}else{
			   System.out.println("Failed to connect.");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

		
}

	
