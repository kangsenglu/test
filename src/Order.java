public class Order {
    private int orderId;
    private String productName;
    private double amount;
    private OrderStatus status;

    public Order(int orderId, String productName, double amount) {
        this.orderId = orderId;
        this.productName = productName;
        this.amount = amount;
        this.status = OrderStatus.PENDING;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public double getAmount() {
        return amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
