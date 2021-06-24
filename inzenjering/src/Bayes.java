import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;

import unbbayes.io.BaseIO;
import unbbayes.io.NetIO;
import unbbayes.prs.Node;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.ProbabilisticNode;
import unbbayes.util.extension.bn.inference.IInferenceAlgorithm;

public class Bayes {

    private static int risk = 0;
    private static int access_control = 0;
    private static int read_data = 0;
    private static int severity = 0;
    private static int confidentiality = 0;
    private static int modify_data = 0;
    private static int integrity = 0;
    private static int authorization = 0;
    private static int bad_security_system = 0;
    private static int outdated_antivirus = 0;
    private static int poor_connection = 0;
    private static int small_company = 0;
    private static int installing_malicious_software = 0;
    private static int poor_data_storage = 0;



    public ProbabilisticNetwork load() {
        // loading from file
        String fileName = "data/bayes.net";
        ProbabilisticNetwork net = new ProbabilisticNetwork("bayes");
        BaseIO io = new NetIO();
        try {
            net = (ProbabilisticNetwork) io.load(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (net == null) {
            System.err.println("Can't load file: '" + fileName + "'");
            return null;
        }

        // compiling
        IInferenceAlgorithm algorithm = new JunctionTreeAlgorithm();
        algorithm.setNetwork(net);
        algorithm.run();

        // states overview
        /*List<Node> nodeList = net.getNodes();
        for (Node node : nodeList) {
            System.out.println(node.getName());
            for (int i = 0; i < node.getStatesSize(); i++) {
                System.out.println(node.getStateAt(i) + ": " + ((ProbabilisticNode) node).getMarginalAt(i));
            }
        }*/
        return net;
    }
    public void evidence(ProbabilisticNetwork net){

        // adding an evidence
        ProbabilisticNode factNode1 = (ProbabilisticNode)net.getNode("Risk");
        ProbabilisticNode factNode2 = (ProbabilisticNode)net.getNode("Access_Control");
        ProbabilisticNode factNode3 = (ProbabilisticNode)net.getNode("Read_Data");
        ProbabilisticNode factNode4 = (ProbabilisticNode)net.getNode("Severity");
        ProbabilisticNode factNode5 = (ProbabilisticNode)net.getNode("Confidentiality");
        ProbabilisticNode factNode6 = (ProbabilisticNode)net.getNode("Modify_Data");
        ProbabilisticNode factNode7 = (ProbabilisticNode)net.getNode("Integrity");
        ProbabilisticNode factNode8 = (ProbabilisticNode)net.getNode("Authorization");
        ProbabilisticNode factNode9 = (ProbabilisticNode)net.getNode("Bad_Security_System");
        ProbabilisticNode factNode10 = (ProbabilisticNode)net.getNode("Outdated_Antivirus");
        ProbabilisticNode factNode11 = (ProbabilisticNode)net.getNode("Poor_Connection");
        ProbabilisticNode factNode12 = (ProbabilisticNode)net.getNode("Small_Company");
        ProbabilisticNode factNode13 = (ProbabilisticNode)net.getNode("Installing_malicious_software");
        ProbabilisticNode factNode14 = (ProbabilisticNode)net.getNode("Poor_Data_Storage");

        factNode1.addFinding(risk, true);
        factNode2.addFinding(access_control,true);
        factNode3.addFinding(read_data,true);
        factNode4.addFinding(severity,true);
        factNode5.addFinding(confidentiality,true);
        factNode6.addFinding(modify_data,true);
        factNode7.addFinding(integrity,true);
        factNode8.addFinding(authorization,true);

        factNode9.addFinding(bad_security_system,true);
        factNode10.addFinding(outdated_antivirus,true);
        factNode11.addFinding(poor_connection,true);
        factNode12.addFinding(small_company,true);
        factNode13.addFinding(installing_malicious_software,true);
        factNode14.addFinding(poor_data_storage,true);

        // propagation
        try {
            net.updateEvidences();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // states overview after propagation
        List<Node> nodeList = net.getNodes();
        List<Node> nodeListLief = new ArrayList<>();
        for(Node nodeLief: nodeList){
            if (nodeLief.getChildren().isEmpty() == true) {
                nodeListLief.add(nodeLief);
            }
        }
        Collections.sort(nodeListLief, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(((ProbabilisticNode) o1).getMarginalAt(0) > ((ProbabilisticNode) o2).getMarginalAt(0)){
                    return -1;
                }else if(((ProbabilisticNode) o1).getMarginalAt(0) < ((ProbabilisticNode) o2).getMarginalAt(0)) return 1;
                else return 0;
            }
        });
        DecimalFormat df = new DecimalFormat("###.###");
        String max1 = nodeListLief.get(0).getName() + " " + ": " + df.format(((ProbabilisticNode) nodeListLief.get(0)).getMarginalAt(0)*100)+"%";
        String max2 = nodeListLief.get(1).getName() + " " + ": " + df.format(((ProbabilisticNode) nodeListLief.get(1)).getMarginalAt(0)*100)+"%";
        String max3 = nodeListLief.get(2).getName() + " " + ": " + df.format(((ProbabilisticNode) nodeListLief.get(2)).getMarginalAt(0)*100)+"%";

        viewResult(max1,max2,max3);

        try {
            net.updateEvidences();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Bayes(){
        ProbabilisticNetwork net = load();

        GridLayout gl = new GridLayout(15,2);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(gl);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        String[] lowStrings = {"low","medium","high"};
        String[] noStrings = {"yes","no"};

        JLabel labelRisk = new JLabel("Risk: ");
        JComboBox comboRisk = new JComboBox(lowStrings);

        JLabel labelAccessControl = new JLabel("Access control: ");
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
                access_control = comboAccessControl.getSelectedIndex();
                read_data = comboReadData.getSelectedIndex();
                severity = comboSeverity.getSelectedIndex();
                confidentiality = comboConfidentiality.getSelectedIndex();
                modify_data = comboModifyData.getSelectedIndex();
                integrity = comboIntegrity.getSelectedIndex();
                authorization = comboAuthorization.getSelectedIndex();
                bad_security_system = comboBadSecurity.getSelectedIndex();;
                outdated_antivirus = comboAntivirus.getSelectedIndex();
                poor_connection = comboConnection.getSelectedIndex();
                small_company = comboCompany.getSelectedIndex();
                installing_malicious_software = comboSoftware.getSelectedIndex();
                poor_data_storage = comboStorage.getSelectedIndex();
                evidence(net);
                frame.dispose();
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

    public static void viewResult(String max1, String max2, String max3){
        GridLayout gl = new GridLayout(3,1);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(gl);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        JLabel result1 = new JLabel("First result: "+max1);
        JLabel result2 = new JLabel("Second result: "+max2);
        JLabel result3 = new JLabel("Third result: "+max3);
        panel.add(result1);
        panel.add(result2);
        panel.add(result3);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Attacks");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
