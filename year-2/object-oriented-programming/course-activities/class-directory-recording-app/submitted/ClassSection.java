import java.util.ArrayList;

public class ClassSection {
    // fields
    private int gradeLevel;
    private String section;
    private Adviser adviser;
    private ArrayList<Student> students;

    // init empty list
    public ClassSection() {
        this.students = new ArrayList<>();
    }

    // setters
    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
    public void setSection(String section) {
        this.section = section;
    }
    public void setAdviser(Adviser adviser) {
        this.adviser = adviser;
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    // getters
    public int getGradeLevel() {
        return this.gradeLevel;
    }
    public String getSection() {
        return this.section;
    }
    public Adviser getAdviser() {
        return this.adviser;
    }
     public ArrayList<Student> getStudents() {
        return this.students;
    }
}