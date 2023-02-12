package ex1_Polygon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class polygontest extends JPanel implements MouseMotionListener, MouseListener{

	int width = 600;
	int height = 400;
	ArrayList<Point> polygonPoint = new ArrayList<Point>();
	
	int nearness = 2;
	Point pointNearMouse;
	
	public polygontest() {
		
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setOpaque(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		polygonPoint = new ArrayList<Point>();
		
		pointNearMouse = null;
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Paint");
		frame.getContentPane().add(new polygontest());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setLocation(400 , 200);
	}
	
	/*
	 * public void Paint(Graphics graphics) { super.paint(graphics); Graphics2D g =
	 * (Graphics2D)graphics; g.setColor(Color.GREEN); drawLine(g); }
	 */
	
	/*
	 * private void drawLine(Graphics2D g) { for(int i=0; i<polygonPoint.size();i++)
	 * { Point point = polygonPoint.get(i); if(i==polygonPoint.size()-1) {
	 * g.drawLine((int)point.getX(), (int)point.getY(), (int)point.getX(),
	 * (int)point.getY()); }else { Point nextPoint = polygonPoint.get(i+1);
	 * g.drawLine((int)point.getX(), (int)point.getY(), (int)nextPoint.getX(),
	 * (int)nextPoint.getY()); }
	 * System.out.println("X: "+point.getX()+", Y: "+point.getY()); } }
	 */
	
	boolean isNear(Point p1, Point p2) {
		boolean near = false;
		int deltaX = (p2.x-p1.x);
		int deltaY = (p2.y-p1.y);
		double distance = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
		if(Math.round(distance) <= nearness) {
			near = true;
		}
		return near;
	}
	
	
	
	public void paintComponent(Graphics g) {
		System.out.println("paintComponent()");
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(getBackground());
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.RED);
		int i=0;
		for(Iterator<Point> it=polygonPoint.iterator(); it.hasNext();) {
			Point point = it.next();
			int x = point.x - 2;
			int y = point.y - 2;
			int w = 4;
			int h = 4;
			if(pointNearMouse != null && pointNearMouse.equals(point)) {
				g2.clearRect(x, y, 8, 8);
				w *= 2;
				h *= 2;
				g2.setColor(Color.GREEN);
			}
			
			g2.fillRect(x, y, w, h);
			
			if(i>0) {
				Point lastPoint = polygonPoint.get(i-1);
				g2.drawLine(x+1, y+1, lastPoint.x, lastPoint.y);
			}
			i++;
			
		}
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Click!!");
		Point p = new Point(e.getX(),e.getY());
		polygonPoint.add(p);
		repaint();
		
		
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
		polygonPoint.add(p);
		repaint();
		
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Moved!!");
		
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("x:" + x + ", y:" + y + ", xOs:" + xOs + ", yOs:" + yOs);
		pointNearMouse = null;
		for (Point pointOld : polygonPoint) {
			if (isNear(point, pointOld)) {
				pointNearMouse = pointOld;
			}
		}
		repaint();
		
	}
	


}
