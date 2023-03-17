package test10;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewListPage extends JPanel {
	
	JTable jTable;
	DefaultTableModel model;

	
	public ViewListPage() {
		
		setBounds(0, 0, 500, 300);
		setPreferredSize(new Dimension(500, 300));
		setLayout(null);
		
		JLabel label = new JLabel("View List Page");
		label.setBounds(10, 10, label.getPreferredSize().width, 
				label.getPreferredSize().height);

		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBounds(10, 30, 
				450, 
				200);
		add(jScrollPane);
		
		jTable = new JTable();
		jScrollPane.setViewportView(jTable);
		
		model = (DefaultTableModel)jTable.getModel();
		model.addColumn("Plate");
		model.addColumn("Model");
		model.addColumn("Make");
		
		JButton btnName = new JButton(" View List ");
		btnName.setBounds(10, 200, btnName.getPreferredSize().width, 
				btnName.getPreferredSize().height);

		add(label);
		add(jScrollPane);
		add(btnName);
	}

}
