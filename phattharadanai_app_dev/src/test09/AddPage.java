package test09;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
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

		JLabel labelName = new JLabel("Name");
		labelName.setBounds(10, 100, labelName.getPreferredSize().width, 
				labelName.getPreferredSize().height);

		JTextField textName = new JTextField(30);
		textName.setBounds(80, 100, textName.getPreferredSize().width, 
				textName.getPreferredSize().height);

		JButton btnName = new JButton(" Add ");
		btnName.setBounds(10, 200, btnName.getPreferredSize().width, 
				btnName.getPreferredSize().height);

		add(label);
		add(labelName);
		add(textName);
		add(btnName);
		
	}

}
