package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;

public class wordedit extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                    wordedit frame = new wordedit();
                    frame.setVisible(true);
            }
        });
    }

    public wordedit() {
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(64, 128, 128));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP); //�ܾ��� ��� ��
        JPanel panel1=new JPanel();
        panel1.setBackground(new Color(215, 236, 213));
        tabbedPane.add("�ܾ��� ���",panel1);
        panel1.setLayout(null);
        
        List list = new List();      //�ܾ��� ��� ����� list
        list.setBounds(10, 10, 316, 198);
        panel1.add(list);
        
        JButton btn_add = new JButton("�߰�");    //�ܾ� �߰� ��ư
        btn_add.setFont(new Font("HY����M", Font.BOLD, 12));
        btn_add.setBackground(new Color(245, 249, 208));
        btn_add.setBounds(10, 223, 148, 45);
        panel1.add(btn_add);
        
        JButton btn_edit = new JButton("���� / ����");  //�ܾ� ����,���� ��ư
        btn_edit.setFont(new Font("HY����M", Font.BOLD, 12));
        btn_edit.setBackground(new Color(245, 249, 208));
        btn_edit.setBounds(178, 223, 148, 45);
        panel1.add(btn_edit);
        tabbedPane.setBounds(22, 30, 341, 307);
        contentPane.add(tabbedPane);
        
        btn_add.addActionListener(new ActionListener() {  //�ܾ��߰���ư ������ add_word.java���
            public void actionPerformed(ActionEvent e) {
                add_word aw=new add_word();
                aw.setVisible(true);
            }
        });

        btn_edit.addActionListener(new ActionListener() { //�ܾ������ư ������ delete_word.java���
            public void actionPerformed(ActionEvent e) {
                delete_word dw=new delete_word();
                dw.setVisible(true);
            }
        });
    }

}
