public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        // Create orders
        paymentService.createOrder(1, "Laptop", 1200.00);
        paymentService.createOrder(2, "Smartphone", 800.00);

        // Pay orders
        paymentService.payOrder(1, PaymentMethod.CREDIT_CARD);
        paymentService.payOrder(2, PaymentMethod.ALIPAY);

        // Cancel an order
        paymentService.cancelOrder(2);

        // View order status
        paymentService.viewOrderStatus(1);
        paymentService.viewOrderStatus(2);

        // View payment history
        paymentService.viewPaymentHistory();
    }
}
