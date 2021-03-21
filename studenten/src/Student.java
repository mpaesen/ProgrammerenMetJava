import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Student {
    private String voornaam;
    private String naam;
 /*   private Date birthDate;
    SimpleDateFormat formatter = new SimpleDateFormat("00/00/0000");
    Date date = new Date();
    --lossen we later op
    */

    public Student(String voornaam, String naam /*LocalDate birthDate*/) {
        this.voornaam = voornaam;
        this.naam = naam;
       // this.birthDate = birthDate;
    }

    public String getVoornaam() { return voornaam;}

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getNaam() {return naam;}

    public void setNaam(String naam) {
        this.naam = naam;
    }

    //public Date getBirthDate() {return birthDate;}
    //public void setBirthDate(Date birthDate) {this.birthDate = birthDate;}

    public String voornaamToString() {
        return voornaam.toString();
    }
    public String naamToString() {
        return naam.toString();
    }
   // public String gbDateToString() {return birthDate.toString();}
}
