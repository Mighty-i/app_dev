package test08;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test08A extends JPanel {
	
	
	public Test08A() {
		
		setPreferredSize(new Dimension(500, 300));
		setBackground(Color.MAGENTA);
		
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		String str = "Hello world!";
		g2.drawString(str, 10, 20);
		
		g2.drawLine(10, 25, 100, 25);

		g2.setColor(Color.CYAN);
		g2.drawRect(10, 50, 200, 50);
		g2.setColor(Color.BLACK);
		g2.fillOval(10, 125, 200, 50);

	}
	
	public static void main(String[] args) {
		
		Test08A test08A = new Test08A();
		JFrame frame = new JFrame("Bar Graph");
		frame.add(test08A);
		
		frame.pack();
		frame.setVisible(true);
		
	}

}
