import javax.swing.*;
import java.awt.*;

public class Registration {



    public Registration(){
        GridLayout gl = new GridLayout(7,2);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(gl);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));

        String[] severityStrings = {"low","medium","high","very high"};
        String[] riskStrings = {"low","medium","high"};
        JLabel labelName = new JLabel("Attack name: ");
        JTextField textName = new JTextField();
        JLabel labelRisk = new JLabel("Risk: ");
        JComboBox comboRisk = new JComboBox(riskStrings);
        JLabel labelScope = new JLabel("Scope: ");
        //JCheckBox checkScope = new JCheckBox();
        JCheckBox confidentiality = new JCheckBox("confidentiality");
        JLabel labelEmpty = new JLabel("");
        JLabel labelEmpty1 = new JLabel("");
        JLabel labelEmpty2 = new JLabel("");
        JLabel labelEmpty3 = new JLabel("");
        JLabel labelEmpty4 = new JLabel("");
        JCheckBox integrity = new JCheckBox("integrity");
        JCheckBox access_control = new JCheckBox("access control");
        JCheckBox authorization = new JCheckBox("authorization");
        JCheckBox availability = new JCheckBox("availability");

        panel.add(labelName);
        panel.add(textName);
        panel.add(labelRisk);
        panel.add(comboRisk);
        panel.add(labelScope);
        panel.add(confidentiality);
        panel.add(labelEmpty);
        panel.add(integrity);
        panel.add(labelEmpty1);
        panel.add(access_control);
        panel.add(labelEmpty2);
        panel.add(authorization);
        panel.add(labelEmpty3);
        panel.add(availability);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Register attack");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
