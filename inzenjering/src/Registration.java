import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration {

    public String impact="";
    public String scope="";


    public Registration(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(layout);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));

        String[] severityStrings = {"low","medium","high","very high"};
        String[] riskStrings = {"low","medium","high"};
        String[] skillsString = {"none", "low", "high"};

        //attack name
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel labelName = new JLabel("Attack name: ");
        panel.add(labelName,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 150;
        JTextField textName = new JTextField();
        panel.add(textName,gbc);

        //risk
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel labelRisk = new JLabel("Risk: ");
        panel.add(labelRisk,gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 150;
        JComboBox comboRisk = new JComboBox(riskStrings);
        panel.add(comboRisk,gbc);

        //severity
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel labelSeverity = new JLabel("Severity: ");
        panel.add(labelSeverity,gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 150;
        JComboBox comboSeverity = new JComboBox(severityStrings);
        panel.add(comboSeverity,gbc);

        //scope
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel labelScope = new JLabel("Scope: ");
        panel.add(labelScope,gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        JCheckBox confidentiality = new JCheckBox("confidentiality");
        panel.add(confidentiality,gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        JCheckBox integrity = new JCheckBox("integrity");
        panel.add(integrity,gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
        JCheckBox access_control = new JCheckBox("access control");
        panel.add(access_control,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 4;
        JCheckBox authorization = new JCheckBox("authorization");
        panel.add(authorization,gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        JCheckBox availability = new JCheckBox("availability");
        panel.add(availability,gbc);

        //impact
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel labelImpact = new JLabel("Impact:");
        panel.add(labelImpact,gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        JCheckBox read_data = new JCheckBox("read data");
        panel.add(read_data,gbc);
        gbc.gridx = 2;
        gbc.gridy = 5;
        JCheckBox confidentiality2 = new JCheckBox("confidentiality Impact");
        panel.add(confidentiality2,gbc);
        gbc.gridx = 3;
        gbc.gridy = 5;
        JCheckBox information_leakage = new JCheckBox("information leakage");
        panel.add(information_leakage,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 6;
        JCheckBox pull_data = new JCheckBox("pull data");
        panel.add(pull_data,gbc);
        gbc.gridx = 2;
        gbc.gridy = 6;
        JCheckBox modify_data = new JCheckBox("modify data");
        panel.add(modify_data,gbc);
        gbc.gridx = 3;
        gbc.gridy = 6;
        JCheckBox gain_privileges = new JCheckBox("gain privileges");
        panel.add(gain_privileges,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 7;
        JCheckBox unreliable_execution = new JCheckBox("unreliable execution");
        panel.add(unreliable_execution,gbc);
        gbc.gridx = 2;
        gbc.gridy = 7;
        JCheckBox bypass_protection_mechanism = new JCheckBox("bypass protection mechanism");
        panel.add(bypass_protection_mechanism,gbc);
        gbc.gridx = 3;
        gbc.gridy = 7;
        JCheckBox hide_activities = new JCheckBox("hide activities");
        panel.add(hide_activities,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 8;
        JCheckBox execute_unauthorized_commands = new JCheckBox("execute unauthorized commands");
        panel.add(execute_unauthorized_commands,gbc);
        gbc.gridx = 2;
        gbc.gridy = 8;
        JCheckBox access_control2 = new JCheckBox("access control Impact");
        panel.add(access_control2,gbc);


        //skills
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 9;
        JLabel labelSkills = new JLabel("Skills Required: ");
        panel.add(labelSkills,gbc);
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.ipadx = 150;
        JComboBox comboSkills = new JComboBox(skillsString);
        panel.add(comboSkills,gbc);

        //prerequisites
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 10;
        JLabel labelPrerequisites = new JLabel("Prerequisites: ");
        panel.add(labelPrerequisites,gbc);
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.ipadx = 150;
        JComboBox comboPrerequisites = new JComboBox(skillsString);
        panel.add(comboPrerequisites,gbc);

        //mitigations
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 11;
        JLabel labelMitigation = new JLabel("Mitigations: ");
        panel.add(labelMitigation,gbc);
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.ipadx = 150;
        JTextField textMitigaiton = new JTextField();
        panel.add(textMitigaiton,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 12;
        //gbc.gridwidth = 2;
        JButton calculate = new JButton("Register");
        panel.add(calculate,gbc);

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textName.getText().length()==0){
                    JOptionPane.showMessageDialog(frame,
                            "Attack name can't be empty.",
                            "Inane error",
                            JOptionPane.ERROR_MESSAGE);
                }
                if(textMitigaiton.getText().length()==0){
                    JOptionPane.showMessageDialog(frame,
                            "Attack mitigation can't be empty.",
                            "Inane error",
                            JOptionPane.ERROR_MESSAGE);
                }
                if(textName.getText().length()!=0 && textMitigaiton.getText().length()!=0){
                    checkScope(confidentiality);
                    checkScope(integrity);
                    checkScope(access_control);
                    checkScope(authorization);
                    checkScope(availability);

                    checkImpact(read_data);
                    checkImpact(confidentiality2);
                    checkImpact(information_leakage);
                    checkImpact(pull_data);
                    checkImpact(modify_data);
                    checkImpact(gain_privileges);
                    checkImpact(unreliable_execution);
                    checkImpact(bypass_protection_mechanism);
                    checkImpact(hide_activities);
                    checkImpact(execute_unauthorized_commands);
                    checkImpact(access_control2);


                    Attack attack = new Attack(textName.getText(),
                            impact,
                            textMitigaiton.getText(),
                            comboPrerequisites.getSelectedItem().toString(),
                            comboRisk.getSelectedItem().toString(),
                            scope,
                            comboSeverity.getSelectedItem().toString(),
                            comboSkills.getSelectedItem().toString());

                    RemoteDatabase.insertQuery(attack);

                    JOptionPane.showMessageDialog(frame,
                            "Attack successfully registered.",
                            "Success message",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Register attack");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void checkImpact(JCheckBox checkBox){
        if(checkBox.isSelected()){
            if(impact.length()==0){
                impact = checkBox.getText();
            }else{
                impact = impact + ":" + checkBox.getText();
            }
        }
    }

    public void checkScope(JCheckBox checkBox){
        if(checkBox.isSelected()){
            if(scope.length()==0){
                scope = checkBox.getText();
            }else{
                scope = scope + ":" + checkBox.getText();
            }
        }
    }

}
