import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainMenu {
    public static void main (String[] args){
        GridLayout gl = new GridLayout(4,1);
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


        panel.add(fuzzy);
        panel.add(bayes);
        panel.add(register);
        panel.add(viewAll);

        frame.setPreferredSize(new Dimension(400, 300));
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MainMenu");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
