package test05;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test05A extends JPanel implements MouseListener, MouseMotionListener {

	public Test05A () {
		
		setPreferredSize(new Dimension(500, 300));
		setBackground(Color.CYAN);
		setOpaque(true);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}
	
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked())");
		Object source = e.getSource();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("source:" + source.toString() +
				", x:" + x + ", y" + y + ", xOs:" + xOs +
				", yOs:" + yOs);		
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed())");
		Object source = e.getSource();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("source:" + source.toString() +
				", x:" + x + ", y" + y + ", xOs:" + xOs +
				", yOs:" + yOs);		
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased())");
		Object source = e.getSource();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("source:" + source.toString() +
				", x:" + x + ", y" + y + ", xOs:" + xOs +
				", yOs:" + yOs);		
	}

	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered())");
		Object source = e.getSource();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("source:" + source.toString() +
				", x:" + x + ", y" + y + ", xOs:" + xOs +
				", yOs:" + yOs);		
	}

	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited())");
		Object source = e.getSource();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("source:" + source.toString() +
				", x:" + x + ", y" + y + ", xOs:" + xOs +
				", yOs:" + yOs);		
	}
	
	public void mouseMoved(MouseEvent e) {
		System.out.println("mouseMoved())");
		Object source = e.getSource();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("source:" + source.toString() +
				", x:" + x + ", y" + y + ", xOs:" + xOs +
				", yOs:" + yOs);		
	}

	public void mouseDragged(MouseEvent e) {
		System.out.println("mouseDragged())");
		Object source = e.getSource();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("source:" + source.toString() +
				", x:" + x + ", y" + y + ", xOs:" + xOs +
				", yOs:" + yOs);		
	}



	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Test05A");
		frame.setContentPane(new Test05A());
		
		frame.pack();
		frame.setVisible(true);;
		
		
		
	}
}
