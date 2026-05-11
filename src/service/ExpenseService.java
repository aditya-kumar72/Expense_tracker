package service;

import db.DBConnection;
import model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExpenseService {

    public void addTransaction(Transaction t) {
        String sql = "INSERT INTO transactions(type, category, amount, description) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, t.getType());
            ps.setString(2, t.getCategory());
            ps.setDouble(3, t.getAmount());
            ps.setString(4, t.getDescription());

            ps.executeUpdate();
            System.out.println("Transaction added successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}