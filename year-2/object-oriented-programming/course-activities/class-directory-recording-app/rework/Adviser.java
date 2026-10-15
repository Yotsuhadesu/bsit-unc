public class Adviser extends Person{
    // encapsulated field
    private String degree;

    public Adviser(String degree, String lastName, String firsttName, String middleName, 
                  String gender, String birthDate, long contactNumber) {
        super(lastName, firsttName, middleName, gender, birthDate, contactNumber);
        this.degree = degree;
    }
    public Adviser() {
        this(null, null, null, null, null, null, 0);
    }

    public String getDegree() { return this.degree; }
}
