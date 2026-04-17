import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadHandler {
    public static void main(String[] args) {
        String fileName = "data.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("--- File Content ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error: We couldn't find or read '" + fileName + "'.");
            System.err.println("Please ensure the file exists in the project directory.");
        }
    }
}