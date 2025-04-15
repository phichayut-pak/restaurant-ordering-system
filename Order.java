import java.util.ArrayList;
import java.util.List;

public class Order implements Subject {
    private List<MenuItem> items = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private String status = "Created";

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObserver();
    }

    public String getStatus() {
        return status;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}