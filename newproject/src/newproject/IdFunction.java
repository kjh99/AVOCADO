package newproject;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IdFunction {


	//id가 존재하는지 확인 true ->있음 false ->없음
	public boolean hasId(String id) {
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet rs = null;
		String nickname = null;

		try {
			Connection conn = MysqlConnection.getConnection();
			sql = "SELECT user_id FROM user WHERE user_id = '" + id+"\'"+";";
			System.out.println(sql);
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				nickname = rs.getString("user_id");
			}
			
			if(nickname == null) return false;
			else return true;
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}
	
	public void userInsert(String id, String nickname) {
		PreparedStatement preparedStatement = null;
		
		String sql = "INSERT INTO user VALUES("+ "\'"+ id +"\'" +","+ "\'" + nickname +"\'"+");";
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
