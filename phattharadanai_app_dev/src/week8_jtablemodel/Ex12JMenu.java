package week8_jtablemodel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.CardLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex12JMenu extends JFrame implements ActionListener {
	
	public final static int FRAME_WIDTH = 500;
	final public static int FRAME_HEIGHT = 300;
	
	Ex12Main ex12Main;
	
	 Ex12FormAdd ex12FormAdd;
	// Ex12FormEdit ex12FormEdit;
	// Ex12FormDelete ex12FormDelete;
	// Ex12FormSearch ex12FormSearch;
	 Ex12FormViewFruit ex12FormViewFruit;
	Ex12FormView ex12FormView;
	
	JPanel mainPanel;
	
	final static String CAR_STR = "CAR";
	final static String ADD_STR = "Add";
	final static String EDIT_STR = "Edit";
	final static String DELETE_STR = "Delete";
	final static String SEARCH_STR = "Search";
	final static String VIEW_STR = "View";
	final static String VIEWFRUIT_STR = "ViewFruit";
	final static String EXIT_STR = "Exit";
	
	final static String CANCEL_STR = "Cancel";
	
	public Ex12JMenu(Ex12Main ex12Main) {
		
		super("Ex12JMenu Main Frame");
		
		this.ex12Main = ex12Main;
		
//		getContentPane().setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenDim.width-FRAME_WIDTH)/2, (screenDim.height-FRAME_HEIGHT)/2);
		
		JMenuBar jMenuBar = new JMenuBar();
		JMenu mainMenu = new JMenu(CAR_STR);
		JMenuItem menuAdd = new JMenuItem(ADD_STR);
		JMenuItem menuEdit = new JMenuItem(EDIT_STR);
		JMenuItem menuDelete = new JMenuItem(DELETE_STR);
		JMenuItem menuSearch = new JMenuItem(SEARCH_STR);
		JMenuItem menuView = new JMenuItem(VIEW_STR);
		JMenuItem menuViewFruit = new JMenuItem(VIEWFRUIT_STR);
		JMenuItem menuExit = new JMenuItem(EXIT_STR);
		
		menuAdd.addActionListener(this);
		menuEdit.addActionListener(this);
		menuDelete.addActionListener(this);
		menuSearch.addActionListener(this);
		menuView.addActionListener(this);
		menuViewFruit.addActionListener(this);
		menuExit.addActionListener(this);
		
		mainMenu.add(menuAdd);
		mainMenu.add(menuEdit);
		mainMenu.add(menuDelete);
		mainMenu.add(menuSearch);
		mainMenu.add(menuView);
		mainMenu.add(menuViewFruit);
		mainMenu.add(menuExit);
		jMenuBar.add(mainMenu);
		setJMenuBar(jMenuBar);
		
		 ex12FormAdd = new Ex12FormAdd(ex12Main);
		// ex12FormEdit = new Ex12FormEdit(ex12Main);
		// ex12FormDelete = new Ex12FormDelete(ex12Main);
		// ex12FormSearch = new Ex12FormSearch(ex12Main);
		 ex12FormViewFruit = new Ex12FormViewFruit(ex12Main);
		ex12FormView = new Ex12FormView(ex12Main);
		
		mainPanel = new JPanel(new CardLayout());
		 mainPanel.add(ex12FormAdd, ADD_STR);
		// mainPanel.add(ex12FormEdit, EDIT_STR);
		// mainPanel.add(ex12FormDelete, DELETE_STR);
		// mainPanel.add(ex12FormSearch, SEARCH_STR);
		mainPanel.add(ex12FormView, VIEW_STR);
		
		add(mainPanel);

//		add(ex9FormAdd);
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		
		String command = evt.getActionCommand();
		System.out.println("command:" + command);
		Object source = evt.getSource();
		System.out.println("source:" + source.toString());
		if(command.equals(ADD_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, ADD_STR);
		} else if(command.equals(EDIT_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, EDIT_STR);
		} else if(command.equals(DELETE_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, DELETE_STR);
		} else if(command.equals(SEARCH_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, SEARCH_STR);
		} else if(command.equals(VIEW_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, VIEW_STR);
		} else if(command.equals(EXIT_STR)) {
			System.exit(0);
		}
		
	}

}
