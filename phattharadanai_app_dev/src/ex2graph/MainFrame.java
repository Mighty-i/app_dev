package ex2graph;

import java.awt.Dimension;

import javax.swing.BoundedRangeModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;




public class MainFrame {

        public static void main (String[] args) {
            
            JFrame frame = new JFrame("Main Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            int bound = 12;
    		int[] data = {5,8,7,6,1};
            
    
            JPanel panel = new JPanel();
            Generator generator = new  Generator();
            panel.add(generator);

            
            JPanel panel2 = new JPanel();
            BarGraph barGraph = new BarGraph(bound, data);
            panel2.add(barGraph);

            
            
            
            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.add("Form Data",panel);
            tabbedPane.add("bar",panel2);
            
            
            
            frame.add(tabbedPane);
            frame.pack();
            frame.setLocationRelativeTo(null);

            frame.setResizable(false);
            frame.setLayout(null);
            frame.setVisible(true);


}
}