package src.main;

import src.dao.PatientDAO;
import src.model.Patient;

public class HospitalManagementApp {

    public static void main(String[] args) {
        PatientDAO patientDAO = new PatientDAO();

        // Create a new patient
        Patient newPatient = new Patient(0, "John Doe", 30, "Male", "123 Elm Street");
        patientDAO.addPatient(newPatient);

        // Retrieve patient by ID
        Patient retrievedPatient = patientDAO.getPatientById(1);
        if (retrievedPatient != null) {
            System.out.println("Patient Name: " + retrievedPatient.getName());
        }
    }
}
