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
import java.util.Collection;


public class MainMenu implements StandardCBRApplication {
	
	
	Connector _connector;  /** Connector object */
	CBRCaseBase _caseBase;  /** CaseBase object */
	static CsvConnector ccc=new CsvConnector();
	public static ArrayList<Model> attacks;
	public static JPanel panel;
	NNConfig simConfig;  /** KNN configuration */
	public static JFrame frame;
	
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
		for (RetrievalResult nse : eval)
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
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
    	
    	
    	
    	
    	
    	Collection<CBRCase> attacks=ccc.retrieveAllCases();
    	System.out.println("Napadi suu  "+attacks);
    	
    	StandardCBRApplication recommender = new MainMenu();
		try {
			recommender.configure();

			recommender.preCycle();
			
			
			///////////////////////////////izlistaj sve podatke
			

			CBRQuery query = new CBRQuery();
			
			Model model=new Model();
			
			//	//Name,Risk,Severity,Scope,Impact,Skills Required,Prerequisites,Mitigations
//Collect Data from Common Resource Locations;none;Medium;none;none;none;none;none

			model.setName("Collect Data from Common Resource Locations");
			model.setRisk("none");
			model.setSeverity("Medium");
			model.setScope("none");
			model.setImpact("none");
			model.setSkills("none");
			model.setPrerequisites("none");
			model.setMitigations("none");
			
			query.setDescription(model);
			recommender.cycle(query);

			recommender.postCycle();
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
    	
    	
    	
    	
    	
        GridLayout gl = new GridLayout(4,1);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(gl);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        JButton fuzzy = new JButton("Fuzzy");
        fuzzy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI();
            }
        });
        JButton bayes = new JButton("Bayes");
        bayes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Bayes();
            }
        });
        
        JButton allAttacks = new JButton("Attacks");
        allAttacks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Attacks();
            }
        });
        panel.add(fuzzy);
        panel.add(bayes);
        panel.add(allAttacks);

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
}
