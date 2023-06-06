package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class game extends JFrame {

    private JPanel contentPane;
    private JTextField textField;


    public game() {
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(218, 218, 254));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lb = new JLabel("맞출단어 : ");
        lb.setFont(new Font("HY엽서M", Font.BOLD, 15));
        lb.setBounds(68, 87, 101, 42);
        contentPane.add(lb);
        
        JLabel lb_word = new JLabel("");      //맞춰야하는 단어의 뜻 띄울 label
        lb_word.setFont(new Font("HY엽서M", Font.BOLD, 12));
        lb_word.setBounds(155, 87, 125, 42);
        contentPane.add(lb_word);
        
        textField = new JTextField();         //답을 입력받을 textfield
        textField.setBounds(54, 139, 198, 34);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btn_guess = new JButton("GUESS");   //추측 버튼(제출버튼)
        btn_guess.setBackground(new Color(215, 236, 213));
        btn_guess.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 12));
        btn_guess.setBounds(258, 139, 95, 34);
        contentPane.add(btn_guess);
        
        JLabel lb_ = new JLabel("시도횟수 : ");  
        lb_.setFont(new Font("HY엽서M", Font.BOLD, 15));
        lb_.setBounds(117, 201, 95, 25);
        contentPane.add(lb_);
        
        JLabel lb_count = new JLabel("");     //시도횟수 띄울 label
        lb_count.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        lb_count.setBounds(198, 200, 107, 20);
        contentPane.add(lb_count);
        
        JButton btn_next = new JButton("다음문제");  //다음문제로 넘어가는데 쓰이는 버튼
        btn_next.setFont(new Font("HY엽서M", Font.BOLD, 15));
        btn_next.setBackground(new Color(215, 236, 213));
        btn_next.setBounds(54, 252, 281, 42);
        contentPane.add(btn_next);
    }

}
