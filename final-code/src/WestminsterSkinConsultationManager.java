import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


//testing 
public class WestminsterSkinConsultationManager implements SkinConsultationManager{
    private final int number_of_doctors;
    public static ArrayList<Doctor> doctors = new ArrayList<>(); //Stores all doctor's data
    private final Scanner scanner;

    public WestminsterSkinConsultationManager(int number_of_doctors) {
        this.number_of_doctors = number_of_doctors;
        doctors = new ArrayList<>();
        scanner = new Scanner(System.in);
        displayMenu();
    }

    // loading the saved data to the system on restart
    private void displayMenu() {
        File doctorDFile = new File("E:\\CAMPUS\\L5\\OOP\\CW\\Code\\w1869874\\doctor-data.txt");
        if(doctorDFile.exists()){
            loadAllDetails();
        }
            // printing the console menu
        while(true) {
            System.out.println("""
                        \n----Skin Consultation Center----
                        \nEnter '1' to add up a doctor to the system.
                        Enter '2' to delete a doctor from the system.
                        Enter '3' to view all doctors information.
                        Enter '4' to store program data in to a file.
                        Enter '5' to load.
                        Enter '6' to add consultation.
                        Enter '7' to cancel consultation.
                        Enter '8' to open GUI.
                        """);
            System.out.print("Select an option :");
            int line = scanner.nextInt();
            int selection = 0;
            try {
                selection = line;
            }
            catch (Exception ignored) {
            }

            switch (selection) {
                case 1 -> addDoctor();
                case 2 -> deleteDoctor();
                case 3 -> displayAllDoctors();
                case 4 -> { saveAllDetails();
                            System.out.println("\nData saved successfully.");}
                case 5 -> {loadAllDetails();
                            System.out.println("\nData loaded successfully.");}
                case 6 -> addConsultation();
                case 7 -> cancelConsultations();
                case 8 -> guiHomePage();
                default -> System.out.println("Wrong input, Try Again!");
            }
        }
    }
    //adding doctor's details to the system
    @Override
    public void addDoctor(){
        if(doctors.size() == number_of_doctors){
            System.out.println("Participation limit has been exceeded. Unable to add more doctors.");
            return;
        }
        Doctor doctor1 = new Doctor();

        System.out.println("\nAdd Doctor\n");
        System.out.print("Enter the Doctor's licence number: ");
        String sc = scanner.next();
        doctor1.setLicenceNumber(sc);

        if(doctors.contains(doctor1)){ //validation of doctor's name
            System.out.println("Error : this doctor is already exist in the system.");
            return;
        }

        System.out.print("Enter the doctor's name: ");
        sc = scanner.next();
        doctor1.setFirstName(sc);

        System.out.print("Enter the doctor's Surname: ");
        sc = scanner.next();
        doctor1.setSurname(sc);

        System.out.print("Enter the doctor's mobile number: ");
        sc=scanner.next();
        doctor1.setMobileNum(sc);

        System.out.print("Enter the date of birth in dd/MM/yyyy format: ");
        sc = scanner.next();
        doctor1.setDateOfBirth(sc);

        System.out.print("Enter the Doctor's medical speciality: ");
        sc = scanner.next();
        doctor1.setSpecialization(sc);

        doctors.add(doctor1);   //Adding doctor's details to 'Doctor' array list
        System.out.println("\nSuccessfully added the DR."+doctor1.getSurname()+" to the system." );

    }

    //delete a doctor using licence Number
    @Override
    public void deleteDoctor() {
        System.out.println("\nDelete Doctor\n");
        System.out.println("List of doctors\n--------------------------");
        System.out.printf("%-25s%-25s%n", "Doctor's licence Number", "Doctor's Surname"); //Printing all the doctors details

        for (Doctor doctor1 : doctors) {
            System.out.printf("%-25s%-25s%n", "\t\t"+doctor1.getLicenceNumber(), doctor1.getSurname());
        }

        while (true){
            System.out.print("\nEnter the Doctor's licence Number to delete the record: ");
            String sc = scanner.next();
            for(Doctor doctor1 : doctors) {
                if(doctor1.getLicenceNumber().equals(sc)){
                    doctors.remove(doctor1);
                    System.out.println("\nDoctor with licence number :"+ doctor1.getLicenceNumber()+" has been deleted from the system.");
                    System.out.println("\nList of available doctors\n--------------------------");
                    System.out.printf("%-25s%-25s%n", "Doctor's licence Number", "Doctor's Surname"); //Printing all the doctors details
                    for (Doctor doc : doctors){
                        System.out.printf("%-25s%-25s%n", "\t\t"+doc.getLicenceNumber(), doc.getSurname());
                    }
                    saveAllDetails();
                    return;
                }
            }
            System.out.println("Error : there is no record of a doctor in the system.");
        }
    }

    //Display details of all doctors
    @Override
    public void displayAllDoctors() {
        System.out.println("\nDoctor Details\n");
        System.out.printf("%-25s%-25s%-25s%-25s%-25s%-25s%n", "Doctor's licence Number", "Doctor's Name", "Doctor's Surname","Doctor's Mobile Number", "Doctor's DOB", "Area of Speciality");
        System.out.printf("%-25s%-25s%-25s%-25s%-25s%-25s%n","----------------------","----------------------","----------------------","---------------------","----------------------","----------------------");

        for (Doctor doctor1 : doctors) {
            System.out.printf("%-25s%-25s%-25s%-25s%-25s%-25s%n", doctor1.getLicenceNumber(), doctor1.getFirstName(), doctor1.getSurname(),doctor1.getMobileNum(), doctor1.getDateOfBirth(), doctor1.getSpecialization());
        }
    }

    // saving all the details
    @Override
    public void saveAllDetails() {
        try{
            FileOutputStream writeDData = new FileOutputStream("doctor-data.txt");
            ObjectOutputStream writerD = new ObjectOutputStream(writeDData);

            writerD.writeObject(doctors);
            writerD.flush();
            writerD.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // loading all the details
    @Override
    public void loadAllDetails() {
        try {
           FileInputStream readDData = new FileInputStream("doctor-data.txt");
            ObjectInputStream readerD = new ObjectInputStream(readDData);

            ArrayList<Doctor> read_doctors = (ArrayList<Doctor>) readerD.readObject();
            readerD.close();
            doctors = read_doctors;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // adding consultations
    @Override
    public void addConsultation() {
        System.out.println("\nAdd Consultation\n");
        Patient patient = new Patient();
        Consultation consultation = new Consultation();
        Doctor doctor = new Doctor();

        System.out.print("Enter Name: ");
        String scanner1 = scanner.next();
        patient.setFirstName(scanner1);

        System.out.print("Enter Surname: ");
        scanner1 = scanner.next();
        patient.setSurname(scanner1);

        System.out.print("Enter DOB: ");
        scanner1 = scanner.next();
        patient.setDateOfBirth(scanner1);

        System.out.print("Enter Mobile: ");
        scanner1 = scanner.next();
        patient.setMobileNum(scanner1);

        System.out.print("Enter ID: ");
        scanner1 = scanner.next();
        patient.setUniqueID(scanner1);

        System.out.print("Enter Notes: ");
        scanner1 = scanner.next();
        consultation.setNotes(scanner1);

        System.out.print("Select Doctor: ");
        scanner1 = scanner.next();
        doctor.setSurname(scanner1);

        System.out.print("Enter Date: ");
        scanner1 = scanner.next();
        consultation.setDate(LocalDate.parse(scanner1, DateTimeFormatter.ISO_DATE));

        System.out.print("Enter Consult hours: ");
        int scanner2 = scanner.nextInt();
        consultation.setHrsConsult(scanner2);

        System.out.print("Enter Time: ");
        scanner1 = scanner.next();
        consultation.setTime(scanner1);

        float cost = consultation.getHrsConsult()*15;
        consultation.setCost(cost);

        System.out.println("\nConsultation booked with Dr. "+doctor.getSurname()+" for Mr/Mrs "+patient.getFirstName()+".");

        GUI_Add_Consult.patients.add(patient);
        GUI_Add_Consult.consultationArrayList.add(consultation);
        GUI_Add_Consult.doctorArrayList.add(doctor);
    }

    //cancel consultation
    @Override
    public void cancelConsultations() {
        System.out.println("\nCancel Consultation\n");

        System.out.print("Enter patient ID: ");
        String scan1 = scanner.next();

        System.out.print("Enter Doctor's Surname: ");
        String scan2 = scanner.next();

        System.out.print("Enter booked time: ");
        String scan3 = scanner.next();

        for (Patient patient: GUI_Add_Consult.patients){
            if(patient.getUniqueID().equals(scan1)){
                patient.setUniqueID(null);
                patient.setFirstName(null);
                patient.setSurname(null);
                patient.setMobileNum(null);
                patient.setSurname(null);
                patient.setDateOfBirth(null);
            }
        }

        for (Doctor doctor: GUI_Add_Consult.doctorArrayList){
            if (doctor.getSurname().equals(scan2)){
                doctor.setSurname(null);
            }
        }

        for (Consultation consultation: GUI_Add_Consult.consultationArrayList){
            if (consultation.getTime().equals(scan3)){
                consultation.setTime(null);
                consultation.setHrsConsult(0);
                consultation.setDate(null);
                consultation.setNotes(null);
                consultation.setCost(0);
                return;
            }
        }
    }

    // open GUI
    private void guiHomePage(){
        new GUI_HomePage();
    }
}
