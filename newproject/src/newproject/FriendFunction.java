package newproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class FriendFunction extends MysqlConnection{
	
	public String[] friendSearch(String search_id) {
		Vector<String> list = new Vector<String>();
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet rs = null;
		String[] friendlist=null;
		
		try {
			Connection conn = getConnection();
			sql = "SELECT user_id FROM user WHERE user_id like '%" + search_id+"%\'"+";";
			System.out.println(sql);
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("user_id");
				list.add(id);
			
			}
			friendlist = list.toArray(new String[list.size()]);
			return friendlist;
		}catch(Exception e){
			e.printStackTrace();
		}
		return friendlist;
		
	}
	
	//친구 추가
	public void friendInsert(String my_id, String friend_id) {
		PreparedStatement preparedStatement = null;
		
		String sql = "INSERT INTO friend VALUES("+ "\'"+ my_id +"\'" +","+ "\'" + friend_id +"\'"+");";
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
	
	
	//id의 전체 친구 닉네임 목록을 불러온다
	public String[] friendList(String id) {
		Vector<String> friend_list = new Vector<String>();
		String[] friendlist = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet rs = null;

		try {
			Connection conn = getConnection();
			sql = "SELECT friend_id FROM friend WHERE my_id = '" + id+"\'"+";";
			System.out.println(sql);
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String friend = rs.getString("friend_id");
				
				friend_list.add(friend);
			}
			friendlist = friend_list.toArray(new String[friend_list.size()]);
			return friendlist;
		}catch(Exception e){
			e.printStackTrace();
		}
		return friendlist;
		
	}
	
	//친구 삭제
	public void friendDelete(String user_id, String friend_id) {
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM friend WHERE(my_id ="+"\'"+user_id+"\'"+")and(friend_id="+"\'"+friend_id+"\'"+");";
		System.out.println(sql);
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
