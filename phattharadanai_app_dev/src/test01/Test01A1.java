package test01;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test01A1 extends JPanel{
	public Test01A1() {
		setBounds(0,0,500,300);
		setPreferredSize(new Dimension(500,300));
		setLayout(null);
		
		JLabel label = new JLabel ("A Simple Form");
		label.setBounds(10, 10,100, 100);
		JLabel labelname = new JLabel ("name");
		labelname.setBounds(10, 100,100,100);
		JTextField nameTxt = new JTextField(30);
		nameTxt.setBounds(50, 140,100, 20);
		JButton btnname = new JButton ("A Simple Form");
		btnname.setBounds(50, 190,100, 30);
		add(label);
		add(labelname);
		add(nameTxt);
		add(btnname);
	}
	public static void main(String[] args) {
		
		Test01A1 panel = new Test01A1();
		panel.setBackground(Color.GRAY);
		panel.setOpaque(true);
		
		JFrame frame = new JFrame();
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.pack();
	}

}
