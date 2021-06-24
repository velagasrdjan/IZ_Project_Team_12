import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;

class ButtonCellRenderer extends JButton implements TableCellRenderer{
    public Component getTableCellRendererComponent(JTable aTable, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column){
        setText(value.toString());
        return this;
    }
}

public class AttackTable {
    public AttackTable(List<Attack> attackList){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        String[] columnNames = {"Name",
                "Impact",
                "Mitigations",
                "Prerequisites",
                "Risk",
                "Scope",
                "Severity",
                "Skills Required",
                "Edit"};

        String[][] data = new String[attackList.size()][columnNames.length];
        for(int i=0; i<attackList.size(); i++){
                data[i]= new String[]
                        {attackList.get(i).name, attackList.get(i).impact,
                        attackList.get(i).mitigations, attackList.get(i).prerequisites,
                        attackList.get(i).risk, attackList.get(i).scope,
                        attackList.get(i).severity, attackList.get(i).skills_required,
                        "Edit" };

        }

        String[][] q = {
                { "Kundan Kumar Jha", "4031", "CSE" , "blabla", "blabla", "aa", "aaa", "aaa", "Edit"},

        };

        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(data, columnNames);
        JTable table = new JTable(dm);
        table.getColumn("Edit").setCellRenderer(new ButtonCellRenderer());

        table.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.getColumnModel().getColumn(0).setPreferredWidth(100);

        frame.add(sp);
        // Frame Size
        frame.setSize(500, 200);
        // Frame Visible = true
        frame.setVisible(true);
    }



}
