public class Waiter implements Observer {
    public void update(Order order) {
        System.out.println("Waiter: Order is now " + order.getStatus());
    }
}
