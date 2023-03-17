package test12;

import java.awt.Dimension;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import lect15.SupplyChainSim;
import lect15.Transaction;
import lect15.ViewPage;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewListPage extends JPanel implements ActionListener {
	
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
		model.addColumn("Id");
		model.addColumn("Name");
		
		JButton btnName = new JButton(" View List ");
		btnName.setBounds(10, 200, btnName.getPreferredSize().width, 
				btnName.getPreferredSize().height);

		add(label);
		add(jScrollPane);
		add(btnName);
	}
	
	public void actionPerformed(ActionEvent ev) {
		
		String command = ev.getActionCommand();
		if(command.equals(" View List ")) {
			
			ArrayList<Data> datas = new DataDAO().viewDataList();
			int rows = model.getRowCount();
			for(int i=0; i<rows; i++) {
				model.removeRow(0);
			}
			
			for(Iterator<Data> it=datas.iterator(); it.hasNext();) {
				Data data = it.next();
				Vector<Object> columns = new Vector<Object>();
				columns.add(String.valueOf(data.id));
				columns.add(data.name);
				model.addRow(columns);
				
			}
				
		}

		
	}

}
