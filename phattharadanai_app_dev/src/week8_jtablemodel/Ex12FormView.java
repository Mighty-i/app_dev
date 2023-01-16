package week8_jtablemodel;

	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;
	
	import java.awt.Dimension;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	
	import java.util.ArrayList;
	import java.util.Vector;
	import java.util.Iterator;

	public class Ex12FormView extends JPanel implements ActionListener {
		
		JTable jTable;
		DefaultTableModel model;
		
		Ex12Main ex12Main;


		public Ex12FormView(Ex12Main ex12MainParam) {
			
			ex12Main = ex12MainParam;
			
			setPreferredSize(new Dimension( ex12Main.ex12JMenu.FRAME_WIDTH, ex12Main.ex12JMenu.FRAME_HEIGHT));
			setLayout(null);
			JLabel lbHeader = new JLabel("Ex9 Form View");
			lbHeader.setBounds((ex12Main.ex12JMenu.FRAME_WIDTH-lbHeader.getPreferredSize().width)/2, 10, 
					lbHeader.getPreferredSize().width, lbHeader.getPreferredSize().height);
			add(lbHeader);
			
			int width;
			int height;
			int xl = 10;
			int yl = 30;
			
			JScrollPane jScrollPane = new JScrollPane();
			jScrollPane.setBounds(xl, yl, 
					ex12Main.ex12JMenu.FRAME_WIDTH - xl*2, 
					ex12Main.ex12JMenu.FRAME_HEIGHT - yl*4);
			add(jScrollPane);
			
			jTable = new JTable();
			jScrollPane.setViewportView(jTable);
			
			model = (DefaultTableModel)jTable.getModel();
			model.addColumn("Plate");
			model.addColumn("Model");
			model.addColumn("Make");
			
			JButton btView = new JButton(Ex12JMenu.VIEW_STR);
			width = btView.getPreferredSize().width;
			height = btView.getPreferredSize().height;
			btView.setBounds(Ex12JMenu.FRAME_WIDTH/2-width-10, 
					ex12Main.ex12JMenu.FRAME_HEIGHT - yl*3, width, height);
			add(btView);
			btView.addActionListener(this);
			
			JButton btCancel = new JButton(Ex12JMenu.CANCEL_STR);
			width = btCancel.getPreferredSize().width;
			height = btCancel.getPreferredSize().height;
			btCancel.setBounds(Ex12JMenu.FRAME_WIDTH/2+10, 
					ex12Main.ex12JMenu.FRAME_HEIGHT - yl*3, width, height);
			add(btCancel);
			
		}
		
		public void actionPerformed(ActionEvent evt) {
			
			String command = evt.getActionCommand();
			if(command.equals(Ex12JMenu.VIEW_STR)) {
				ex12Main.viewCars();
					
			}
			
		}
		
		public void setForm(ArrayList<Ex12Car> cars) {
			
			int rows = model.getRowCount();
			for(int i=0; i<rows; i++) {
				model.removeRow(0);
			}
			
			for(Iterator<Ex12Car> it=cars.iterator(); it.hasNext();) {
				Ex12Car car = it.next();
				Vector data = new Vector();
				data.add(String.valueOf(car.plate));
				data.add(car.model);
				data.add(car.make);
				model.addRow(data);
			}
		}
	}