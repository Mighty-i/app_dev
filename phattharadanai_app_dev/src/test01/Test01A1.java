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
		label.setBounds(10, 10,label.getPreferredSize().width, label.getPreferredSize().height);
		JLabel labelname = new JLabel ("name");
		labelname.setBounds(10, 100,labelname.getPreferredSize().width, labelname.getPreferredSize().height);
		JTextField nameTxt = new JTextField(30);
		nameTxt.setBounds(80, 100,nameTxt.getPreferredSize().width, nameTxt.getPreferredSize().height);
		JButton btnname = new JButton ("A Simple Form");
		btnname.setBounds(10, 200,btnname.getPreferredSize().width, btnname.getPreferredSize().height);
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
