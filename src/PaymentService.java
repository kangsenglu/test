import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    private List<Order> orders;
    private List<Payment> payments;
    private int paymentIdCounter;
    private NotificationService notificationService;

    public PaymentService() {
        this.orders = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.paymentIdCounter = 1;
        this.notificationService = new NotificationService();
    }

    public void createOrder(int orderId, String productName, double amount) {
        Order order = new Order(orderId, productName, amount);
        orders.add(order);
        System.out.println("Order created: " + order);
    }

    public void payOrder(int orderId, PaymentMethod paymentMethod) {
        Order order = findOrderById(orderId);
        if (order == null) {
            System.out.println("Order not found with ID: " + orderId);
            return;
        }

        if (order.getStatus() == OrderStatus.PAID) {
            System.out.println("Order is already paid.");
            return;
        }

        if (order.getStatus() == OrderStatus.CANCELLED) {
            System.out.println("Order is cancelled and cannot be paid.");
            return;
        }

        Payment payment = new Payment(paymentIdCounter++, orderId, order.getAmount(), paymentMethod);
        payments.add(payment);
        order.setStatus(OrderStatus.PAID);
        System.out.println("Payment successful: " + payment);
        notificationService.sendPaymentNotification(order);
    }

    public void cancelOrder(int orderId) {
        Order order = findOrderById(orderId);
        if (order == null) {
            System.out.println("Order not found with ID: " + orderId);
            return;
        }

        if (order.getStatus() == OrderStatus.PAID) {
            System.out.println("Order is already paid and cannot be cancelled.");
            return;
        }

        order.setStatus(OrderStatus.CANCELLED);
        System.out.println("Order cancelled: " + order);
    }

    public void viewOrderStatus(int orderId) {
        Order order = findOrderById(orderId);
        if (order == null) {
            System.out.println("Order not found with ID: " + orderId);
            return;
        }

        System.out.println("Order status: " + order.getStatus());
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
