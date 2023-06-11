package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class delete_word extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    public delete_word() {
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(215, 236, 213));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 249, 208));
        panel.setBounds(12, 20, 362, 322);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(259, 46, 91, 266);
        panel.add(scrollPane);
        
        JLabel lb_list = new JLabel("    단어 목록");
        lb_list.setFont(new Font("HY엽서M", Font.BOLD, 12));
        lb_list.setVerticalAlignment(SwingConstants.BOTTOM);
        lb_list.setBounds(259, 10, 91, 27);
        panel.add(lb_list);
        
        JLabel lb_e = new JLabel("영어");
        lb_e.setFont(new Font("HY엽서M", Font.BOLD, 12));
        lb_e.setBounds(44, 96, 59, 27);
        panel.add(lb_e);
        
        JLabel lb_k = new JLabel("한글");
        lb_k.setFont(new Font("HY엽서M", Font.BOLD, 12));
        lb_k.setBounds(44, 138, 59, 27);
        panel.add(lb_k);
        
        textField = new JTextField();             //수정하고 삭제할 영어 textfield
        textField.setBounds(76, 99, 134, 21);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();          //수정하고 삭제할 한글 textfield
        textField_1.setBounds(76, 141, 134, 21);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        JButton btn_edit = new JButton("단어 수정");    //단어수정 버튼
        btn_edit.setFont(new Font("HY엽서M", Font.BOLD, 12));
        btn_edit.setBounds(22, 185, 95, 39);
        panel.add(btn_edit);
        
        JButton btn_delete = new JButton("단어 삭제");  //단어삭제 버튼
        btn_delete.setFont(new Font("HY엽서M", Font.BOLD, 12));
        btn_delete.setBounds(129, 185, 95, 39);
        panel.add(btn_delete);
       
    }

}
