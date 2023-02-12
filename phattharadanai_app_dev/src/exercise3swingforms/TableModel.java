package exercise3swingforms;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{
	private String[] columnNames;
	private Object[][] data;
	
	int colPrice = 3;
	int colQuantity = 4;
	int colAmount = 5;

	public TableModel(Object[][] data, String[] columnNames) {
		this.columnNames = columnNames;
		this.data = data;
		System.out.println("TableModel()");
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

	public boolean isCellEditable(int row, int col) {

		if (col < 1 && col < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void setValueAt(Object value, int row, int col) {
		System.out.println("setValueAt() row:" + row + " " + "col:" + col);

		data[row][col] = value;
		fireTableCellUpdated(row, col);
		if (col == colQuantity) {
			try {
				String strQuantity = value.toString();
				Integer intQuantity = Integer.parseInt(strQuantity);
				int quantity = intQuantity.intValue();
				String strPrice = data[row][colPrice].toString();
				Integer intPrice = Integer.parseInt(strPrice);
				int price = intPrice.intValue();
				int amount = quantity * price;
				data[row][colAmount] = amount;
				System.out.println("Quantity:"+quantity+" x Price:"+price+" = Amount:"+amount);

			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		fireTableCellUpdated(row, colQuantity);
	}
}
