package week5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LineGraph extends JPanel {
	
	final static int PAD_RIGHT = 150;
	final static int PAD_LEFT = 100;
	final static int PAD_TOP = 50;
	final static int PAD_BOTTOM = 60;
	final static int OFFSET_TOP = 30;
	final static int OFFSET_BOTTOM = 20;
	final static int OFFSET_X_AXIS = PAD_LEFT - 40;
	final static int OFFSET_Y_AXIS = PAD_BOTTOM - 10;
	final static int SCALE_LENGTH = 15;
	
	String graphLabel = "Line Graph";
	String xLabel = "Data Axis";
	String yLabel = "Value Axis";
	
	int width;
	int height;
	int graphWidth;
	int graphHeight;
	
	int fontHeight = 20;
		
	int dataBound;
	int[] data;
	
	double valueRatio;

	public LineGraph(int dataBound, int[] data) {
		
		this(800, 600, dataBound, data);
		
	}
	
	public LineGraph(int w, int h, int dataBound, int[] data) {
		
		super();
		
		this.dataBound = dataBound;
		this.data = data;

		width = w;
		height = h;
		
		setPreferredSize(new Dimension(width, height));
		
		graphWidth = width - PAD_RIGHT - PAD_LEFT;
		graphHeight = height - PAD_TOP - PAD_BOTTOM;
		
		valueRatio = graphHeight*1.0/dataBound;
		
		System.out.println("xAxisWidth:" + graphWidth
				+ ", yAxisHeight:" + graphHeight
				+ ", valueRatio:" + valueRatio);
		
	}
	
	public int[] scaleData(int[] raw) {
		int[] scaled = new int[raw.length];
		
		int i = 0;
		for(int data : raw) {
			
			double temp = valueRatio * data;
			int dataScaled = (int)Math.round(temp);
			scaled[i++] = dataScaled;
			System.out.println("raw:" + data + ", temp:" + temp 
					+ ", dataScaled:" + dataScaled);
		}
		
		return scaled;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		int[] scaledData = scaleData(data);
		int yBlockSize = graphHeight / (scaledData.length+1);
		int xBlockSize = graphWidth / (scaledData.length-1);
		int dataBlockSize = dataBound/(data.length+1);
		System.out.println("yBlockSize:" + yBlockSize + ", xBlockSize:" + xBlockSize + ", dataBlockSize:" + dataBlockSize);
		
		int x1, y1, x2, y2;
		
		// graph label
		x1 = PAD_LEFT + (graphWidth/2);
		y1 = PAD_TOP - OFFSET_TOP;
		g2.drawString(graphLabel, x1, y1);
		
		// draw x label
		x1 = PAD_LEFT + (graphWidth/2);
		y1 = height - OFFSET_BOTTOM;
		g2.drawString(xLabel, x1, y1);
		
		// draw x axis
		x1 = PAD_LEFT;
		y1 = height - PAD_BOTTOM;
		x2 = width - PAD_RIGHT;		
		y2 = y1;
		g2.drawLine(x1, y1, x2, y2);

		// draw scale on x axis
		x1 = PAD_LEFT;
		y1 = height - PAD_BOTTOM;
		y2 = y1 + SCALE_LENGTH;
		for(int i=0; i<scaledData.length; i++) {
			x2 = x1;
			g2.drawLine(x1, y1, x2, y2);
			g2.drawString("Data-" + i, x1, (height-OFFSET_Y_AXIS) + fontHeight);
			// move right one block
			x1 += xBlockSize;
		}
				
		// draw y label
		x1 = PAD_LEFT;
		y1 = OFFSET_TOP;
		g2.drawString(yLabel, x1, y1);

		// draw y axis		
		x1 = PAD_LEFT;
		y1 = PAD_TOP;		
		x2 = PAD_LEFT;
		y2 = height - PAD_BOTTOM;
		g2.drawLine(x1, y1, x2, y2);

		// draw scale on y axis
		x1 = PAD_LEFT;
		x2 = PAD_LEFT - SCALE_LENGTH;
		y1 = height - PAD_BOTTOM;
		for(int i=0; i<=scaledData.length+1; i++) {
			y2 = y1;
			g2.drawLine(x1, y1, x2, y2);
			g2.drawString(String.valueOf(dataBlockSize*i), OFFSET_X_AXIS, y1);
			// move up one block
			y1 -= yBlockSize;
		}
				
		// draw graph
		x1 = PAD_LEFT;
		for(int i=0; i<data.length-1; i++) {
			
			y1 = height-PAD_BOTTOM - scaledData[i];
			x2 = x1 + xBlockSize;
			y2 = height-PAD_BOTTOM - scaledData[i+1];
			g2.drawString(String.valueOf(data[i]), x1, y1);
			if(i == scaledData.length-1) {
				g2.drawString(String.valueOf(scaledData[i+1]), x2, y2);
			}
			
			g2.setColor(Color.BLUE);
			g2.fillRect(x1-4, y1-4, 8, 8);
			g2.fillRect(x2-4, y2-4, 8, 8);
			// draw graph between a pair of point
			g2.setColor(Color.ORANGE);
			g2.drawLine(x1, y1, x2, y2);
			x1 += xBlockSize;
			
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] data = {5, 3, 7, 11, 1};
		int bound = 12;
		
		JFrame frame = new JFrame();
		LineGraph lg = new LineGraph(bound, data);
		frame.add(lg);
		
		frame.pack();
		frame.setVisible(true);
		
	}

}