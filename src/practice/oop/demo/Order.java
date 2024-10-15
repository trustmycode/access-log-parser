package practice.oop.demo;

// Принцип SRP соблюдён: теперь класс Order отвечает только за логику заказа
public class Order {
    private String customerName;
    private String product;
    private double price;

    public Order(String customerName, String product, double price) {
        this.customerName = customerName;
        this.product = product;
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getPrice() {
        return price;
    }

    public String getProduct() {
        return product;
    }
}

// Принцип OCP соблюдён: новый способ уведомления можно добавить без изменения существующего кода
interface NotificationService {
    void sendNotification(String message, String recipient);
}

class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending email to " + recipient + ": " + message);
    }
}

class SMSNotification implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}

// Принцип DIP соблюдён: теперь зависимость на интерфейс, а не на конкретную реализацию
interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalPayment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of " + amount);
    }
}

class CreditCardPayment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of " + amount);
    }
}

// Принцип LSP соблюдён: подклассы могут корректно заменять базовый класс
class StandardOrderProcessor {
    private PaymentProcessor paymentProcessor;
    private NotificationService notificationService;

    public StandardOrderProcessor(PaymentProcessor paymentProcessor, NotificationService notificationService) {
        this.paymentProcessor = paymentProcessor;
        this.notificationService = notificationService;
    }

    public void processOrder(Order order) {
        System.out.println("Processing order for " + order.getCustomerName());
        paymentProcessor.processPayment(order.getPrice());
        notificationService.sendNotification("Order for " + order.getProduct() + " is processed.", order.getCustomerName());
    }
}

// Принцип ISP соблюдён: каждый интерфейс делает только одну задачу
class SpecialOrderProcessor extends StandardOrderProcessor {
    public SpecialOrderProcessor(PaymentProcessor paymentProcessor, NotificationService notificationService) {
        super(paymentProcessor, notificationService);
    }

    @Override
    public void processOrder(Order order) {
        // Специфическая логика для особых заказов
        System.out.println("Processing special order for " + order.getCustomerName());
    }
}
