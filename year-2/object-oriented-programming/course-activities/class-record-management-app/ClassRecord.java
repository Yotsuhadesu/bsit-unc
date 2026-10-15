import java.util.ArrayList;

public class ClassRecord implements ClassList{
    // composition of initialized class instances
    private College college = new College();
    private Program program = new Program();
    private Course course = new Course();
    private Faculty faculty = new Faculty();
    private ArrayList <Student> students = new ArrayList<>();
    private ArrayList <Student> sortedStudents = new ArrayList<>(); 

    // overrridden abstract methods from the ClassList interface
    @Override 
    public void assignCollegeDetails() {
        System.out.println("--- COLLEGE & PROGRAM ASSIGNMENT ---");
        college.setCollegeCode(Input.acceptString("Enter College Code:"));
        college.setCollegeName(Input.acceptString("Enter College Name:"));
    }
    @Override
    public void assignProgramDetails() {
        program.setProgramCode(Input.acceptString("Enter Program Code:"));
        program.setProgramName(Input.acceptString("Enter Program Name:"));
        System.out.println(">> College and Program successfully assigned!");
    }
    @Override 
    public void assignCourseDetails() {
        System.out.println("--- COURSE (SUBJECT) DETAILS ---");
        course.setCourseCode(Input.acceptString("Enter Subject Code:"));
        course.setCourseID(Input.acceptString("Enter Subject ID:"));
        course.setCourseName(Input.acceptString("Enter Subject Name:"));
        course.setUnits(Input.acceptInt("Enter Units:"));
        System.out.println(">> Course details successfully set!");

    }
    @Override
    public void assignInstructorDetails() {
        System.out.println("--- FACULTY INSTRUCTOR ASSIGNMENT ---");
        faculty.setFacultyID(Input.acceptString("Enter Faculty ID:"));
        faculty.setFirstName(Input.acceptString("Enter First Name:"));
        faculty.setMiddleName(Input.acceptString("Enter Middle Name:"));
        faculty.setLastName(Input.acceptString("Enter Last Name:"));
        faculty.setDegree(Input.acceptString("Enter Highest Degree:"));
        System.out.println(">> Instructor successfully assigned!");
    }
    @Override
    public void addStudent() {
        if (students.size() == MAX_STUDENTS) {
            System.out.println(">> The current class is at full capacity. It cannot accept more students.");
            return;
        }
        System.out.printf("--- ADD ENROLLED STUDENT (Current: %d/%d) ---\n", students.size(), MAX_STUDENTS);
        String studentNumber = Input.acceptString("Enter Student No:");
        String firstName = Input.acceptString("Enter First Name:");
        String middleName = Input.acceptString("Enter Middle Name:");
        String lastName = Input.acceptString("Enter Last Name:");
        String gender = Input.acceptString("Enter Gender:");
        String course = Input.acceptString("Enter Course Enrolled:");
        Student student = new Student(firstName, middleName, lastName, studentNumber, gender, course);
        students.add(student);
        System.out.printf(">> Student %s added successfully!\n", student.getCompleteName());
    }
    @Override
    public void removeStudent() {
        String studentNumber = Input.acceptString("Enter Student Number:");

        boolean isFound = false;
        int i = 0;
        for (Student student : students) {  // find the student's index in the ArrayList
            if (student.getStudentNumber().equals(studentNumber)) {
                isFound = true;
                break;
            }
            i++;
        }
        if (isFound) {
            Student student = students.get(i);
            boolean willRemove = Input.acceptBoolean("Remove " + student.getCompleteName() + "? (true/false)");
            if (willRemove) {
                students.remove(i);
                System.out.println(">> Student successfully removed!");
            } else {
                System.out.println(">> Student didn't get removed!");
            }
        } else {
            System.out.println(">> Unknown student number.");
        }
    }
    @Override
    public void displayStudents() {
        switch (Input.acceptInt("""
                === ENROLLED STUDENTS LIST ===
                [1] Sort Alphabetically
                [2] Display in Order Added
                Select option:""")) {
            case 1:
                sortStudents();
                viewStudents(sortedStudents, "TABLE");
                break;
            case 2:
                viewStudents(students, "TABLE");
                break;
            default:
                System.out.println(">> Invalid choice.");
                break;
        }
    }
    @Override
    public void displayClassRecord() {
        System.out.println("=".repeat(100));
        System.out.println("OFFICIAL CLASS RECORD | " + getInstitutionName());
        System.out.println("=".repeat(100));
        System.out.printf(
                "COLLEGE: [%s] %s\n" +
                "PROGRAM: [%s] %s\n" +
                "COURSE: %s - %s (Subject ID: %s | Units: %d)\n" +
                "INSTRUCTOR: %s (ID: %s)\n", 
                college.getCollegeCode(), college.getCollegeName(),
                program.getProgramCode(), program.getProgramName(),
                course.getCourseCode(), course.getCourseName(), course.getCourseID(), course.getUnits(),
                faculty.getCompleteName(), faculty.getFacultyID()
            );
        System.out.println("-".repeat(100));
        System.out.println("ENROLLED STUDENTS ROSTER (Sorted Alphabetically):");
        sortStudents();
        viewStudents(sortedStudents, "ITEM");
        System.out.println("=".repeat(100));
    }

    // helper methods
    public void saveToFile() {
        FileProcess.saveToFile(this.college, this.program, this.course, this.faculty, this.students);
    }
    public void loadFromFile() {
        FileProcess.loadFromFile(this.college, this.program, this.course, this.faculty, this.students);
    }

    public void sortStudents() {
        ArrayList<Student> sortedStudents = new ArrayList<>(this.students); // copy the ArrayList of Student objects

        // insertion sort
        for (int i = 1; i < sortedStudents.size(); i++) {
            Student key = sortedStudents.get(i);
            int j = i - 1;
            while (j >= 0 && sortedStudents.get(j).getCompleteName().compareToIgnoreCase(key.getCompleteName()) > 0) {
                sortedStudents.set(j + 1, sortedStudents.get(j));
                j--;
            }
            sortedStudents.set(j + 1, key);
        }
        this.sortedStudents = sortedStudents;
    }

    public void viewStudents(ArrayList<Student> students, String format) {
        int i = 1;
        System.out.println("-".repeat(100));
        switch (format) {
            case "TABLE":
                System.out.printf("%-2s %-13s %-45s %-8s %-18s\n", "#", "STUDENT NO.", "COMPLETE NAME (Lastname, Firstname M.I.)", "GENDER", "COURSE ENROLLED");
                System.out.println("-".repeat(100));
                for (Student student : students) {
                    System.out.printf("%-2d %-13s %-45s %-8s %-18s\n", i, student.getStudentNumber(), student.getCompleteName(), student.getGender(), student.getCourse());
                    i++;
                }
                System.out.println("-".repeat(100));
                System.out.printf("Total Enrolled: %d / %d Students\n", students.size(), MAX_STUDENTS);
                break;
            case "ITEM":
                for (Student student : students) {
                    System.out.printf("%d. [%s] %s | Gender: %s | Program: %s\n", i, student.getStudentNumber(), student.getCompleteName(), student.getGender(), student.getCourse());
                    i++;
                }
                break;
            default:
                System.out.println(">> Invalid student viewing format.");
                break;
        }
    }
}