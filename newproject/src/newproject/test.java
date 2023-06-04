package newproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class test extends JFrame{
	private JPanel northLayout = new JPanel(new FlowLayout());
	private JPanel centerLayout = new JPanel(new FlowLayout());
	private JPanel southLayout = new JPanel(new FlowLayout());
	

	
	private JButton btSearch = new JButton("검색");
	private JButton btFavorite = new JButton("즐겨찾기 추가 / 삭제");
	private JTextField tfSearch = new JTextField(10);
	private String[] choices = {  "전체", "영어" ,"한글"};
	private JComboBox<String> cbLanguage = new JComboBox<>(choices);
	private String[][] data = {
			{"♡", "apple", "사과"},
          	{"♡", "banana", "바나나"},
          	{"♡", "cherry", "체리"} };
	private String[] columnNames = {"♡", "영어 단어", "한글 뜻"};

	private DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false; // 이 메소드는 모든 셀이 수정 불가능하도록 합니다.
	    }
	};
	private JTable wordTable = new JTable(tableModel);
	         
          
   
   
	public test() {
		setTitle("Avocado Favorite");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		wordTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


		btFavorite.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int[] rows = wordTable.getSelectedRows();
		        boolean allEmptyHearts = true;
		        for (int row : rows) {
		            String currentValue = (String) wordTable.getValueAt(row, 0);
		            if (!currentValue.equals("♡")) {
		                allEmptyHearts = false;
		                break;
		            }
		        }
		        for (int row : rows) {
		            wordTable.setValueAt(allEmptyHearts ? "♥" : "♡", row, 0);
		        }
		    }
		});
		
		wordTable.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 2) {
		            int row = wordTable.getSelectedRow();
		            if (row != -1) {
		                String currentValue = (String) wordTable.getValueAt(row, 0);
		                wordTable.setValueAt(currentValue.equals("♡") ? "♥" : "♡", row, 0);
		            }
		        }
		    }
		});
		
		
		
		
		
		
		
      
		wordTable.getColumnModel().getColumn(0).setPreferredWidth(4);
		wordTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		wordTable.getColumnModel().getColumn(2).setPreferredWidth(100);
      
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		wordTable.setDefaultRenderer(Object.class, centerRenderer);
		
		northLayout.add(cbLanguage);
		northLayout.add(tfSearch);
		northLayout.add(btSearch);
		
		JScrollPane scrollPane = new JScrollPane(wordTable);
		scrollPane.setBackground(Color.WHITE); 
		centerLayout.setLayout(new BorderLayout());
		centerLayout.add(scrollPane, BorderLayout.CENTER);
		
		southLayout.add(btFavorite);  
		
		c.setLayout(new BorderLayout());
		c.add(northLayout, BorderLayout.NORTH);
		c.add(centerLayout, BorderLayout.CENTER);
		c.add(southLayout, BorderLayout.SOUTH);
		
		
		

		setSize(250,450);
		setVisible(true);
	}
   
   
	public static void main(String [] args) {
		new test();
	}
}