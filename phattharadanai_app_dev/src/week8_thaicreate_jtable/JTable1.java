package week8_thaicreate_jtable;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;

public class JTable1 extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JTable1 frame = new JTable1();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JTable1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 218);
		setTitle("ThaiCreate.Com Java GUI Tutorial");
		getContentPane().setLayout(null);

		String data[][] = { { "Row1/1", "Row1/2", "Row1/3", "Row1/4" },
				{ "Row2/1", "Row2/2", "Row2/3", "Row2/4" },
				{ "Row3/1", "Row3/2", "Row3/3", "Row3/4" },
				{ "Row4/1", "Row4/2", "Row4/3", "Row4/4" }, };

		String header[] = { "Column 1", "Column 2", "Column 3", "Column 4" };

		// Table
		JTable table = new JTable(data,header);
		table.setBounds(36, 37, 407, 79);
		getContentPane().add(table);
		
	}
}