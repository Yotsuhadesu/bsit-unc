/*
    Description: An application of Intermediate Programming Java file handling lecture
 */
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import static java.nio.file.StandardOpenOption.APPEND;

public class FileStudy {
    public static void main(String[] args) {
        Path path = Paths.get("myfile.txt");
        if(Files.exists(path)) {
            System.out.println(path);
        } else {
            try {
                Files.createFile(path); // create the file if it's non-existent
                System.out.println("File created");
            } catch (IOException e) {
                System.out.println("Cannot create the file");
            }
        }
        try {
            Files.writeString(path, "Java file handling is clicking\n", APPEND);    // append instead of overwrite
            System.out.println("Successfully written on the file");
        } catch (IOException e) {
            System.out.println("Cannot write on the file");
        }
        try {
            List<String> lines = Files.readAllLines(path);  // store the file content line by line into a list
            int count = 1;
            for (String line : lines) {
                System.out.println("Line " + count + ": " + line);  // print each line with line number
                count++;
            }
            System.out.println("Successfully read the file");
        } catch (IOException e) {
            System.out.println("Cannot read the file");
        }
    }
}
