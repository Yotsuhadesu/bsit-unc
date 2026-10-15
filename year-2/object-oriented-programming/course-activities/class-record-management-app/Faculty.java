public final class Faculty extends Person{
    private String facultyID;
    private String degree;

    public Faculty(String firstName, String middleName, String lastName,
        String facultyID, String degree
    ) {
        super(firstName, middleName, lastName);
        this.facultyID = facultyID;
        this.degree = degree;
    }
    public Faculty() {
        super();
        this.facultyID = null;
        this.degree = null;
    }

    @Override
    public String getCompleteName() {
        if (middleName == null) { return null; }
        return String.format("%s %s. %s, %s", firstName, middleName.charAt(0), lastName, degree);
    }

    public String getFacultyID() {
        return this.facultyID;
    }
    public String getDegree() {
        return this.degree;
    }
    
    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
}
