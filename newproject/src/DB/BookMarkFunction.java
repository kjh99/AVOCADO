package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class BookMarkFunction extends MysqlConnection{
	
	
	//즐겨찾기 추가
	public void bookMarkInsert(String user_id, String word, String meaning) {
		PreparedStatement preparedStatement = null;
		
		String sql = "INSERT INTO bookmark VALUES("+ "\'"+ user_id +"\'" +","+ "\'" + word +"\'"+","+"\'"+meaning+"\'"+");";
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
	//즐겨찾기 모두 가져오기
	public HashMap<String,String> bookMarkList(String user_id) {
		HashMap<String, String> wordlist = new HashMap<String,String>();
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet rs = null;

		try {
			Connection conn = getConnection();
			sql = "SELECT word,meaning FROM bookmark WHERE user_id = '" + user_id+"\'"+";";
			System.out.println(sql);
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String word = rs.getString("word");
				String meaning = rs.getString("meaning");
				wordlist.put(word, meaning);
			}
			
			return wordlist;
		}catch(Exception e){
			e.printStackTrace();
		}
		return wordlist;
		
	}
	//즐겨찾기 내부 단어 삭제
	public void bookMarkDelete(String user_id, String word) {
		PreparedStatement preparedStatement = null;
		
		String sql = "DELETE FROM bookmark WHERE(user_id ="+"\'"+user_id+"\'"+")and(word="+"\'"+word+"\'"+");";
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
