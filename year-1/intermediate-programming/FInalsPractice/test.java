package FInalsPractice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class test {
    static void main(String[] args) {
        Path path = Paths.get("grades.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String pseudoGrade = line.split(":")[1];
                double grade = Double.parseDouble(pseudoGrade);
                if (grade >= 75) System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}
