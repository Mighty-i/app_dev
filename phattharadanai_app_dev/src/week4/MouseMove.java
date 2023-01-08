package week4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MouseMove extends JPanel implements MouseListener, MouseMotionListener {

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
				// "source:" + source +
				// ", point:" + point +
				", x:" + x + ", y:" + y + ", xOs:" + xOs + ", yOs:" + yOs);
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
				// "source:" + source +
				", point:" + point + ", x:" + x + ", y:" + y + ", xOs:" + xOs + ", yOs:" + yOs);
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
				// "source:" + source +
				", point:" + point + ", x:" + x + ", y:" + y + ", xOs:" + xOs + ", yOs:" + yOs);
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed()");
		Object source = e.getSource();
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println(
				// "source:" + source +
				", point:" + point + ", x:" + x + ", y:" + y + ", xOs:" + xOs + ", yOs:" + yOs);
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased()");
		Object source = e.getSource();
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println(
				// "source:" + source +
				", point:" + point + ", x:" + x + ", y:" + y + ", xOs:" + xOs + ", yOs:" + yOs);
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
				// "source:" + source +
				", point:" + point + ", x:" + x + ", y:" + y + ", xOs:" + xOs + ", yOs:" + yOs);
	}

	public void mouseMoved(MouseEvent e) {
		System.out.println("mouseMoved()");
		Object source = e.getSource();
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println(
				// "source:" + source +
				", point:" + point + ", x:" + x + ", y:" + y + ", xOs:" + xOs + ", yOs:" + yOs);

		points.add(point);

		repaint();
	}

	public void paintComponent(Graphics g) {
		System.out.println("paintComponent()");
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.BLUE);
//		g2.setColor(Color.YELLOW);
		for (Iterator<Point> it = points.iterator(); it.hasNext();) {
			Point point = it.next();
			int w = 100;
			int h = 100;
			int x = point.x - w / 2;
			int y = point.y - h / 2;
			int w2 = 50;
			int h2 = 50;
			int x2 = point.x - w / 2;
			int y2 = point.y - h / 2;

			g2.fillOval(x2, y2, w2, h2);
			g2.drawRect(x, y, w, h);

		}
	}

	public MouseMove() {

		setPreferredSize(new Dimension(width, height));
		setOpaque(true);
		addMouseListener(this);
		addMouseMotionListener(this);

		points = new ArrayList<Point>();

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		MouseMove mouseMove = new MouseMove();
		frame.add(mouseMove);
		frame.pack();
		frame.setVisible(true);
	}
}
