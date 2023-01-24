package week9window;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewPage extends JPanel{
	
public ViewPage() {
		
		setBackground(Color.YELLOW);
		setBounds(0, 0, 500, 300);
		setLayout(null);
		
		JLabel label = new JLabel("ViewPage");
		label.setBounds(10, 10, label.getPreferredSize().width, label.getPreferredSize().height);
		this.add(label);
	}

}
