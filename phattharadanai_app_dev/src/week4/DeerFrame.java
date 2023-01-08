package week4;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class DeerFrame extends JFrame implements ActionListener {

	static int frameWidth = 1200;
	static int frameHeight = 700;

	static String truckStr = "Number of Trucks";
	static String customerStr = "Number of Customers";
	static String computeStr = "Compute";
	static String exitStr = "Exit";

	static JTextField numbCustText;
	static JTextField numbTruckText;
	static JLabel truckLabel;
	static JLabel customerLabel;
	static JButton computeBtn;
	static JButton exitBtn;

	DeerPanel deerPanel;

	public DeerFrame() {
		super();

		// manual layout
		setLayout(null);
		// specify frame size
		getContentPane().setPreferredSize(new Dimension(frameWidth, frameHeight));

		// ImagePanel panel = new ImagePanel("images/aero1.jpg");
		deerPanel = new DeerPanel(this);
		deerPanel.setPreferredSize(new Dimension(960, 650));

		// create exitBtn
		truckLabel = new JLabel(truckStr);
		customerLabel = new JLabel(customerStr);
		computeBtn = new JButton(computeStr);
		exitBtn = new JButton(exitStr);
		numbTruckText = new JTextField(3);
		numbCustText = new JTextField(3);

		// add ActionListener
		computeBtn.addActionListener(this);
		exitBtn.addActionListener(this);

		add(truckLabel);
		add(customerLabel);
		add(computeBtn);
		add(exitBtn);
		add(numbTruckText);
		add(numbCustText);
		add(deerPanel);

		// specify position and size of exitBtn
		Dimension size = truckLabel.getPreferredSize();
		truckLabel.setBounds(1000, 50, size.width, size.height);
		size = customerLabel.getPreferredSize();
		customerLabel.setBounds(1000, 100, 160, size.height);
		size = computeBtn.getPreferredSize();
		computeBtn.setBounds(1000, 160, 100, size.height);
		size = exitBtn.getPreferredSize();
		exitBtn.setBounds(1000, 200, 70, size.height);
		size = numbTruckText.getPreferredSize();
		numbTruckText.setBounds(1000, 70, size.width, size.height);
		size = numbCustText.getPreferredSize();
		numbCustText.setBounds(1000, 120, size.width, size.height);
		size = deerPanel.getPreferredSize();
		deerPanel.setBounds(20, 20, size.width, size.height);

		// pack and show
		pack();
		setVisible(true);
	}

	// called when buttons are pressed
	public void actionPerformed(ActionEvent evt) {
		// which button is pressed
		String actionCommand = evt.getActionCommand();
		System.out.println("actionCommand:" + actionCommand);

		// specify what to do
		if (actionCommand.equals(exitStr)) {
			System.exit(0);

		} else if (actionCommand.equalsIgnoreCase(computeStr)) {
			deerPanel.generatePos();
			deerPanel.computeTruck();
			deerPanel.repaint();
			deerPanel.compute();
		}
	}
	
	public static void main(String[] args) {
		DeerFrame deerFrame = new DeerFrame();
	}

}
