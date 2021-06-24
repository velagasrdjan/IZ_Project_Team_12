import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
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



public class Cbr {

	
	public  ArrayList<Result> newRes=new ArrayList<Result>();

	public Cbr(Attack a) {
		
    	StandardCBRApplication recommender = new MainMenu();
		try {
			recommender.configure();
			recommender.preCycle();

			CBRQuery query = new CBRQuery();

			Model model=new Model();
		
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
				String[] ss=r.getRess().split("=");
				String[] ss1=ss[8].split("]");
				String mitigations=ss1[0];
				System.out.println("Mitigations "+mitigations );
				
			}

			recommender.postCycle();

		} catch (Exception e) {
			e.printStackTrace();
		}

		 JFrame frame = new JFrame();
	        JPanel panel = new JPanel();

	        String[] columnNames = {"Similar attacks","Similarity percentage"};

	        String[][] data = new String[newRes.size()][columnNames.length];
	        for(int i=0; i<newRes.size(); i++){
	        		String[] split1 = newRes.get(i).ress.split("=");
	        		String[] split2 = split1[1].split(",");
					String[] split3 = newRes.get(i).ress.split("->");

	                data[i]= new String[]
	                        {
	                        		split2[0],
									split3[1].trim()
	                        		//newRes.get(i).ress
	                        };

	        }

	        DefaultTableModel dm = new DefaultTableModel();
	        dm.setDataVector(data, columnNames);
	        JTable table = new JTable(dm);
	        
	        table.setBounds(30, 40, 200, 300);

	       
	        JScrollPane sp = new JScrollPane(table);
	        table.setPreferredScrollableViewportSize(table.getPreferredSize());
	        table.getColumnModel().getColumn(0).setPreferredWidth(100);
	        

	       frame.add(sp);
	       
	        frame.setSize(800, 400);
		frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
		
		
		
	}
	

}
