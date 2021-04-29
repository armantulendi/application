package myExample;

import java.util.ArrayList;
import java.util.List;

public class Subscriber {
    private List<ListOfMessage> listOfMessages = new ArrayList<>();

    private String destinationAddress;
    private String name;

    public Subscriber(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public Subscriber() {

    }

    public List<ListOfMessage> getOrderItems() {
        return listOfMessages;
    }

    public void setOrderItems(List<ListOfMessage> listOfMessages) {
        this.listOfMessages = listOfMessages;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }


    public void addListOfMessage(Message message, int amount) {
        listOfMessages.add(new ListOfMessage( message,  amount));
    }
}