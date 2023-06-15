package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.List;
import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import DB.*;
import UI.game.MyDialog;

public class vocabulary extends JFrame {
	
    private JPanel contentPane;
    private JTextField textField;
    String user_id = CurrentUser.getInstance().getUserId(); // 로그인 아이디 불러오기 추가했음
    private String friend_id;
    private String note;
    private wordDialog dialog;
    private String selectedFriendId;
    
  //추가했음 
    public vocabulary(String selectedFriendId) {
        this.friend_id = selectedFriendId;
        // 추가적인 초기화 작업 등을 수행할 수 있습니다.
        // ...
    }


    public vocabulary() {
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(64, 128, 128));
        

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(new Color(215, 236, 213));
        tabbedPane.setBounds(22, 29, 337, 310);
        
        JPanel panel1=new JPanel();                        //내 단어장 탭
        panel1.setBackground(new Color(215, 236, 213));
        tabbedPane.add("내 단어장",panel1);
        panel1.setLayout(null);
        
        List list = new List();            //내 단어장 목록들을 띄울 list
        list.setBounds(10, 10, 312, 221);
        panel1.add(list);
        
        NoteFunction noteFunction = new NoteFunction();
        String[] noteList = noteFunction.noteList(user_id); // noteList 메서드를 호출하여 노트 이름 목록을 가져옴

        // noteList의 각 요소를 List에 추가
        for (String note_name : noteList) {
            list.add(note_name);
        }
        
        JButton btn_create = new JButton("단어장 생성");   //단어장 생성 버튼
        btn_create.setFont(new Font("HY엽서M", Font.BOLD, 12));
        btn_create.setBackground(new Color(245, 249, 208));
        btn_create.setBounds(216, 237, 106, 34);
        panel1.add(btn_create);
        
        textField = new JTextField();     //새로운 단어장 추가할때 단어장 이름 입력받을 textfield
        textField.setBounds(12, 237, 200, 34);
        panel1.add(textField);
        textField.setColumns(10);
        
        JPanel panel2=new JPanel();     //친구 id 탭
        panel2.setBackground(new Color(215, 236, 213));
        tabbedPane.add("친구 id",panel2);
        panel2.setLayout(null);
        
        List list_ = new List();        //친구목록 띄울 list
        list_.setBounds(10, 10, 312, 261);
        panel2.add(list_);
        contentPane.add(tabbedPane);  
        
     // Fetch friend list and populate list_
        FriendFunction friendFunction = new FriendFunction();
        String[] friendList = friendFunction.friendList(user_id);

        // Add friend IDs to list_
        for (String friend_id : friendList) {
            list_.add(friend_id);
        }
        
        JPanel panel3=new JPanel();     //친구 단어장 탭
        panel3.setBackground(new Color(215, 236, 213));
        tabbedPane.add("친구 단어장",panel3);
        panel3.setLayout(null);
        
        List list2 = new List();        //친구목록 띄울 list
        list2.setBounds(10, 10, 312, 261);
        panel3.add(list2);
        contentPane.add(tabbedPane);
        

        

        btn_create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String note_name = textField.getText(); 
                NoteFunction noteFunction = new NoteFunction();
                noteFunction.noteListInsert(note_name, user_id); 
                
                
                list.add(note_name);
                
                textField.setText(""); // Clear the text field
            }
        });
        
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    note = list.getSelectedItem();
                 
                    dialog = new wordDialog(user_id,note);
                    dialog.setVisible(true);
                   
                    
                }
            }
        });
        
        list2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    note = list2.getSelectedItem();
                   
                    dialog = new wordDialog(selectedFriendId,note);
                    dialog.setVisible(true);
                   
                    
                }
            }
        });
        
      
        list_.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() == 2) { 
                    selectedFriendId = list_.getSelectedItem(); 
                    NoteFunction noteFunction = new NoteFunction();
                    String[] friendNoteList = noteFunction.noteList(selectedFriendId); 

                    list2.removeAll(); 

                   
                    for (String note_name : friendNoteList) {
                        list2.add(note_name);
                    }
                }
            }
        });
        
        
        
    }
    
    class wordDialog extends JDialog{
    	private NoteFunction nf = new NoteFunction();
    	private String user;
    	private String note;
    	
    	public wordDialog(String user,String note) {
    		
    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(400, 400);
            setTitle(note);
            Container c = getContentPane();
            c.setLayout(new BorderLayout());
            
            String[] columnNames = {"단어", "뜻"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            JTable table = new JTable(model);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setBackground(new Color(255, 255, 255));
            table.setFillsViewportHeight(true);

            
            HashMap<String, String[]> words = nf.wordList(user,note);
            for (Map.Entry<String, String[]> entry : words.entrySet()) {
                String word = entry.getKey();
                String[] meaning = entry.getValue();
                model.addRow(new Object[]{word, meaning[0]});
            }
            
            JPanel tablePanel = new JPanel(new BorderLayout());
            tablePanel.setBackground(new Color(0xa0c040));
            tablePanel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
            tablePanel.add(table);
            JScrollPane scrollPane = new JScrollPane(tablePanel);
            c.add(scrollPane, BorderLayout.CENTER);
    	}
    }
}



