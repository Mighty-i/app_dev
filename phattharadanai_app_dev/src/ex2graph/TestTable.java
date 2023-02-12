/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package ex2graph;

/*
 * SimpleTableDemo.java requires no other files.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestTable extends JPanel implements TableModelListener {
    private boolean DEBUG = false;

    int COL_QUANTITY = 3;
	int COL_PRICE = 2;
	int COL_AMOUNT = 4;
	
	int TOTAL_ROW = 4;
	int TOTAL_COLUMN = 4;
	
	String[] columnNames = { "Product", "Price", "Quantity", "Amount" };

	Object[][] data = { { "Liverpool Stadium Shirt", 750, 0, 0 }, 
						{ "Arsenal Player Shirt", 2750, 0, 0 },
						{ "Manchester United Sweatpants", 1250, 0, 0 },
						{ "Chelsea tracksuit", 1500, 0, 0 },
						{ "total",null, null, 0} 
						
	
	};
		
		

	
	JTable table = new JTable(data, columnNames);

	public TestTable() {
        super(new GridLayout(1,0));

       
        MyTableModel model = new MyTableModel(data , columnNames);
        final JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);
        table.getModel().addTableModelListener(this);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }


	
	private void printDebugData(JTable table) {
    
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("printDebugData()... ");
        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i,j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }


  
    class MyTableModel extends AbstractTableModel {

        private String[] columnNames;
        private Object[][] data;
        
        public MyTableModel(Object[][] data,String[] columnNames) {
        	System.out.println("MyTableModel()...");
        	this.columnNames = columnNames;
        	this.data = data;
        	System.out.println("MyTableModel()");
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
        
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
        //����������Cell��
        public boolean isCellEditable(int row, int col ) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }
        
        public Class getColumnClass1(int col) {
            if (col == TOTAL_COLUMN)
              return Number.class;
            return String.class;
          }
        
      
   


    
    public void setValueAt(Object value, int row, int col) {
    	System.out.println("setValueAt()... Row:" + row + "x" + "col: " + col);
    	
    	if(DEBUG) {
    		System.out.println("Setting Value at " + row + "," + col
    							+ " to " + value
    							+ " (an instance of "
    							+ value.getClass() + ")");
    	}
    	
        data[row][col] = value;
        fireTableCellUpdated(row , col);
        if(col == COL_QUANTITY) {
        try {
        	String strQTY = value.toString();
        	Integer intQTY = Integer.parseInt(strQTY);
        	int qty = intQTY.intValue();
        	String strPrice = data[row][COL_PRICE].toString();
        	Integer intPrice = Integer.parseInt(strPrice);
        	int price = intPrice.intValue();
        	int amount = qty * price;
        	System.out.println("quantity: " + qty + ", price: "+ price + ", amount: " + amount);
        	data[row][COL_AMOUNT] = amount;
        	
        	
        	
        } catch(NumberFormatException ex) {
        	ex.printStackTrace();
        }
      }
        fireTableCellUpdated(row , COL_QUANTITY);
        
      if(DEBUG) {
    	  System.out.println("New value of data: ");
    	  printDebugData();
      }
    }
    

	private void printDebugData() {
    	
    	System.out.println("printDebugData()...");
        int numRows = getRowCount();
        int numCols = getColumnCount();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
	
    }

	/**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        TestTable newContentPane = new TestTable();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    
 	public void tableChanged(TableModelEvent e) {
		if (e.getType() == TableModelEvent.UPDATE) {
			if (e.getColumn() == 2) {
				int totalSum = 0;
				if (String.valueOf(table.getValueAt(e.getFirstRow(), 0)).equals("Arsenal Player Shirt")) {
					String currQtyStr = String.valueOf(table.getValueAt(e.getFirstRow(), e.getColumn()));
					String currPrice = String.valueOf(table.getValueAt(e.getFirstRow(), e.getColumn() - 1));
					int currQty = Integer.parseInt(currQtyStr);
					int sale=0;
					if (currQty > 2) {
						sale = currQty * 20;
					}
					String total = String.valueOf(currQty * Integer.parseInt(currPrice) - sale);
					table.setValueAt(total, e.getFirstRow(), e.getColumn() + 1);
				} else {
					String currPrice = String.valueOf(table.getValueAt(e.getFirstRow(), e.getColumn() - 1));
					String currQty = String.valueOf(table.getValueAt(e.getFirstRow(), e.getColumn()));
					String total = String.valueOf(Integer.parseInt(currQty) * Integer.parseInt(currPrice));
					table.setValueAt(total, e.getFirstRow(), e.getColumn() + 1);
				}
				for(int i =0;i<data.length-1;i++) {
					String amount = String.valueOf(table.getValueAt( i, 3));
					totalSum += Integer.parseInt(amount);
				}
				String totalStr = String.valueOf(totalSum);
				table.setValueAt(totalStr,data.length-1, 3);
				printDebugData(table);
			}
		}
	}
    
    
  
}