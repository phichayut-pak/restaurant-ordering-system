import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OrderWriter {
    public static void writeReceipt(Order order, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Receipt:\n");
            for (MenuItem item : order.getItems()) {
                writer.write(item.getName() + " - " + item.getPrice() + " baht\n");
            }

            writer.write("Status: " + order.getStatus() + "\n");
            writer.write("\n"); // Add a line break between orders if needed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
