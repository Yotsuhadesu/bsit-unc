import java.time.LocalDate;
import java.time.Period;

public class Person {
    // protected keyword so that these can only be used by classes inside the package and the child classes
    protected String lastName;
    protected String firstName;
    protected String middleName;
    protected String gender;
    protected String birthDate;
    protected long contactNumber;
    private int age;

    // Constructor to be passed to child classes
    public Person(String lastName, String firstName, String middleName, 
                  String gender, String birthDate, long contactNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.contactNumber = contactNumber;
    }

    public void computeAge() {
        if (this.birthDate != null) {
            LocalDate birthDate = LocalDate.parse(this.birthDate);  // parse the String into ISO 8601 date format
            LocalDate currDate = LocalDate.now();   // get the current date
            this.age = Period.between(birthDate, currDate).getYears();  // get the years between the birthdate and current date
        } else {
            System.out.println("Please assign a bitrhdate first.");
        }
    }

    // setters
    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public void setGender(String gender) { this.gender = gender; }

    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public void setContactNumber(long contactNumber) { this.contactNumber = contactNumber; }

    public void setAge(int age) { this.age = age; }

    // getters
    public String getLastName() { return this.lastName; }

    public String getFirstName() { return this.firstName; }

    public String getMiddleName() { return this.middleName; }

    public String getGender() { return this.gender; }

    public String getBirthDate() { return this.birthDate; }

    public long getContactNumber() { return this.contactNumber; }

    public int getAge() { return this.age; }

}
