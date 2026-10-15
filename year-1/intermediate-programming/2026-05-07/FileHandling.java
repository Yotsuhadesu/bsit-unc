import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        Path path = Paths.get("grades.txt");    // address object for the file
        if (!Files.exists(path)) {
            try {
                Files.createFile(path); // create the file if it doesn't exist
                System.out.println("File created!");
            } catch (IOException e) {
                System.out.println("There is an error while creating the file.");
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        try {
            Files.writeString(path,name + " " + grade + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("There is an error while saving your data.");
        }
        try {
            List<String> lines = Files.readAllLines(path);    // store all lines in a list
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("There is an error while reading the file.");
        }
    }
}
