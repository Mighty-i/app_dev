package week8_thaicreate_jtable;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JTable4 extends JFrame {


	/**
	 * Create the frame.
	 */
	public JTable4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 242);
		setTitle("ThaiCreate.Com Java GUI Tutorial");
		getContentPane().setLayout(null);

		// ScrollPane for Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 41, 494, 90);
		getContentPane().add(scrollPane);

		// Table
		final JTable table = new JTable();
		scrollPane.setViewportView(table);

		// Model for Table
		DefaultTableModel model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				case 5:
					return String.class;
				case 6:
					return String.class;
				default:
					return String.class;
				}
			}
		};
		table.setModel(model);

		model.addColumn("Select");
		model.addColumn("CustomerID");
		model.addColumn("Name");
		model.addColumn("Email");
		model.addColumn("CountryCode");
		model.addColumn("Budget");
		model.addColumn("Used");

		// Data Row
		for (int i = 0; i <= 10; i++) {
			model.addRow(new Object[0]);
			model.setValueAt(false, i, 0);
			model.setValueAt("Row"+ (i+1), i, 1);
			model.setValueAt("Data Col 2", i, 2);
			model.setValueAt("Data Col 3", i, 3);
			model.setValueAt("Data Col 4", i, 4);
			model.setValueAt("Data Col 5", i, 5);
			model.setValueAt("Data Col 6", i, 6);
		}

		// Get Row Selected
		JButton btnGetRowSelected = new JButton("Get Row Selected");
		btnGetRowSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < table.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table.getValueAt(i, 0)
							.toString());
					String dataCol1 = table.getValueAt(i, 1).toString();
					if (chked) {
						JOptionPane.showMessageDialog(null, dataCol1);
					}
				}
			}

		});
		btnGetRowSelected.setBounds(224, 149, 131, 23);
		getContentPane().add(btnGetRowSelected);

	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JTable4 frame = new JTable4();
				frame.setVisible(true);
			}
		});
	}

}