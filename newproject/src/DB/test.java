package newproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import newproject.CurrentUser;  

public class NoteFunction extends MysqlConnection{
	
	
	
	//mynote 테이블에 (나만의 단어장) 단어 추가
		public void noteInsert(String user_id, String note_name, String word, String meaning) {
			PreparedStatement preparedStatement = null;
			
			String sql = "SELECT MAX(num) FROM mynote;";
			try {
				
				
				Connection conn = getConnection();
				
				preparedStatement = conn.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery();
				rs.next();
				int num = rs.getInt("MAX(num)")+1;
				
				sql = "INSERT INTO mynote VALUES("+ "\'"+ num +"\'" +","+ "\'" + user_id +"\'"+","+"\'"+ note_name +"\'" +","+"\'"+ word +"\'" +","+"\'"+ meaning +"\'"+");";
				System.out.println(sql);
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.execute();
				preparedStatement.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		//단어장에서 단어 삭제
		public void noteDelete(String user_id,String note_name ,String word) {
			PreparedStatement preparedStatement = null;
			
			String sql = "DELETE FROM mynote WHERE(user_id ="+"\'"+user_id+"\'"+")and(note_name="+"\'"+note_name+"\'"+")and(word="+"\'"+word+"\'"+");";
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

	//번호를 이용해 mynote 테이블의 내용 수정
		public void noteUpdate(String column, String new_data, int num) {
			PreparedStatement preparedStatement = null;
			String sql = null;
			if(column.equals("word"))
				sql = "UPDATE mynote SET word =" + "\'"+new_data+"\'"+"WHERE(num = "+num +");";
			else if(column.equals("meaning"))
				sql = "UPDATE mynote SET meaning =" + "\'"+new_data+"\'"+"WHERE(num = "+num+");";
			
			try {
				Connection conn = getConnection();
				System.out.println(sql);
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.execute();
				preparedStatement.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		
	//지정된 노트의 단어 목록을 모두 불러온다
		public HashMap<String,String[]> wordList(String user_id,String note_name) {
			HashMap<String, String[]> wordlist = new HashMap<String,String[]>();
			PreparedStatement preparedStatement = null;
			String sql = null;
			ResultSet rs = null;

			try {
				Connection conn = getConnection();
				sql = "SELECT word,meaning,num FROM mynote WHERE(user_id ="+"\'"+user_id+"\'"+")and(note_name="+"\'"+note_name+"\'"+");";
				System.out.println(sql);
				preparedStatement = conn.prepareStatement(sql);
				rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					String word = rs.getString("word");
					String meaning = rs.getString("meaning");
					String num = rs.getString("num");
					String[] a = {meaning,num};
					wordlist.put(word, a);
				}
				
				return wordlist;
			}catch(Exception e){
				e.printStackTrace();
			}
			return wordlist;
			
		}
	//단어장 추가
	public void noteListInsert(String note_name, String user_id) {
		PreparedStatement preparedStatement = null;
		
		String sql = "INSERT INTO note_list VALUES("+ "\'"+ note_name +"\'" +","+ "\'" + user_id +"\'"+");";
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
	
	//단어장 자체 삭제(내부 단어 포함)
	public void noteListDelete(String user_id,String note_name ) {
		PreparedStatement preparedStatement = null;
		
		String sql = "DELETE FROM note_list WHERE(user_id ="+"\'"+user_id+"\'"+")and(note_name="+"\'"+note_name+"\'"+");";
		System.out.println(sql);
		try {
			Connection conn = getConnection();

			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.execute();
			sql = "DELETE FROM mynote WHERE(user_id ="+"\'"+user_id+"\'"+")and(note_name="+"\'"+note_name+"\'"+");";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.execute();
			preparedStatement.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	//id의 모든 노트 목록을 가져온다
	public String[] noteList(String user_id) {
		Vector<String> note_list = new Vector<String>();
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet rs = null;
		String[] notelist=null;

		try {
			Connection conn = getConnection();
			sql = "SELECT note_name FROM note_list WHERE user_id = '" + user_id+"\'"+";";
			System.out.println(sql);
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String note_name = rs.getString("note_name");
				note_list.add(note_name);
			
			}
			notelist = note_list.toArray(new String[note_list.size()]);
			return notelist;
		}catch(Exception e){
			e.printStackTrace();
		}
		return notelist;
		
	}
	
	
	//이 밑부턴 오류남... 
	public String[] noteList2(String friend_id) {  
		Vector<String> note_list = new Vector<String>();
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet rs = null;
		String[] noteList2=null;

		try {
			Connection conn = getConnection();
			sql = "SELECT note_name FROM note_list WHERE friend_id = '" + friend_id+"\'"+";";
			System.out.println(sql);
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String note_name = rs.getString("note_name");
				note_list.add(note_name);
			
			}
			noteList2 = note_list.toArray(new String[note_list.size()]);
			return noteList2;
		}catch(Exception e){
			e.printStackTrace();
		}
		return noteList2;
		
	}
	//지정된 노트의 단어 목록을 모두 불러온다 (친구 단어)
			public HashMap<String,String[]> wordList2(String friend_id,String note_name) {
				HashMap<String, String[]> wordlist2 = new HashMap<String,String[]>();
				PreparedStatement preparedStatement = null;
				String sql = null;
				ResultSet rs = null;

				try {
					Connection conn = getConnection();
					sql = "SELECT word,meaning,num FROM mynote WHERE(user_id ="+"\'"+friend_id+"\'"+")and(note_name="+"\'"+note_name+"\'"+");";
					System.out.println(sql);
					preparedStatement = conn.prepareStatement(sql);
					rs = preparedStatement.executeQuery();
					
					while(rs.next()) {
						String word = rs.getString("word");
						String meaning = rs.getString("meaning");
						String num = rs.getString("num");
						String[] a = {meaning,num};
						wordlist2.put(word, a);
					}
					
					return wordlist2;
				}catch(Exception e){
					e.printStackTrace();
				}
				return wordlist2;
				
			}
}

