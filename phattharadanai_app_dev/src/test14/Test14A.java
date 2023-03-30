package test14;

import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import test12.Data;
import test12.DataDAO;

public class Test14A extends JPanel {
	
	static Random rand1 = new Random(System.currentTimeMillis());
	static Random rand2 = new Random(System.currentTimeMillis());

	public static double genUniformDouble(double upBound, double lowBound, double interval) {
		
		double number = 0.0;
		
		int upBoundInt = 10000*100;
		int lowBoundInt = -10000*100;
		int intervalInt = 1;
		int rangeInt = (upBoundInt - lowBoundInt)/intervalInt + 1;
		int excUpBound = rangeInt;
		System.out.println("upBoundInt:" + upBoundInt + ", lowBoundInt:" + lowBoundInt +
				", intervalInt:" + intervalInt + ", rangeInt:" + rangeInt + 
				", excUpBound:" + excUpBound);
		int orgValue = rand1.nextInt(excUpBound);
		double scaledValue = orgValue * interval;
		double netValue = scaledValue + lowBound;
		System.out.println("orgValue:" + orgValue + ", scaledValue:" + scaledValue + 
				", netValue:" + netValue);
		
		number = netValue;
		return number;
		
	}
	
	public static double genNormalDouble(double upBound, double lowBound, double interval) {
		
		double number = 0.0;
		
		double range = (upBound - lowBound) / interval;
		double fixedRange = 7 - (-7);
		double scaledValue = fixedRange / range;
		System.out.println("range:" + range +", fixedRange:" + fixedRange + ", scaledValue:" + scaledValue);
		double orgValue = rand2.nextGaussian();
		double netValue = (orgValue / scaledValue);
		System.out.println("orgValue:" + orgValue + ", netValue:" + netValue);
		netValue = netValue * interval;
		System.out.println("orgValue:" + orgValue + ", netValue:" + netValue);
		
		number = netValue;
		return number;
		
	}
	
	public Test14A() {
		
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(500, 300));
		
		setPreferredSize(frame.getContentPane().getPreferredSize());
		setBackground(Color.GRAY);
		setOpaque(true);
		
		JLabel label = new JLabel(" Random Data Table");
		setLayout(null);
		label.setBounds(10, 5, label.getPreferredSize().width, label.getPreferredSize().height);
		add(label);
		
		
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBounds(10, 30, 
				450, 
				200);
		add(jScrollPane);
		
		JTable jTable = new JTable();
		jScrollPane.setViewportView(jTable);
		
		DefaultTableModel model = (DefaultTableModel)jTable.getModel();
		model.addColumn("Item");
		model.addColumn("Normal Form");
		model.addColumn("Uniform Form");
		
		double upBound = 10000.00;
		double lowBound = -10000.00;
		System.out.println("main() upBound:" + upBound + ", lowBound:" + lowBound);
		
		int rows = model.getRowCount();
		for(int i=0; i<rows; i++) {
			model.removeRow(0);
		}
		
		int number = 10;
		double[] arrUni = new double[number];
		double[] arrNor = new double[number];
		
		for(int i=0; i<number; i++) {
			Vector<Object> columns = new Vector<Object>();
			
			columns.add(String.valueOf((i+1)));
			
			double netValue = genUniformDouble(upBound, lowBound, 0.01);
			System.out.println("main() genUniformDouble netValue:" + netValue);
			columns.add(String.valueOf(netValue));
			arrUni[i] = netValue;
			
			netValue = genNormalDouble(10000.00, -10000.00, 0.01);
			System.out.println("main() genNormalDouble netValue:" + netValue);
			columns.add(String.valueOf(netValue));
			model.addRow(columns);
			arrNor[i] = netValue;
			
		}


		add(label);
		add(jScrollPane);

		
		
		frame.setContentPane(this);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		double upBound = 10000.00;
		double lowBound = -10000.00;
		System.out.println("main() upBound:" + upBound + ", lowBound:" + lowBound);
		
		double netValue = genUniformDouble(upBound, lowBound, 0.01);
		System.out.println("main() genUniformDouble netValue:" + netValue);
		
		netValue = genNormalDouble(10000.00, -10000.00, 0.01);
		System.out.println("main() genNormalDouble netValue:" + netValue);
		
		new Test14A();
		
		
	}

}
