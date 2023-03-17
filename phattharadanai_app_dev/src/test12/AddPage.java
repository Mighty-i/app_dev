package test12;

import java.awt.Dimension;

import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddPage extends JPanel implements ActionListener {
	
	JTextField textId;
	JTextField textName;
	
	public AddPage() {
		
		setBounds(0, 0, 500, 300);
		setPreferredSize(new Dimension(500, 300));
		setLayout(null);
		
		JLabel label = new JLabel("Add Page");
		label.setBounds(10, 10, label.getPreferredSize().width, 
				label.getPreferredSize().height);

		JLabel labelId = new JLabel("ID");
		labelId.setBounds(10, 50, labelId.getPreferredSize().width, 
				labelId.getPreferredSize().height);

		textId = new JTextField(5);
		textId.setBounds(80, 50, textId.getPreferredSize().width, 
				textId.getPreferredSize().height);

		JLabel labelName = new JLabel("Name");
		labelName.setBounds(10, 100, labelName.getPreferredSize().width, 
				labelName.getPreferredSize().height);

		textName = new JTextField(30);
		textName.setBounds(80, 100, textName.getPreferredSize().width, 
				textName.getPreferredSize().height);

		JButton btnName = new JButton(" Add ");
		btnName.setBounds(10, 200, btnName.getPreferredSize().width, 
				btnName.getPreferredSize().height);

		add(label);
		add(labelId);
		add(textId);
		add(labelName);
		add(textName);
		add(btnName);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals(" Add ")) {
			try {
				int id = Integer.parseInt(textId.getText());
				String name = textName.getText();
				Data data = new Data(id, name);
				new DataDAO().addData(data);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		
	}

}
