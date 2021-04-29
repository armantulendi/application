package myExample;

public class Main {
    public static void main(String[] args) {
        Subscriber subscriber=new Subscriber();
        Message message=new Message("hello",3);
        subscriber.addListOfMessage(message,3);
    }
}
