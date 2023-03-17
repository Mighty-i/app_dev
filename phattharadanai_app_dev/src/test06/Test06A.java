package test06;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test06A extends JPanel implements KeyListener {

	public Test06A () {
		
		setPreferredSize(new Dimension(500, 300));
		setBackground(Color.CYAN);
		setOpaque(true);
		
		JTextArea textArea = new JTextArea(10, 30);
		textArea.addKeyListener(this);
		add(textArea);
		
	}

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Test05A");
		frame.setContentPane(new Test06A());
		
		frame.pack();
		frame.setVisible(true);;
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyTyped()");
		char keyChar = e.getKeyChar();
		System.out.println("keyChar:" + keyChar);
		int keyCode = e.getKeyCode();
		System.out.println("keyCode:" + keyCode);
		int modifier = e.getModifiers();
		System.out.println("modifier:" + modifier);
		String modifierText = e.getKeyModifiersText(modifier);
		System.out.println("modifierText:" + modifierText);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyTyped()");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyTyped()");
		
	}
	
}
