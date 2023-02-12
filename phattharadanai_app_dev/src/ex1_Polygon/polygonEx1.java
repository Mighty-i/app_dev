package ex1_Polygon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class polygonEx1 extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

	private ArrayList<Point> polygonPoint = new ArrayList<Point>();
	private int pointLength = 10;
	private Polygon po;
	private boolean drawSuccess = false;
	private int[] mouseNearPoint = new int[3];
	private ArrayList<Integer[]> delta = new ArrayList<Integer[]>();

	public polygonEx1() {

		JButton ZoomIn = new JButton("ZoomIn");
		JButton ZoomOut = new JButton("ZoomOut");
		JButton VerticalFlip = new JButton("Vertical Flip");
		JButton HorizontalFlip = new JButton("Horizontal Flip");

		ZoomIn.addActionListener(this);
		ZoomOut.addActionListener(this);
		VerticalFlip.addActionListener(this);
		HorizontalFlip.addActionListener(this);

		add(ZoomIn);
		add(ZoomOut);
		add(VerticalFlip);
		add(HorizontalFlip);

		this.setSize(500, 500);
		this.setBackground(Color.white);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		this.setFocusable(true);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Polygin");
		frame.getContentPane().add(new polygonEx1());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setLocation(400, 200);
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		Graphics2D g = (Graphics2D) graphics;
		po = new Polygon();

		g.setColor(Color.LIGHT_GRAY);
		drawLine(g);

		if (drawSuccess) {
			g.drawPolygon(po);
			g.fillPolygon(po);
		}

//		if(mouseNearPoint!=null) {
//			g.setColor(Color.green);
//			g.fillOval(mouseNearPoint[0]-(pointLength/2),mouseNearPoint[1]-(pointLength/2), pointLength, pointLength);
//		}
	}

	private boolean isEnd() {
		if (polygonPoint.size() > 1) {
			int lastX = (int) polygonPoint.get(polygonPoint.size() - 1).getX();
			int lastY = (int) polygonPoint.get(polygonPoint.size() - 1).getY();

			Point firstPoint = polygonPoint.get(0);
			return (((lastX >= firstPoint.getX() - pointLength) && (lastX <= firstPoint.getX() + pointLength))
					&& ((lastY >= firstPoint.getY() - pointLength) && (lastY <= firstPoint.getY() + pointLength)));
		}

		return false;
	}

	private void drawLine(Graphics2D g) {
		for (int i = 0; i < polygonPoint.size(); i++) {
			Point point = polygonPoint.get(i);
			if (i == polygonPoint.size() - 1) {
				g.fillOval((int) point.getX() - 5, (int) point.getY() - 5, pointLength, pointLength);
				g.drawLine((int) point.getX(), (int) point.getY(), (int) point.getX(), (int) point.getY());
			} else {
				Point nextPoint = polygonPoint.get(i + 1);
				g.fillOval((int) point.getX() - 5, (int) point.getY() - 5, pointLength, pointLength);
				g.drawLine((int) point.getX(), (int) point.getY(), (int) nextPoint.getX(), (int) nextPoint.getY());
			}
			System.out.println("x:" + point.getX() + ",y:" + point.getY());
			po.addPoint((int) point.getX(), (int) point.getY());
		}
	}

	private int[] nearPoint(MouseEvent e) {
		int[] thisPoint = new int[3];
		for (int i = 0; i < polygonPoint.size(); i++) {
			Point point = polygonPoint.get(i);
			if (e.getX() >= point.getX() - pointLength && e.getX() <= point.getX() + pointLength
					&& e.getY() >= point.getY() - pointLength && e.getY() <= point.getY() + pointLength) {
				thisPoint[0] = e.getX();
				thisPoint[1] = e.getY();
				thisPoint[2] = i;
				return thisPoint;
			}
		}
		return null;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (nearPoint(e) != null && drawSuccess) {
			polygonPoint.get(nearPoint(e)[2]).setLocation(e.getX(), e.getY());
			repaint();

		}
		Point point = e.getPoint();
		int sumx = 0;
		int sumy = 0;
		if (delta != null & po.contains(e.getPoint())) {
			System.out.println("delta" + delta);
			for (int i = 0; i < delta.size(); i++) {
				sumx = delta.get(i)[0] + point.x;
				sumy = delta.get(i)[1] + point.y;
				System.out.println("x ==" + sumx + "y ==" + sumy);
				polygonPoint.get(i).setLocation(sumx, sumy);
			}
//			for(int i=delta.size()-1; i>=0; i--){
//			 sumx =	delta.get(i)[0]+point.x;
//			 sumy = delta.get(i)[1]+point.y;
//			 System.out.println("x =="+sumx+"y =="+sumy);
//			 polygonPoint.get(i).setLocation(sumx,sumy);
//			}
			System.out.println(" polygonPoint = " + polygonPoint);
			repaint();
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (nearPoint(e) != null) {
			System.out.println("near" + nearPoint(e)[2]);
			mouseNearPoint = nearPoint(e);
			repaint();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("clicked!!");
		if (!drawSuccess) {
			Point p = new Point(e.getX(), e.getY());
			polygonPoint.add(p);
			if (isEnd()) {
				polygonPoint.remove(polygonPoint.size() - 1);
				drawSuccess = true;
			}
		}

		repaint();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point point = e.getPoint();
		if (po.contains(e.getPoint())) {
			Integer[] diff = null;
			for (Point points : polygonPoint) {
				diff = new Integer[2];
				diff[0] = (point.x - points.x) * (-1);
				diff[1] = (point.y - points.y) * (-1);
				delta.add(diff);
				System.out.println("diff0 =" + diff[0]);
//			Point diff = null;
//			for(Point points : pointList) {
//				diff = new Point();
//				int x = points.x - point.x;
//				int y = points.y - point.y;
//				diff.x = x;
//				diff.y = y;
//				difference.add(diff);
			}
			System.out.println("after =" + delta);
		}

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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("ZoomIn")) {
			for (Point item : polygonPoint) {
				item.setLocation(item.x * 1.1, item.y * 1.1);
			}
			int sumx = 0;
			int sumy = 0;
			int centerx = 0;
			int centery = 0;
			for (Point item : polygonPoint) {
				sumx += item.x;
				sumy += item.y;
			}
			centery = sumy / polygonPoint.size();
			centerx = sumx / polygonPoint.size();
			int centerh = getSize().height / 2;
			int centerw = getSize().width / 2;
			for (Point item : polygonPoint) {
				int diffx = item.x - centerx;
				int diffy = item.y - centery;
				item.setLocation(centerw + diffx, centerh + diffy);
			}
			repaint();

		} else if (e.getActionCommand().equals("ZoomOut")) {
			for (Point item : polygonPoint) {
				item.setLocation(item.x * 0.8, item.y * 0.8);
			}
			int sumx = 0;
			int sumy = 0;
			int centerx = 0;
			int centery = 0;
			for (Point item : polygonPoint) {
				sumx += item.x;
				sumy += item.y;
			}
			centery = sumy / polygonPoint.size();
			centerx = sumx / polygonPoint.size();
			int centerh = getSize().height / 2;
			int centerw = getSize().width / 2;
			for (Point item : polygonPoint) {
				int diffx = item.x - centerx;
				int diffy = item.y - centery;
				item.setLocation(centerw + diffx, centerh + diffy);
			}
			repaint();
		} else if (e.getActionCommand().equals("Vertical Flip")) {
			int sumx = 0;
			int centerx = 0;
			for (Point item : polygonPoint) {
				sumx += item.x;
			}
			centerx = sumx / polygonPoint.size();
			for (Point item : polygonPoint) {
				int diff = (item.x - centerx) * (-1);
				item.setLocation(diff + centerx, item.y);
			}
			repaint();

		} else if (e.getActionCommand().equals("Horizontal Flip")) {
			int sumy = 0;
			int centery = 0;
			for (Point item : polygonPoint) {
				sumy += item.y;
			}
			centery = sumy / polygonPoint.size();
			for (Point item : polygonPoint) {
				int diff = (item.y - centery) * (-1);
				item.setLocation(diff + centery, item.x);
			}
			repaint();
		}
	}
}
