package ex1_Polygon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class Level_D  {

	private static final int PANEL_WIDTH = 600;
    private static final int PANEL_HEIGHT = 600;

    public static class Drawing extends JPanel {

        private static final Font FONT = new Font("Arial", Font.PLAIN, 12);

        private List<Polygon> polygons = new ArrayList<Polygon>();

        private Polygon currentPolygon = new Polygon();

        private MouseAdapter mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    if (e.getClickCount() == 1) {
                        addPoint(e.getX(), e.getY());
                    } else if (e.getClickCount() == 2) {
                        createPolygon();
                    }
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    clearCurrentPolygon();
                }
            }

        };

        public Drawing() {
            addMouseListener(mouseListener);
        }

        protected void addPoint(int x, int y) {
            currentPolygon.addPoint(x, y);
            repaint();
        }

        protected void clearCurrentPolygon() {
            currentPolygon = new Polygon();
            repaint();
        }

        protected void createPolygon() {
            if (currentPolygon.npoints > 2) {
                
				polygons.add(currentPolygon);
            }
            clearCurrentPolygon();
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.setFont(FONT);
            
			for (Polygon polygon : polygons) {
                drawPolygon(g, polygon);
            }
            g.setColor(Color.GREEN);
            drawPolygon(g, currentPolygon);
        }

        private void drawPolygon(Graphics g, Polygon polygon) {
            if (polygon.npoints < 3) {
                if (polygon.npoints == 1) {
                    g.fillOval(polygon.xpoints[0] - 2, polygon.ypoints[0] - 2, 4, 4);
                    drawNthPoint(g, polygon, 0);
                } else if (polygon.npoints == 2) {
                    g.drawLine(polygon.xpoints[0], polygon.ypoints[0], polygon.xpoints[1], polygon.ypoints[1]);
                    drawNthPoint(g, polygon, 0);
                    drawNthPoint(g, polygon, 1);
                }
            } else {
                g.drawPolygon(polygon);
                for (int i = 0; i < polygon.npoints; i++) {
                    drawNthPoint(g, polygon, i);
                }
            }
        }

        private void drawNthPoint(Graphics g, Polygon polygon, int nth) {
            // Only works 26 times!
            String name = Character.toString((char) ('A' + nth));
            int x = polygon.xpoints[nth];
            int height = g.getFontMetrics().getHeight();
            int y = polygon.ypoints[nth] < height ? polygon.ypoints[nth] + height : polygon.ypoints[nth];
            g.drawString(name, x, y);
        }

    }

    protected static void initUI() {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Drawing());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                initUI();
            }
        });
    }
}
