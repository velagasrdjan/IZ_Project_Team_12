import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class ButtonCellRenderer extends JButton implements TableCellRenderer{
    public Component getTableCellRendererComponent(JTable aTable, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column){
        setText(value.toString());
        return this;
    }
}

public class CbrTable {
    public CbrTable(List<Attack> attackList){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        String[] columnNames = {"Name",
                "Impact",
                "Mitigations",
                "Prerequisites",
                "Risk",
                "Scope",
                "Severity",
                "Skills Required"};

        String[][] data = new String[attackList.size()][columnNames.length];
        for(int i=0; i<attackList.size(); i++){
                data[i]= new String[]
                        {attackList.get(i).name, attackList.get(i).impact,
                        attackList.get(i).mitigations, attackList.get(i).prerequisites,
                        attackList.get(i).risk, attackList.get(i).scope,
                        attackList.get(i).severity, attackList.get(i).skills_required };

        }

        String[][] q = {
                { "Kundan Kumar Jha", "4031", "CSE" , "blabla", "blabla", "aa", "aaa", "aaa", "Edit"},

        };

        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(data, columnNames);
        JTable table = new JTable(dm);
 
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()) {
					int row =table.getSelectedRow();
					new Cbr(attackList.get(row));
				}
				
			}
		});;

        
        
        
        
        table.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        

       frame.add(sp);
        //frame.add(register);
        // Frame Size
        frame.setSize(800, 400);
        // Frame Visible = true
        frame.setVisible(true);
    }



}
