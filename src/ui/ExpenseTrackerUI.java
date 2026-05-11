package ui;

import model.Transaction;
import service.ExpenseService;

import javax.swing.*;
import java.awt.*;

public class ExpenseTrackerUI extends JFrame {

    private JTextField typeField;
    private JTextField categoryField;
    private JTextField amountField;
    private JTextField descriptionField;

    private ExpenseService service;

    public ExpenseTrackerUI() {
        service = new ExpenseService();

        setTitle("Expense Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Type:"));
        typeField = new JTextField();
        add(typeField);

        add(new JLabel("Category:"));
        categoryField = new JTextField();
        add(categoryField);

        add(new JLabel("Amount:"));
        amountField = new JTextField();
        add(amountField);

        add(new JLabel("Description:"));
        descriptionField = new JTextField();
        add(descriptionField);

        JButton saveButton = new JButton("Save");
        add(saveButton);

        saveButton.addActionListener(e -> saveTransaction());

        setVisible(true);
    }

    private void saveTransaction() {
        try {
            String type = typeField.getText();
            String category = categoryField.getText();
            double amount = Double.parseDouble(amountField.getText());
            String description = descriptionField.getText();

            Transaction t = new Transaction(type, category, amount, description);
            service.addTransaction(t);

            JOptionPane.showMessageDialog(this, "Transaction saved");

            typeField.setText("");
            categoryField.setText("");
            amountField.setText("");
            descriptionField.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input");
        }
    }
}