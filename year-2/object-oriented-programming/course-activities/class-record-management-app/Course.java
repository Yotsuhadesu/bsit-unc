public class Course {
    private String courseCode;
    private String courseID;
    private String courseName;
    private int units;

    public String getCourseCode() {
        return this.courseCode;
    }
    public String getCourseID() {
        return this.courseID;
    }
    public String getCourseName() {
        return this.courseName;
    }
    public int getUnits() {
        return this.units;
    }
    
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setUnits(int units) {
        this.units = units;
    }
}
