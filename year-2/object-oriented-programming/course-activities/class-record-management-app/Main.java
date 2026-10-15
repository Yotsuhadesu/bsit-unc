public class Main {
    public static void main(String[] args) {
        ClassRecord classRecord = new ClassRecord();
        Input.showMenu(classRecord);
        int choice;
        do {
            System.out.println();
            choice = Input.acceptInt("Select option:");
            System.out.println();
            switch (choice) {
                case 1:
                    classRecord.assignCollegeDetails();
                    classRecord.assignProgramDetails();
                    break;
                case 2:
                    classRecord.assignCourseDetails();
                    break;
                case 3:
                    classRecord.assignInstructorDetails();
                    break;
                case 4:
                    classRecord.addStudent();
                    break;
                case 5:
                    classRecord.removeStudent();
                    break;
                case 6:
                    classRecord.displayStudents();
                    break;
                case 7:
                    classRecord.displayClassRecord();
                    break;
                case 8:
                    classRecord.saveToFile();
                    break;
                case 9:
                    classRecord.loadFromFile();
                    break;
                case 0:
                    System.out.println("Exiting system. Thank you for using UNC Class Record System!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while(choice != 0);
    }
}