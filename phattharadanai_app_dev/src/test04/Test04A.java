package test04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

import test03.Test03A;

public class Test04A extends JPanel
                             implements ActionListener {
    static private final String newline = "\n";
    JButton openButton, saveButton;
    JFileChooser fc;

    public Test04A () {
        super(new BorderLayout());


        fc = new JFileChooser();

        openButton = new JButton("Open a File...");
        openButton.addActionListener(this);

        saveButton = new JButton("Save a File...");
        saveButton.addActionListener(this);

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);

        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
    }

    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(Test04A.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                System.out.println("Opening: " + file.getName() + "." + newline);
                
            } else {
                System.out.println("Open command cancelled by user." + newline);
            }

        //Handle save button action.
        } else if (e.getSource() == saveButton) {
            int returnVal = fc.showSaveDialog(Test04A.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
                System.out.println("Saving: " + file.getName() + "." + newline);
            } else {
                System.out.println("Save command cancelled by user." + newline);
            }
        }
    }

    public void writeFile(String fName) {
    	
		String fileName = "Data-Written-For-Test04.txt";
		fileName = fName;
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
	        Date today = new Date();
	        SimpleDateFormat formatter =
	           new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");
	        String dateString = formatter.format(today);

			
			bw = new BufferedWriter(new FileWriter(fileName));
			bw.write("Data-Written-For-Test04.txt:" + dateString);
			bw.close();
        } catch (IllegalArgumentException iae) {
            System.err.println("Error: " + iae.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();
		}

    	
    }
    
    public void readFile(String fName) {
    	
		String fileName = "files/StudentMarks.txt";
		fileName = fName;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
    }
    
    public static void main(String[] args) {
    	
    	JFrame frame = new JFrame("Test04A - Color Chooser");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Test04A panel = new Test04A();
    	panel.setOpaque(true);
    	frame.setContentPane(panel);
    	
    	frame.pack();
    	frame.setVisible(true);
    }
}