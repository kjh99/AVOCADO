package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import newproject.*;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.awt.Font;

public class add_id extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JTable friendTable;
    private JTable searchTable;
    DefaultTableModel model1,model2;
    
    private MysqlConnection db = new MysqlConnection();
    private String currentid = CurrentUser.getInstance().getUserId();

    public static void main(String[] args) {
    	new add_id();
    }

    public add_id() {
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(215, 236, 213));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lb = new JLabel("ID");
        lb.setFont(new Font("굴림", Font.BOLD, 14));
        lb.setBounds(237, 37, 52, 15);
        contentPane.add(lb);
        
        JLabel lb_id = new JLabel(currentid);         //현재 로그인중인 id출력할 lable
        lb_id.setBounds(273, 37, 109, 15);
        contentPane.add(lb_id);
        
        textField = new JTextField();         //추가할 id입력받을 textfield
        textField.setBounds(24, 62, 265, 28);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btn_search = new JButton("검색");  //id검색할 검색 버튼
        btn_search.setBackground(new Color(245, 249, 208));
        btn_search.setFont(new Font("HY엽서M", Font.BOLD, 12));
        btn_search.setBounds(294, 62, 68, 28);
        
        btn_search.addActionListener(new MyActionListener_btn_search());
        contentPane.add(btn_search);
        
        String header1[]= {"친구 목록"};
        model1=new DefaultTableModel(header1,0);
        friendTable=new JTable(model1);
        friendTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        getfriend();
        
        
        String header2[]= {"검색된 친구"};
        model2=new DefaultTableModel(header2,0);
        searchTable=new JTable(model2);
        searchTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        
        
        scrollPane1 = new JScrollPane(friendTable);   //단어 목록 출력하는 scrollpane
        scrollPane1.setBackground(new Color(255, 255, 255));
        scrollPane1.setEnabled(false);
        scrollPane1.setForeground(new Color(0, 0, 0));
        scrollPane1.setBounds(24, 96, 160, 207);
        contentPane.add(scrollPane1);
        
        scrollPane2 = new JScrollPane(searchTable);   //단어 목록 출력하는 scrollpane
        scrollPane2.setBackground(new Color(255, 255, 255));
        scrollPane2.setEnabled(false);
        scrollPane2.setForeground(new Color(0, 0, 0));
        scrollPane2.setBounds(203, 96, 160, 207);
        contentPane.add(scrollPane2);
        
//        List list = new List();           //검색한 id목록 출력할 list
//        list.setBounds(24, 96, 338, 207);
//        contentPane.add(list);
        
        JButton btn_del = new JButton("친구 삭제");  //list에서 특정id선택 후 친구 추가할 버튼
        btn_del.setBackground(new Color(245, 249, 208));
        btn_del.setFont(new Font("HY엽서M", Font.BOLD, 12));
        btn_del.setBounds(24, 309, 160, 33);
        btn_del.addActionListener(new MyActionListener_btn_del());
        contentPane.add(btn_del);
        
        JButton btn_add = new JButton("친구 추가");  //list에서 특정id선택 후 친구 추가할 버튼
        btn_add.setBackground(new Color(245, 249, 208));
        btn_add.setFont(new Font("HY엽서M", Font.BOLD, 12));
        btn_add.setBounds(203, 309, 160, 33);
        btn_add.addActionListener(new MyActionListener_btn_add());
        contentPane.add(btn_add);

    }
    
    class MyActionListener_btn_del implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		
    		int selectedRow = friendTable.getSelectedRow();
    		if (selectedRow >= 0) {
    			 String friend = (String) model1.getValueAt(selectedRow, 0);
    			 db.friendDelete(currentid,friend);
    		}
    		
    		model1.setNumRows(0);
    		getfriend();

    	}
    }
    
    class MyActionListener_btn_add implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		
    	int selectedRow = searchTable.getSelectedRow();
   		if (selectedRow >= 0) {
   			String friend = (String) model2.getValueAt(selectedRow, 0);
   			db.friendInsert(currentid,friend);
   		}
   		
   		model1.setNumRows(0);
   		getfriend();
    		
	
    	}
    }
    
    
    
    class MyActionListener_btn_search implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		
    		String search_word = textField.getText();
    		DefaultTableModel model2=(DefaultTableModel)searchTable.getModel();
    		
    		String []searchlist = db.friendSearch(search_word);

    		model2.setNumRows(0);
            for(int i=0; i<searchlist.length;i++) {
            	System.out.println(searchlist[i]);
            	model2.addRow(new Object[] {searchlist[i]});
            }
    		
	
    	}
    }
    
    public void getfriend() {
        String[] friendlist = db.friendList(currentid);
        
        for(int i=0; i<friendlist.length;i++) {
        	model1.addRow(new Object[] {friendlist[i]});
        }
    }
    

}
