import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class Total extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Total frame = new Total();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Total() {
		int x;
		int add = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(433, 417, -421, -103);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 12, 429, 302);
		contentPane.add(scrollPane);

	      String[][] data =  DB.getTotal();
	      String[] headers = new String[] { "번호","날짜","가격"}; 
	      DefaultTableModel model = new DefaultTableModel(data, headers);
		JTable table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JLabel lb01 = new JLabel("\uCD1D\uB9E4\uCD9C");
		lb01.setBounds(176, 375, 62, 18);
		contentPane.add(lb01);
		
		JLabel totalprice = new JLabel("");
		totalprice.setBackground(Color.WHITE);
		totalprice.setForeground(Color.BLACK);
		totalprice.setBounds(230, 358, 149, 40);
		contentPane.add(totalprice);
	      model.setRowCount(0);
	      for (int i = 0; i < data.length; i++) {
	         model.addRow(data[i]);
	      }
	      ArrayList<String> a = DB.getseat();
	      for (int i = 0; i < a.size(); i++)
	      {
	    	x=Integer.parseInt(a.get(i));
	    	add+=x;
	    	System.out.println(a.get(i));
	      }
	      totalprice.setText(add+"");

	}
}
