public class NotificationService {
    public void sendPaymentNotification(Order order) {
        System.out.println("Payment notification sent for order: " + order.getOrderId());
    }
}
