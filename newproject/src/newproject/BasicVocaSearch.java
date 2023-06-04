package newproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class BasicVocaSearch {

	public BasicVocaSearch() { //생성자를 통해 언어와 검색어 초기화

	}
	
	public HashMap<String,String> search(String lang, String search_word) {
		HashMap<String, String> wordlist = new HashMap<String,String>();
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet rs = null;
		
		try {
			Connection conn = MysqlConnection.getConnection();
			
			if(lang.equals("Eng")) {// 언어가 영어일때
				sql = "SELECT word,meaning FROM basic_voca WHERE word like '%" + search_word+"%\'"+";";
				System.out.println(sql);
				preparedStatement = conn.prepareStatement(sql);
				rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					
					String word = rs.getString("word");
					String meaning = rs.getString("meaning");
					wordlist.put(word, meaning);
					
				}
				return wordlist;
			}
			
			if(lang.equals("Kor")) {// 언어가 한국어 일때
				
				sql = "SELECT word,meaning FROM basic_voca WHERE meaning like '%" + search_word +"%\'"+";";
				System.out.println(sql);
				preparedStatement = conn.prepareStatement(sql);
				rs = preparedStatement.executeQuery();
				
				
				while(rs.next()) {
					String word = rs.getString("word");
					String meaning = rs.getString("meaning");
					wordlist.put(word, meaning);
				}
				return wordlist;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		
		
		}
				
		
		return wordlist;
	}

}
