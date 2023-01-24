package week9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class W8AddForm extends JDialog implements ActionListener {

	private static final int width = 400;
	private static final int height = 200;

	JTextField idTxt;
	JTextField nameTxt;
	JTextField surnameTxt;
	JTextField markTxt;

	private static final String addString = "Add";
	private static final String cancelString = "Cancel";

	public W8AddForm(JFrame frame) {
		super(frame, true);

		// Create pane as container
		Container pane = getContentPane();
		// set layout manager to manual
		pane.setLayout(null);

		// create labels
		JLabel addStudentLabel = new JLabel("Add Student");
		JLabel idLabel = new JLabel("ID:");
		JLabel nameLabel = new JLabel("Name:");
		JLabel surnameLabel = new JLabel("Surname:");
		JLabel markLabel = new JLabel("Mark:");

		// create buttons
		JButton addBtn = new JButton(addString);
		JButton cancelBtn = new JButton(cancelString);

		// create texts
		idTxt = new JTextField(10);
		nameTxt = new JTextField(20);
		surnameTxt = new JTextField(20);
		markTxt = new JTextField(5);

		// create control buttons.
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		// add labels
		pane.add(addStudentLabel);
		pane.add(idLabel);
		pane.add(nameLabel);
		pane.add(surnameLabel);
		pane.add(markLabel);

		// add text fields
		pane.add(idTxt);
		pane.add(nameTxt);
		pane.add(surnameTxt);
		pane.add(markTxt);

		// add control buttons
		pane.add(addBtn);
		pane.add(cancelBtn);

		// set sizes and positions for labels
		Dimension size = addStudentLabel.getPreferredSize();
		addStudentLabel.setBounds((width - size.width) / 2, 5, size.width, size.height);
		size = idLabel.getPreferredSize();
		idLabel.setBounds(10, 20, size.width, size.height);
		size = nameLabel.getPreferredSize();
		nameLabel.setBounds(10, 50, size.width, size.height);
		size = surnameLabel.getPreferredSize();
		surnameLabel.setBounds(10, 80, size.width, size.height);
		size = markLabel.getPreferredSize();
		markLabel.setBounds(10, 110, size.width, size.height);

		// set sizes and positions for labels
		size = idTxt.getPreferredSize();
		idTxt.setBounds(70, 20, size.width, size.height);
		size = nameTxt.getPreferredSize();
		nameTxt.setBounds(70, 50, size.width, size.height);
		size = surnameTxt.getPreferredSize();
		surnameTxt.setBounds(70, 80, size.width, size.height);
		size = markTxt.getPreferredSize();
		markTxt.setBounds(70, 110, size.width, size.height);
		
		// set sizes and positions for controls buttons
		size = addBtn.getPreferredSize();
		addBtn.setBounds(width / 2 - size.width - 10, 140, size.width, size.height);
		size = cancelBtn.getPreferredSize();
		cancelBtn.setBounds(width / 2 + 10, 140, size.width, size.height);

		// set size and position for container
		pane.setPreferredSize(new Dimension(width, height));

		pack();
		setVisible(false);

		System.out.println("AddStudentDialog() done!");

	}

	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		// user presses "Add"
		if (actionCommand.equals(addString)) {
			System.out.println("actionCommand:" + addString);
			try {
				// retrieve values from text fields.
				int id = Integer.parseInt(idTxt.getText());
				String name = nameTxt.getText();
				String surname = surnameTxt.getText();
				int mark = Integer.parseInt(markTxt.getText());
				W8StudentMark student = new W8StudentMark(id, name, surname, mark);
				// retrieve grade
				String grade = W8Grader.decideGrade(mark);
				System.out.println("id:" + id);
				System.out.println("name:" + name);
				System.out.println("surname:" + surname);
				System.out.println("mark:" + mark);
				System.out.println("grade:" + grade);
				// reset text fields
				idTxt.setText(null);
				nameTxt.setText(null);
				surnameTxt.setText(null);
				markTxt.setText(null);
			} catch (Exception ex) {
				System.err.println("Error! Invalid data.");
			}
		// user presses "Cancel"
		} else if (actionCommand.equals(cancelString)) {
			System.out.println("actionCommand:" + cancelString);
			setVisible(false);
		}
	}
}	
