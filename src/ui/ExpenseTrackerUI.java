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
    private JTextField dateField;
    private JTextField paymentModeField;
    private JTextField paidToField;

    private ExpenseService service;

    public ExpenseTrackerUI() {
        service = new ExpenseService();

        setTitle("Expense Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(8, 2, 10, 10));

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

        add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        add(dateField);

        add(new JLabel("Payment Mode:"));
        paymentModeField = new JTextField();
        add(paymentModeField);

        add(new JLabel("Paid To:"));
        paidToField = new JTextField();
        add(paidToField);

        JButton saveButton = new JButton("Save");
        add(saveButton);

        saveButton.addActionListener(e -> saveTransaction());

        setVisible(true);
    }

    private void saveTransaction() {
        try {
            String date = dateField.getText();
            String paymentMode = paymentModeField.getText();
            String paidTo = paidToField.getText();
            String type = typeField.getText();
            String category = categoryField.getText();
            double amount = Double.parseDouble(amountField.getText());
            String description = descriptionField.getText();


            Transaction t = new Transaction(type, category, amount, description, date, paymentMode, paidTo);
            service.addTransaction(t);

            JOptionPane.showMessageDialog(this, "Transaction saved");

            typeField.setText("");
            categoryField.setText("");
            amountField.setText("");
            descriptionField.setText("");
            dateField.setText("");
            paymentModeField.setText("");
            paidToField.setText("");

            typeField.setText("");
            categoryField.setText("");
            amountField.setText("");
            descriptionField.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input");
        }
    }
}