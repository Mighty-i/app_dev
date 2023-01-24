package week9window;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AddPage extends JPanel {
	
	public AddPage() {
		
		setBackground(Color.GRAY);
		setBounds(0, 0, 500, 300);
		setLayout(null);
		
		JLabel label = new JLabel("AddPage");
		label.setBounds(10, 10, label.getPreferredSize().width, label.getPreferredSize().height);
		this.add(label);
	}

}
