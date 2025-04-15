import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OrderReader {
    public static void readReceipt(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}