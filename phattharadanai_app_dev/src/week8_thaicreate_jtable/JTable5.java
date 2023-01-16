package week8_thaicreate_jtable;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class JTable5 extends JFrame {


	/**
	 * Create the frame.
	 */
	public JTable5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 218);
		setTitle("ThaiCreate.Com Java GUI Tutorial");
		getContentPane().setLayout(null);

		// Data Source
		CustomModel model = new CustomModel();

		// Table
		JTable table = new JTable(model);
		getContentPane().add(table);
		
		// ScrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(69, 46, 358, 78);
		getContentPane().add(scrollPane);

	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JTable5 frame = new JTable5();
				frame.setVisible(true);
			}
		});
	}


}

class CustomModel extends AbstractTableModel {

    List<Member> dataRow;
    String[] columnHeader = {"Name", "Email"};

    public CustomModel() {
    	dataRow = new ArrayList<Member>();

    	dataRow.add(new Member("Win", "win@thaicreate.com"));
    	dataRow.add(new Member("Eak", "eak@thaicreate.com"));
    	dataRow.add(new Member("Chai", "chai@thaicreate.com"));
    	dataRow.add(new Member("Sorn", "sorn@thaicreate.com"));
    	dataRow.add(new Member("Keng", "keng@thaicreate.com"));
    	dataRow.add(new Member("Toro", "toro@thaicreate.com"));

    }

    @Override
    public String getColumnName(int column) {
        return columnHeader[column];
    }

    @Override
    public int getColumnCount() {
        return columnHeader.length;
    }

    @Override
    public int getRowCount() {
        return dataRow.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	Member member = dataRow.get(rowIndex);
        switch (columnIndex) {
        case 0:
            return member.getName();
        case 1:
            return member.getEmail();
        default:
            return null;
        }
    }
    

}

class Member {
    private String name;
    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}