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


    public wordedit() {
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(64, 128, 128));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP); //단어장 목록 탭
        JPanel panel1=new JPanel();
        panel1.setBackground(new Color(215, 236, 213));
        tabbedPane.add("단어장 목록",panel1);
        panel1.setLayout(null);
        
        List list = new List();      //단어장 목록 출력할 list
        list.setBounds(10, 10, 316, 198);
        panel1.add(list);
        
        JButton btn_add = new JButton("추가");    //단어 추가 버튼
        btn_add.setFont(new Font("HY엽서M", Font.BOLD, 12));
        btn_add.setBackground(new Color(245, 249, 208));
        btn_add.setBounds(10, 223, 148, 45);
        panel1.add(btn_add);
        
        JButton btn_edit = new JButton("수정 / 삭제");  //단어 수정,삭제 버튼
        btn_edit.setFont(new Font("HY엽서M", Font.BOLD, 12));
        btn_edit.setBackground(new Color(245, 249, 208));
        btn_edit.setBounds(178, 223, 148, 45);
        panel1.add(btn_edit);
        tabbedPane.setBounds(22, 30, 341, 307);
        contentPane.add(tabbedPane);
        
        btn_add.addActionListener(new ActionListener() {  //단어추가버튼 누르면 add_word.java띄움
            public void actionPerformed(ActionEvent e) {
                add_word aw=new add_word();
                aw.setVisible(true);
            }
        });

        btn_edit.addActionListener(new ActionListener() { //단어수정버튼 누르면 delete_word.java띄움
            public void actionPerformed(ActionEvent e) {
                delete_word dw=new delete_word();
                dw.setVisible(true);
            }
        });
    }

}
