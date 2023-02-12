package ex3;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class JTableAmountModel extends JPanel implements TableModelListener {
    private boolean DEBUG = true;
    
    int COL_PRICE = 2;
	int COL_QUANTITY = 3;
	int COL_AMOUNT = 4;


    public JTableAmountModel() {
        super(new GridLayout(1,0));

        String[] columnNames = {"Good",
                                "Unit Name",
                                "Price",
                                "Quantity",
                                "Amount"};

       
        MyTableModel model = new MyTableModel( columnNames);
        final JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.getModel().addTableModelListener(this);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        JScrollPane scrollPane = new JScrollPane(table);

 
        add(scrollPane);
    }

    private void printDebugData(JTable table) {
    }

    public void tableChanged(TableModelEvent ev) {

    }
    
    class MyTableModel extends AbstractTableModel {
    	
        private String[] columnNames;
        private Object[][] data;

        public MyTableModel( String[] columnNames) {
        	
        	dao goodDAO = new dao();
        	ArrayList<good> goods = goodDAO.ViewDAO();
        	
        	Object[][] data = new Object[goods.size()][];
        	int j=0;
        	for(good good:goods) {
        		Object obj[] = new Object[5];
        		obj[0] = good.getGood();
        		obj[1] = good.getName();
        		obj[2] = good.getPrice();
        		obj[3] = good.getQty();
        		obj[4] = good.getAmount();
        		data[j++] = obj;	
        	}
       		this.columnNames = columnNames;
       		this.data = data;
     
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

        public boolean isCellEditable(int row, int col) {

            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        public void setValueAt(Object value, int row, int col) {
        	System.out.println("setValueAt()... row:" + row + "x" + "col:" + col);
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }

            data[row][col] = value;
            fireTableCellUpdated(row, col);
            if(col == COL_QUANTITY) {
            	try {
            		String strQuantity = value.toString();
                	Integer intQuantity = Integer.parseInt(strQuantity);
                	int quantity = intQuantity.intValue();
                	String strPrice = data[row][COL_PRICE].toString();
                	Integer intPrice = Integer.parseInt(strPrice);
                	int price = intPrice.intValue();
                	int amount = quantity * price;
                	System.out.println("quantity:" + quantity + ", price:" + price +
                			", amount:" + amount);
                	data[row][COL_AMOUNT] = amount;
            	} catch(NumberFormatException ex) {
            		ex.printStackTrace();
            	}
            }
            fireTableCellUpdated(row, COL_QUANTITY);

            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void printDebugData() {
        	System.out.println("printDebugData()...");
            int numRows = getRowCount();
            int numCols = getColumnCount();

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

    
    private static void createAndShowGUI() {
   
        JFrame frame = new JFrame("JTableAmount");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
        JTableAmountModel newContentPane = new JTableAmountModel();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
