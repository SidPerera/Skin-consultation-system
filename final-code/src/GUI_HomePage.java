import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI_HomePage {
    JFrame frame;
    JPanel panel;
    JButton addConsultButton, bookedConsultButton, cancelConsultation;

    public GUI_HomePage(){

        //frame
        frame = new JFrame("Westminster Skin Consultation Manager");
        frame.setSize(500, 800);
        frame.setLayout(null);
        frame.setResizable(false);

        //panel
        panel = new JPanel();
        panel.setBounds(0, 0, 500, 800);
        panel.setBackground(Color.GRAY);
        panel.setLayout(new GridLayout(6,3));

        //add consult Button
        addConsultButton = new JButton("Add Consultation");
        addConsultButton.setBounds(60, 60, 60, 40);
        addConsultButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                new GUI_Add_Consult();
            }
        });

        //cancel consult Button
        cancelConsultation = new JButton("Cancel Consultation");
        cancelConsultation.setBounds(60, 120, 60, 40);
        cancelConsultation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI_Cancel();
            }
        });

        //view consult Button
        bookedConsultButton = new JButton("Booked Consultations");
        bookedConsultButton.setBounds(60, 180, 60, 40);
        bookedConsultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI_Booked_Consultations();
            }
        });

        //Adding to Panel
        panel.setBorder(BorderFactory.createEmptyBorder(200, 80, 50, 100));
        panel.add(addConsultButton);
        panel.add(cancelConsultation);
        panel.add(bookedConsultButton);
        panel.setLayout(new GridLayout(4, 1));

        //frame Options
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
