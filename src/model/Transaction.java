package model;

public class Transaction {
    private int id;
    private String type;
    private String category;
    private double amount;
    private String description;

    public Transaction(String type, String category, double amount, String description) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.description = description;
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
}