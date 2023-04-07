package test02;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test2A extends JPanel implements ActionListener{

	static JFrame frame;
	JLabel result;
	String cur;
	
	public test2A() {
		setLayout(null);
		setPreferredSize(new Dimension(500, 300));
		String[] pat= {"dd.MM.yy"};
		cur = pat[0];
		
		JLabel patt = new JLabel("enter a pattern");
		patt.setBounds(10, 10, 100, 110);
		
		JComboBox pattList = new JComboBox(pat);
		pattList.setEditable(true);
		pattList.addActionListener(this);
		pattList.setBounds(10, 40, 50, 30);
		
		result = new JLabel("current date/time");
		result.setBounds(10, 70, 400, 200);
		
		add(patt);
		add(pattList);
		add(result);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox cb = (JComboBox)e.getSource();
		String newSelection = (String)cb.getSelectedItem();
		cur = newSelection;
		reformat();
	}
	public void reformat() {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(cur);
		try{
			String dateString = formatter.format(today);
			result.setForeground(Color.BLACK);
			result.setText("Current Date/Time:" + dateString);
		}catch(IllegalArgumentException iae) {
			result.setForeground(Color.red);
			result.setText("Error: " + iae.getMessage());
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("test2a");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test2A panel = new test2A();
		panel.setOpaque(true);
		frame.setContentPane(panel);
		
		frame.pack();
		frame.setVisible(true);
	}

}
