package Ex2;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Generator extends JPanel implements ActionListener {

	static final String BOUND_STR = "bound";
	static final String NUMBER_STR = "number";
	static final String BARWIDTH_STR = "bar width";
	static final String GRAPHWIDTH_STR = "graph width";
	static final String GENERATE_STR = "Generate";

	Random random;
	BarGraph barGraph;
	LineGraph lineGraph;

	JTextField boundTextField;
	JTextField numberTextField;
	JTextField barWidthTextField;
	JTextField graphWidthTextField;

	JButton genButton;

	static int intRadioRow = 10;
	static int doubleRadioRow = 50;

	JTabbedPane tabbedPane;

	static int boundTextCol = 120;
	static int boundLabelCol = 220;
	static int barWidthTextCol = 350;
	static int barWidthLabelCol = 450;
	static int genButtonCol = 600;

	int number = 0;
	int bound = 0;
	int bw = 0;
	int gw = 0;

	static int width = 1200;
	static int height = 900;

	BarGraph myBG;
	LineGraph myLG;

	public Generator() {

		setLayout(null);
		setPreferredSize(new Dimension(width, height));
		setLayout(null);

		boundTextField = new JTextField(7);
		boundTextField.setBounds(107, 74, 62,
				20);
		add(boundTextField);
		JLabel boundLabel = new JLabel("Bound");
		boundLabel.setBounds(120, 61, 49,
				14);
		add(boundLabel);

		numberTextField = new JTextField(7);
		numberTextField.setBounds(205, 75, 62,
				20);
		add(numberTextField);
		JLabel numberLabel = new JLabel("Number");
		numberLabel.setBounds(218, 61, 55,
				14);
		add(numberLabel);

		barWidthTextField = new JTextField(7);
		barWidthTextField.setBounds(307, 74, 62,
				20);
		add(barWidthTextField);
		JLabel barWidthLabel = new JLabel("Bar width");
		barWidthLabel.setBounds(313, 61, 62,
				14);
		add(barWidthLabel);

		graphWidthTextField = new JTextField(7);
		graphWidthTextField.setBounds(410, 74, 62,
				20);
		add(graphWidthTextField);

		JLabel graphWidthLabel = new JLabel("Graph width");
		graphWidthLabel.setBounds(410, 61, 77,
				14);
		add(graphWidthLabel);

		random = new Random(System.currentTimeMillis());

		genButton = new JButton(GENERATE_STR);
		genButton.setBounds(522, 73, 127,
				23);
		add(genButton);
		genButton.addActionListener(this);

		tabbedPane = new JTabbedPane();
		tabbedPane.setSize(1180, 762);
		tabbedPane.setLocation(10, 127);
		add(tabbedPane);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		System.out.println("command:" + command);
		if (command.equals(GENERATE_STR)) {
			String strBound = boundTextField.getText();
			String strNumber = numberTextField.getText();

			String strBW = barWidthTextField.getText();
			String strGW = graphWidthTextField.getText();
			try {
				bound = Integer.parseInt(strBound);
			} catch (NumberFormatException ex) {
				bound = 0;
			}
			try {
				number = Integer.parseInt(strNumber);
			} catch (NumberFormatException ex) {
				number = 0;
			}
			System.out.println("bound: " + bound + ", number: " + number);
			if (number == 0) {
				return;
			} else if (bound == 0) {
				return;
			}

			System.out.println("....Generating....");
			int[] array;

			array = genInt(number, bound);

			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + ",");
			}

			System.out.println();

			tabbedPane.removeAll();

			myLG = new LineGraph(bound, array);
			tabbedPane.addTab("Line Graph", myLG);

			bw = 40;
			gw = 600;
			if (strBW.isEmpty() == false) {
				bw = Integer.parseInt(strBW);
			}
			if (strGW.isEmpty() == false) {
				gw = Integer.parseInt(strGW);
			}
			myBG = new BarGraph(bound, array, bw, gw);
			tabbedPane.addTab("Bar Graph", myBG);

		}

	}

	int[] genInt(int number, int bound) {

		int[] figures = new int[number];
		for (int i = 0; i < number; i++) {
			int figure = random.nextInt(bound);
			figures[i] = figure;
		}

		return figures;

	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Ex2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent newContentPane = new Generator();
		newContentPane.setOpaque(true); // <-- content panes must be opaque
		frame.setContentPane(newContentPane);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
