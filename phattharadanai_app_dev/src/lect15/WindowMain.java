package lect15;

import java.awt.event.*;
import java.awt.CardLayout;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class WindowMain implements ActionListener {
	
	JFrame frame;
	
	public void actionPerformed(ActionEvent ev) {
		
		String actionCommand = ev.getActionCommand();
		int id = ev.getID();
		Object source = ev.getSource();
		System.out.println("actionPerformed..." +
		", actionCommand:" + actionCommand +
		", id:" + id + ", source:" + source);
		
	    CardLayout cl = (CardLayout)(frame.getContentPane().getLayout());
        cl.show(frame.getContentPane(), actionCommand);

		
	}
	
	public WindowMain() {
		
		frame = new JFrame("Main Window");
		frame.getContentPane().setLayout(new CardLayout());
		
		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("Managing Pages");
		JMenuItem jMenuItem = new JMenuItem("Main Page");
		jMenuItem.addActionListener(this);
		
		jMenuBar.add(jMenu);
		jMenu.add(jMenuItem);
		frame.setJMenuBar(jMenuBar);
		jMenu.add(jMenuItem = new JMenuItem("Add Page"));
		jMenuItem.addActionListener(this);
		jMenu.add(jMenuItem = new JMenuItem("View Page"));
		jMenuItem.addActionListener(this);
		
		MainPage mainPage = new MainPage();
		AddPage addPage = new AddPage();
		ViewPage viewPage = new ViewPage();
		
		frame.getContentPane().add(mainPage, "Main Page");
		frame.getContentPane().add(addPage, "Add Page");
		frame.getContentPane().add(viewPage, "View Page");
		
		
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new WindowMain();
		
	}

}
