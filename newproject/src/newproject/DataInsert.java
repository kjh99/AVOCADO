package newproject;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataInsert {
	
	public static void main(String args[]) {
		
		PreparedStatement preparedStatement = null;
		
		String sql = "Insert into Voca values(3,"+"\'grape\',"+"\'포도\')";
		
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
