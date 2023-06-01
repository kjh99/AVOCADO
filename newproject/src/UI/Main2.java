package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

public class Main2 extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                    Main2 frame = new Main2();
                    frame.setVisible(true);
            }
        });
    }

    public Main2() {
        setSize(550,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new CompoundBorder(new LineBorder(new Color(0, 64, 0), 4), new LineBorder(new Color(215, 236, 213), 9)));
        contentPane.setForeground(new Color(0, 64, 0));
        contentPane.setBackground(new Color(255, 255, 255));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lb = new JLabel("A!VOCA.DO");
        lb.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 50));
        lb.setBounds(128, 55, 317, 132);
        contentPane.add(lb);
        
        JLabel lb_ = new JLabel("");
        lb_.setIcon(new ImageIcon("src/image/avocado.png"));
        lb_.setBounds(182, 37, 140, 130);
        contentPane.add(lb_);
        
        JLabel lb_search = new JLabel("�ܾ�˻�");
        lb_search.setVerticalAlignment(SwingConstants.BOTTOM);
        lb_search.setForeground(new Color(0, 64, 0));
        lb_search.setFont(new Font("HY����M", Font.BOLD, 15));
        lb_search.setBounds(182, 167, 88, 40);
        contentPane.add(lb_search);
        
        JLabel lb_edit = new JLabel(" �ܾ��߰�/����");
        lb_edit.setForeground(new Color(255, 255, 255));
        lb_edit.setFont(new Font("HY����M", Font.BOLD, 11));
        lb_edit.setBounds(282, 179, 100, 40);
        contentPane.add(lb_edit);
        
        JLabel lb_bookmark = new JLabel("���ã��");
        lb_bookmark.setForeground(new Color(255, 255, 255));
        lb_bookmark.setFont(new Font("HY����M", Font.BOLD, 15));
        lb_bookmark.setBounds(128, 218, 100, 40);
        contentPane.add(lb_bookmark);
        
        JLabel lb_voca = new JLabel("�ܾ����");
        lb_voca.setForeground(new Color(0, 64, 0));
        lb_voca.setFont(new Font("HY����M", Font.BOLD, 15));
        lb_voca.setBounds(240, 218, 100, 40);
        contentPane.add(lb_voca);
        
        JLabel lb_game = new JLabel("   �ܾ����");
        lb_game.setForeground(new Color(255, 255, 255));
        lb_game.setFont(new Font("HY����M", Font.BOLD, 15));
        lb_game.setBounds(334, 219, 96, 38);
        contentPane.add(lb_game);
        
        JButton btn_search = new JButton("");   //�ܾ�˻� ��ư
        btn_search.setOpaque(false);
        btn_search.setFont(new Font("����", Font.PLAIN, 19));
        btn_search.setIcon(new ImageIcon("src/image/yellowbtn.png"));
        btn_search.setBounds(164, 181, 96, 32);
        contentPane.add(btn_search);
        
        JButton btn_edit = new JButton("");     //�ܾ� �߰�,���� ��ư
        btn_edit.setIcon(new ImageIcon("src/image/greenbtn.png"));
        btn_edit.setOpaque(false);
        btn_edit.setBounds(272, 183, 100, 32);
        contentPane.add(btn_edit);
        
        JButton btn_bookmark = new JButton(""); //���ã�� ��ư
        btn_bookmark.setIcon(new ImageIcon("src/image/greenbtn.png"));
        btn_bookmark.setOpaque(false);
        btn_bookmark.setBounds(118, 223, 96, 32);
        contentPane.add(btn_bookmark);
        
        JButton btn_voca = new JButton("");     //�ܾ��� ��ư
        btn_voca.setIcon(new ImageIcon("src/image/yellowbtn.png"));
        btn_voca.setOpaque(false);
        btn_voca.setBounds(222, 223, 100, 32);
        contentPane.add(btn_voca);
        
        JButton btn_game = new JButton("");     //�ܾ���� ��ư
        btn_game.setIcon(new ImageIcon("src/image/greenbtn.png"));
        btn_game.setOpaque(false);
        btn_game.setBounds(330, 223, 100, 32);
        contentPane.add(btn_game);
        
        JButton btn_id = new JButton("");
        btn_id.setForeground(new Color(255, 255, 255));   //id�߰��� �� �ִ� ��ư(����� ������)
        btn_id.setIcon(new ImageIcon("src/image/person_icon.png"));
        btn_id.setBounds(474, 25, 33, 32);
        contentPane.add(btn_id);
        
        btn_search.addActionListener(new ActionListener() { //�˻���ư ������ search.java���
            public void actionPerformed(ActionEvent e) {
                search sh=new search();
                sh.setVisible(true);
            }
        });
        btn_edit.addActionListener(new ActionListener() {   //������ư ������ wordedit.java���
            public void actionPerformed(ActionEvent e) {
                wordedit wd=new wordedit();
                wd.setVisible(true);
            }
        });
        btn_bookmark.addActionListener(new ActionListener() { //���ã���ư ������ bookmark.java���
            public void actionPerformed(ActionEvent e) {
                bookmark bm=new bookmark();
                bm.setVisible(true);
            }
        });
        btn_voca.addActionListener(new ActionListener() {   //�ܾ����ư ������ vocabulary.java���
            public void actionPerformed(ActionEvent e) {
                vocabulary voca=new vocabulary();
                voca.setVisible(true);
            }
        });
        btn_game.addActionListener(new ActionListener() {  //�ܾ���ӹ�ư ������ game.java���
            public void actionPerformed(ActionEvent e) {
                game gm=new game();
                gm.setVisible(true);
            }
        });
        btn_id.addActionListener(new ActionListener() {  //����ڹ�ư ������ add_id.java���
            public void actionPerformed(ActionEvent e) {
                add_id id=new add_id();
                id.setVisible(true);
            }
        });
    }
}
