package week9;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;

public class PanelTest {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Panel Test");
		frame.setLocation(20, 20);
		frame.setOpacity(1);
		frame.setBackground(Color.RED);
		frame.setPreferredSize(new Dimension(800, 800));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.green);
		frame.getContentPane().setBounds(100, 100, 300, 300);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(true);
		panel.setPreferredSize(new Dimension(600, 600));
		panel.setBounds(150, 150, 700, 700);
		panel.setBackground(Color.ORANGE);
		String strLabel = "Label in Panel Test";
		JLabel label = new JLabel(strLabel);
		label.setOpaque(true);
		label.setAlignmentX(10.0f);
		label.setBounds(200,200, label.getPreferredSize().width+10, label.getPreferredSize().height+10);
		label.setBackground(Color.CYAN);
		System.out.println("alignmentX:" + label.getAlignmentX());
		panel.add(label);
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
		
	}

}
