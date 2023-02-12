package ex3;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.tools.JavaCompiler;
import javax.swing.event.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.MessageFormat;
import java.util.ArrayList;

public class JTableAmountModel2 extends JPanel {

	int frameWidth = 500;
	int frameHeight = 100;

	int width = 500;
	int height = 450;

	JTextField requesdateField;
	JTextField duedateField;
	JTextField requesterField;

	private static final String readfile = "readfile";
	private static final String writefile = "writefile";

	public JTableAmountModel2() {
		super(new GridLayout(1, 0));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(width, height);

		JLabel requestDateLabel = new JLabel("Request Date");
		JLabel dueDateLabel = new JLabel("Request Date");
		JLabel requesterLabel = new JLabel("Requester");

		

		requesdateField = new JTextField(20);
		duedateField = new JTextField(20);
		requesterField = new JTextField(20);

		panel.add(requestDateLabel);
		panel.add(dueDateLabel);
		panel.add(requesterLabel);

		

		panel.add(requesdateField);
		panel.add(duedateField);
		panel.add(requesterField);

		

		requesdateField.setBounds(60, 30, 100, 20);
		duedateField.setBounds(240, 30, 100, 20);
		requesterField.setBounds(420, 30, 100, 20);

		

		requestDateLabel.setBounds(60, 10, requestDateLabel.getPreferredSize().width,
				requestDateLabel.getPreferredSize().height);
		dueDateLabel.setBounds(240, 10, dueDateLabel.getPreferredSize().width, dueDateLabel.getPreferredSize().height);
		requesterLabel.setBounds(420, 10, requesterLabel.getPreferredSize().width,
				requesterLabel.getPreferredSize().height);

		String[] columnNames = { "Good", "Unit Name", "Price", "Quantity", "Amount" };

		Object[][] data = { { "Coke can", "Can", new Integer(15), new Integer(0), new Integer(0) },
				{ "Fanta 1.5 Litre", "Bottle", new Integer(25), new Integer(0), new Integer(0) },
				{ "Soap Parrot", "Bar", new Integer(20), new Integer(0), new Integer(0) },
				{ "Orange Jam", "Can", new Integer(35), new Integer(0), new Integer(0) }, };

		MyTableModel model = new MyTableModel(data, columnNames);
		final JTable table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(45, 60, frameWidth, frameHeight);
		panel.add(scrollPane);
		add(panel);

		// Add a print button.
		JButton printButton = new JButton("Print");
		printButton.setBounds(55, 186, 80, 30);
		panel.add(printButton);
		printButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MessageFormat header = new MessageFormat("Page {0,number,integer}");
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, header, null);
				} catch (java.awt.print.PrinterException ex) {
					System.err.format("Cannot print %s%n", ex.getMessage());
				}
			}
		});

		JButton readfileButton1 = new JButton("ReadFile");
		readfileButton1.setBounds(186, 186, 100, 30);
		panel.add(readfileButton1);

		JButton writefileButton = new JButton("WriteFile");
		writefileButton.setBounds(326, 186, 100, 30);
		panel.add(writefileButton);
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

	}

	private static void createAndShowGUI() {

		JFrame frame = new JFrame("JTableAmount");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);

		JTableAmountModel2 newContentPane = new JTableAmountModel2();
		newContentPane.setOpaque(true);
		frame.getContentPane().add(newContentPane);

		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
