package ex1_Polygon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class e1 extends JPanel implements MouseListener,MouseMotionListener,ActionListener{
	
	int width = 500;
	int height = 500;
	int currentIndex = -1;
	int nearness = 4;
	
	ArrayList<Point> points = null;
		
	Point pointNearMouse;
	Point pointPressed;
    Point startMousePosition = null;
	
	boolean isClosed = false;
	boolean isDraggingPolygon = false;
	
	boolean isNear(Point p1, Point p2) {
		boolean near = false;
		int deltaX = (p2.x-p1.x);
		int deltaY = (p2.y-p1.y);
		double distance = Math.sqrt(deltaX*deltaX+deltaY*deltaY);
		if(Math.round(distance) <= nearness) {
			near = true;
		}
		return near;
	}
	
	boolean isInsidePolygon(Point p) {
        int crossings = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            if ((((p1.getY() <= p.getY()) && (p.getY() < p2.getY())) ||
                ((p2.getY() <= p.getY()) && (p.getY() < p1.getY()))) &&
                (p.getX() > (p2.getX() - p1.getX()) * (p.getY() - p1.getY()) / (p2.getY() - p1.getY()) + p1.getX())) {
            	crossings++;
            }
        }
        return (crossings % 2 == 1);
    }
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseDragged()");
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("point:"+point+" x:"+x+" y:"+y+" xOs:"+xOs+" yOs:"+yOs);
		
		//DragginggPointNearMouse
		if(pointPressed != null && pointPressed.equals(pointNearMouse)) {
			pointNearMouse.setLocation(point);
			repaint();
		}
		
		//DraggingPolygon
		 if (pointPressed != null && !pointPressed.equals(pointNearMouse)) {
			 pointPressed.setLocation(e.getPoint());
			 repaint();
		 } else if (isDraggingPolygon) {
	        int dragX = e.getX() - startMousePosition.x;
	        int dragY = e.getY() - startMousePosition.y;
	        for (Point p : points) {
	            p.x += dragX;
	            p.y += dragY;
	        }
	        repaint();
	        startMousePosition = e.getPoint();
		 }
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseMoved()");
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("point:"+point+" x:"+x+" y:"+y+" xOs:"+xOs+" yOs:"+yOs);
		pointNearMouse = null;
		Point polyPoint = null;
		for(Iterator<Point> it=points.iterator(); it.hasNext();) {
			polyPoint = it.next();
			if(isNear(point, polyPoint)) {
				System.out.println("mouseMoved");
				pointNearMouse = polyPoint;
				System.out.println("pointNearMouse:" + pointNearMouse);
				System.out.println("polyPoint:" + polyPoint);
				System.out.println("point:" + point);
				System.out.println("pointNearMouse.equals(polyPoint):" +
						pointNearMouse.equals(polyPoint));
				System.out.println("(pointNearMouse == polyPoint):" +
						(pointNearMouse == polyPoint));
			}
		}
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseClicked()");
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("point:"+point+" x:"+x+" y:"+y+" xOs:"+xOs+" yOs:"+yOs);
		
		if (!isClosed) {
            if (points.size() > 0 && point.distance(points.get(0)) < nearness) {
                isClosed = true;
            } else {
                points.add(point);
            }
            repaint();
        }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mousePressed()");
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("point:"+point+" x:"+x+" y:"+y+" xOs:"+xOs+" yOs:"+yOs);
		
		//DraggingPointNearMouse
		if(pointNearMouse != null) {
			pointPressed = pointNearMouse;
		}
		
		//DraggingPolygon
		if (pointPressed == null) {
            startMousePosition = e.getPoint();
            if (isInsidePolygon(startMousePosition)) {
                isDraggingPolygon = true;
            }
        }
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseReleased()");
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("point:"+point+" x:"+x+" y:"+y+" xOs:"+xOs+" yOs:"+yOs);
		
		pointPressed = null;
   	 	startMousePosition = null;
   	 	isDraggingPolygon = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseEntered()");
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("point:"+point+" x:"+x+" y:"+y+" xOs:"+xOs+" yOs:"+yOs);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseExited()");
		Point point = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		int xOs = e.getXOnScreen();
		int yOs = e.getYOnScreen();
		System.out.println("point:"+point+" x:"+x+" y:"+y+" xOs:"+xOs+" yOs:"+yOs);
	}
	
	public void verticalFlip() {
	    for (Point point : points) {
	        point.setLocation(point.getX(), height - point.getY());
	    }
	    repaint();
	}
	
	public void horizontalFlip() {
	    for (Point point : points) {
	        point.setLocation(width - point.getX(), point.getY());
	    }
	    repaint();
	}

	public void zoomIn() {
	    for (Point point : points) {
	        point.setLocation(point.getX() * 1.5, point.getY() * 1.5);
	    }
	    repaint();
	}

	public void zoomOut() {
	    for (Point point : points) {
	        point.setLocation(point.getX() / 1.5, point.getY() / 1.5);
	    }
	    repaint();
	}
	
	public void paintComponent(Graphics g) {
		System.out.println("paintComponent()");
		super.paintComponent(g);
		
		int[] xPoints = new int[points.size()];
        int[] yPoints = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            xPoints[i] = (int) points.get(i).getX();
            yPoints[i] = (int) points.get(i).getY();
        }
		
        //DrawPolygon
        g.setColor(Color.YELLOW);
        if (isClosed) {
            g.fillPolygon(xPoints, yPoints, points.size());
        }
        
        //DrawLine
		g.setColor(Color.RED);
		if (points.size() > 1) {
          for (int i = 0; i < points.size() - 1; i++) {
              Point newPoint = points.get(i);
              Point lastPoint = points.get(i + 1);
              g.drawLine(newPoint.x, newPoint.y, lastPoint.x, lastPoint.y);
          }
	    }
		if (isClosed) {
	        g.drawPolygon(xPoints, yPoints, points.size());
	    }
      		
		for (int i = 0; i < points.size(); i++) {
	        Point point = points.get(i);
	        g.setColor(Color.RED);
	        
	        int w = 4;
	        int h = 4;
	        
	        //PointNearMouse
	        if(pointNearMouse != null && pointNearMouse.equals(point)) {
				w *= 2;
				h *= 2;
				g.setColor(Color.GREEN);
			}
            
            int x = point.x - (w/2);
            int y = point.y - (h/2);
            
          //DrawRect
            g.fillRect(x , y , w, h);
        }
	}
	
	public e1() {
		setPreferredSize(new Dimension(width, height));
		setOpaque(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		points = new ArrayList<Point>();
		
		JPanel jPanel = new JPanel();
        add(jPanel);

        JButton verticalFlipButton = new JButton("Vertical Flip");
        verticalFlipButton.addActionListener(this);
        jPanel.add(verticalFlipButton);

        JButton horizontalFlipButton = new JButton("Horizontal Flip");
        horizontalFlipButton.addActionListener(this);
        jPanel.add(horizontalFlipButton);

        JButton zoomInButton = new JButton("Zoom In");
        zoomInButton.addActionListener(this);
        jPanel.add(zoomInButton);

        JButton zoomOutButton = new JButton("Zoom Out");
        zoomOutButton.addActionListener(this);
        jPanel.add(zoomOutButton);
	}
	
	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		if(actionCommand.equals("Vertical Flip")) {
			verticalFlip();
		}
		else if(actionCommand.equals("Horizontal Flip")) {
			horizontalFlip();
		}
		else if(actionCommand.equals("Zoom In")) {
			zoomIn();
		}
		else if(actionCommand.equals("Zoom Out")) {
			zoomOut();
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		e1 makePolygon = new e1();
		frame.add(makePolygon);
		frame.pack();
		frame.setVisible(true);
	}
}
