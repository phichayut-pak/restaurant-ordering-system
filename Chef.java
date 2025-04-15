public class Chef implements Observer {
    public void update(Order order) {
        System.out.println("Chef: Order is now " + order.getStatus());
    }
}
