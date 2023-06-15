package UI;
import java.awt.EventQueue;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

import DB.*;

public class newid extends JFrame {

    private JPanel contentPane;
    private JPasswordField passwordField;
    private String id;
    IdFunction idf = new IdFunction();


    public newid() {
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        JLabel lb = new JLabel(new ImageIcon("src/UI/image/error.png"));
        lb.setBounds(35, 105, 95, 75);
        contentPane.add(lb);
        
        JLabel lb_1 = new JLabel("존재하지 않는 ID입니다!");
        lb_1.setFont(new Font("HY엽서M", Font.BOLD, 17));
        lb_1.setBounds(130, 105, 244, 85);
        contentPane.add(lb_1);
        
        JLabel lb_2 = new JLabel("비밀번호");
        lb_2.setFont(new Font("HY엽서M", Font.BOLD, 15));
        lb_2.setBounds(33, 205, 73, 34);
        contentPane.add(lb_2);
        
        passwordField = new JPasswordField();          //가입할 닉네임 입력받을 textfield
        passwordField.setBounds(97, 200, 182, 39);
        
        contentPane.add(passwordField);
        passwordField.setColumns(10);
        
        JButton btn_create = new JButton("생성"); //닉네임 생성 버튼
        btn_create.addActionListener(new MyActionListener());
        btn_create.setFont(new Font("HY엽서M", Font.PLAIN, 12));
        btn_create.setBackground(new Color(247, 204, 94));
        btn_create.setBounds(283, 200, 73, 39);
        contentPane.add(btn_create);
    }
    
    class MyActionListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String password = new String(passwordField.getPassword());
    		if(password.equals("") == false) {
    			idf.userInsert(id,password);
    			JOptionPane.showMessageDialog(null,"아이디 생성 성공", "Message",JOptionPane.INFORMATION_MESSAGE);
    			CurrentUser.getInstance().setUserId(id);
    			dispose();
	    		new Main();
    		}else 
    			JOptionPane.showMessageDialog(null,"다시 입력하세요", "Message",JOptionPane.ERROR_MESSAGE);
    }
    	
    }	
    public void setId(String id) {
    	this.id= id;
    }

}
