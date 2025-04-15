import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printWelcome();

        Scanner scanner = new Scanner(System.in);
        Order order = OrderFactory.createOrder();

        // Attach observers
        Chef chef = new Chef();
        Waiter waiter = new Waiter();
        order.attach(chef);
        order.attach(waiter);

        boolean ordering = true;

        while (ordering) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Add Burger");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Dessert");
            System.out.println("4. View Order");
            System.out.println("5. Confirm Order");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    MenuItem item1 = MenuItemFactory.createItem("burger");
                    order.addItem(item1);
                    System.out.println("Added: " + item1.getName());
                    break;
                case "2":
                    MenuItem item2 = MenuItemFactory.createItem("drink");
                    order.addItem(item2);
                    System.out.println("Added: " + item2.getName());
                    break;
                case "3":
                    MenuItem item3 = MenuItemFactory.createItem("dessert");
                    order.addItem(item3);
                    System.out.println("Added: " + item3.getName());
                    break;
                case "4":
                    System.out.println("\n------ Your Current Order ------");
                    for (MenuItem item : order.getItems()) {
                        System.out.println(item.getName() + " - " + item.getPrice() + " baht");
                    }
                    System.out.println("Status: " + order.getStatus());
                    break;
                case "5":
                    order.setStatus("Cooking");
                    sleep(1500);
                    order.setStatus("Ready");
                    OrderManager.getInstance().addOrder(order);
                    OrderWriter.writeReceipt(order, "receipt.txt");
                    System.out.println("Order confirmed and receipt saved to 'receipt.txt'!");
                    ordering = false;
                    break;
                case "6":
                    ordering = false;
                    System.out.println("Exited without confirming order.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        }

        printGoodbye();
        scanner.close();
    }

    private static void printWelcome() {
        System.out.println("==========================================");
        System.out.println("        Welcome to Java Restaurant        ");
        System.out.println("==========================================");
        System.out.println("  Powered by Factory, Singleton, Observer ");
        System.out.println("==========================================");
    }

    private static void printGoodbye() {
        System.out.println("==========================================");
        System.out.println("  Thank you for your order! Bon Appétit!  ");
        System.out.println("==========================================");
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
