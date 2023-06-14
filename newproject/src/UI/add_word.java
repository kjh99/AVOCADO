package UI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DB.*;


public class add_word extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private static String noteName;
    private NoteFunction nff = new NoteFunction();
	
	
    public add_word(String noteName) {
        setSize(300,300);
        setVisible(true);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(215, 236, 213));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lb_e = new JLabel("    영어");
        lb_e.setFont(new Font("HY엽서M", Font.BOLD, 12));
        lb_e.setForeground(new Color(0, 0, 0));
        lb_e.setBounds(30, 75, 57, 21);
        contentPane.add(lb_e);
        
        JLabel lb_k = new JLabel("    한글");
        lb_k.setForeground(new Color(0, 0, 0));
        lb_k.setFont(new Font("HY엽서M", Font.BOLD, 12));
        lb_k.setBounds(30, 116, 57, 21);
        contentPane.add(lb_k);
        
        textField = new JTextField();          //영어 입력받을 textfield
        textField.setBounds(89, 72, 150, 27);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();        //한글 입력받을 textfield
        textField_1.setBounds(89, 113, 150, 27);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JButton btn_add = new JButton("단어 추가");   //단어 추가 버튼
        btn_add.setBackground(new Color(245, 249, 208));
        btn_add.setFont(new Font("HY엽서M", Font.BOLD, 15));
        btn_add.setBounds(44, 166, 206, 48);
        contentPane.add(btn_add);
        
        
        btn_add.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String word = textField.getText();
        		String meaning = textField_1.getText();
        		String user_id = CurrentUser.getInstance().getUserId();
        		nff.noteInsert(user_id, noteName, word, meaning);
        		
        		JOptionPane.showMessageDialog(null, "단어가 추가되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    

    
    
}
