import java.time.LocalDate;

public class Consultation{

    private float cost;
    private String notes;
    private LocalDate Date;
    private String time;
    private int hrsConsult;


    // getting and setting methods for cost
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    // getting and setting methods for notes
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    // getting and setting methods for date
    public LocalDate getDate() {
        return Date;
    }
    public void setDate(LocalDate date) {
        Date = date;
    }

    // getting and setting methods for time
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    // getting and setting methods for times of consultation
    public int getHrsConsult() {
        return hrsConsult;
    }
    public void setHrsConsult(int hrsConsult) {
        this.hrsConsult = hrsConsult;
    }

}