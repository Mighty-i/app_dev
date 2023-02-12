package exercise3swingforms;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class JTableForm extends JPanel {
	
	int frameWidth = 500;
	int frameHeight = 105;

	int width = 500;
	int height = 150;
	
	public JTableForm() {
		super(new GridLayout(1, 0));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(width, height);
		
		//RequeDate
		JTextField requesdateField = new JTextField();
		requesdateField.setBounds(60, 30, 100, 20);
		panel.add(requesdateField);
		JLabel requestDateLabel = new JLabel("Request Date");
		requestDateLabel.setBounds(60, 10, requestDateLabel.getPreferredSize().width,
				requestDateLabel.getPreferredSize().height);
		panel.add(requestDateLabel);

		//DueDate
		JTextField duedateField = new JTextField();
		duedateField.setBounds(240, 30, 100, 20);
		panel.add(duedateField);
		JLabel dueDateLabel = new JLabel("Request Date");
		dueDateLabel.setBounds(240, 10, dueDateLabel.getPreferredSize().width,
				dueDateLabel.getPreferredSize().height);
		panel.add(dueDateLabel);
		
		//Requester
		JTextField requesterField = new JTextField();
		requesterField.setBounds(420, 30, 100, 20);
		panel.add(requesterField);
		JLabel requesterLabel = new JLabel("Requester");
		requesterLabel.setBounds(420, 10, requesterLabel.getPreferredSize().width,
				requesterLabel.getPreferredSize().height);
		panel.add(requesterLabel);

		
		String[] columnNames = { "Goods Group", "Goods", "Unit", "Price", "Quantity", "Amount" };

		Object[][] data = { { "Beverage", "SINGHA", "Can", new Integer(15), new Integer(0), new Integer(0) },
				{ "Detergent", "Pao", "Sack", new Integer(25), new Integer(0), new Integer(0) },
				{ "Softener", "Downy", "Sack", new Integer(20), new Integer(0), new Integer(0) },
				{ "Juice", "Coconut", "Glass", new Integer(45), new Integer(0), new Integer(0) } };
		
		TableModel model = new TableModel(data, columnNames);
		final JTable table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(45, 60, frameWidth, frameHeight);
		panel.add(scrollPane);
		add(panel);
		
		//Print
		JButton printButton = new JButton("Print");
		printButton.setBounds(100, 200, 80, 30);
		panel.add(printButton);
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Page {0,number,integer}");
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, header, null);
				} catch (java.awt.print.PrinterException ex) {
					System.err.format("Cannot print %s%n", ex.getMessage());
				}
			}
		});
		
		//ReadFile
		JButton readfileButton = new JButton("ReadFile");
		readfileButton.setBounds(220, 200, 100, 30);
		panel.add(readfileButton);
		
		//WriteFile
		JButton writefileButton = new JButton("WriteFile");
		writefileButton.setBounds(360, 200, 100, 30);
		panel.add(writefileButton);
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	
	
	private static void createAndShowGUI() {

		JFrame frame = new JFrame("JTableAmount");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);

		JTableForm newContentPane = new JTableForm();
		newContentPane.setOpaque(true);
		frame.add(newContentPane);

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
