package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.List;
import java.awt.Font;

public class add_id extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                    add_id frame = new add_id();
                    frame.setVisible(true);
            }
        });
    }

    public add_id() {
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(215, 236, 213));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lb = new JLabel("ID");
        lb.setFont(new Font("����", Font.BOLD, 14));
        lb.setBounds(237, 37, 52, 15);
        contentPane.add(lb);
        
        JLabel lb_id = new JLabel("");         //���� �α������� id����� lable
        lb_id.setBounds(253, 37, 109, 15);
        contentPane.add(lb_id);
        
        textField = new JTextField();         //�߰��� id�Է¹��� textfield
        textField.setBounds(24, 62, 265, 28);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btn_search = new JButton("�˻�");  //id�˻��� �˻� ��ư
        btn_search.setBackground(new Color(245, 249, 208));
        btn_search.setFont(new Font("HY����M", Font.BOLD, 12));
        btn_search.setBounds(294, 62, 68, 28);
        contentPane.add(btn_search);
        
        List list = new List();           //�˻��� id��� ����� list
        list.setBounds(24, 96, 338, 207);
        contentPane.add(list);
        
        JButton btn_add = new JButton("ģ�� �߰�");  //list���� Ư��id���� �� ģ�� �߰��� ��ư
        btn_add.setBackground(new Color(245, 249, 208));
        btn_add.setFont(new Font("HY����M", Font.BOLD, 12));
        btn_add.setBounds(24, 309, 338, 33);
        contentPane.add(btn_add);
    }

}
