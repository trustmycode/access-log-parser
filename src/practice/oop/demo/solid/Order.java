package practice.oop.demo.solid;
// Принцип SRP соблюдён: класс Order отвечает только за логику заказа
public class Order {
    private String customerName; // Имя клиента
    private String product;       // Продукт
    private double price;         // Цена

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

// Принцип OCP соблюдён: новые способы уведомления можно добавлять без изменения существующего кода
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

// Принцип DIP соблюдён: зависимости передаются через интерфейсы
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
abstract class OrderProcessor {
    protected PaymentProcessor paymentProcessor; // Зависимость от абстракции
    protected NotificationService notificationService; // Зависимость от абстракции

    public OrderProcessor(PaymentProcessor paymentProcessor, NotificationService notificationService) {
        this.paymentProcessor = paymentProcessor;
        this.notificationService = notificationService;
    }

    public abstract void processOrder(Order order);
}

class StandardOrderProcessor extends OrderProcessor {
    public StandardOrderProcessor(PaymentProcessor paymentProcessor, NotificationService notificationService) {
        super(paymentProcessor, notificationService);
    }

    @Override
    public void processOrder(Order order) {
        System.out.println("Processing order for " + order.getCustomerName());
        paymentProcessor.processPayment(order.getPrice());
        notificationService.sendNotification("Order for " + order.getProduct() + " is processed.", order.getCustomerName());
    }
}

class SpecialOrderProcessor extends OrderProcessor {
    public SpecialOrderProcessor(PaymentProcessor paymentProcessor, NotificationService notificationService) {
        super(paymentProcessor, notificationService);
    }

    @Override
    public void processOrder(Order order) {
        // Специфическая логика для особых заказов
        System.out.println("Processing special order for " + order.getCustomerName());
        paymentProcessor.processPayment(order.getPrice());
        notificationService.sendNotification("Special order for " + order.getProduct() + " is processed.", order.getCustomerName());
    }
}

// Использование классов
class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PayPalPayment(); // или CreditCardPayment
        NotificationService notificationService = new EmailNotification(); // или SMSNotification

        OrderProcessor orderProcessor = new StandardOrderProcessor(paymentProcessor, notificationService);
        orderProcessor.processOrder(new Order("Alice", "Laptop", 1200.00));

        OrderProcessor specialOrderProcessor = new SpecialOrderProcessor(paymentProcessor, notificationService);
        specialOrderProcessor.processOrder(new Order("Bob", "Special Laptop", 1500.00));
    }
}
