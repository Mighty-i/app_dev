package week5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.geom.*;


public class FontTest extends JPanel {
	
	int width = 500;
	int height = 400;

	public FontTest() {
		
		setPreferredSize(new Dimension(width, height));
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
		Font font = g2.getFont();
		String fontName = font.getName();
		String fontSize = String.valueOf(font.getSize());
		String fontStyle = String.valueOf(font.getStyle());
		
		g2.drawLine(0, height/2, width, height/2);
		g2.drawLine(width/2,  0,  width/2, height);
		
		
		System.out.println("font.getName:" + font.getName() 
			+ ", font.getSize:"+ font.getSize()
			+ ", font.getStyle:" + font.getStyle());
		
		System.out.println("font.PLAIN:" + font.PLAIN
				+ ", font.BOLD:" + font.BOLD 
				+ ", font.ITALIC:" + font.ITALIC);
		
		int x = width/2;
		int y = height/2;
		
		g2.drawString("aString", x, y);
	    AffineTransform at = new AffineTransform();
	    at.setToRotation(Math.PI / 4.0);
	    g2.setTransform(at);
	    g2.drawString("RotatedString", x, y);

		
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("FontTest");
		JPanel panel = new FontTest();
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		
		
	}

}
