package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.List;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import DB.*;

public class vocabulary extends JFrame {
	
    private JPanel contentPane;
    private JTextField textField;
    String user_id = CurrentUser.getInstance().getUserId(); // 로그인 아이디 불러오기 추가했음
    private String friend_id;
    
    
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
        
        JPanel panel4=new JPanel();     //친구 단어 탭
        panel4.setBackground(new Color(215, 236, 213));
        tabbedPane.add("친구의 단어",panel4);
        panel4.setLayout(null);
        
        List list3 = new List();        //친구목록 띄울 list
        list3.setBounds(10, 10, 312, 261);
        panel4.add(list3);
        contentPane.add(tabbedPane);
        /*친구 목록 띄운다음에 그 list에서 특정 친구 선택하고
        선택했을 때 그 친구의 단어장 목록 출력하는 창 띄워야해요..!
        그다음에 그 단어장목록 중에서 특정 단어장 선택하면 해당하는 단어목록들이 출력되는 창 띄우면 돼요!
        (리스트에서 선택됐을 때 새로운 창을 띄워야 해서 미리 못 만들어놨어요ㅠㅠ)*/ 
        
     // Inside the constructor of vocabulary class
        btn_create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String note_name = textField.getText(); // Get the entered text from the text field
                NoteFunction noteFunction = new NoteFunction();
                noteFunction.noteListInsert(note_name, user_id); // Call the noteListInsert method from NoteFunction class
                // You can perform any additional actions here after saving the note name
                
                list.add(note_name);
                
                textField.setText(""); // Clear the text field
            }
        });
        
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() == 2) { // Check if it's a double-click event
                    String selectedNote = list.getSelectedItem(); // Get the selected note from the list
                    // Open wordedit window passing the selected note as a parameter
                    wordmanagerselect wd=new wordmanagerselect();
                    wd.setVisible(true);
                }
            }
        });
        
        //이 밑부턴 실행 오류남... 친구id 탭에서 친구id 더블클릭시 친구 단어장 탭에 친구가 추가한 단어장이 출력되야함. 그다음 친구 단어장을 더블클릭하면 친구 단어 탭에 친구가 단어장에 추가한 단어가 나와야함.
        list_.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() == 2) { // Check if it's a double-click event
                    String selectedFriendId = list_.getSelectedItem(); // Get the selected friend ID
                    NoteFunction noteFunction = new NoteFunction();
                    String[] friendNoteList = noteFunction.noteList(selectedFriendId); // Get the friend's note list

                    list2.removeAll(); // Clear the existing items in list2

                    // Add the friend's note names to list2
                    for (String note_name : friendNoteList) {
                        list2.add(note_name);
                    }
                }
            }
        });

        
        
    }
}



