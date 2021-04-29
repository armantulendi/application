import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> orderItems = new ArrayList<>();
    private String destinationAddress;

    public Order(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public int getPrice() {
        int result = 0;

        for(OrderItem orderItem : orderItems) {
            result += orderItem.getPrice();
        }

        return result;
    }

    public void addOrderItem(int amount, String name, int price) {
        orderItems.add(new OrderItem(amount, name, price));
    }
}