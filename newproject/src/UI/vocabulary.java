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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                    vocabulary frame = new vocabulary();
                    frame.setVisible(true);
            }
        });
    }
    public vocabulary() {
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(64, 128, 128));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(new Color(215, 236, 213));
        tabbedPane.setBounds(22, 29, 337, 310);
        
        JPanel panel1=new JPanel();                        //�� �ܾ��� ��
        panel1.setBackground(new Color(215, 236, 213));
        tabbedPane.add("�� �ܾ���",panel1);
        panel1.setLayout(null);
        
        List list = new List();            //�� �ܾ��� ��ϵ��� ��� list
        list.setBounds(10, 10, 312, 221);
        panel1.add(list);
        
        JButton btn_create = new JButton("�ܾ��� ����");   //�ܾ��� ���� ��ư
        btn_create.setFont(new Font("HY����M", Font.BOLD, 12));
        btn_create.setBackground(new Color(245, 249, 208));
        btn_create.setBounds(216, 237, 106, 34);
        panel1.add(btn_create);
        
        textField = new JTextField();     //���ο� �ܾ��� �߰��Ҷ� �ܾ��� �̸� �Է¹��� textfield
        textField.setBounds(12, 237, 200, 34);
        panel1.add(textField);
        textField.setColumns(10);
        
        JPanel panel2=new JPanel();     //ģ�� �ܾ��� ��
        panel2.setBackground(new Color(215, 236, 213));
        tabbedPane.add("ģ�� �ܾ���",panel2);
        panel2.setLayout(null);
        
        List list_ = new List();        //ģ����� ��� list
        list_.setBounds(10, 10, 312, 261);
        panel2.add(list_);
        contentPane.add(tabbedPane);  
        /*ģ�� ��� �������� �� list���� Ư�� ģ�� �����ϰ�
        �������� �� �� ģ���� �ܾ��� ��� ����ϴ� â ������ؿ�..!
        �״����� �� �ܾ����� �߿��� Ư�� �ܾ��� �����ϸ� �ش��ϴ� �ܾ��ϵ��� ��µǴ� â ���� �ſ�!
        (����Ʈ���� ���õ��� �� ���ο� â�� ����� �ؼ� �̸� �� ���������Ф�)*/ 
    }
}
