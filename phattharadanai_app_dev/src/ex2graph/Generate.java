package ex2graph;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Generate extends JPanel implements ActionListener {

	LineGraph lineGraph;
	BarGraph baeGraph;

	private static final String mainString = "Main";
	private static final String generate = "Generate";

	JTextField boundTxt;
	JTextField numberTxt;
	private JTextField textField;
	private JTextField textField_1;

	public Generate(JFrame frame) {
		// TODO Auto-generated constructor stub
		super();
		
		
		setLayout(null);
		
		
		final int Height = 700;
		final int Width = 500;

		JLabel mainLabel = new JLabel(mainString);
//		JLabel boundLabel = new JLabel(Bound);
//		JLabel numberLabel = new JLabel(Number);
		
		JButton generateBtn = new JButton(generate);
		
		boundTxt = new JTextField(10);
		numberTxt = new JTextField(100);
		
		generateBtn.addActionListener(this);
		
		add(generateBtn);
		
		Dimension size = mainLabel.getPreferredSize();
		mainLabel.setBounds((getWidth() - size.width) / 2, 20, size.width, size.height);
		size = generateBtn.getPreferredSize();
		generateBtn.setBounds(336, 121, 104, 52);
		
		textField = new JTextField();
		textField.setBounds(102, 69, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 119, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		
		
		frame.setPreferredSize(new Dimension(Height, Width));

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
