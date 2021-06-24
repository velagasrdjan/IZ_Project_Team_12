import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import CaseBasedReasoning.Model;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;


class ButtonCellRenderer extends JButton implements TableCellRenderer{
    public Component getTableCellRendererComponent(JTable aTable, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column){
        setText(value.toString());
        return this;
    }
}

public class Cbr {

	
	public  ArrayList<Result> newRes=new ArrayList<Result>();

	public Cbr(Attack a) {
		
    	StandardCBRApplication recommender = new MainMenu();

		try {
			recommender.configure();

			recommender.preCycle();


			///////////////////////////////izlistaj sve podatke


			CBRQuery query = new CBRQuery();

			Model model=new Model();

			//	//Name,Risk,Severity,Scope,Impact,Skills Required,Prerequisites,Mitigations
//Collect Data from Common Resource Locations;none;Medium;none;none;none;none;none

			model.setName(a.getName());
			model.setRisk(a.getRisk());
			model.setSeverity(a.getSeverity());
			model.setScope(a.getScope());
			model.setImpact(a.getImpact());
			model.setSkills(a.getSkills_required());
			model.setPrerequisites(a.getPrerequisites());
			model.setMitigations(a.getMitigations());
            
			query.setDescription(model);
			recommender.cycle(query);
			
			
			for(String s:MainMenu.res) {
				Result r=new Result(s);
				newRes.add(r);
				System.out.println("jedannn "+r.getRess());
				
				

			}

			recommender.postCycle();


		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		 JFrame frame = new JFrame();
	        JPanel panel = new JPanel();

	        String[] columnNames = {"Similar attacks"};

	        String[][] data = new String[newRes.size()][columnNames.length];
	        for(int i=0; i<newRes.size(); i++){
	                data[i]= new String[]
	                        { newRes.get(i).ress};

	        }

	      

	        DefaultTableModel dm = new DefaultTableModel();
	        dm.setDataVector(data, columnNames);
	        JTable table = new JTable(dm);


	        
	        
	        
	        
	        table.setBounds(30, 40, 200, 300);

	        // adding it to JScrollPane
	        JScrollPane sp = new JScrollPane(table);
	        table.setPreferredScrollableViewportSize(table.getPreferredSize());
	        table.getColumnModel().getColumn(0).setPreferredWidth(100);
	        

	       frame.add(sp);
	        //frame.add(register);
	        // Frame Size
	        frame.setSize(800, 400);
	        // Frame Visible = true
	        frame.setVisible(true);
		
		
		
	}
	

}
