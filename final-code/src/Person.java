import java.io.Serializable;

public class Person  implements Serializable {
    private String firstName;
    private String surname;
    private String dateOfBirth;
    private String mobileNum;

    // getting and setting methods for first name
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // getting and setting methods for surname
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // getting and setting methods for DOB
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // getting and setting methods for mobile number
    public String getMobileNum() {
        return mobileNum;
    }
    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
}


