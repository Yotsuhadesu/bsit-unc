public interface ClassList {
    int MAX_STUDENTS = 40;  // constant variable

    default String getInstitutionName() {
        return "University of Nueva Caceres";
    }

    // abstract methods
    void assignCollegeDetails();
    void assignProgramDetails();
    void assignCourseDetails();
    void assignInstructorDetails();
    void addStudent();
    void removeStudent();
    void displayStudents();
    void displayClassRecord();
}
