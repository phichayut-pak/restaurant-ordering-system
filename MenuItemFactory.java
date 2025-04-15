public class MenuItemFactory {
    public static MenuItem createItem(String type) {
        if (type.toLowerCase().equals("burger")) {
            return new Burger();
        } else if (type.toLowerCase().equals("drink")) {
            return new Drink();
        } else if (type.toLowerCase().equals("dessert")) {
            return new Dessert();
        } else {
            throw new IllegalArgumentException("Unknown item type: " + type);
        }

    }
}
