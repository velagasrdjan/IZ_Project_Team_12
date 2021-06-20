import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.temporal.ValueRange;
import java.util.ArrayList;

public class GUI {

    private static double risk = 0;
    private static double access_control = 0;
    private static double availability = 0;
    private static double authorization = 0;
    private static double confidentiality = 0;
    private static double integrity = 0;
    private static double prerequisites = 0;
    private static double scope = 0;
    private static double severity = 0;

    public static void viewRisk(double risk){
        GridLayout gl = new GridLayout(1,2);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(gl);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        JLabel labelRisk = new JLabel("Risk: ");
        JLabel resultRisk = new JLabel(Double.toString(risk));
        panel.add(labelRisk);
        panel.add(resultRisk);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Risk");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void load_fis(){
        // Load from 'FCL' file
        String fileName = "template.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) {
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        // Set inputs
        fis.setVariable("access_control",access_control);
        fis.setVariable("availability", availability);
        fis.setVariable("authorization", authorization);
        fis.setVariable("confidentiality", confidentiality);
        fis.setVariable("integrity", integrity);
        fis.setVariable("prerequisites", prerequisites);
        fis.setVariable("scope", scope);
        fis.setVariable("severity", severity);

        // Evaluate
        fis.evaluate();

        // Print ruleSet
        risk = fis.getVariable("risk").getLatestDefuzzifiedValue();
        System.out.println(risk);
    }

    public static double scale1(String input){
        if(input.equals("low")){
            return 0;
        }else if(input.equals("medium")){
            return 0.45;
        }else if(input.equals("high")){
            return 0.75;
        }else return 1;
    }

    public static double scale2(String input){
        if(input.equals("unchanged")){
            return 0;
        }else return 1;
    }

    public static double scale3(String input){
        if(input.equals("not_affected")){
            return 0;
        }else return 1;
    }

    public static double scale4(String input){
        if(input.equals("low")){
            return 0.3;
        }else if(input.equals("high")){
            return 0.9;
        }else return 0;
    }

    public GUI(){
        GridLayout gl = new GridLayout(9,2);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(gl);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        String[] severityStrings = {"low","medium","high","very high"};
        String[] prerequisitesStrings = {"none","low","high"};
        String[] scopeStrings = {"changed","unchanged"};
        String[] affectedStrings = {"affected","not affected"};

        JLabel labelAccessControl = new JLabel("Access control: ");
        JComboBox comboAccessControl = new JComboBox(prerequisitesStrings);

        JLabel labelAvailability = new JLabel("Availability: ");
        JComboBox comboAvailability = new JComboBox(affectedStrings);

        JLabel labelAuthorization = new JLabel("Authorization: ");
        JComboBox comboAuthorization = new JComboBox(affectedStrings);

        JLabel labelConfidentiality = new JLabel("Confidentiality: ");
        JComboBox comboConfidentiality = new JComboBox(affectedStrings);

        JLabel labelIntegrity = new JLabel("Integrity: ");
        JComboBox comboIntegrity = new JComboBox(affectedStrings);

        JLabel labelPrerequisites = new JLabel("Prerequisites: ");
        JComboBox comboPrerequisites = new JComboBox(prerequisitesStrings);

        JLabel labelScope = new JLabel("Scope: ");
        JComboBox comboScope = new JComboBox(scopeStrings);

        JLabel labelSeverity = new JLabel("Severity: ");
        JComboBox comboSeverity = new JComboBox(severityStrings);

        JButton calculate = new JButton("Calculate");
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                severity = scale1(comboSeverity.getSelectedItem().toString());
                access_control = scale4(comboAccessControl.getSelectedItem().toString());
                availability = scale3(comboAvailability.getSelectedItem().toString());
                authorization = scale3(comboAuthorization.getSelectedItem().toString());
                prerequisites = scale4(comboPrerequisites.getSelectedItem().toString());
                scope = scale2(comboScope.getSelectedItem().toString());
                confidentiality = scale3(comboConfidentiality.getSelectedItem().toString());
                integrity = scale3(comboIntegrity.getSelectedItem().toString());
                load_fis();
                viewRisk(risk);
            }
        });


        panel.add(labelAccessControl);
        panel.add(comboAccessControl);
        panel.add(labelAvailability);
        panel.add(comboAvailability);
        panel.add(labelAuthorization);
        panel.add(comboAuthorization);
        panel.add(labelConfidentiality);
        panel.add(comboConfidentiality);
        panel.add(labelIntegrity);
        panel.add(comboIntegrity);
        panel.add(labelPrerequisites);
        panel.add(comboPrerequisites);
        panel.add(labelScope);
        panel.add(comboScope);
        panel.add(labelSeverity);
        panel.add(comboSeverity);

        panel.add(calculate);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Risk calculator");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }


}
