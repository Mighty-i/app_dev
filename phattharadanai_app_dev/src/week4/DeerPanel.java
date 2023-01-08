package week4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JPanel;

public class DeerPanel extends JPanel {
	
	DeerFrame deerFrame;

	final static BasicStroke stroke = new BasicStroke(2.0f);
	final static BasicStroke wideStroke = new BasicStroke(8.0f);

	final static float dash1[] = { 10.0f };
	final static BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1,
			0.0f);
	Dimension totalSize;
	FontMetrics fontMetrics;

	final static int maxCharHeight = 15;
	final static int minFontSize = 6;
	
	static int panelWidth = 960;
	static int panelHeight = 650;
	
	Color[] colors = { Color.red, Color.blue, Color.green, Color.orange, Color.black, Color.yellow, Color.lightGray,
			Color.magenta, Color.darkGray, Color.pink, Color.gray, Color.cyan };
	Point[] points = new Point[0];
	int numTruck = 0;

	public DeerPanel(DeerFrame frame) {
		super();
		this.deerFrame = frame;
		System.out.println("DeerPanel.DeerPanel()");
	}
	
	FontMetrics pickFont(Graphics2D g2, String longString, int xSpace) {
		boolean fontFits = false;
		Font font = g2.getFont();
		FontMetrics fontMetrics = g2.getFontMetrics();
		int size = font.getSize();
		String name = font.getName();
		int style = font.getStyle();

		while (!fontFits) {
			if ((fontMetrics.getHeight() <= maxCharHeight) && (fontMetrics.stringWidth(longString) <= xSpace)) {
				fontFits = true;
			} else {
				if (size <= minFontSize) {
					fontFits = true;
				} else {
					g2.setFont(font = new Font(name, style, --size));
					fontMetrics = g2.getFontMetrics();
				}
			}
		}

		return fontMetrics;
	}

	private int getAbsX(int x) {
		int absX = x + (panelWidth / 2);
		return absX;
	}

	private int getAbsY(int y) {
		int absY = y + (panelHeight / 2);
		return absY;
	}

	private int getMapX(int x) {
		int mapX = x - (panelWidth / 2);
		return mapX;
	}

	private int getMapY(int y) {
		int mapY = y - (panelHeight / 2);
		return mapY;
	}

	protected void generatePos() {
		System.out.println("DeerPanel.generatePos()");
		Random rand = new Random(System.currentTimeMillis());
		try {
			int numbCust = Integer.parseInt(deerFrame.numbCustText.getText());
			System.out.println("numbCust:" + numbCust);
			points = new Point[numbCust];
			for (int i = 0; i < numbCust; i++) {
				int x = rand.nextInt(panelWidth);
				int y = rand.nextInt(panelHeight);
				System.out.println("abs x:" + x + ", y:" + y);
				x = getMapX(x);
				y = getMapY(y);
				System.out.println("map x:" + x + ", y:" + y);
				points[i] = new Point(x, y);
			}
			System.out.println("DeerPanel.generatePos() done!");
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
	}

	protected void computeTruck() {
		try {
			numTruck = Integer.parseInt(deerFrame.numbTruckText.getText());
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
	}

	protected void compute() {
		;
	}


	public void paint(Graphics g) {
		System.err.println("begin paint DeerPanel");

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Dimension d = getSize();
		int gridWidth = d.width / 6;
		int gridHeight = d.height / 2;

		System.err.println("d.width:" + d.width + ", d.height:" + d.height);

		fontMetrics = pickFont(g2, "Filled and Stroked GeneralPath", gridWidth);

		// draw Rectangle2D.Double
		g2.setStroke(stroke);
		g2.draw(new Rectangle2D.Double(0, 0, panelWidth, panelHeight));

		// draw X and Y axis
		int x1 = 0;
		int x2 = panelWidth;
		int y1 = panelHeight / 2;
		int y2 = panelHeight / 2;
		// draw Line2D.Double
		g2.drawLine(x1, y1, x2, y2);
		x1 = panelWidth / 2;
		x2 = panelWidth / 2;
		y1 = 0;
		y2 = panelHeight;
		g2.drawLine(x1, y1, x2, y2);

		for (int i = 0; i < points.length; i++) {
			g2.setStroke(stroke);

			int colorIdx = i % numTruck;
			g2.setColor(colors[colorIdx]);
			// g2.setColor(Color.red);

			g2.draw(new Rectangle2D.Double(getAbsX(points[i].x) - 2, getAbsY(points[i].y) - 2, 4, 4));
		}
		

		System.err.println("finished paint");

	}


}
