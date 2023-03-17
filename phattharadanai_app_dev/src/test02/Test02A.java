package test02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Test02A  extends JPanel
                           implements ActionListener {
    static JFrame frame;
    JLabel resultLabel;
    String currentPattern;

    public Test02A() {
        setLayout(null);
        setPreferredSize(new Dimension(500, 300));
        String[] patternExamples = {
                 "dd MMMMM yyyy",
                 "dd.MM.yy",
                 "MM/dd/yy",
                 "yyyy.MM.dd G 'at' hh:mm:ss z",
                 "EEE, MMM d, ''yy",
                 "h:mm a",
                 "H:mm:ss:SSS",
                 "K:mm a,z",
                 "yyyy.MMMMM.dd GGG hh:mm aaa"
                 };

        currentPattern = patternExamples[0];

        //Set up the UI for selecting a pattern.
        JLabel patternLabel = new JLabel("Enter a pattern or choose one from the list:");
        patternLabel.setBounds(10,10, patternLabel.getPreferredSize().width, 
        		patternLabel.getPreferredSize().height);
        

        JComboBox patternList = new JComboBox(patternExamples);
        patternList.setEditable(true);
        patternList.addActionListener(this);
        patternList.setBounds(10, 40, patternList.getPreferredSize().width, 
        		patternList.getPreferredSize().height);

        //Create the UI for displaying result.
        resultLabel = new JLabel("Current Date/Time"); //== LEFT
        resultLabel.setBounds(10, 70, 400, 
        		resultLabel.getPreferredSize().height);

        add(patternLabel);
        add(patternList);
        add(resultLabel);
    } //constructor

    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String newSelection = (String)cb.getSelectedItem();
        currentPattern = newSelection;
        reformat();
    }

    /** Formats and displays today's date. */
    public void reformat() {
        Date today = new Date();
        SimpleDateFormat formatter =
           new SimpleDateFormat(currentPattern);
        try {
            String dateString = formatter.format(today);
            resultLabel.setForeground(Color.BLACK);
            resultLabel.setText("Current Date/Time:" + dateString);
        } catch (IllegalArgumentException iae) {
            resultLabel.setForeground(Color.red);
            resultLabel.setText("Error: " + iae.getMessage());
        }
    }

    public static void main(String[] args) {
    	JFrame frame = new JFrame("Test02A - Combo Box");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Test02A panel = new Test02A();
    	panel.setOpaque(true);
    	frame.setContentPane(panel);
    	
    	frame.pack();
    	frame.setVisible(true);
    }
}