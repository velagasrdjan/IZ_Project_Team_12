package CaseBasedReasoning;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DataPanel extends JPanel {

	//private static final long serialVersionUID = 1L;
	
	public static JTextField imeTxt;
	public static JPanel imePanel;
	
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataPanel(){
		
		//ime pacijenta---------------------------------------------------------------------------
				imePanel = new JPanel();
				imePanel.setBackground(Color.lightGray);
				imePanel.setBorder(BorderFactory.createLineBorder(Color.black));
				imePanel.setPreferredSize(new Dimension(300,10));
				imePanel.setMaximumSize(new Dimension(300,10));
				imePanel.setMinimumSize(new Dimension(300,10));
				
				JLabel ime = new JLabel("  Ime napada: ");
				ime.setPreferredSize(new Dimension(95,10));
				imeTxt = new JTextField();
				imeTxt.setPreferredSize(new Dimension(130,10));
				imeTxt.setMinimumSize(new Dimension(130,20));
				imeTxt.setMaximumSize(new Dimension(130,25));
				
				imePanel.setLayout(new BoxLayout(imePanel, BoxLayout.X_AXIS));
				imePanel.add(ime);
				imePanel.add(Box.createHorizontalStrut(10));
				imePanel.add(imeTxt);	
				imePanel.add(Box.createHorizontalStrut(30));
				//MainMenu.panel.add(imePanel);
	}
	
		
}
