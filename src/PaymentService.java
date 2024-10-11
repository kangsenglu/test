import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    private List<Order> orders;
    private List<Payment> payments;
    private int paymentIdCounter;

    public PaymentService() {
        this.orders = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.paymentIdCounter = 1;
    }

    public void createOrder(int orderId, String productName, double amount) {
        Order order = new Order(orderId, productName, amount);
        orders.add(order);
        System.out.println("Order created: " + order);
    }

    public void payOrder(int orderId) {
        Order order = findOrderById(orderId);
        if (order == null) {
            System.out.println("Order not found with ID: " + orderId);
            return;
        }

        if (order.isPaid()) {
            System.out.println("Order is already paid.");
            return;
        }

        Payment payment = new Payment(paymentIdCounter++, orderId, order.getAmount());
        payments.add(payment);
        order.setPaid(true);
        System.out.println("Payment successful: " + payment);
    }

    public void viewPaymentHistory() {
        System.out.println("Payment History:");
        for (Payment payment : payments) {
            System.out.println(payment);
        }
    }

    private Order findOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }
}
