import java.io.File;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileProcess {
    // static method to save the college, program, course, faculty, and the students to a text file
    public static void saveToFile(College college, Program program, Course course, Faculty faculty, ArrayList<Student> students) {
        System.out.println("--- PERSISTENT FILE STORAGE ---");
        File file = new File("ClassRecord_" + course.getCourseCode() + ".txt"); // dynamic file naming
        if (!file.exists()) {
            System.out.println(">> Creating " + file.getName() + ".");
            System.out.println(">> " + file.getName() + " successfully created!");
        }

        System.out.printf(">> Saving current class record to \"%s\"...\n", file.getName());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // save college
            writer.write("COLLEGE|" + 
                college.getCollegeCode() + "|" +
                college.getCollegeName()
            );
            writer.newLine();
            
            // save program
            writer.write("PROGRAM|" + 
            program.getProgramCode() + "|" +
            program.getProgramName()
            );
            writer.newLine();

            // save course
            writer.write("COURSE|" + 
                course.getCourseCode() + "|" +
                course.getCourseID() + "|" +
                course.getCourseName() + "|" + 
                course.getUnits()
            );
            writer.newLine();
            
            // save faculty
            writer.write("FACULTY|" + 
                faculty.getFacultyID() + "|" +
                faculty.getFirstName() + "|" +
                faculty.getMiddleName() + "|" +
                faculty.getLastName() + "|" +
                faculty.getDegree()
            );
            writer.newLine();

            // save students
            for(Student student : students) {
                writer.write("STUDENT|" + 
                    student.getStudentNumber() + "|" +
                    student.getFirstName() + "|" +
                    student.getMiddleName() + "|" +
                    student.getLastName() + "|" +
                    student.getGender() + "|" + 
                    student.getCourse()
                );
                writer.newLine();
            }
            System.out.println(">> Class record data saved successfully!");
        } catch (Exception e) {
            System.out.println(">> Cannot save the class record to " + file.getName() + ".");
            e.printStackTrace();
        }
    }
    
    // static method to retrieve college, programs, course, faculty, and the students from a text file
    public static void loadFromFile(College college, Program program, Course course, Faculty faculty, ArrayList<Student> students) {
        File file = new File("ClassRecord_" + course.getCourseCode() + ".txt");
        if (!file.exists()) {
            System.out.println(">> " + file.getName() + " doesn't exist. Please save the class record to file first.");
            return;
        }

        System.out.printf(">> Fetching class record data from \"%s\"...\n", file.getName());
        students.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split("\\|");

                switch (attributes[0]) {
                    case "COLLEGE":
                        college.setCollegeCode(attributes[1]);
                        college.setCollegeName(attributes[2]);
                        break;
                    case "PROGRAM":
                        program.setProgramCode(attributes[1]);
                        program.setProgramName(attributes[2]);
                        break;
                    case "COURSE":
                        course.setCourseCode(attributes[1]);
                        course.setCourseID(attributes[2]);
                        course.setCourseName(attributes[3]);
                        course.setUnits(Integer.parseInt(attributes[4]));
                        break;
                    case "FACULTY":
                        faculty.setFacultyID(attributes[1]);
                        faculty.setFirstName(attributes[2]);
                        faculty.setMiddleName(attributes[3]);
                        faculty.setLastName(attributes[4]);
                        faculty.setDegree(attributes[5]);
                        break;
                    case "STUDENT":
                        String studentNumber = attributes[1];
                        String firstName = attributes[2];
                        String middleName = attributes[3];
                        String lastName = attributes[4];
                        String gender = attributes[5];
                        String stCourse = attributes[6];
                        Student student = new Student(firstName, middleName, lastName, studentNumber, gender, stCourse);
                        students.add(student); 
                        break;
                    default:
                        System.out.println(">> Invalid classification encountered: " + attributes[0]);
                        break;
                }
            }
            System.out.println(">> Class record data fetched successfully!");
        } catch (Exception e) {
            System.out.println(">> An error occurred while reading " + file.getName() + ".");
            e.printStackTrace();
        }
    }
}