package newproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getData {
	public static void main(String args[]) {
		
		PreparedStatement preparedStatement = null;
		
		String sql = "SELECT * FROM Voca";
		
		try {
			Connection conn = MysqlConnection.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String word = rs.getString("word");
				String meaning = rs.getString("meaning");
				System.out.println(num + "\t" + word +  "\t" + meaning + "\t");
			}
			
			
			preparedStatement.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
}