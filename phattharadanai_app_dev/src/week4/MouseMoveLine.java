package week4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MouseMoveLine extends JPanel implements MouseListener, MouseMotionListener {
	
	int width = 600;
	int height = 400;
	
	ArrayList<Point> points;
	
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked()");
		Object source = e.getSource();
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println(
				//"source:" + source + 
				//", point:" + point +
				", x:" + x + ", y:" + y + ", xOs:" +xOs + ", yOs:" + yOs);
		points.add(point);
		repaint();
		
	}
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered()");
		Object source = e.getSource();
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println(
				//"source:" + source + 
				", point:" + point +
				", x:" + x + ", y:" + y + ", xOs:" +xOs + ", yOs:" + yOs);
	}
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited()");
		Object source = e.getSource();
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println(
				//"source:" + source + 
				", point:" + point +
				", x:" + x + ", y:" + y + ", xOs:" +xOs + ", yOs:" + yOs);
	}
	public void	mousePressed(MouseEvent e) {
		System.out.println("mousePressed()");
		Object source = e.getSource();
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println(
				//"source:" + source + 
				", point:" + point +
				", x:" + x + ", y:" + y + ", xOs:" +xOs + ", yOs:" + yOs);
	}

	public void	mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased()");
		Object source = e.getSource();
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println(
				//"source:" + source + 
				", point:" + point +
				", x:" + x + ", y:" + y + ", xOs:" +xOs + ", yOs:" + yOs);
	}

	
	public void mouseDragged(MouseEvent e) {
		System.out.println("mouseDragged()");
		Object source = e.getSource();
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println(
				//"source:" + source + 
				", point:" + point +
				", x:" + x + ", y:" + y + ", xOs:" +xOs + ", yOs:" + yOs);
	}
	
	public void	mouseMoved(MouseEvent e) {
		System.out.println("mouseMoved()");
		Object source = e.getSource();
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println(
				//"source:" + source + 
				", point:" + point +
				", x:" + x + ", y:" + y + ", xOs:" +xOs + ", yOs:" + yOs);
	}
	
	public void paintComponentOld(Graphics g) {
		System.out.println("paintComponent()");
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.RED);
		int newIndex = 0;
		Point newPoint = null;
		int lastIndex = 0;
		Point lastPoint = null;
		for(Iterator<Point> it=points.iterator(); it.hasNext();) {
			newPoint = it.next();
			// paint last point
			if(newIndex >= 0) {
				newPoint = points.get(newIndex);
				int x = newPoint.x - 1;
				int y = newPoint.y - 1;
				int w = 2;
				int h = 2;
				g2.drawRect(x, y, w, h);;
			}
			System.out.println("newIndex:" + newIndex + ", lastIndex:" + lastIndex);
			if(newIndex > 0) {
				lastPoint = points.get(lastIndex);
				g2.drawLine(newPoint.x, newPoint.y, lastPoint.x, lastPoint.y);
			}
			lastPoint = newPoint;
			lastIndex = newIndex++;
		}		
		
	}
	
	public void paintComponent(Graphics g) {
		System.out.println("paintComponent()");
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.RED);
		int i=0;
		for(Iterator<Point> it=points.iterator(); it.hasNext();) {
			Point point = it.next();
			int x = point.x - 1;
			int y = point.y - 1;
			int w = 2;
			int h = 2;
			g2.drawRect(x, y, w, h);
			if(i>0) {
				Point lastPoint = points.get(i-1);
				g2.drawLine(x+1, y+1, lastPoint.x, lastPoint.y);
			}
			i++;
			
		}
	}

	public MouseMoveLine() {
		
		setPreferredSize(new Dimension(width, height));
		setOpaque(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		points = new ArrayList<Point>();

	}

	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		MouseMoveLine mouseMove = new MouseMoveLine();
		frame.add(mouseMove);
		frame.pack();
		frame.setVisible(true);
	}
}
