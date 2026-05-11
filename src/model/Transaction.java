package model;

public class Transaction {
    private int id;
    private String type;
    private String category;
    private double amount;
    private String description;
    private String date;
    private String paymentMode;
    private String paidTo;

    public Transaction(String type, String category, double amount,
                       String description, String date,
                       String paymentMode, String paidTo) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.paymentMode = paymentMode;
        this.paidTo = paidTo;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public String getDate() {
        return date;
    }

    public String getPaidTo() {
        return paidTo;
    }
}