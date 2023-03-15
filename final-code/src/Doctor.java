public class Doctor extends Person{

    private String licenceNumber;
    private String specialization;

    // getting and setting methods for license number
    public String getLicenceNumber() {
        return licenceNumber;
    }
    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    // getting and setting methods for specialization of the doctor
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
