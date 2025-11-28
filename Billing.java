import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Billing class for managing patient bills
public class Billing {
    private String id;
    private String patientId;
    private String patientName;
    private List<BillItem> items;
    private double totalAmount;
    private double paidAmount;
    private String status; // Unpaid, Partially Paid, Paid
    private String createdDate;
    private List<Payment> paymentHistory;

    // Inner class for Bill Item
    public static class BillItem {
        private String name;
        private double price;
        private int quantity;
        private double total;

        public BillItem(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.total = price * quantity;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
        public int getQuantity() { return quantity; }
        public double getTotal() { return total; }
    }

    // Inner class for Payment
    public static class Payment {
        private double amount;
        private String method;
        private String date;

        public Payment(double amount, String method, String date) {
            this.amount = amount;
            this.method = method;
            this.date = date;
        }

        public double getAmount() { return amount; }
        public String getMethod() { return method; }
        public String getDate() { return date; }
    }

    // Constructor
    public Billing(String id, String patientId, String patientName) {
        this.id = id;
        this.patientId = patientId;
        this.patientName = patientName;
        this.items = new ArrayList<>();
        this.totalAmount = 0;
        this.paidAmount = 0;
        this.status = "Unpaid";
        this.createdDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        this.paymentHistory = new ArrayList<>();
    }

    // Getters
    public String getId() { return id; }
    public String getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public List<BillItem> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
    public double getPaidAmount() { return paidAmount; }
    public String getStatus() { return status; }
    public String getCreatedDate() { return createdDate; }
    public List<Payment> getPaymentHistory() { return paymentHistory; }

    // Add item to bill
    public void addItem(String itemName, double itemPrice, int quantity) {
        items.add(new BillItem(itemName, itemPrice, quantity));
        calculateTotal();
    }

    // Calculate total amount
    public void calculateTotal() {
        totalAmount = 0;
        for (BillItem item : items) {
            totalAmount += item.getTotal();
        }
        updateStatus();
    }

    // Make payment
    public boolean makePayment(double amount, String paymentMethod) {
        if (amount <= 0) {
            return false;
        }
        
        paidAmount += amount;
        String date = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        paymentHistory.add(new Payment(amount, paymentMethod, date));
        
        updateStatus();
        return true;
    }

    // Update payment status
    private void updateStatus() {
        if (paidAmount == 0) {
            status = "Unpaid";
        } else if (paidAmount >= totalAmount) {
            status = "Paid";
        } else {
            status = "Partially Paid";
        }
    }

    // Get balance due
    public double getBalance() {
        return Math.max(0, totalAmount - paidAmount);
    }

    // Display billing information
    public void displayInfo() {
        System.out.println("\n========== BILLING INFORMATION ==========");
        System.out.println("Bill ID: " + id);
        System.out.println("Patient: " + patientName + " (ID: " + patientId + ")");
        System.out.println("Created: " + createdDate.substring(0, 10));
        System.out.println("Status: " + status);
        System.out.println("\n--- Items ---");
        for (int i = 0; i < items.size(); i++) {
            BillItem item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - $" + item.getPrice() + 
                             " x " + item.getQuantity() + " = $" + item.getTotal());
        }
        System.out.println("\n--- Payment Summary ---");
        System.out.println("Total Amount: $" + String.format("%.2f", totalAmount));
        System.out.println("Paid Amount: $" + String.format("%.2f", paidAmount));
        System.out.println("Balance Due: $" + String.format("%.2f", getBalance()));
        System.out.println("=========================================\n");
    }

    // Display payment history
    public void displayPaymentHistory() {
        System.out.println("\n--- Payment History ---");
        if (paymentHistory.isEmpty()) {
            System.out.println("No payments made yet.");
        } else {
            for (int i = 0; i < paymentHistory.size(); i++) {
                Payment payment = paymentHistory.get(i);
                System.out.println((i + 1) + ". $" + payment.getAmount() + " via " + 
                                 payment.getMethod() + " on " + payment.getDate().substring(0, 10));
            }
        }
    }

    // toString
    @Override
    public String toString() {
        return "[" + id + "] Patient: " + patientName + " | Total: $" + 
               String.format("%.2f", totalAmount) + " | Status: " + status;
    }
}

