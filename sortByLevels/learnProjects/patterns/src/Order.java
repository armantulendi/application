import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> orderItems;


    public Order(ArrayList<Object> objects) {
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
