import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

public class OrderItem {
    private Good good;
    private int amount;

    public OrderItem(int amount, String name, int price) {
        this.amount = amount;
        this.good = new Good(name, price);
    }

    public int getPrice() {
        return amount * good.getPrice();
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}