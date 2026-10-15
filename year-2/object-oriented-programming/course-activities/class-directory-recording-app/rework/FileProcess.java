import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileProcess {
    private static final File file = new File("ClassDirectory.txt");    // constant text file 

    public static void saveDirectory(ClassSection classSection) {
        if (file.exists()) {
            try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(file))) {
                // write class to file
                // format: Class|Grade Level|Section
                bWriter.write("Class|" + classSection.getGradeLevel() + "|" + classSection.getSection());
                bWriter.newLine();

                Adviser adviser = classSection.getAdviser();
                if (adviser != null) {
                    // write adviser to file
                    // format: Adviser|Last Name|First Name|Middle Name|Gender|Birth Date|Contact Num|Degree
                    bWriter.write(
                        "Adviser|" + 
                        adviser.getLastName() + "|" + 
                        adviser.getFirstName() + "|" + 
                        adviser.getMiddleName() + "|" +
                        adviser.getGender() + "|" +
                        adviser.getBirthDate() + "|" +
                        adviser.getContactNumber() + "|" +
                        adviser.getDegree()
                    );
                    bWriter.newLine();
                }

                ArrayList<Student> students = classSection.getStudents();
                if (students != null && students.size() != 0) {
                    // write student to file
                    for (Student student : students) {
                        // format: Student|LRN|last Name|First Name|Middle Name|gender|Birth Date|Contact Num|Address
                        bWriter.write(
                            "Student|" + 
                            student.getLRN() + "|" + 
                            student.getLastName() + "|" +
                            student.getFirstName() + "|" +
                            student.getMiddleName() + "|" +
                            student.getGender() + "|" +
                            student.getBirthDate() + "|" + 
                            student.getContactNumber() + "|" +
                            student.getAddress()
                        );
                        bWriter.newLine();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Directory successfully saved!");
        } else {
            System.out.println("File doesn't exist. Please create \"ClassDirectory.txt\"");
        }
    }

    public static void loadDirectory(ClassSection classSection) {
        classSection.clearDirectory();
        if (file.exists() && file.length() != 0) {
            try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = bReader.readLine()) != null) {
                    String[] attributes = line.split("\\|");
    
                    switch (attributes[0]) {
                        case "Class":
                            // format: Class|Grade Level|Section
                            classSection.setGradelevel(attributes[1]);
                            classSection.setSection(attributes[2]);
                            break;
                        case "Adviser":
                            // format: Adviser|Last Name|First Name|Middle Name|
                            // Gender|Birth Date|Contact Number|Degree
                            String adLastName = attributes[1];
                            String adFirstName = attributes[2];
                            String adMiddleName = attributes[3];
                            String adGender = attributes[4];
                            String adBirthdate = attributes[5];
                            long adContactNumber = Long.parseLong(attributes[6]);
                            String adDegree = attributes[7];
                            classSection.setAdviser(new Adviser(adDegree, adLastName, adFirstName, adMiddleName, adGender, adBirthdate, adContactNumber));
                            break;
                        case "Student":
                            // Student|LRN|Last Name|First Name|Middle Name|Gender|Birth Date|Contact Number|Address
                            long stLRN = Long.parseLong(attributes[1]);
                            String stLastName = attributes[2];
                            String stFirstName = attributes[3];
                            String stMiddleName = attributes[4];
                            String stGender = attributes[5];
                            String stBirthdate = attributes[6];
                            long stContactNumber = Long.parseLong(attributes[7]);
                            String stAddress = attributes[8];
                            // public Student(long lrn, String address, String lastName, String firsttName, String middleName, String gender, String birthDate, long contactNumber)
                            classSection.addStudent(new Student(stLRN, stAddress, stLastName, stFirstName, stMiddleName, stGender, stBirthdate, stContactNumber));
                            break;
                        default:
                            System.out.println("Invalid category.");
                            break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("File successfully loaded!");
        } else {
            System.out.println("File doesn't exist or is empty.");
        }
    }
}
