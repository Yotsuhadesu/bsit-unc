import java.time.LocalDate;
import java.time.Period;
public class Student {
    // fields
    private long lRN;
    private String lastName;
    private String firstName;
    private String middleName;
    private String gender;
    private String birthDate;
    private long contactNumber;
    private String homeAddress;
    private int age; // computed later

    // constructor
    public Student(long lRN, String lastName, String firstName, 
        String middleName, String gender, String birthDate, 
        long contactNumber, String homeAddress) {
        this.lRN = lRN;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.contactNumber = contactNumber;
        this.homeAddress = homeAddress;
    }

    // setters
    public void setLrn(long lRN) {
        this.lRN = lRN;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    
    // getters
    public long getLRN() {
        return this.lRN;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getMiddleName() {
        return this.middleName;
    }
    public String getGender() {
        return this.gender;
    }
    public String getBirthDate() {
        return this.birthDate;
    }
    public long getContactNumber() {
        return this.contactNumber;
    }
    public String getHomeAddress() {
        return this.homeAddress;
    }
    public int getAge() {
        return this.age;
    }

    // calculate age from birthdate
    public void processAge() {
        LocalDate birthDate = LocalDate.parse(this.birthDate);
        LocalDate currrentdate = LocalDate.now();
        Period age = Period.between(birthDate, currrentdate);
        this.age = age.getYears();
    }
}