package ex2graph;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;

public class RandomNumber extends JPanel
implements ActionListener {
	
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
    int number = 0;
    int bound = 0;

	Random random;
	
	int[] genInt(int number) {
		int[] figures = new int[number];
		for(int i=0; i<number; i++) {
			int figure = random.nextInt();
			figures[i] = figure;
		}
		
		return figures;
	}
	
	int[] genInt(int number, int bound) {
		
		int[] figures = new int[number];
		for(int i=0; i<number; i++) {
			int figure = random.nextInt(bound);
			figures[i] = figure;
		}
		
		return figures;
		
	}
	
	double[] genGaussian(int number) {
		
		double[] figures = new double[number];
		for(int i=0; i<number; i++) {
			double figure = random.nextGaussian();
			figures[i] = figure;
		}
		
		return figures;

	}
	
	public RandomNumber() {
		
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
		
		random = new Random(System.currentTimeMillis());
		number = 0;
		bound = 0;
	}
	
	
	public static void test() {
		RandomNumber randomNumber = new RandomNumber();
		randomNumber.number = 100;
		int[] intFigures = randomNumber.genInt(randomNumber.number);
		int counter = 0;
		for(int figure : intFigures) {
			System.out.println("intFigures[" + counter + "]:" + intFigures[(counter++)] + 
					", " + figure);
		}
		
		int bound = 1000;
		intFigures = randomNumber.genInt(randomNumber.number, bound);
		counter = 0;
		for(int figure : intFigures) {
			System.out.println("intFigures[" + counter + "]:" + intFigures[(counter++)] +
					", " + figure);
		}
		
		double[] doubleFigures = randomNumber.genGaussian(randomNumber.number);
		counter = 0;
		for(double figure : doubleFigures) {
			System.out.println("doubleFigures[" + counter + "]:" + doubleFigures[(counter++)] +
					", " + figure);
		}

	
	}
	public static void main(String[] args) {
		
		test();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}