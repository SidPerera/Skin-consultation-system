import javax.swing.*;

public class GUI_Cancel {
    JFrame frame;
    JPanel panel;
    JTextField textField1, textField2, textField3;
    JLabel label, print;
    public GUI_Cancel(){
        frame = new JFrame("Westminster Skin Consultation Manager");  // creating a new frame, title
        panel = new JPanel();       // creating new panel
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);

        label = new JLabel("Cancel Consultations");    // LABEL
        label.setBounds(130,50,150,25);
        panel.add(label);

        JLabel user = new JLabel("Patient ID");       // LABEL
        user.setBounds(10, 100, 100, 25);
        panel.add(user);

        textField1 = new JTextField(30);             // TEXT FIELD
        textField1.setBounds(120, 100, 100, 25);
        panel.add(textField1);

        user= new JLabel("Doctor's Surname");                // LABEL
        user.setBounds(10, 130, 100, 25);
        panel.add(user);

        textField2 = new JTextField(30);             // TEXT FIELD
        textField2.setBounds(120, 130, 100, 25);
        panel.add(textField2);

        user= new JLabel("Booked time");                // LABEL
        user.setBounds(10, 160, 100, 25);
        panel.add(user);

        textField3 = new JTextField(30);             // TEXT FIELD
        textField3.setBounds(120, 160, 100, 25);
        panel.add(textField3);

        JButton subButton = new JButton("Submit");   // SUBMIT button
        subButton.setBounds(50, 210, 100, 25);

        subButton.addActionListener(e -> {
            print.setText("Consultation removed successfully.");
            String id = textField1.getText();
            String name = textField2.getText();
            String time = textField3.getText();
            textField1.setText(null);
            textField2.setText(null);
            textField3.setText(null);

            for (Patient patient: GUI_Add_Consult.patients){
                if(patient.getUniqueID().equals(id)){
                    patient.setUniqueID(null);
                    patient.setFirstName(null);
                    patient.setSurname(null);
                    patient.setMobileNum(null);
                    patient.setDateOfBirth(null);
                }
            }

            for (Doctor doctor: GUI_Add_Consult.doctorArrayList){
                if (doctor.getSurname().equals(name)){
                    doctor.setSurname(null);
                }
            }

            for (Consultation consultation: GUI_Add_Consult.consultationArrayList){
                if (consultation.getTime().equals(time)){
                    consultation.setTime(null);
                    consultation.setHrsConsult(0);
                    consultation.setDate(null);
                    consultation.setNotes(null);
                    consultation.setCost(0);
                    return;
                }
            }
        });
        panel.add(subButton);

        print = new JLabel("");
        print.setBounds(10, 240, 300, 30);
        panel.add(print);
    }
}
