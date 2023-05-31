package newproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BasicVocaSearch {
	String lang;
	String search_word;
	
	public BasicVocaSearch(String lang, String search_word) { //생성자를 통해 언어와 검색어 초기화
		this.lang = lang;
		this.search_word = search_word;
	}
	
	public String[] search() {
		String[] a = new String[2]; // 출력 결과를 넣을 String배열
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet rs = null;
		
		try {
			Connection conn = MysqlConnection.getConnection();
			
			if(lang.equals("Eng")) {// 언어가 영어일때
				sql = "SELECT meaning FROM basic_voca WHERE word = '" + search_word+"\'"+";";
				System.out.println(sql);
				preparedStatement = conn.prepareStatement(sql);
				rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					String meaning = rs.getString("meaning");
					a[0] = search_word;
					a[1] = meaning;
					
				}
			}
			
			if(lang.equals("Kor")) {// 언어가 한국어 일때
				
				sql = "SELECT word FROM basic_voca WHERE meaning = '" + search_word+"\'"+";";
				System.out.println(sql);
				preparedStatement = conn.prepareStatement(sql);
				rs = preparedStatement.executeQuery();
				
				
				while(rs.next()) {
					String word = rs.getString("word");
					a[0] = search_word;
					a[1] = word;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		
		
		}
				
		
		return a;
	}

}
