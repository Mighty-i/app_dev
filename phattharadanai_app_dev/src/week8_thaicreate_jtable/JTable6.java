package week8_thaicreate_jtable;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class JTable6 extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JTable6 frame = new JTable6();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JTable6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 218);
		setTitle("ThaiCreate.Com Java GUI Tutorial");
		getContentPane().setLayout(null);

		// Data Source
		final CustomModel model = new CustomModel();

		// Table
		JTable table = new JTable(model);
		getContentPane().add(table);
		
		// Timer Loop Add Row
		final String name = "Win";
		final String email = "win@thaicreate.com";
		
		Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(name,email);
            }
        });
        timer.start();
		
		// ScrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(69, 34, 358, 106);
		getContentPane().add(scrollPane);

	}
	
}

class CustomModel extends AbstractTableModel {

    List<Member6> dataRow;
    String[] columnHeader = {"Id", "Name", "Email"};
    int id = 0;

    public CustomModel() {
    	dataRow = new ArrayList<Member6>();
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
    	Member6 Member6 = dataRow.get(rowIndex);
        switch (columnIndex) {
        case 0:
            return Member6.getId();
        case 1:
            return Member6.getName();
        case 2:
            return Member6.getEmail();
        default:
            return null;
        }
    }
    
    public void addRow(String name,String email) {
    	id++;
    	dataRow.add(new Member6(id,name, email));
    	 int rowCount = getRowCount();
    	fireTableRowsInserted(rowCount, rowCount);
    }   

}

class Member6 {
	private int id;
    private String name;
    private String email;

    public Member6(int id,String name, String email) {
    	this.id = id;
        this.name = name;
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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