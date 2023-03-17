package test03;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

public class Test03A  extends JPanel
                              implements ChangeListener {

    protected JColorChooser tcc;
    protected JLabel banner;

    public Test03A() {
        super(new BorderLayout());

        //Set up the banner at the top of the window
        banner = new JLabel("Welcome to the Tutorial Zone!",
                            JLabel.CENTER);
        banner.setForeground(Color.yellow);
        banner.setBackground(Color.blue);
        banner.setOpaque(true);
        banner.setFont(new Font("SansSerif", Font.BOLD, 24));
        banner.setPreferredSize(new Dimension(100, 65));

        JPanel bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.add(banner, BorderLayout.CENTER);
        bannerPanel.setBorder(BorderFactory.createTitledBorder("Banner"));

        //Set up color chooser for setting text color
        tcc = new JColorChooser(banner.getForeground());
        tcc.getSelectionModel().addChangeListener(this);
        tcc.setBorder(BorderFactory.createTitledBorder(
                                             "Choose Text Color"));

        add(bannerPanel, BorderLayout.CENTER);
        add(tcc, BorderLayout.PAGE_END);
    }

    public void stateChanged(ChangeEvent e) {
        Color newColor = tcc.getColor();
        banner.setForeground(newColor);
    }

    public static void main(String[] args) {
    	
    	JFrame frame = new JFrame("Test03A - Color Chooser");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Test03A panel = new Test03A();
    	panel.setOpaque(true);
    	frame.setContentPane(panel);
    	
    	frame.pack();
    	frame.setVisible(true);
    	
    }
}