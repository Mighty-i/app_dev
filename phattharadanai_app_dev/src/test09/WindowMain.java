package test09;

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
		
		MainPage mainPage = new MainPage();
		AddPage addPage = new AddPage();
		EditPage editPage = new EditPage();
		DeletePage deletePage = new DeletePage();
		ViewPage viewPage = new ViewPage();
		ViewListPage viewListPage = new ViewListPage();
		
//		frame.getContentPane().add(mainPage);
		frame.getContentPane().add(addPage);
//		frame.getContentPane().add(editPage);
//		frame.getContentPane().add(deletePage);
//		frame.getContentPane().add(viewPage);
//		frame.getContentPane().add(viewListPage);
		
		
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new WindowMain();
		
	}

}
