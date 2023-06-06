package UI;
import java.awt.EventQueue;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import newproject.*;

public class search extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private String[] lang = {"Eng","Kor"};
    private String slang= "Eng";
    private JScrollPane scrollPane;
    private JTable wordTable;
    
    public search() {
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(64, 128, 128));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JComboBox<String> comboBox = new JComboBox<String>(lang);   //영,한 선택할 combobox
        comboBox.setBounds(24, 30, 63, 31);
        contentPane.add(comboBox);
        
        comboBox.addActionListener(new MyActionListener());
        
        textField = new JTextField();           //검색할 단어 입력받을 textfield
        textField.setBounds(94, 31, 182, 30);
        
        contentPane.add(textField);
        textField.setColumns(10);
        
        String header[]= {"단어","뜻"};
        DefaultTableModel model=new DefaultTableModel(header,0);
        wordTable=new JTable(model);
        wordTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        
        JButton btn_search = new JButton("검색");   //검색버튼
        btn_search.setFont(new Font("HY엽서M", Font.BOLD, 12));
        btn_search.setBackground(new Color(245, 249, 208));
        btn_search.setBounds(279, 30, 72, 31);
        btn_search.addActionListener(new MyActionListener_btn());
        contentPane.add(btn_search);
        
        
        
        scrollPane = new JScrollPane(wordTable);   //단어 목록 출력하는 scrollpane
        scrollPane.setBackground(new Color(255, 255, 255));
        scrollPane.setEnabled(false);
        scrollPane.setForeground(new Color(0, 0, 0));
        scrollPane.setBounds(24, 71, 327, 266);
        contentPane.add(scrollPane);
    }
    
    class MyActionListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		JComboBox<String> cb = (JComboBox<String>)e.getSource();
    		int idx = cb.getSelectedIndex();
    		slang = lang[idx];
    		
    		System.out.println(slang);
    		

    	}
    }
    class MyActionListener_btn implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		
    		String search_word = textField.getText();
    		DefaultTableModel model=(DefaultTableModel)wordTable.getModel();
    		
    		HashMap<String,String> wordlist = new BasicVocaFunction().search(slang, search_word);
    		Set<String> keys = wordlist.keySet();
    		Iterator<String> it = keys.iterator();
    		String []record=new String[2];
    		model.setNumRows(0);
    		while(it.hasNext()) {
    			String word = it.next();
    			String meaning = wordlist.get(word);
    			record[0] = word;
    			record[1] = meaning;
    			model.addRow(record);
    			}
    		
	
    	}
    }
}
