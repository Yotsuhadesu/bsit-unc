package FInalsPractice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class FileErrorHandling {
    public static void main(String[] args) {
        Path path = Paths.get("student.txt");
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                System.out.println("File created.");
            } catch (IOException e) {
                System.out.println("File not created.");
            }
        }
        try (
                BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND);
                Scanner scanner = new Scanner(System.in)
        ) {
            for (int i = 1; i <= 3; i++) {
                System.out.print("Student " + i + ": ");
                writer.write(scanner.nextLine());
                writer.newLine();
            }
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not write on the file.");
        }
    }
}
