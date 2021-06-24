import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import unbbayes.prs.bn.ProbabilisticNetwork;

public class Attacks {
	
	 public Attacks(){
	       // ProbabilisticNetwork net = load();

	        GridLayout gl = new GridLayout(35,8);
	        JFrame frame = new JFrame();
	        JPanel panel = new JPanel(gl);
	        panel.setBorder(BorderFactory.createEmptyBorder(60,60,10,60));
	       // String[] lowStrings = {"low","medium","high"};
			/*
			 * String[] noStrings = {"yes","no"};
			 */
	        JLabel Name = new JLabel("Name: ");
	        //JComboBox comboRisk = new JComboBox(lowStrings);

/*	        JLabel labelAccessControl = new JLabel("Access control: ");
	        JComboBox comboAccessControl = new JComboBox(lowStrings);

	        JLabel labelReadData = new JLabel("Read data: ");
	        JComboBox comboReadData = new JComboBox(lowStrings);

	        JLabel labelSeverity = new JLabel("Severity: ");
	        JComboBox comboSeverity = new JComboBox(lowStrings);

	        JLabel labelConfidentiality = new JLabel("Confidentiality: ");
	        JComboBox comboConfidentiality = new JComboBox(lowStrings);

	        JLabel labelModifyData = new JLabel("Modify data: ");
	        JComboBox comboModifyData = new JComboBox(lowStrings);

	        JLabel labelIntegrity = new JLabel("Integrity: ");
	        JComboBox comboIntegrity = new JComboBox(lowStrings);

	        JLabel labelAuthorization = new JLabel("Authorization: ");
	        JComboBox comboAuthorization = new JComboBox(lowStrings);

	        JLabel labelBadSecurity = new JLabel("Bad security system: ");
	        JComboBox comboBadSecurity = new JComboBox(noStrings);

	        JLabel labelAntivirus = new JLabel("Outdated antivirus: ");
	        JComboBox comboAntivirus = new JComboBox(noStrings);

	        JLabel labelConnection = new JLabel("Poor connection: ");
	        JComboBox comboConnection = new JComboBox(noStrings);

	        JLabel labelCompany = new JLabel("Company: ");
	        JComboBox comboCompany = new JComboBox(noStrings);

	        JLabel labelSoftware = new JLabel("Installing malicious software: ");
	        JComboBox comboSoftware = new JComboBox(noStrings);

	        JLabel labelStorage = new JLabel("Poor data storage: ");
	        JComboBox comboStorage = new JComboBox(noStrings);

	        JButton calculate = new JButton("Calculate");
	        calculate.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                risk = comboRisk.getSelectedIndex();
	                System.out.println(risk);
	                access_control = comboAccessControl.getSelectedIndex();
	                System.out.println(access_control);
	                read_data = comboReadData.getSelectedIndex();
	                System.out.println(read_data);
	                severity = comboSeverity.getSelectedIndex();
	                System.out.println(severity);
	                confidentiality = comboConfidentiality.getSelectedIndex();
	                System.out.println(confidentiality);
	                modify_data = comboModifyData.getSelectedIndex();
	                System.out.println(modify_data);
	                integrity = comboIntegrity.getSelectedIndex();
	                System.out.println(integrity);
	                authorization = comboAuthorization.getSelectedIndex();
	                System.out.println(authorization);
	                bad_security_system = comboBadSecurity.getSelectedIndex();
	                System.out.println(bad_security_system);
	                outdated_antivirus = comboAntivirus.getSelectedIndex();
	                System.out.println(outdated_antivirus);
	                poor_connection = comboConnection.getSelectedIndex();
	                System.out.println(poor_connection);
	                small_company = comboCompany.getSelectedIndex();
	                System.out.println(small_company);
	                installing_malicious_software = comboSoftware.getSelectedIndex();
	                System.out.println(installing_malicious_software);
	                poor_data_storage = comboStorage.getSelectedIndex();
	                System.out.println(poor_data_storage);
	                evidence(net);
	            }
	        });

	        panel.add(labelRisk);
	        panel.add(comboRisk);
	        panel.add(labelAccessControl);
	        panel.add(comboAccessControl);
	        panel.add(labelReadData);
	        panel.add(comboReadData);
	        panel.add(labelSeverity);
	        panel.add(comboSeverity);
	        panel.add(labelConfidentiality);
	        panel.add(comboConfidentiality);
	        panel.add(labelModifyData);
	        panel.add(comboModifyData);
	        panel.add(labelIntegrity);
	        panel.add(comboIntegrity);
	        panel.add(labelAuthorization);
	        panel.add(comboAuthorization);
	        panel.add(labelBadSecurity);
	        panel.add(comboBadSecurity);
	        panel.add(labelAntivirus);
	        panel.add(comboAntivirus);
	        panel.add(labelConnection);
	        panel.add(comboConnection);
	        panel.add(labelCompany);
	        panel.add(comboCompany);
	        panel.add(labelSoftware);
	        panel.add(comboSoftware);
	        panel.add(labelStorage);
	        panel.add(comboStorage);

	        panel.add(calculate);
	        frame.setContentPane(panel);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setTitle("Bayes calculator");
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);

	    }
*/
	 }
}
