package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class id_error extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                    id_error frame = new id_error();
                    frame.setVisible(true);
            }
        });
    }
    public id_error() {
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lb = new JLabel("");
        lb.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\바탕 화면\\error.png"));
        lb.setBounds(46, 105, 95, 75);
        contentPane.add(lb);
        
        JLabel lb_1 = new JLabel("존재하지 않는 ID입니다!");
        lb_1.setFont(new Font("HY엽서M", Font.BOLD, 17));
        lb_1.setBounds(130, 105, 244, 85);
        contentPane.add(lb_1);
        
        JLabel lb_2 = new JLabel("닉네임");
        lb_2.setFont(new Font("HY엽서M", Font.BOLD, 15));
        lb_2.setBounds(46, 205, 73, 34);
        contentPane.add(lb_2);
        
        textField = new JTextField();          //가입할 닉네임 입력받을 textfield
        textField.setBounds(97, 200, 182, 39);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btn_create = new JButton("생성");    //닉네임 생성 버튼
        btn_create.setFont(new Font("HY엽서M", Font.PLAIN, 12));
        btn_create.setBackground(new Color(247, 204, 94));
        btn_create.setBounds(283, 200, 73, 39);
        contentPane.add(btn_create);
    }

}
