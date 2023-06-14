package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.*;
import DB.*;


public class game extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String user;
	private String note;
	private FriendFunction connectionFriends = new FriendFunction();
	private NoteFunction nf = new NoteFunction();
	private String userId = CurrentUser.getInstance().getUserId();
	private MyDialog dialog;
	private HashMap<String, String[]> words;
	private JLabel lb_;JLabel lb_1;JLabel lb;
	Set<String> keys;
	Iterator<String> it;
	MyThread th;
	private String word; String meaning; 
	 
	private int right=0;int wrong=0;int n=0;
	
	public game() {
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(218, 218, 254));
		dialog = new MyDialog(this, "단어장 목록");
		dialog.setVisible(true);
		setContentPane(contentPane);
		JLabel timerLabel = new JLabel();
		th = new MyThread(timerLabel);
		
		contentPane.setLayout(null);
        lb = new JLabel("맞출단어 : "+meaning);
        lb.setFont(new Font("HY엽서M", Font.BOLD, 15));
        lb.setBounds(68, 87, 200, 42);
        contentPane.add(lb);
        
        
        timerLabel.setFont(new Font("Gothic", Font.ITALIC, 12));
        timerLabel.setBounds(300, 10, 125, 42);
        contentPane.add(timerLabel);
        
        textField = new JTextField();         //답을 입력받을 textfield
        textField.setBounds(54, 139, 198, 34);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btn_guess = new JButton("GUESS");   //추측 버튼(제출버튼)
        btn_guess.addActionListener(new guessActionListener());
        btn_guess.setBackground(new Color(215, 236, 213));
        btn_guess.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 12));
        btn_guess.setBounds(258, 139, 95, 34);
        contentPane.add(btn_guess);
        
        lb_ = new JLabel("오답수 : "+ wrong);  
        lb_.setFont(new Font("HY엽서M", Font.BOLD, 15));
        lb_.setBounds(101, 190, 95, 25);
        contentPane.add(lb_);
        
        lb_1 = new JLabel("정답 : " + right);  
        lb_1.setFont(new Font("HY엽서M", Font.BOLD, 15));
        lb_1.setBounds(117, 210, 95, 25);
        contentPane.add(lb_1);
        
        JLabel lb_count = new JLabel("");     //시도횟수 띄울 label
        lb_count.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        lb_count.setBounds(198, 200, 107, 20);
        contentPane.add(lb_count);
        
        JButton btn_next = new JButton("다음문제");  //다음문제로 넘어가는데 쓰이는 버튼
        btn_next.setFont(new Font("HY엽서M", Font.BOLD, 15));
        btn_next.setBackground(new Color(215, 236, 213));
        btn_next.setBounds(54, 252, 281, 42);
        contentPane.add(btn_next);
        th.start();
    }

		
	class guessActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String answer = textField.getText();
			textField.setText("");
			if(answer.equals(word)) {
				right++;
				selectword();
				if(word.equals("endword")) {
					JOptionPane.showMessageDialog(null,"정답 : "+right+"\n오답 : "+wrong+"\n경과시간 : "+n );
					dispose();
					
				}
				lb_1.setText("정답 : " + right);
				lb.setText("맞출단어 : "+meaning);
			}else wrong++;
				lb_.setText("오답수 : "+ wrong);
		}
	}

	
	class MyDialog extends JDialog{
		public MyDialog(JFrame frame, String title) {
			super(frame,title,true);
			JPanel panel3 = new JPanel(new BorderLayout());
			panel3.setBackground(new Color(0xa0c040));  // 색상
			setSize(400,400);
			String[] columnNames3 = {"nickname", "notename"};  // 칼럼 이름
			DefaultTableModel model3 = new DefaultTableModel(columnNames3, 0) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			JTable table3 = new JTable(model3);
			table3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table3.setBackground(new Color(255, 255, 255));
			table3.setFillsViewportHeight(true);



			JPanel tablePanel3 = new JPanel(new BorderLayout());
			tablePanel3.setBackground(new Color(0xa0c040));  // 색상
			tablePanel3.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
			tablePanel3.add(table3);

			JButton btn3 = new JButton("단어장 선택");  // 버튼 
			//단어장 접속버튼 클릭시 창을 띄운다.
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedRow = table3.getSelectedRow();
					if (selectedRow >= 0) {  // 행이 선택되었는지 확인
						user = (String) model3.getValueAt(selectedRow, 0);  // "nickname" 칼럼
						note = (String) model3.getValueAt(selectedRow, 1); // "notename" 칼럼
						words = nf.wordList(user,note);
						keys = words.keySet();
						it = keys.iterator();
						selectword();
						
						contentPane.revalidate();     // 컨테이너 c의 재배치
						contentPane.repaint();
						setVisible(false);
						
					}
				}
			});

			panel3.add(btn3, BorderLayout.SOUTH);
			NoteFunction connectionUser = new NoteFunction();
			String[] userNotes = connectionUser.noteList(userId);
			for (String note : userNotes) {
				model3.addRow(new Object[]{userId, note});
			}

			// 친구 목록 데이터를 불러와서 친구의 단어장 목록을 모델에 추가
			FriendFunction connectionFriends = new FriendFunction();
			NoteFunction connectionnotes = new NoteFunction();
			String[] friends = connectionFriends.friendList(userId);
			for (String friend : friends) {
				String[] friendNotes = connectionnotes.noteList(friend);
				for (String note : friendNotes) {
					model3.addRow(new Object[]{friend, note});
				}
			}
			
			JScrollPane scrollPane3 = new JScrollPane(tablePanel3);
	        panel3.add(scrollPane3, BorderLayout.CENTER);
	        add(panel3);
		}
	}
	class MyThread extends Thread {
		private JLabel timerLabel;
		public MyThread(JLabel timerLabel) {
			this.timerLabel = timerLabel;
		}
		public void run() {

			while(true) {
				timerLabel.setText("Time : "+Integer.toString(n));
				n++;
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) {
					return;
				}
			}
		}
	}

	public void selectword() {

		
		if(it.hasNext()) {
			
				word = it.next();
				meaning = words.get(word)[0];

		}else {
			word = "endword";
		}

		
	}

}
