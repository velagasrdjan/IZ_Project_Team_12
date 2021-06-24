import javax.swing.*;

import CaseBasedReasoning.CsvConnector;
import CaseBasedReasoning.Model;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.GlobalSimilarityFunction;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.EqualsStringIgnoreCase;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Threshold;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;


public class MainMenu implements StandardCBRApplication {
	
	
	Connector _connector;  /** Connector object */
	CBRCaseBase _caseBase;  /** CaseBase object */
	static CsvConnector ccc=new CsvConnector();
	public static ArrayList<Model> attacks;
	public static JPanel panel;
	NNConfig simConfig;  /** KNN configuration */
	public static JFrame frame;
	
	public static ArrayList<String> res=new ArrayList<String>();
	
	


	
	CsvConnector konektor=new CsvConnector();
	
	
	
	
	

	public void configure() throws ExecutionException {
		_connector =  new CsvConnector();
		
		_caseBase = new LinealCaseBase();  // Create a Lineal case base for in-memory organization
	
		
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average

			
		
			
	// global similarity function = average
		//Name,Risk,Severity,Scope,Impact,Skills,Prerequisites,Mitigations

		
		simConfig.addMapping(new Attribute("name", Model.class), new EqualsStringIgnoreCase());
		// simConfig.addMapping(new Attribute("price", TransactionDescription.class), new Interval(100));
		simConfig.addMapping(new Attribute("risk", Model.class), new EqualsStringIgnoreCase());
		simConfig.addMapping(new Attribute("severity", Model.class), new EqualsStringIgnoreCase());
		simConfig.addMapping(new Attribute("scope", Model.class), new EqualsStringIgnoreCase());
		simConfig.addMapping(new Attribute("impact", Model.class), new EqualsStringIgnoreCase());
		simConfig.addMapping(new Attribute("skills", Model.class), new EqualsStringIgnoreCase());
		simConfig.addMapping(new Attribute("prerequisites", Model.class), new EqualsStringIgnoreCase());
		simConfig.addMapping(new Attribute("mitigations", Model.class), new EqualsStringIgnoreCase());
		System.out.println(" sim conffig  "+simConfig);


		// Equal - returns 1 if both individuals are equal, otherwise returns 0
		// Interval - returns the similarity of two number inside an interval: sim(x,y) = 1-(|x-y|/interval)
		// Threshold - returns 1 if the difference between two numbers is less than a threshold, 0 in the other case
		// EqualsStringIgnoreCase - returns 1 if both String are the same despite case letters, 0 in the other case
		// MaxString - returns a similarity value depending of the biggest substring that belong to both strings
		// EnumDistance - returns the similarity of two enum values as the their distance: sim(x,y) = |ord(x) - ord(y)|
		// EnumCyclicDistance - computes the similarity between two enum values as their cyclic distance
		// Table - uses a table to obtain the similarity between two values. Allowed values are Strings or Enums. The table is read from a text file.
		// TableSimilarity(List<String> values).setSimilarity(value1,value2,similarity) 
	}

	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 5);
		System.out.println("Retrieved cases:");


		if(res.size()==0) {
			
		}else {
			res.clear();
		}
		
		for (RetrievalResult nse : eval) {		
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
		    res.add(nse.get_case().getDescription() + " -> " + nse.getEval());
		}
		
		
		
	}




	public void postCycle() throws ExecutionException {
		
	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
		for (CBRCase c: cases)
		System.out.println("blaaaa "+ c.getDescription().toString());
		
		System.out.println("ajdeee");
		return _caseBase;
	}

	
	
    public static void main (String[] args){
    	
    	
    	
    	
  
	
    	
    	
    	
    	
    	
        GridLayout gl = new GridLayout(5,1);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(gl);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        JButton fuzzy = new JButton("Risk calculation(Fuzzy)");
        fuzzy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI();
            }
        });
        JButton bayes = new JButton("Classification(Bayes)");
        bayes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Bayes();
            }
        });

        

        panel.add(fuzzy);
        panel.add(bayes);


        JButton register = new JButton("Register new attack");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Registration();
            }
        });
        JButton viewAll = new JButton("View all attacks"); // ovde ce biti i izmena postojecih napada
        viewAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Attack> attacks = RemoteDatabase.selectAllQuery();
                new AttackTable(attacks);

            }
        });
        JButton cbr = new JButton("View similarity"); // ovde ce biti i izmena postojecih napada
        cbr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Attack> attacks = RemoteDatabase.selectAllQuery();
                new CbrTable(attacks);

            }
        });

		JButton cbd = new JButton("Find similar attack"); // ovde ce biti i izmena postojecih napada
		cbd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CaseBased();
			}
		});


        panel.add(fuzzy);
        panel.add(bayes);
        panel.add(register);
        panel.add(viewAll);
        panel.add(cbr);
        

        frame.setPreferredSize(new Dimension(400, 300));
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MainMenu");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
       Object[] rowData = new Object[10];
       
      
		frame.repaint();
		frame.revalidate();
    }

	public static ArrayList<String> getRes() {
		return res;
	}

	public static void setRes(ArrayList<String> res) {
		MainMenu.res = res;
	}
}
