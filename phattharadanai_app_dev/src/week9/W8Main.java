package week9;

import javax.swing.JFrame;

public class W8Main {
			
	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event dispatch thread.
	 */
	/**
	 * 
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("GUI Mini Scm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add contents to the window.
		frame.add(new W8MainMenu(frame));

		// Display the window.
		// frame.setPreferredSize(new Dimension(frameWidth, frameHeight));
		// frame.setSize(frameWidth, frameHeight);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		System.out.println("Main lect 8");
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}


}
