public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        // Create orders
        paymentService.createOrder(1, "Laptop", 1200.00);
        paymentService.createOrder(2, "Smartphone", 800.00);

        // Pay orders
        paymentService.payOrder(1);
        paymentService.payOrder(2);

        // View payment history
        paymentService.viewPaymentHistory();
    }
}
