public final class Student extends Person{
    private String studentNumber;
    private String gender;
    private String course;

    public Student(String firstName, String middleName, String lastName,
        String studentNumber, String gender, String course
    ) {
        super(firstName, middleName, lastName);
        this.studentNumber = studentNumber;
        this.gender = gender;
        this.course = course;
    }

    @Override
    public String getCompleteName() {
        if (this.getMiddleName() == null) { return null; }
        return String.format("%s, %s %s.", lastName, firstName, middleName.charAt(0));
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }
    public String getGender() {
        return this.gender;
    }
    public String getCourse() {
        return this.course;
    }
    
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setCourse(String course) { 
        this.course = course;
    }
}
