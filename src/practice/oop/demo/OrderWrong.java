package practice.oop.demo;

public class OrderWrong {
    private String customerName;
    private String product;
    private double price;

    public OrderWrong(String customerName, String product, double price) {
        this.customerName = customerName;
        this.product = product;
        this.price = price;
    }

    // Нарушение SRP (Принцип единственной ответственности)
    // Класс отвечает за логику заказа, обработку платежей и отправку уведомлений
    public void processOrder() {
        System.out.println("Processing order for " + customerName);
        // Логика обработки заказа
        sendEmail();
        processPayment();
    }

    public void sendEmail() {
        // Нарушение OCP (Принцип открытости/закрытости)
        // Если нужно отправить смс, придётся изменить этот метод
        System.out.println("Sending email to " + customerName);
    }

    public void processPayment() {
        // Нарушение DIP (Принцип инверсии зависимостей)
        // Зависит от конкретной реализации PayPal
        PayPalPaymentWrong payment = new PayPalPaymentWrong();
        payment.processPayment(price);
    }
}

// Нарушение LSP (Принцип подстановки Лисков)
// Этот подкласс не может полностью заменить базовый класс
class SpecialOrder extends OrderWrong {
    public SpecialOrder(String customerName, String product, double price) {
        super(customerName, product, price);
    }

    @Override
    public void processOrder() {
        throw new UnsupportedOperationException("Special orders are not processed the same way!");
    }

    public void specialProcessOrder(){
        System.out.println("Some kind of logic");
    }
}

class PayPalPaymentWrong {
    public void processPayment(double amount) {
        // Логика обработки платежа через PayPal
        System.out.println("Processing PayPal payment of " + amount);
    }
}

// Нарушение ISP (Принцип разделения интерфейсов)
// Интерфейс с избыточным количеством методов
interface OrderService {
    void processOrder();
    void sendEmail();
    void processPayment();
}
