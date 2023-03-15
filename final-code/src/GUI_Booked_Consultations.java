import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;

public class GUI_Booked_Consultations {
    JFrame frame;

    public GUI_Booked_Consultations() {
        frame = new JFrame("Westminster Skin Consultation Manager");  // creating a new frame ,title
        JPanel panel = new JPanel();  // creating a new panel

        frame.setSize(1000, 450);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);

        JLabel label1 = new JLabel("Booked Consultations"); // header
        label1.setBounds(400, 10, 150, 70);
        panel.add(label1);

        /** TABLE 1*/
        JTable table1 = new JTable();
        Object[] columns = {"Patient ID", "Patient's Name", "Patient's surname", "Patient DOB", "Patient Mobile"}; //Headers of the table

        DefaultTableModel modelTable = new DefaultTableModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelTable); //Sorting columns in ascending and descending order

        table1.setRowSorter(sorter);
        modelTable.setColumnIdentifiers(columns);
        table1.setModel(modelTable);

        Object[] row = new Object[5];
        JScrollPane jPane = new JScrollPane(table1);
        jPane.setBounds(10, 80, 500, 250);
        table1.setFillsViewportHeight(true);
        jPane.setBorder(BorderFactory.createEmptyBorder());
        panel.add(jPane);

        for (Patient p1 : GUI_Add_Consult.patients) {   // displaying patient data
            row[0] = p1.getUniqueID();
            row[1] = p1.getFirstName();
            row[2] = p1.getSurname();
            row[3] = p1.getDateOfBirth();
            row[4] = p1.getMobileNum();
            modelTable.addRow(row);
        }

        /** TABLE 2*/
        JTable table2 = new JTable();
        Object[] secColumns = {"Doctor's Surname"}; //Headers of the table

        DefaultTableModel modelTable2 = new DefaultTableModel();
        TableRowSorter<DefaultTableModel> sorter2 = new TableRowSorter<>(modelTable2); //Sorting columns in ascending and descending order

        table2.setRowSorter(sorter2);
        modelTable2.setColumnIdentifiers(secColumns);
        table2.setModel(modelTable2);

        Object[] rows = new Object[1];
        JScrollPane jPane2 = new JScrollPane(table2);
        jPane2.setBounds(503, 80, 115, 250);
        table2.setFillsViewportHeight(true);
        jPane2.setBorder(BorderFactory.createEmptyBorder());
        panel.add(jPane2);

        for (Doctor d1 : GUI_Add_Consult.doctorArrayList) {   // displaying doctor data
            rows[0] = d1.getSurname();
            modelTable2.addRow(rows);
        }

        /** TABLE 3*/
        JTable table3 = new JTable();
        Object[] conColumns = {"Notes", "Date", "Time", "Cost"}; //Headers of the table

        DefaultTableModel modelTable3 = new DefaultTableModel();
        TableRowSorter<DefaultTableModel> sorter3 = new TableRowSorter<>(modelTable3); //Sorting columns in ascending and descending order

        table3.setRowSorter(sorter3);
        modelTable3.setColumnIdentifiers(conColumns);
        table3.setModel(modelTable3);

        Object[] detRows = new Object[4];
        JScrollPane jPane3 = new JScrollPane(table3);
        jPane3.setBounds(618, 80, 300, 250);
        table3.setFillsViewportHeight(true);
        jPane3.setBorder(BorderFactory.createEmptyBorder());
        panel.add(jPane3);

        for (Consultation c1 : GUI_Add_Consult.consultationArrayList) {  // displaying consultation data
            detRows[0] = c1.getNotes();
            detRows[1] = c1.getDate();
            detRows[2] = c1.getTime();
            detRows[3] = c1.getCost();
            modelTable3.addRow(detRows);
        }
    }
}
