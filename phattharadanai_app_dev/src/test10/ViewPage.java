package test10;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewPage extends JPanel {
	
	public ViewPage() {
		
		setBounds(0, 0, 500, 300);
		setPreferredSize(new Dimension(500, 300));
		setLayout(null);
		
		JLabel label = new JLabel("View Page");
		label.setBounds(10, 10, label.getPreferredSize().width, 
				label.getPreferredSize().height);

		JLabel labelName = new JLabel("Name");
		labelName.setBounds(10, 100, labelName.getPreferredSize().width, 
				labelName.getPreferredSize().height);

		JTextField textName = new JTextField(30);
		textName.setBounds(80, 100, textName.getPreferredSize().width, 
				textName.getPreferredSize().height);

		JButton btnName = new JButton(" View ");
		btnName.setBounds(10, 200, btnName.getPreferredSize().width, 
				btnName.getPreferredSize().height);

		add(label);
		add(labelName);
		add(textName);
		add(btnName);
		
	}

}
