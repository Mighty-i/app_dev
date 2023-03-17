package test12;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditPage extends JPanel {
	
	JTextField textId;
	JTextField textName;
	
	public EditPage() {
		
		setBounds(0, 0, 500, 300);
		setPreferredSize(new Dimension(500, 300));
		setLayout(null);
		
		JLabel label = new JLabel("Edit Page");
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

		JButton btnName = new JButton(" Edit ");
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
		if(command.equals(" Edit ")) {
			try {
				int id = Integer.parseInt(textId.getText());
				String name = textName.getText();
				Data data = new Data(id, name);
				new DataDAO().editData(data);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		
	}
}
