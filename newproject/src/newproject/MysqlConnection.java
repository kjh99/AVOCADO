package newproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


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
	
	//테이블 보기
	public void viewTable(String table) {// table 변수 ->all(전체보기),user,note_list,friend,mynote,basicvoca,bookmark
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet rs = null;
		
		try {
			Connection conn = getConnection();
			
			if(table.equals("user") || table.equals("all")) {
				System.out.println("");
				sql = "SELECT * FROM user;";
				preparedStatement = conn.prepareStatement(sql);
				rs = preparedStatement.executeQuery();
				
				System.out.println("user_id");
				
				while(rs.next()) {
					String user_id = rs.getString("user_id");
					System.out.println(user_id);
				}
			}
				
			if(table.equals("friend") || table.equals("all")) {
				System.out.println("");
				sql = "SELECT * FROM friend;";
				preparedStatement = conn.prepareStatement(sql);
				rs = preparedStatement.executeQuery();
				
				System.out.println("my_id\tfriend_id");
				while(rs.next()) {
					String my_id = rs.getString("my_id");
					String friend_id= rs.getString("friend_id");
					System.out.println(my_id + "\t" + friend_id);
				}
			}
			
			if(table.equals("note_list") || table.equals("all")) {
				System.out.println("");
				sql = "SELECT * FROM note_list;";
				preparedStatement = conn.prepareStatement(sql);
				rs = preparedStatement.executeQuery();
				System.out.println("note_name\tuser_id");
				while(rs.next()) {
					String note_name = rs.getString("note_name");
					String user_id = rs.getString("user_id");
					System.out.println(note_name + "\t" + user_id+ "\t" );
				}
			}
			
			
			if(table.equals("basic_voca") || table.equals("all")) {
				System.out.println("");
				sql = "SELECT * FROM basic_voca;";
				preparedStatement = conn.prepareStatement(sql);
				rs = preparedStatement.executeQuery();
				System.out.println("num\tword\tmeaning");
				while(rs.next()) {
					int num = rs.getInt("num");
					String word = rs.getString("word");
					String meaning = rs.getString("meaning");
					System.out.println(num + "\t" + word +  "\t" + meaning + "\t");
				}
			}
			
			if(table.equals("mynote") || table.equals("all")) {
				System.out.println("");
				sql = "SELECT * FROM mynote;";
				preparedStatement = conn.prepareStatement(sql);
				rs = preparedStatement.executeQuery();
				
				System.out.println("num\tuser_id\tnote_name\tword\tmeaning");
				while(rs.next()) {
					int num = rs.getInt("num");
					String user_id = rs.getString("user_id");
					String note_name= rs.getString("note_name");
					String word = rs.getString("word");
					String meaning = rs.getString("meaning");
					System.out.println(num + "\t" + user_id + "\t" + note_name + " \t" + word + "\t" + meaning + "\t");
				}
			}
			if(table.equals("bookmark") || table.equals("all")) {
				System.out.println("");
				sql = "SELECT * FROM bookmark;";
				preparedStatement = conn.prepareStatement(sql);
				rs = preparedStatement.executeQuery();
				
				System.out.println("user_id\tword\tmeaning");
				while(rs.next()) {
					
					String user_id = rs.getString("user_id");
					
					String word = rs.getString("word");
					String meaning = rs.getString("meaning");
					System.out.println( user_id + "\t" + word + "\t" + meaning + "\t");
				}
			}
			
			
			
			
			preparedStatement.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		
		
		}
	}
	
	//DB 테이블 생성 (웬만하면 건들지 말것)
	public void creatTable(String sql){//  ex) "CREATE table newtable(ID INT)"

			PreparedStatement preparedStatement = null;
			
			
			try {
				Connection conn = getConnection();
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.execute();
				preparedStatement.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
	}
	
	//sql문으로 작동
	public void query(String sql){// ex) "Insert into Voca values(3,"+"\'grape\',"+"\'포도\')"

			PreparedStatement preparedStatement = null;
			
			try {
				Connection conn = getConnection();
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.execute();
				preparedStatement.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
				
	}
	

	
	

	

}