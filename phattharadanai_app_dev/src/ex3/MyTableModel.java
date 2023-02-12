package ex3;

import javax.swing.table.AbstractTableModel;



public class MyTableModel extends AbstractTableModel{
	private String[] columnNames;
	private Object[][] data;
	
	int COL_PRICE = 2;
	int COL_QUANTITY = 3;
	int COL_AMOUNT = 4;
	
	
	
	public MyTableModel(Object[][] data, String[] columnNames) {
		this.columnNames = columnNames;
		this.data = data;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	public String getColumnName(int col) {

		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {

		return data[row][col];
	}

	public boolean isCellEditable(int row, int col) {

        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }
	@Override
	public void setValueAt(Object value, int row, int col) {
		// TODO Auto-generated method stub
		
		data[row][col] = value;
		fireTableCellUpdated(row, col);
		if (col == COL_QUANTITY) {
			try {
				String strQuantity = value.toString();
				Integer intQuantity = Integer.parseInt(strQuantity);
				int quantity = intQuantity.intValue();
				String strPrice = data[row][COL_PRICE].toString();
				Integer intPrice = Integer.parseInt(strPrice);
				int price = intPrice.intValue();
				int amount = quantity * price;
				data[row][COL_AMOUNT] = amount;
				System.out.println("Quantity:"+quantity+" x Price:"+price+" = Amount:"+amount);

			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		fireTableCellUpdated(row, COL_QUANTITY);
	}
	}


