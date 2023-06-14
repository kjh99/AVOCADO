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

public class vocabulary extends JFrame {

    private JPanel contentPane;
    private JTextField textField;


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
        
        JButton btn_create = new JButton("단어장 생성");   //단어장 생성 버튼
        btn_create.setFont(new Font("HY엽서M", Font.BOLD, 12));
        btn_create.setBackground(new Color(245, 249, 208));
        btn_create.setBounds(216, 237, 106, 34);
        panel1.add(btn_create);
        
        textField = new JTextField();     //새로운 단어장 추가할때 단어장 이름 입력받을 textfield
        textField.setBounds(12, 237, 200, 34);
        panel1.add(textField);
        textField.setColumns(10);
        
        JPanel panel2=new JPanel();     //친구 단어장 탭
        panel2.setBackground(new Color(215, 236, 213));
        tabbedPane.add("친구 단어장",panel2);
        panel2.setLayout(null);
        
        List list_ = new List();        //친구목록 띄울 list
        list_.setBounds(10, 10, 312, 261);
        panel2.add(list_);
        contentPane.add(tabbedPane);  
        /*친구 목록 띄운다음에 그 list에서 특정 친구 선택하고
        선택했을 때 그 친구의 단어장 목록 출력하는 창 띄워야해요..!
        그다음에 그 단어장목록 중에서 특정 단어장 선택하면 해당하는 단어목록들이 출력되는 창 띄우면 돼요!
        (리스트에서 선택됐을 때 새로운 창을 띄워야 해서 미리 못 만들어놨어요ㅠㅠ)*/ 
    }
}
