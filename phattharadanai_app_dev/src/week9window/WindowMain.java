package week9window;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class WindowMain {
	
	public static void main(String[] args) {
		
		final int Height = 700;
		final int Width = 500;
		
		System.out.println("Hello world");
		JFrame frame = new JFrame("Main Window");
		
		frame.setPreferredSize(new Dimension(Height,Width));
		
		MainPage mainPage = new MainPage();
		frame.add(mainPage);
		
		AddPage addPage = new AddPage();
		frame.add(addPage);
		
		ViewPage viewPage = new ViewPage();
		frame.add(viewPage);
		
		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("Manage Data");
		JMenuItem jMenuItem = new JMenuItem("Main Page");
		
		frame.setJMenuBar(jMenuBar);
		
		
		jMenu.add(jMenuItem);
		
		jMenuBar.add(jMenu);
		jMenuItem = new JMenuItem("Add Page");
		jMenu.add(jMenuItem);
		jMenuItem = new JMenuItem("View Page");
		jMenu.add(jMenuItem);
		
		frame.pack();
		frame.setVisible(true);
		
//		frame.setBounds(200, 200, 500, 700);
		
	}

}
