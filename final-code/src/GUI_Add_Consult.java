import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GUI_Add_Consult{
    JTextField userText1, userText2, userText3, userText4, userText5, userText6, userText7, userText8,userText9, userText11;
    JFrame frame;
    JLabel print;
    public static ArrayList<Consultation> consultationArrayList = new ArrayList<>();
    public static ArrayList<Doctor> doctorArrayList = new ArrayList<>();
    public static ArrayList<Patient> patients = new ArrayList<>();

    public GUI_Add_Consult(){
        //creating the frame
        frame = new JFrame("Westminster Skin Consultation Manager");
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setResizable(false);

        //creating the panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        /** PATIENT DETAILS SUBMITTING FORM */
        JLabel label = new JLabel("Enter patient details"); // HEADER
        label.setBounds(80, 20, 150, 25);
        panel.add(label);

        JLabel user = new JLabel("Patient name");       // LABEL
        user.setBounds(10, 80, 100, 25);
        panel.add(user);

        userText1 = new JTextField(30);             // TEXT FIELD
        userText1.setBounds(150, 80, 100, 25);
        panel.add(userText1);

        user = new JLabel("Patient surname");          // LABEL
        user.setBounds(10, 120, 100, 25);
        panel.add(user);

        userText2 = new JTextField(30);            // TEXT FIELD
        userText2.setBounds(150, 120, 100, 25);
        panel.add(userText2);

        user = new JLabel("Patient DOB");              // LABEL
        user.setBounds(10, 160, 100, 25);
        panel.add(user);

        userText3 = new JTextField(30);             // TEXT FIELD
        userText3.setBounds(150, 160, 100, 25);
        panel.add(userText3);

        user = new JLabel("Patient mobile No");        // LABEL
        user.setBounds(10, 200, 100, 25);
        panel.add(user);

        userText4 = new JTextField(30);             // TEXT FIELD
        userText4.setBounds(150, 200, 100, 25);
        panel.add(userText4);

        user= new JLabel("Patient ID");                // LABEL
        user.setBounds(10, 240, 100, 25);
        panel.add(user);

        userText5 = new JTextField(30);             // TEXT FIELD
        userText5.setBounds(150, 240, 100, 25);
        panel.add(userText5);

        user = new JLabel("Notes");             // LABEL
        user.setBounds(10,280,100,25);
        panel.add(user);

        userText6 = new JTextField(100);            // TEXT FIELD
        userText6.setBounds(150,280,250,60);
        panel.add(userText6);

        user = new JLabel("Select Doctor");         //  LABEL
        user.setBounds(10,350,100,25);
        panel.add(user);

        userText7 = new JTextField(100);             // TEXT FIELD
        userText7.setBounds(150,350,100,25);
        panel.add(userText7);

        user = new JLabel("Date");                     // LABEL
        user.setBounds(10,380,100,25);
        panel.add(user);

        user = new JLabel("(yyyy-mm-dd)");                     // LABEL
        user.setBounds(40,380,100,25);
        panel.add(user);

        userText8 = new JTextField(100);             // TEXT FIELD
        userText8.setBounds(150,380,100,25);
        panel.add(userText8);

        user = new JLabel("Consult Hours");         // LABEL
        user.setBounds(10,410,100,25);
        panel.add(user);

        userText11 = new JTextField(100);           // TEXT FIELD
        userText11.setBounds(150,410,100,25);
        panel.add(userText11);

        user = new JLabel("Time");                     // LABEL
        user.setBounds(10,440,100,25);
        panel.add(user);

        userText9 = new JTextField(100);             // TEXT FIELD
        userText9.setBounds(150,440,100,25);
        panel.add(userText9);

        print = new JLabel("");
        print.setBounds(10, 530, 300, 30);
        panel.add(print);

        JButton subButton = new JButton("Submit");   // SUBMIT button
        subButton.setBounds(10, 480, 100, 25);

        subButton.addActionListener(e -> {     //  adding an action on the button click
            print.setText("Consultation booked successfully.");
            Patient patient1 = new Patient();
            Consultation appointment = new Consultation();
            Doctor doctor = new Doctor();

            // setting the patient details
            String name = userText1.getText();
            patient1.setFirstName(name);

            String surname = userText2.getText();
            patient1.setSurname(surname);

            String DOB = userText3.getText();
            patient1.setDateOfBirth(DOB);

            String mobile = userText4.getText();
            patient1.setMobileNum(mobile);

            String ID = userText5.getText();
            patient1.setUniqueID(ID);

            // setting the consultation details
            String notes = userText6.getText();
            appointment.setNotes(notes);

            String doc = userText7.getText();
            doctor.setSurname(doc);

            LocalDate date = LocalDate.parse(userText8.getText(), DateTimeFormatter.ISO_DATE);
            appointment.setDate(date);

            String time= userText9.getText();
            appointment.setTime(time);

            int count = Integer.parseInt(userText11.getText());
            appointment.setHrsConsult(count);

            float cost= appointment.getHrsConsult()*15;  // getting the cost for a consultation
            appointment.setCost(cost);

            patients.add(patient1);
            doctorArrayList.add(doctor);
            consultationArrayList.add(appointment);

            userText1.setText(null);
            userText2.setText(null);
            userText3.setText(null);
            userText4.setText(null);
            userText5.setText(null);
            userText6.setText(null);
            userText7.setText(null);
            userText8.setText(null);
            userText9.setText(null);
            userText11.setText(null);
        });
        panel.add(subButton);
        /**
         * DISPLAYING DOCTORS DETAILS ON A TABLE
         * */

        JLabel label1 = new JLabel("Doctor details"); // HEADER
        label1.setBounds(650, 50, 100, 25);
        panel.add(label1);

        JTable statsTable = new JTable();
        Object[] columns = {"Doctor's Name", "Medical Speciality"}; //Headers of the table

        DefaultTableModel modelTable = new DefaultTableModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelTable); //Sorting columns in ascending and descending order

        statsTable.setRowSorter(sorter);
        modelTable.setColumnIdentifiers(columns);
        statsTable.setModel(modelTable);

        Object[] row = new Object[2];
        JScrollPane jPane = new JScrollPane(statsTable);
        jPane.setBounds(450, 100, 500, 250);
        panel.add(jPane);

        for (Doctor d1 : WestminsterSkinConsultationManager.doctors) {
            row[0] = d1.getSurname();
            row[1] = d1.getSpecialization();
            modelTable.addRow(row);
        }
    }
}