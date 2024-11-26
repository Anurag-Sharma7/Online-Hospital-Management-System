package src.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import src.model.Patient;

public class PatientDAO {

    public void addPatient(Patient patient) {
        String query = "INSERT INTO patients (name, age, gender, address) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setString(3, patient.getGender());
            stmt.setString(4, patient.getAddress());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Patient getPatientById(int id) {
        String query = "SELECT * FROM patients WHERE id = ?";
        Patient patient = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                patient = new Patient(rs.getInt("id"), rs.getString("name"),
                                      rs.getInt("age"), rs.getString("gender"),
                                      rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }
}
