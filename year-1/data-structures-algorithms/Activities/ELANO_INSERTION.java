import java.io.*;
import java.util.Scanner;

public class ELANO_INSERTION {
    // data storage
    static String[] names = new String[20];
    static String[] genders = new String[20];
    static String[] courses = new String[20];
    static String[] yearLevels = new String[20];

    public static void writeFile(File file) {
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File not found. \nFile created.");
                }
            } catch (IOException e) {
                System.out.println("Cannot create the file.");
            }
        }
        if (file.exists() && file.length() == 0) {
            try(
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                    Scanner sc = new Scanner(System.in)
            ) {
                int i = 0;
                while(i < 20) {
                    System.out.print("Student: ");
                    bw.write(sc.nextLine());
                    bw.newLine();
                    i++;
                }
            } catch (IOException e) {
                System.out.println("Could not write to file.");
            }
        }
    }
    public static void readFile(File file) {    // read and store the data
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;  // index
            while((line = br.readLine()) != null) {
                String[] credentials = line.split(",");
                // store each student's credentials in designated arrays
                names[i] = credentials[0];
                genders[i] = credentials[1];
                courses[i] = credentials[2];
                yearLevels[i] = credentials[3];
                i++;
            }
        } catch (IOException e) {
            System.out.println("Cannot read the file.");
        }
    }
    public static int displayMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                Sorting Options:
                1. Sort by Name
                2. Sort by Gender
                3. Sort by Course
                4. Sort by Year Level
                Choice:""");
        return sc.nextInt();
    }
    public static void sortData(int choice) {
        switch (choice) {
            case 1: // sort by name
                for(int i = 1; i < 20; i++) {
                    String keyN = names[i];
                    String keyG = genders[i];
                    String keyC = courses[i];
                    String keyY = yearLevels[i];
                    int j = i - 1;
                    while(j >= 0 && names[j].compareTo(keyN) > 0) {
                        names[j + 1] = names[j];
                        genders[j + 1] = genders[j];
                        courses[j + 1] = courses[j];
                        yearLevels[j + 1] = yearLevels[j];
                        j--;
                    }
                    names[j + 1] = keyN;
                    genders[j + 1] = keyG;
                    courses[j + 1] = keyC;
                    yearLevels[j + 1] = keyY;
                }
                break;
            case 2: // sort by gender
                for(int i = 1; i < 20; i++) {
                    String keyN = names[i];
                    String keyG = genders[i];
                    String keyC = courses[i];
                    String keyY = yearLevels[i];
                    int j = i - 1;
                    while(j >= 0 && genders[j].compareTo(keyG) > 0) {
                        names[j + 1] = names[j];
                        genders[j + 1] = genders[j];
                        courses[j + 1] = courses[j];
                        yearLevels[j + 1] = yearLevels[j];
                        j--;
                    }
                    names[j + 1] = keyN;
                    genders[j + 1] = keyG;
                    courses[j + 1] = keyC;
                    yearLevels[j + 1] = keyY;
                }
                break;
            case 3: // sort by course
                for(int i = 1; i < 20; i++) {
                    String keyN = names[i];
                    String keyG = genders[i];
                    String keyC = courses[i];
                    String keyY = yearLevels[i];
                    int j = i - 1;
                    while(j >= 0 && courses[j].compareTo(keyC) > 0) {
                        names[j + 1] = names[j];
                        genders[j + 1] = genders[j];
                        courses[j + 1] = courses[j];
                        yearLevels[j + 1] = yearLevels[j];
                        j--;
                    }
                    names[j + 1] = keyN;
                    genders[j + 1] = keyG;
                    courses[j + 1] = keyC;
                    yearLevels[j + 1] = keyY;
                }
                break;
            case 4: // sort by year level
                for(int i = 1; i < 20; i++) {
                    String keyN = names[i];
                    String keyG = genders[i];
                    String keyC = courses[i];
                    String keyY = yearLevels[i];
                    int j = i - 1;
                    while(j >= 0 && yearLevels[j].charAt(0) > keyY.charAt(0)) {
                        names[j + 1] = names[j];
                        genders[j + 1] = genders[j];
                        courses[j + 1] = courses[j];
                        yearLevels[j + 1] = yearLevels[j];
                        j--;
                    }
                    names[j + 1] = keyN;
                    genders[j + 1] = keyG;
                    courses[j + 1] = keyC;
                    yearLevels[j + 1] = keyY;
                }
                break;
        }
    }
    public static void display() {
        System.out.println("- - - - - - - Students List - - - - - - -");
        System.out.printf("%-13s %-9s %-8s %-8s \n", "NAME", "GENDER", "COURSE", "YEAR LEVEL");
        for(int i = 0; i < 20; i++) {
            String name = names[i];
            String gender = genders[i];
            String course = courses[i];
            String yearLevel = yearLevels[i];
            System.out.printf("%-13s %-9s %-8s %-8s \n",name, gender, course, yearLevel);
        }
    }
    public static void main(String[] args) {
        File file = new File("students.txt");
        writeFile(file);
        readFile(file);
        sortData(displayMenu());
        display();
    }
}