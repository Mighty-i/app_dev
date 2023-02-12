package ex2graph;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Generator extends JPanel implements ActionListener{

//    static final String BOUND_STR = "bound";
//    static final String NUMBER_STR = "number";
//    static final String GENERATE_STR = "Generate";
//    
//    static final int INT_TYPE = 0;
//    static final int DOUBLE_TYPE = 1;
//    
//    JRadioButton intButton;
//    JRadioButton doubleButton;
//    
//    JTextField boundTextField;
//    JTextField numberTextField;
//    
//    JButton genButton;
//    
// 
//    static int typeLabelCol = 25;
//    static int boundTextCol = 120;
//    static int boundLabelCol = 220;
//    static int genButtonCol = 400;
//     
//    static int width = 600;
//    static int height = 50;
//    
//    int type = INT_TYPE;
//    int number = 0;
//    int bound = 0;
    
	static final String INT_STR = "int";
    static final String DOUBLE_STR = "double";
    static final String BOUND_STR = "bound";
    static final String NUMBER_STR = "number";
    static final String GENERATE_STR = "Generate";
    
    static final int INT_TYPE = 0;
    static final int DOUBLE_TYPE = 1;
    
    JRadioButton intButton;
    JRadioButton doubleButton;
    
    JTextField boundTextField;
    JTextField numberTextField;
    
    JButton genButton;
    
    static int typeRadioCol = 10;
    static int typeLabelCol = 25;
    static int boundTextCol = 120;
    static int boundLabelCol = 220;
    static int genButtonCol = 400;
    
    static int intRadioRow = 10;
    static int doubleRadioRow = 50;
    
    static int width = 500;
    static int height = 400;
    
    int type = INT_TYPE;
    static int number = 0;
    static int bound = 0;
    
    RandomNumber randomNumber;
    
    

    public Generator() {
super(new BorderLayout());
        
        setLayout(null);
        setPreferredSize(new Dimension(width, height));

        //Create the radio buttons.
        intButton = new JRadioButton(INT_STR);
        intButton.setMnemonic(KeyEvent.VK_B);
        intButton.setActionCommand(INT_STR);
        intButton.setSelected(true);
        intButton.setBounds(typeRadioCol, intRadioRow, 
        		intButton.getPreferredSize().width, 
        		intButton.getPreferredSize().height);
        add(intButton);
        
        doubleButton = new JRadioButton(DOUBLE_STR);
        doubleButton.setMnemonic(KeyEvent.VK_C);
        doubleButton.setActionCommand(DOUBLE_STR);
        doubleButton.setBounds(typeRadioCol, doubleRadioRow, 
        		doubleButton.getPreferredSize().width, 
        		doubleButton.getPreferredSize().height);
        add(doubleButton);
        
        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(intButton);
        group.add(doubleButton);

        //Register a listener for the radio buttons.
        intButton.addActionListener(this);
        doubleButton.addActionListener(this);

        boundTextField = new JTextField(7);
        boundTextField.setBounds(boundTextCol, intRadioRow, 
        		boundTextField.getPreferredSize().width, 
        		boundTextField.getPreferredSize().height);
        add(boundTextField);
        JLabel boundLabel = new JLabel(BOUND_STR);
        boundLabel.setBounds(boundLabelCol, intRadioRow, 
        		boundLabel.getPreferredSize().width, 
        		boundLabel.getPreferredSize().height);
        add(boundLabel);

        numberTextField = new JTextField(7);
        numberTextField.setBounds(boundTextCol, doubleRadioRow, 
        		numberTextField.getPreferredSize().width, 
        		numberTextField.getPreferredSize().height);
        add(numberTextField);
        JLabel numberLabel = new JLabel(NUMBER_STR);
        numberLabel.setBounds(boundLabelCol, doubleRadioRow, 
        		numberLabel.getPreferredSize().width, 
        		numberLabel.getPreferredSize().height);
        add(numberLabel);
        
        genButton = new JButton(GENERATE_STR);
        genButton.setBounds(genButtonCol, intRadioRow, 
        		genButton.getPreferredSize().width, 
        		genButton.getPreferredSize().height);
        add(genButton);
        genButton.addActionListener(this);
        
        randomNumber = new RandomNumber();
      
    }





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		System.out.println("Command :" + command);
    	if(command.equals(INT_STR)) {
    		type = INT_TYPE;
    	} else if(command.equals(DOUBLE_STR)) {
    		type = DOUBLE_TYPE;	
    	} else if(command.equals(GENERATE_STR)) {
    		String strBound = boundTextField.getText();
    		String strNumber = numberTextField.getText();
    		try {
    			bound = Integer.parseInt(strBound);
    		} catch(NumberFormatException ex) {
    			bound = 0;
//    			 ex.printStackTrace();
    		}
    		try {
    			number = Integer.parseInt(strNumber);
    		} catch(NumberFormatException ex) {
    			number = 0;
    			// ex.printStackTrace();
    		}
    	
    		if(number == 0) {
    			return;
    		}
    		System.out.println(" [!!--Generating--!!] ");
    		if(type == INT_TYPE) {
    			System.out.println("Integer == bound:" + bound + 
        				", number:" + number);
    			int[] array;
    			if(bound == 0) {
    				array = randomNumber.genInt(number);
    			} else {
    				array = randomNumber.genInt(number, bound);
    			}
   
    			ArrayViewer.view1DIntArray(array);
    			
    		} else if(type == DOUBLE_TYPE) {
    			double[] array = randomNumber.genGaussian(number);
    			ArrayViewer.view1DDoubleArray(array);
    		}
    	} 
    	
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        if (path != null) {
            return new ImageIcon(path);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	


}
