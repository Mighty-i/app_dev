package week8_thaicreate_jtable;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTable3 extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JTable3 frame = new JTable3();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JTable3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 242);
		setTitle("ThaiCreate.Com Java GUI Tutorial");
		getContentPane().setLayout(null);
		
		// ScrollPane for Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 41, 494, 90);
		getContentPane().add(scrollPane);
		
		// Table
		JTable table = new JTable();
		scrollPane.setViewportView(table);
				
		// Model for Table
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addColumn("No");
		model.addColumn("CustomerID");
		model.addColumn("Name");
		model.addColumn("Email");
		model.addColumn("CountryCode");
		model.addColumn("Budget");
		model.addColumn("Used");
		
		// Data Row
		for(int i=0;i <= 10; i++)
		{
			model.addRow(new Object[0]);
			model.setValueAt(i+1, i, 0);
			model.setValueAt("Data Col 1", i, 1);
			model.setValueAt("Data Col 2", i, 2);
			model.setValueAt("Data Col 3", i, 3);
			model.setValueAt("Data Col 4", i, 4);
			model.setValueAt("Data Col 5", i, 5);
			model.setValueAt("Data Col 6", i, 6);
		}
		
	}
}