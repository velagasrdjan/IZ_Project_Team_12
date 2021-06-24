package CaseBasedReasoning;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;
import ucm.gaia.jcolibri.util.FileIO;

public class CsvConnector  implements Connector  {
	
	public static ArrayList<Model> attacks;
	
	@Override
	public Collection<CBRCase> retrieveAllCases() {
		LinkedList<CBRCase> cases = new LinkedList<CBRCase>();
	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(FileIO.openFile("data/napadi.csv")));
			if (br == null)
				throw new Exception("Error opening file");

			String line = "";
			while ((line = br.readLine()) != null) {
				
				if (line.startsWith("#") || (line.length() == 0))
					continue;
				String[] values = line.split(";");

				CBRCase cbrCase = new CBRCase();

				Model txDescription = new Model();
				
				
				
				txDescription.setName(values[0]);
				System.out.println("Ime jeee   "+ values[0]);
				txDescription.setRisk(values[1]);
				txDescription.setSeverity(values[2]);
				txDescription.setScope(values[3]);
				txDescription.setImpact(values[4]);
				txDescription.setSkills(values[5]);
				txDescription.setPrerequisites(values[6]);
				txDescription.setMitigations(values[7]);
				
				
				cbrCase.setDescription(txDescription);
				cases.add(cbrCase);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cases;
	}

	@Override
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
		return null;
	}

	@Override
	public void storeCases(Collection<CBRCase> arg0) {
	}
	
	@Override
	public void close() {
	}

	@Override
	public void deleteCases(Collection<CBRCase> arg0) {
	}

	@Override
	public void initFromXMLfile(URL arg0) throws InitializingException {
	}

	public static ArrayList<Model> getAttacks() {
		return attacks;
	}

	public static void setAttacks(ArrayList<Model> attacks) {
		CsvConnector.attacks = attacks;
	}
	
	

}
