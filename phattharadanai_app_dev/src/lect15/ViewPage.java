package lect15;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.Iterator;

public class ViewPage extends JPanel implements ActionListener {
	
	public static String STR_VIEW = " View "; 
	JTable jTable;
	DefaultTableModel model;
	
	WindowMain windowMain;


	public ViewPage() {
				
		setPreferredSize(new Dimension( MainPage.FRAME_WIDTH, MainPage.FRAME_HEIGHT));
		setLayout(null);
		JLabel lbHeader = new JLabel("Lect15 Form View");
		lbHeader.setBounds((MainPage.FRAME_WIDTH-lbHeader.getPreferredSize().width)/2, 10, 
				lbHeader.getPreferredSize().width, lbHeader.getPreferredSize().height);
		add(lbHeader);
		
		int width;
		int height;
		int xl = 10;
		int yl = 30;
		
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBounds(xl, yl, 
				MainPage.FRAME_WIDTH - xl*2, 
				MainPage.FRAME_HEIGHT - yl*4);
		add(jScrollPane);
		
		jTable = new JTable();
		jScrollPane.setViewportView(jTable);
		
		model = (DefaultTableModel)jTable.getModel();
		model.addColumn("Customer ID");
		model.addColumn("Branch ID");
		model.addColumn("Date");
		model.addColumn("Good ID");
		model.addColumn("Price");
		model.addColumn("Quantity");
		model.addColumn("Amount");
		model.addColumn("Taxinvoice");
		
		JButton btView = new JButton(STR_VIEW);
		width = btView.getPreferredSize().width;
		height = btView.getPreferredSize().height;
		btView.setBounds(MainPage.FRAME_WIDTH/2-width-10, 
				MainPage.FRAME_HEIGHT - yl*3, width, height);
		add(btView);
		btView.addActionListener(this);
		
		JButton btCancel = new JButton("Cancel");
		width = btCancel.getPreferredSize().width;
		height = btCancel.getPreferredSize().height;
		btCancel.setBounds(MainPage.FRAME_WIDTH/2+10, 
				MainPage.FRAME_HEIGHT - yl*3, width, height);
		add(btCancel);
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		
		String command = evt.getActionCommand();
		if(command.equals(ViewPage.STR_VIEW)) {
			ArrayList<Transaction> transactions = new ArrayList<Transaction>(Arrays.asList(new SupplyChainSim(10).transactions));
			setForm(transactions);
				
		}
		
	}
	
	public void setForm(ArrayList<Transaction> transactions) {
		
		int rows = model.getRowCount();
		for(int i=0; i<rows; i++) {
			model.removeRow(0);
		}
		
		for(Iterator<Transaction> it=transactions.iterator(); it.hasNext();) {
			Transaction transaction = it.next();
			Vector<Object> data = new Vector<Object>();
			data.add(String.valueOf(transaction.customerId));
			data.add(transaction.branchId);
			data.add(transaction.date);
			data.add(transaction.goodId);
			data.add(transaction.price);
			data.add(transaction.quantity);
			data.add(transaction.amount);
			data.add(transaction.taxinvoice);
			model.addRow(data);
			
		}
	}
}