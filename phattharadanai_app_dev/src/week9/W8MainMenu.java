package week9;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class W8MainMenu extends JPanel implements ActionListener {
	
	private static final String mainString = "Main Menu";
	private static final String addString = "Add Student";
	private static final String viewString = "View Students";
	private static final String exitString = "Exit";

	private static final int frameWidth = 400;
	private static final int frameHeight = 300;

	W8AddForm addForm;
	W8EditForm editForm;


	public W8MainMenu(JFrame frame) {

		// use super class constructor
		super();

		// create a dialog for adding student
		addForm = new W8AddForm(frame);
		editForm = new W8EditForm(frame);

		// define size of container, i.e. pane
		int panelWidth = 400;
		int panelHeight = 200;
		// use manual layout manager
		setLayout(null);

		// create dialogue label
		JLabel mainLabel = new JLabel("Main Menu");
		// create buttons
		JButton addBtn = new JButton(addString);
		JButton viewBtn = new JButton(viewString);
		JButton exitBtn = new JButton(exitString);

		// add listener to buttons
		addBtn.addActionListener(this);
		viewBtn.addActionListener(this);
		exitBtn.addActionListener(this);

		// add label and buttons to main frame, i.e. GuiStudent
		add(mainLabel);
		add(addBtn);
		add(viewBtn);
		add(exitBtn);

		// set sizes and positions for label and buttons
		Dimension size = mainLabel.getPreferredSize();
		mainLabel.setBounds((panelWidth - size.width) / 2, 20, size.width, size.height);
		size = addBtn.getPreferredSize();
//		addBtn.setBounds((panelWidth - size.width) / 2, 60, size.width, size.height);
		addBtn.setBounds(0, 0, size.width, size.height);
		size = viewBtn.getPreferredSize();
		viewBtn.setBounds((panelWidth - size.width) / 2, 100, size.width, size.height);
		size = exitBtn.getPreferredSize();
		exitBtn.setBounds((panelWidth - size.width) / 2, 140, size.width, size.height);

		// set size for main frame
		this.setPreferredSize(new Dimension(panelWidth, panelHeight));
	}

	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		System.out.println("ActionCommand:" + actionCommand);
		if (actionCommand.equals(addString)) {
			System.out.println("equals " + addString);
			addForm.setVisible(true);
		} else if (actionCommand.equals(viewString)) {
			System.out.println("equals " + viewString);
			editForm.setVisible(true);
			//ReadStudents.viewStudents();
		} else if (actionCommand.equals(exitString)) {
			System.out.println("equals " + exitString);
			System.exit(0);
		}
	}
}
