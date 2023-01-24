package week9window;

import java.awt.*;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class MainPage extends JPanel {
	
	public MainPage() {
		
		this.setLayout(null);
		this.setBounds(0,0,300,500);
		this.setBackground(Color.BLUE);
		
		JLabel label = new JLabel("MainPage");
		label.setBounds(10, 10, label.getPreferredSize().width, label.getPreferredSize().height);
		this.add(label);
		
		
		
	}

}
