package FInalsPractice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ErrorFileHandling {
    public static void main(String[] args) {
        try (
                Scanner sc = new Scanner(System.in);
                ) {
            System.out.print("Kimi no na wa: ");
            String user = sc.nextLine();
            System.out.print("Filename: ");
            String file = sc.nextLine();
            Path path = Paths.get(file);
            if (Files.exists(path)) {
                List<String> lines = Files.readAllLines(path);
                for (String line : lines) System.out.println(line);
            } else {
                Files.createFile(path);
                Files.writeString(path, "File created by " + user);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
