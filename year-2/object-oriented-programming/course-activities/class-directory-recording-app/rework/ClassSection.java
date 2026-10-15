import java.util.ArrayList;

public class ClassSection {
    private String gradeLevel;
    private String section;
    private Adviser adviser;    // Adviser object
    private ArrayList<Student> students;    // ArrayList of Student objects 
    private ArrayList<Student> sortedStudents;

    // constructor
    public ClassSection(String gradeLevel, String section) {
        this.gradeLevel = gradeLevel;
        this.section = section;
        this.adviser = null;
        this.students = new ArrayList<>();
    }

    // setters
    public void setGradelevel(String gradeLevel) { this.gradeLevel = gradeLevel; }

    public void setSection(String section) { this.section = section; }

    public void setAdviser(Adviser adviser) {this.adviser = adviser; }

    // getters
    public String getGradeLevel() { return this.gradeLevel; }
    
    public String getSection() { return this.section; }
    
    public Adviser getAdviser() { return adviser; }

    public ArrayList<Student> getStudents() { return students; }

    public ArrayList<Student> getSortedStudents() { return this.sortedStudents; }

    // utility methods
    public void viewClassDirectory(ClassSection classSection) {
        System.out.println("=".repeat(75));
        if (classSection.getGradeLevel() != null && classSection.getSection() != null) {
            // show class info
            System.out.println("CLASS SECTION DIRECTORY");
            System.out.printf("Grade Level: %s\tSection: %s\n", classSection.getGradeLevel(), classSection.getSection());
            System.out.println("-".repeat(75));
        } else {
            System.out.println("WARNING! No class assigned. \nPlease assign a class and section or save and load directory to file first.");
        }
        if (classSection.getAdviser() != null) {
            // show adviser info
            System.out.println("ADVISER INFORMATION");
            Adviser adviser = classSection.getAdviser();
            String adLastName = adviser.getLastName();
            String adFirstName = adviser.getFirstName();
            String adMiddleName = adviser.getMiddleName();
            String adGender = adviser.getGender();
            String adBirthdate = adviser.getBirthDate();
            adviser.computeAge();   // compute the age first
            int adAge = adviser.getAge();
            long adContactNumber = adviser.getContactNumber();
            String adDegree = adviser.getDegree();
            System.out.printf("Name: Prof. %s %s %s\n", adFirstName, adMiddleName, adLastName);
            System.out.printf("Gender: %s | Birthdate: %s (Age: %d)\n", adGender, adBirthdate, adAge);
            System.out.printf("Contact: %d | Degree: %s\n", adContactNumber, adDegree);
            System.out.println("-".repeat(75));
        } else {
            System.out.println("WARNING! No adviser assigned. \nPlease assign an adviser or save and load directory from file.");
        }

        if (classSection.getStudents() != null && classSection.getStudents().size() != 0) {
            // show student list
            classSection.sortStudents();    // sort the students in a dedicated ArrayList first
            ArrayList<Student> sortedStudents =  classSection.getSortedStudents();  // make an ArrayList that points to the sorted ArrayList
            System.out.println("ENROLLED STUDENTS (Sorted Alphabetically - Total: " + sortedStudents.size() + ")");
            int i = 1;  // counter variable
            for (Student student : sortedStudents) {
                long stLRN = student.getLRN();
                String stLastName = student.getLastName();
                String stFirstName = student.getFirstName();
                String stMiddleName = student.getMiddleName();
                String stGender = student.getGender();
                String stBirthdate = student.getBirthDate();
                student.computeAge();
                int stAge = student.getAge();
                long stContactNumber = student.getContactNumber();
                String stAddress = student.getAddress();
    
                System.out.printf("[%02d]\tLRN: %d\n", i, stLRN);
                System.out.printf("\tName: %s, %s %s\n", stLastName, stFirstName, stMiddleName);
                System.out.printf("\tGender: %s |  Birthdate: %s (Age: %d) | Contact: %d\n", stGender, stBirthdate, stAge, stContactNumber);
                System.out.printf("\tAddress: %s\n", stAddress);
                i++;
            }
        } else {
            System.out.println("WARNING! No students in class. \nPlease add a student or save and load directory from file.");
        }
        System.out.println("=".repeat(75));
    }
    
    public void sortStudents() {
        if (this.students == null || this.students.size() == 0) { return; }
        ArrayList<Student> sortedStudents = new ArrayList<>(this.students);

        int size = sortedStudents.size();
        for (int i = 1; i < size; i++) {
            Student key = sortedStudents.get(i);
            String keyName = key.getLastName() + " " + key.getFirstName();
            int j = i - 1;  // sorted Student object(s) boundary
            
            while (j >= 0 &&  (sortedStudents.get(j).getLastName() + " " + sortedStudents.get(j).getFirstName()).compareToIgnoreCase(keyName) > 0) {
                sortedStudents.set(j + 1, sortedStudents.get(j));
                j--;
            }
            // place the unsorted element to its correct position
            sortedStudents.set(j + 1, key);
        }
        this.sortedStudents = sortedStudents;
    }

    public void assignAdviser(ClassSection classSection) {
        boolean willAssign = true;
        if (classSection.getAdviser() != null) {
            System.out.print("There is already an assigned adviser to this class.\nReplace Adviser (Y/N)? ");
            char choice = UserInput.acceptChar();
            System.out.println(choice);
            switch(choice) {
                case 'Y':
                    break;
                case 'N':
                    willAssign = false;
                    break;
                default:
                    willAssign = false;
                    System.out.println("Invalid choice.");
            }
        }
        if (willAssign) {
            System.out.println("--- ASSIGN ADVISER ---");
            System.out.print("Enter Last Name: ");
            String adLastName = UserInput.acceptString();
            System.out.print("Enter First Name: ");
            String adFirstName = UserInput.acceptString();
            System.out.print("Enter Middle Name: ");
            String adMiddleName = UserInput.acceptString();
            System.out.print("Enter Gender: ");
            String adGender = UserInput.acceptString();
            System.out.print("Enter Birth Date (YYYY-MM-DD): ");
            String adBirthDate = UserInput.acceptString();
            System.out.print("Enter Contact Number: ");
            long adContactNumber = UserInput.acceptLong();
            System.out.print("Enter Degree: ");
            String adDegree = UserInput.acceptString();
            
            classSection.setAdviser(new Adviser(adDegree, adLastName, adFirstName, adMiddleName, adGender, adBirthDate, adContactNumber));

            System.out.println("Adviser assigned successfully.");
        }
    }

    public void addStudent(Student student) { students.add(student); }

    public void addStudent(ClassSection classSection) {
        System.out.printf("--- %s ---\n", "ADD NEW STUDENT" );
        System.out.print("Enter LRN: ");
        long stLRN = UserInput.acceptLong();
        System.out.print("Enter Last Name: ");
        String stLastName = UserInput.acceptString();
        System.out.print("Enter First Name: ");
        String stFirstName = UserInput.acceptString();
        System.out.print("Enter Middle Name: ");
        String stMiddleName = UserInput.acceptString();
        System.out.print("Enter Gender: ");
        String stGender = UserInput.acceptString();
        System.out.print("Enter Birth Date (YYYY-MM-DD): ");
        String stBirthDate = UserInput.acceptString();
        System.out.print("Enter Contact Number: ");
        long adContactNumber = UserInput.acceptLong();
        System.out.print("Enter Home Address: ");
        String stAddress = UserInput.acceptString();

        classSection.addStudent(new Student(stLRN, stAddress, stLastName, stFirstName, stMiddleName, stGender, stBirthDate, adContactNumber));
        System.out.println("Student added successfully.");
    }

    public void clearDirectory() {
        this.students = new ArrayList<>();
    }

    public void editStudent(ClassSection classSection) {
        if (classSection.getStudents() == null || classSection.getStudents().size() == 0) {
            System.out.println("No student enrolled yet. Please add a student first.");
            return;
        }
        System.out.print("Enter LRN: ");
        long inputLRN = UserInput.acceptLong();
        boolean found = false;
        for (Student student : classSection.getStudents()) {
            if (student.getLRN() == inputLRN) {
                System.out.println("""
                        1. LRN
                        2. Last Name
                        3. First Name
                        4. Middle Name
                        5. Gender
                        6. BirthDate
                        7. Contact Number
                        8. Home Address
                        9. Exit
                        Choice:\t""");
                int choice = UserInput.acceptInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter LRN: ");
                        student.setLRN(UserInput.acceptLong());
                        break;
                    case 2:
                        System.out.print("Enter Last Name: ");
                        student.setLastName(UserInput.acceptString());
                        break;
                    case 3:
                        System.out.print("Enter First Name: ");
                        student.setFirstName(UserInput.acceptString());
                        break;
                    case 4:
                        System.out.print("Enter Middle Name: ");
                        student.setMiddleName(UserInput.acceptString());
                        break;
                    case 5:
                        System.out.print("Enter Gender: ");
                        student.setGender(UserInput.acceptString());
                        break;
                    case 6:
                        System.out.print("Enter Birthdate (YYYY-MM-DD): ");
                        student.setBirthDate(UserInput.acceptString());
                        break;
                    case 7:
                        System.out.print("Enter Contact Number: ");
                        student.setContactNumber(UserInput.acceptLong());
                        break;
                    case 8:
                        System.out.print("Enter Home Address: ");
                        student.setAddress(UserInput.acceptString());
                        break;
                    case 9:
                        System.out.println("Exiting the updating student system...");
                        return;
                    default:
                        System.out.println("Invalid Input!");
                        break;
                }
                found = true;
                break; // stop once match is updated
            }
        }
        if (!found) {
            System.out.println("LRN not found.");
        } else {
            System.out.println("Student successfully updated!");
        }
    }
}