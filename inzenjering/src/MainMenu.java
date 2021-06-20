import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    public static void main (String[] args){
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
        panel.add(fuzzy);
        panel.add(bayes);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MainMenu");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
