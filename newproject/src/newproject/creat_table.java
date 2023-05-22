package newproject;
import java.sql.Connection;

import java.sql.PreparedStatement;

public class creat_table {
	public static void main(String args[]) {
		
		PreparedStatement preparedStatement = null;
		
		String sql = "CREATE table newtable(ID INT)";
		
		try {
			Connection conn = MysqlConnection.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.execute();
			preparedStatement.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
