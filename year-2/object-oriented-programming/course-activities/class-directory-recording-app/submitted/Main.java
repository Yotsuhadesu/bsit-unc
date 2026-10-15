import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClassSection classSection = new ClassSection();

        // initial section setup
        System.out.print("Enter Grade Level: ");
        classSection.setGradeLevel(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter Section: ");
        classSection.setSection(scanner.nextLine());

        // menu
        System.out.println("=== SCHOOL CLASS DIRECTORY SYSTEM ===");
        System.out.println("[1] View Class Directory");
        System.out.println("[2] Assign/Update Adviser");
        System.out.println("[3] Add Student");
        System.out.println("[4] Update Student by LRN");
        System.out.println("[5] Save Directory to File");
        System.out.println("[6] Load Directory from File");
        System.out.println("[7] Exit");

        int choice;
        do {
            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (choice) {
                case 1:
                    viewClassDirectory(classSection);
                    break;
                case 2:
                    classSection.setAdviser(assignAdviser(scanner));
                    System.out.println(">>> Adviser assigned successfully.");
                    break;
                case 3:
                    addStudent(classSection.getStudents(), scanner);
                    break;
                case 4:
                    updateStudent(classSection, scanner);
                    break;
                case 5:
                    saveDirectory(classSection);
                    break;
                case 6:
                    loadDirectory(classSection);
                    break;
                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while(choice != 7);
    }

    // print section, adviser, sorted student list
    public static void viewClassDirectory(ClassSection classSection) {
        System.out.println("=".repeat(50));
        System.out.println("CLASS SECTION DIRECTORY");
        System.out.println("Grade Level: Grade " + classSection.getGradeLevel() + "\tSection Name: " +  classSection.getSection());
        System.out.println("-".repeat(50));
        System.out.println("ADVISER INFORMATION:");
        String advFullName = classSection.getAdviser().getFirstName() + " " + classSection.getAdviser().getMiddleName() + " " + classSection.getAdviser().getLastName();
        System.out.println("Name: Prof. " + advFullName);
        classSection.getAdviser().processAge();
        System.out.println("Gender: " + classSection.getAdviser().getGender() + " | Birthdate: " + classSection.getAdviser().getBirthDate() + " (Age: " + classSection.getAdviser().getAge() + ")");
        System.out.println("Contact: " + classSection.getAdviser().getContactNumber() + " | Degree: " + classSection.getAdviser().getHighestDegree());
        sortStudents(classSection);
        displayStudents(classSection);
    }

    // prompt and build adviser
    public static Adviser assignAdviser(Scanner scanner) {
        System.out.println("--- ASSIGN ADVISER ---");
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Middle Name: ");
        String middleName = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Birthdate (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        long contactNumber = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter Highest Degree Earned: ");
        String highestDegree = scanner.nextLine();
        return new Adviser(lastName, firstName, middleName, gender, birthDate, contactNumber, highestDegree);
    }

    // prompt and add new student
    public static void addStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.println("--- ADD NEW STUDENT ---");
        System.out.print("Enter LRN: ");
        long lRN = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Middle Name: ");
        String middleName = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Birthdate (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        long contactNumber = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter Home Address: ");
        String homeAddress = scanner.nextLine();
        students.add(new Student(lRN, lastName, firstName, middleName, gender, birthDate, contactNumber, homeAddress));
        System.out.println(">>> Student added successfully!");
    }

    // bubble sort 
    public static void sortStudents(ClassSection classSection) {
        ArrayList<Student> students = classSection.getStudents();

        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size() - 1 - i; j++) {
                String lnCurrent = students.get(j).getLastName();
                String lnNext = students.get(j + 1).getLastName();
                String fnCurrent = students.get(j).getFirstName();
                String fnNext = students.get(j + 1).getFirstName();
                if (lnCurrent.compareToIgnoreCase(lnNext) > 0) {
                    // swap
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                } else if (lnCurrent.compareToIgnoreCase(lnNext) == 0) {
                    if (fnCurrent.compareToIgnoreCase(fnNext) > 0) {
                        // swap
                        Student temp = students.get(j);
                        students.set(j, students.get(j + 1));
                        students.set(j + 1, temp);
                    }
                }
            }
        }
    }

    // print all students
    public static void displayStudents(ClassSection classSection) {
        ArrayList<Student> students = classSection.getStudents();
        System.out.println("-".repeat(50));
        System.out.println("ENROLLED STUDENTS (Sorted Alphabetically - Total: " + students.size() + ")");
        System.out.println();
        int i = 1;
        for (Student student : students) {
            long lRN = student.getLRN();
            String name = student.getLastName() + ", " + student.getFirstName() + " " + student.getMiddleName();
            String gender = student.getGender();
            String birthDate = student.getBirthDate();
            student.processAge();
            int age = student.getAge();
            long contactNumber = student.getContactNumber();
            String address = student.getHomeAddress();
            System.out.println("[" + i + "]" + "\t" + "LRN: " + lRN);
            System.out.println("\tName: " + name);
            System.out.printf("\tGender: %s | Birthdate: %s (Age: %d) | Contact: %d\n", gender, birthDate, age, contactNumber);
            System.out.println("\tAddress: " + address);
            i++;
        }
        System.out.println("-".repeat(50));
    }

    // find student by LRN and edit chosen field
    public static void updateStudent(ClassSection classSection, Scanner scanner) {
        System.out.print("Enter LRN: ");
        long inputLRN = scanner.nextLong();
        scanner.nextLine();
        ArrayList<Student> students = classSection.getStudents();
        boolean found = false;
        for (Student student : students) {
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
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.print("Enter LRN: ");
                        student.setLrn(scanner.nextLong());
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.print("Enter Last Name: ");
                        student.setLastName(scanner.nextLine());
                        break;
                    case 3:
                        System.out.print("Enter First Name: ");
                        student.setFirstName(scanner.nextLine());
                        break;
                    case 4:
                        System.out.print("Enter Middle Name: ");
                        student.setMiddleName(scanner.nextLine());
                        break;
                    case 5:
                        System.out.print("Enter Gender: ");
                        student.setGender(scanner.nextLine());
                        break;
                    case 6:
                        System.out.print("Enter Birthdate (YYYY-MM-DD): ");
                        student.setBirthDate(scanner.nextLine());
                        break;
                    case 7:
                        System.out.print("Enter Contact Number: ");
                        student.setContactNumber(scanner.nextLong());
                        break;
                    case 8:
                        System.out.print("Enter Home Address: ");
                        student.setHomeAddress(scanner.nextLine());
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
        }
    }

    // write section, adviser, students to file
    public static void saveDirectory(ClassSection classSection) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ClassDirectory.txt"))) {
            writer.write("Section," + classSection.getGradeLevel() + "," + 
            classSection.getSection());
            writer.newLine();
            
            Adviser adviser = classSection.getAdviser();
            if (adviser != null) {
                writer.write("Adviser," + adviser.getLastName() + "," + 
                adviser.getFirstName() + "," + adviser.getMiddleName() + "," + 
                adviser.getGender() + "," + adviser.getBirthDate() + "," + 
                adviser.getContactNumber() + "," + adviser.getHighestDegree());
                writer.newLine();
            }
            
            if (classSection.getStudents() != null) {
                for (Student student : classSection.getStudents()) {
                    writer.write("Student," + student.getLRN() + "," + 
                    student.getLastName() + "," + student.getFirstName() + "," + 
                    student.getMiddleName() + "," + student.getGender() + "," + 
                    student.getBirthDate() + "," + student.getContactNumber() + "," + 
                    student.getHomeAddress());
                    writer.newLine();
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while saving the file.");
            e.printStackTrace();
        }
        System.out.println(">>> Directory saved successfully!");
    }

    // read section, adviser, students from file
    public static void loadDirectory(ClassSection classSection) {
        try(BufferedReader reader = new BufferedReader(new FileReader("ClassDirectory.txt"))) {
            classSection.getStudents().clear(); // avoid duplicates on reload
            String line;

            while((line = reader.readLine()) != null) {
                String attribute = line.split(",")[0];

                switch (attribute) {
                    case "Section":
                        int gradeLevel = Integer.parseInt(line.split(",")[1]);
                        String section = line.split(",")[2];
                        classSection.setGradeLevel(gradeLevel);
                        classSection.setSection(section);
                        break;
                    case "Adviser":
                        String advLastName = line.split(",")[1];
                        String advFirstName = line.split(",")[2];
                        String advMiddleName = line.split(",")[3];
                        String advGender = line.split(",")[4];
                        String advBirthDate = line.split(",")[5];
                        long advContactNumber = Long.parseLong(line.split(",")[6]);
                        String advDegree = line.split(",")[7];
                        Adviser adviser = new Adviser(advLastName, advFirstName, advMiddleName, advGender, advBirthDate, advContactNumber, advDegree);
                        classSection.setAdviser(adviser);
                        break;
                    case "Student":
                        long lRN = Long.parseLong(line.split(",")[1]);
                        String stdLastName = line.split(",")[2];
                        String stdFirstName = line.split(",")[3];
                        String stdMiddleName = line.split(",")[4];
                        String stdGender = line.split(",")[5];
                        String stdBirthDate = line.split(",")[6];
                        long stdContactNumber = Long.parseLong(line.split(",")[7]);
                        String stdAddress = line.split(",")[8];
                        ArrayList<Student> students = classSection.getStudents();
                        if (students == null) {
                            students = new ArrayList<>();
                            classSection.setStudents(students);
                        }
                        students.add(new Student(lRN, stdLastName, stdFirstName, stdMiddleName, stdGender, stdBirthDate, stdContactNumber, stdAddress));
                        break;
                    default:
                        System.out.println("Invalid attribute.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        System.out.println(">>> Directory loaded successfully!");
    }
}