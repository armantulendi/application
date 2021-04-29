package myExample;

public class ListOfMessage {
    private Message message;
    private int amount;

    public ListOfMessage(Message message, int amount) {
        this.message = message;
        this.amount = amount;
    }

    public Message getMessage() {
        return message;
    }
    public Message createMessage() {
        return new Message();
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}