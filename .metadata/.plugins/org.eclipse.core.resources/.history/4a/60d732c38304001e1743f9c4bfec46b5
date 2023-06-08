package newproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;

public class test extends JFrame {
	public static void main(String[] args){
		HashMap<String,String[]> a = new NoteFunction().wordList("사용자 아디","노트 이름");
		
		Set<String> keys = a.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {
			String word = it.next();
			String[] mn = a.get(word);
			
			System.out.println(word+" " +mn[0]+" "+mn[1]);
			}
		
    }
    
}