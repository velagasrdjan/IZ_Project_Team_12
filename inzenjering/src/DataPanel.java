

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import CaseBasedReasoning.Model;


public class DataPanel extends JPanel {
private static final long serialVersionUID = 1L;
	
	public static JPanel panelView;
	
	public static JScrollPane scroll;
	
	public static JTable t;
	
	public static DefaultTableModel model;
	
	public static Model selectedPatient;
	
	public static JLabel labela1;

	@SuppressWarnings("serial")
	public DataPanel(){
		panelView = new JPanel();
		
		BorderLayout layout = new BorderLayout();
		panelView.setLayout(layout);
		panelView.setBackground(Color.lightGray);
		panelView.setBorder(BorderFactory.createLineBorder(Color.black));
		panelView.setPreferredSize(new Dimension(700,500));
		panelView.setMinimumSize(new Dimension(700,500));
		MainMenu.frame.getContentPane().add(panelView, "East");
		
		//inicijalizacija tabele
		model = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		t = new JTable(model);
		
		model.addColumn("Ime");
		model.addColumn("Prezime");
		model.addColumn("Godine");
		model.addColumn("Pol");
		model.addColumn("Pusac");
		model.addColumn("Sportista");
		model.addColumn("Simptom");
		model.addColumn("Bolest");
		model.addColumn("Lek");
		model.addColumn("Procedura");
		t.getColumnModel().getColumn(0).setPreferredWidth(59);
		t.getColumnModel().getColumn(1).setPreferredWidth(59);
		t.getColumnModel().getColumn(2).setPreferredWidth(47);
		t.getColumnModel().getColumn(3).setPreferredWidth(47);
		t.getColumnModel().getColumn(4).setPreferredWidth(40);
		t.getColumnModel().getColumn(5).setPreferredWidth(40);
		t.getColumnModel().getColumn(6).setPreferredWidth(59);
		t.getColumnModel().getColumn(7).setPreferredWidth(59);
		t.getColumnModel().getColumn(8).setPreferredWidth(59);
		t.getColumnModel().getColumn(9).setPreferredWidth(59);
		t.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		t.setRowHeight(20);
		
		//popunjavanje tabele vrednostima iz liste "Main.pacijenti"
		
		////Name,Risk,Severity,Scope,Impact,Skills Required,Prerequisites,Mitigations
/*
		Object[] rowData = new Object[10];
		
		for(int i = 0; i < MainMenu.pacijenti.size(); i++){		
				rowData[0] = MainMenu.pacijenti.get(i).getName();
				rowData[1] = MainMenu.pacijenti.get(i).getRisk();
				rowData[2] = MainMenu.pacijenti.get(i).getSeverity();
				rowData[3] = MainMenu.pacijenti.get(i).getScope();
				rowData[4] = MainMenu.pacijenti.get(i).getImpact();
				rowData[5] = MainMenu.pacijenti.get(i).getSkills();
				rowData[6] = MainMenu.pacijenti.get(i).getPrerequisites();
				
				model.addRow(rowData);
		}
		
	*/
		
}
}
