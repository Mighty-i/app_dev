package test12;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MainPage extends JPanel {
	
	public MainPage() {
		
		setLayout(null);
		setBounds(0, 0, 500, 300);
		setPreferredSize(new Dimension(500, 400));
		
		JLabel label = new JLabel("Main Page");
		label.setBounds(10, 10, label.getPreferredSize().width, 
				label.getPreferredSize().height);
		add(label);
		
	}

}
