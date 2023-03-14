package lect15;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddPage extends JPanel {
	
	public AddPage() {
		
		setBounds(0, 0, 500, 300);
		setPreferredSize(new Dimension(500, 300));
		setLayout(null);
		
		JLabel label = new JLabel("Add Page");
		label.setBounds(10, 10, label.getPreferredSize().width, 
				label.getPreferredSize().height);
		add(label);
		
	}

}
