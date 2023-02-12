package ex2graph;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main  {

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Generate Line Graph,Bar Graph");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		frame.add(new Generator(frame));
//		frame.add(new MyFrame(frame));
		Generator generator = new Generator();
		frame.add(generator);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(800,600);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	

public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	

}
