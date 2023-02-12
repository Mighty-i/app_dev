package ex1_Polygon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class polygon_asshole_1 extends JPanel implements MouseMotionListener, MouseListener {

	int width = 900;
	int height = 900;
	ArrayList<Point> polygonPoint = new ArrayList<Point>();

	int nearness = 2;
	Point pointNearMouse;
	Point pointPressed;
//	private Polygon polygon;
	Point startMousePosition = null;
	boolean isDraggingPolygon = false;

	public polygon_asshole_1() {

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setOpaque(true);
		addMouseListener(this);
		addMouseMotionListener(this);

		polygonPoint = new ArrayList<Point>();

		pointNearMouse = null;

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Paint");
		frame.getContentPane().add(new polygon_asshole_1());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setLocation(400, 200);
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
	boolean iscool = false;
	

	boolean isNear(Point p1, Point p2) {
		boolean near = false;
		int deltaX = (p2.x - p1.x);
		int deltaY = (p2.y - p1.y);
		double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		if (Math.round(distance) <= nearness) {
			near = true;
		}
		return near;
	}

	boolean isPolygon(ArrayList<Point> points, Point pointNearMouse) {
		if (points.size() < 3) {
			return false;
		}

		Point firstPoint = points.get(0);
		if (!pointNearMouse.equals(firstPoint)) {
			return false;
		}

		points.add(pointNearMouse);
		System.out.println("New polygon created");
		return true;
	}
	
	

	public void paintComponent(Graphics g) {
		System.out.println("paintComponent()");
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(getBackground());
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.RED);
		int i = 0;
//		****
		int[] xCoords = new int[polygonPoint.size()];
		int[] yCoords = new int[polygonPoint.size()];

		for (int o = 0; o < polygonPoint.size(); o++) {
			xCoords[o] = (int) polygonPoint.get(o).getX();
			yCoords[o] = (int) polygonPoint.get(o).getY();
		}
		
		if (iscool) {

			g2.setColor(Color.BLUE);
			g2.fillPolygon(xCoords, yCoords, polygonPoint.size());
		}
		if (iscool) {
	        g.drawPolygon(xCoords, yCoords, polygonPoint.size());
	    }
//		****
		for (Iterator<Point> it = polygonPoint.iterator(); it.hasNext();) {
			Point point = it.next();

			int x = point.x - 2;
			int y = point.y - 2;
			int w = 4;
			int h = 4;
			if (pointNearMouse != null && pointNearMouse.equals(point)) {
				g2.clearRect(x, y, 8, 8);
				w *= 2;
				h *= 2;
				g2.setColor(Color.GREEN);

			}

			g2.fillRect(x, y, w, h);
//			****

			xCoords[i] = x + 2;
			yCoords[i] = y + 2;
//			*****

			if (i > 0) {
				Point lastPoint = polygonPoint.get(i - 1);
				g2.drawLine(x + 1, y + 1, lastPoint.x, lastPoint.y);

			}

			i++;

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		Point p = e.getPoint();
		if (pointNearMouse == null) {
			polygonPoint.add(p);
			
		} else {
			if (isPolygon(polygonPoint, pointNearMouse)) {
				polygonPoint.add(polygonPoint.get(0));
				iscool = true;
			}
			repaint();
		}
		pointNearMouse = null;

//		****
//		Point p = e.getPoint();
//	    if(pointNearMouse != null) {
//	        polygonPoint.add(pointNearMouse);
//	        pointNearMouse = null;
//	        repaint();
//	        return;
//	    }
//	    int index = 0;
//	    for(Point polygonPoint : polygonPoint) {
//	        if(isNear(polygonPoint, p)) {
//	            pointNearMouse = polygonPoint;
//	            repaint();
//	            return;
//	        }
//	        index++;
//	    }
//	    polygonPoint.add(p);
//	    repaint();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		if (pointNearMouse != null) {
			pointPressed = pointNearMouse;
		}
//		pointPressed = e.getPoint();
		
		
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
		System.out.println("mouseDragged()");
		Object source = e.getSource();
		Point point = e.getPoint();

		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();

		if (pointPressed != null && pointPressed.equals(pointNearMouse)) {
			pointNearMouse.setLocation(point);
			repaint();
		}
		
		
//	   *****
//		Point p = e.getPoint();
//	    if(pointNearMouse != null) {
//	        pointNearMouse.x = p.x;
//	        pointNearMouse.y = p.y;
//	        repaint();
//	        return;
//	    }
//	    int index = 0;
//	    for(Point polygonPoint : polygonPoint) {
//	        if(isNear(polygonPoint, pointPressed)) {
//	            polygonPoint.x = p.x;
//	            polygonPoint.y = p.y;
//	            repaint();
//	            return;
//	        }
//	        index++;
//	    }
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Moved!!");

		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
//		System.out.println("x:" + x + ", y:" + y + ", xOs:" + xOs + ", yOs:" + yOs);
		pointNearMouse = null;
		for (Point pointOld : polygonPoint) {
			if (isNear(point, pointOld)) {
				pointNearMouse = pointOld;
			}
		}

		repaint();

	}

}
