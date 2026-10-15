package FInalsPractice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class All {
    public static void main(String[] args) {
        Path path = Paths.get("grades.txt");
        ArrayList<String> records = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("File created.");
                }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }

        String[] students = new String[3];  // 3 students
        int[][] grades = new int[3][3]; // 3 grades for each student
        for (int i = 0; i < students.length; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            students[i] = sc.nextLine();    // store each student's name
            for (int j = 0; j < grades[i].length; j++) {
                System.out.print("Grade " + (j + 1) + ": ");
                grades[i][j] = sc.nextInt();    // store each student's grades on one row
            }
            sc.nextLine();  // consume leftover line
        }

        for (int i = 0; i < students.length; i++) {
            int sum = 0;
            for (int j = 0; j < grades[i].length; j++) {
                sum += grades[i][j];
            }
            double average = (double) sum / grades[i].length;
            String record = String.format("%s: %.2f", students[i], average);
            records.add(record);
        }
        try {
            if (Files.exists(path)) {
                for (String record : records) {
                    Files.writeString(path, record + "\n", StandardOpenOption.APPEND);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String pseudoGrade = line.split(":")[1];
                double grade = Double.parseDouble(pseudoGrade.trim());
                if (grade >= 75) System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        sc.close();
    }
}
