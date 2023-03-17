package test07;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Test07A extends JPanel implements ActionListener {
          
    BufferedImage img;
    JFileChooser fc;
    JButton btnOpen;
    ImageComponent imageComponent;

    class ImageComponent extends JPanel {
    	public ImageComponent() {
    		setPreferredSize(new Dimension(500, 280));
    		setOpaque(true);
    	}
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, 500, 280, null);
            System.out.println("ImageComponent.paint()");
        }
    }

    public Test07A() {
    	
    	setLayout(null);
    	setPreferredSize(new Dimension(500, 300));
    	fc = new JFileChooser();
    	
    	loadImage("images/java-logo.png");
    	
    	imageComponent = new ImageComponent();
    	imageComponent.setBounds(0, 0, 500, 280);
    	add(imageComponent);

       btnOpen = new JButton("Open");
       btnOpen.addActionListener(this);
       btnOpen.setBounds(0, 275, btnOpen.getPreferredSize().width, 
    		   btnOpen.getPreferredSize().height);
       add(btnOpen);

    }
    
    private void loadImage(String fname) {
    	
        try {
            img = ImageIO.read(new File(fname));
        } catch (IOException e) {
        }
    	
    }

    public void actionPerformed(ActionEvent e) {
    	 int returnVal = fc.showOpenDialog(Test07A.this);
    	 System.out.println("returnVal:" + returnVal);
    	 
         if (returnVal == JFileChooser.APPROVE_OPTION) {
             File file = fc.getSelectedFile();
             //This is where a real application would open the file.
             System.out.println("Opening: " + file.getPath());
             loadImage(file.getPath());
             System.out.println("calling imageCompontnt.repaint()");
             imageComponent.repaint();
             
         } else {
             System.out.println("Open command cancelled by user.");
         }
    	
    }
    
    public static void main(String[] args) {

        JFrame f = new JFrame("Load Image Sample");
            
        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        f.add(new Test07A());
        f.pack();
        f.setVisible(true);
    }
}
