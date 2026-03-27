import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AutoFileRead {
    public static void main(String[] args) {
        String path = "info.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            
            String firstLine = reader.readLine();
            
            if (firstLine != null) {
                System.out.println("First line of the file: " + firstLine);
            } else {
                System.out.println("The file is empty.");
            }

        } catch (IOException e) {
            System.err.println("An error occurred while reading '" + path + "': " + e.getMessage());
        }
    }
}