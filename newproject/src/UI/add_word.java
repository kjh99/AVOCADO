package UI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DB.*;


public class add_word extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    
    public static void main(String[] args) {
       getConnection();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                    add_word frame = new add_word();
                    frame.setVisible(true);
            }
        });
    }
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
   private static final String DB_URL = "jdbc:mysql://new-db.crnbwzhpnodx.ap-northeast-2.rds.amazonaws.com/newdb";
   private static final String DB_USERNAME = "admin";
   private static final String DB_PASSWORD = "OOPproject_10";

   
   
   
    public add_word() {
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(215, 236, 213));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lb_e = new JLabel("    영어");
        lb_e.setFont(new Font("HY엽서M", Font.BOLD, 12));
        lb_e.setForeground(new Color(0, 0, 0));
        lb_e.setBounds(30, 75, 57, 21);
        contentPane.add(lb_e);
        
        JLabel lb_k = new JLabel("    한글");
        lb_k.setForeground(new Color(0, 0, 0));
        lb_k.setFont(new Font("HY엽서M", Font.BOLD, 12));
        lb_k.setBounds(30, 116, 57, 21);
        contentPane.add(lb_k);
        
        textField = new JTextField();          //영어 입력받을 textfield
        textField.setBounds(89, 72, 150, 27);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();        //한글 입력받을 textfield
        textField_1.setBounds(89, 113, 150, 27);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JButton btn_add = new JButton("단어 추가");   //단어 추가 버튼
        btn_add.setBackground(new Color(245, 249, 208));
        btn_add.setFont(new Font("HY엽서M", Font.BOLD, 15));
        btn_add.setBounds(44, 166, 206, 48);
        contentPane.add(btn_add);
        
        
        btn_add.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
              String word = textField.getText();
              String meaning = textField_1.getText();
                // 여기에 사용자 아이디와 노트 이름을 설정
              String user_id = "oop1";
              String note_name = "examplenote";
              noteInsert(user_id, note_name, word, meaning);
            }
        });
    }
    public static Connection getConnection(){
      Connection conn = null;
      try{
         //Register the JDBC driver
         Class.forName(DB_DRIVER);

         //Open the connection
         conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

         if(conn != null){
            System.out.println("Successfully connected.");
         }else{
            System.out.println("Failed to connect.");
         }
      }catch(Exception e){
         e.printStackTrace();
      }
      return conn;
   }
    
    public void noteInsert(String user_id, String note_name, String word, String meaning) {
      PreparedStatement preparedStatement = null;

      String sql = "SELECT MAX(num) FROM mynote;";
      try {


         Connection conn = MysqlConnection.getConnection();

         preparedStatement = conn.prepareStatement(sql);
         ResultSet rs = preparedStatement.executeQuery();
         rs.next();
         int num = rs.getInt("MAX(num)")+1;

         sql = "INSERT INTO mynote VALUES("+ "\'"+ num +"\'" +","+ "\'" + user_id +"\'"+","+"\'"+ note_name+"\'" +","+"\'"+ word +"\'" +","+"\'"+ meaning +"\'"+");";
         System.out.println(sql);
         preparedStatement = conn.prepareStatement(sql);
         preparedStatement.execute();
         preparedStatement.close();
         conn.close();
      }catch(Exception e){
         e.printStackTrace();
      }

    }
    
}