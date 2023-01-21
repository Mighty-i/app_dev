package week8_thaicreate_jtable;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyJTableFruit extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				MyJTableFruit frame = new MyJTableFruit();
				frame.setVisible(true);
			}
		});
	}
	public MyJTableFruit() {
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
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("price");
	
		Fruit[] fruit = {
				new Fruit(1, 99 ,"Mango", 20),
				new Fruit(2, 100 ,"Banana", 30)
		};
		// Data Row
		for(int i=0;i < fruit.length; i++)
		{
			model.addRow(new Object[0]);
			model.setValueAt(i+1, i, 0);
			model.setValueAt(fruit[1].no, i, 1);
			model.setValueAt(fruit[2].id, i, 2);
			model.setValueAt(fruit[3].name, i, 3);
			model.setValueAt(fruit[4].price, i, 4);
		
		}
	}
	
}
