package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.CurrentUser;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import DB.*;


public class wordmanager extends JFrame {
	

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JScrollPane scrollPane;
    private JTextField numField;
    private JPanel wordPanel;
    private JPanel panel;
    private HashMap<String, String[]> wordList;
    private static String noteName;
    private String currentWord;
    private NoteFunction nff = new NoteFunction();
    


    
    
    public wordmanager(String noteName) {
        setSize(400,400);
        setVisible(true);
        
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
        
        wordList = nff.wordList(CurrentUser.getInstance().getUserId(),noteName); //
        
        JPanel wordPanel = new JPanel();
        wordPanel.setLayout(new GridLayout(wordList.size(), 1));
        scrollPane.setViewportView(wordPanel);
        
        for (String word : wordList.keySet()) {
            String[] wordData = wordList.get(word);
            String meaning = wordData[0];
            String num = wordData[1];
            JLabel wordLabel = new JLabel(word);
            wordLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    textField.setText(word);
                    textField_1.setText(meaning);
                    numField.setText(num);
                }
            });
            wordPanel.add(wordLabel);
        }
        
        
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
        
        numField = new JTextField();
        
        JButton btn_edit = new JButton("단어 수정");    //단어수정 버튼
        btn_edit.setFont(new Font("HY엽서M", Font.BOLD, 12));
        btn_edit.setBounds(22, 185, 95, 39);
        panel.add(btn_edit);
        btn_edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String word = textField.getText();
                String meaning = textField_1.getText();
                int num = Integer.parseInt(numField.getText());
                nff.noteUpdate("meaning", meaning, num);
                
                // 수정된 단어 목록 가져오기
                wordList = nff.wordList(CurrentUser.getInstance().getUserId(), noteName);
                
                
                wordPanel.removeAll();  // 기존 단어 목록 제거
                
                // 새로운 단어 목록 출력
                for (String currentWord : wordList.keySet()) {
                    String[] wordData = wordList.get(currentWord);
                    String currentMeaning = wordData[0];
                    String currentNum = wordData[1];
                    JLabel wordLabel = new JLabel(currentWord);
                    wordLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            textField.setText(currentWord);
                            textField_1.setText(currentMeaning);
                            numField.setText(currentNum);
                        }
                    });
                    wordPanel.add(wordLabel);
                }
               
                wordPanel.revalidate();
                wordPanel.repaint();
                
                JOptionPane.showMessageDialog(null, "단어가 수정되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        JButton btn_delete = new JButton("단어 삭제");  //단어삭제 버튼
        btn_delete.setFont(new Font("HY엽서M", Font.BOLD, 12));
        btn_delete.setBounds(129, 185, 95, 39);
        panel.add(btn_delete);
        btn_delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String word = textField.getText();
                nff.noteDelete(CurrentUser.getInstance().getUserId(), noteName, word);
                
                // 삭제 후 단어 목록 갱신
                wordPanel.removeAll();  // 기존 단어 목록 제거
                wordList = nff.wordList(CurrentUser.getInstance().getUserId(), noteName);  // 새로운 단어 목록 가져오기
                
                // 새로운 단어 목록을 출력
                for (String currentWord : wordList.keySet()) {
                    String[] wordData = wordList.get(currentWord);
                    String meaning = wordData[0];
                    String num = wordData[1];
                    JLabel wordLabel = new JLabel(currentWord);
                    wordLabel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            textField.setText(currentWord);
                            textField_1.setText(meaning);
                            numField.setText(num);
                        }
                    });
                    wordPanel.add(wordLabel);
                }
                
                wordPanel.revalidate();  // 단어 목록 다시 그리기
                wordPanel.repaint();
                
                // 텍스트 필드 지우기
                textField.setText("");
                textField_1.setText("");
                JOptionPane.showMessageDialog(null, "단어가 삭제되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
            }
            
        });
        

    }

    

}
