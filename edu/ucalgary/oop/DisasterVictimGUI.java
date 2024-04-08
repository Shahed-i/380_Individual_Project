package edu.ucalgary.oop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisasterVictimGUI extends JFrame {

    private JTextField firstNameField, dateOfBirthField, ageField, entryDateField, commentsField;
    private JTextField treatmentDetailsField, dateOfTreatmentField, relationshipToField;
    private JButton addVictimButton, viewVictimsButton, addMedicalRecordButton, addFamilyRelationButton;
    private JTextArea displayArea;
    private ArrayList<DisasterVictim> victims;

    public DisasterVictimGUI() {
        victims = new ArrayList<>();

        setTitle("Disaster Victim Information");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(7, 2));
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();
        JLabel dateOfBirthLabel = new JLabel("Date of Birth:");
        dateOfBirthField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        JLabel entryDateLabel = new JLabel("Entry Date:");
        entryDateField = new JTextField();
        JLabel commentsLabel = new JLabel("Comments:");
        commentsField = new JTextField();
        JLabel treatmentDetailsLabel = new JLabel("Treatment Details:");
        treatmentDetailsField = new JTextField();
        JLabel dateOfTreatmentLabel = new JLabel("Date of Treatment:");
        dateOfTreatmentField = new JTextField();
        JLabel relationshipToLabel = new JLabel("Relationship To:");
        relationshipToField = new JTextField();

        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameField);
        inputPanel.add(dateOfBirthLabel);
        inputPanel.add(dateOfBirthField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(entryDateLabel);
        inputPanel.add(entryDateField);
        inputPanel.add(commentsLabel);
        inputPanel.add(commentsField);
        inputPanel.add(treatmentDetailsLabel);
        inputPanel.add(treatmentDetailsField);
        inputPanel.add(dateOfTreatmentLabel);
        inputPanel.add(dateOfTreatmentField);
        inputPanel.add(relationshipToLabel);
        inputPanel.add(relationshipToField);

        addVictimButton = new JButton("Add Victim");
        addVictimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addVictim();
            }
        });

        viewVictimsButton = new JButton("View Victims");
        viewVictimsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewVictims();
            }
        });

        addMedicalRecordButton = new JButton("Add Medical Record");
        addMedicalRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMedicalRecord();
            }
        });

        addFamilyRelationButton = new JButton("Add Family Relation");
        addFamilyRelationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFamilyRelation();
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
        buttonPanel.add(addVictimButton);
        buttonPanel.add(viewVictimsButton);
        buttonPanel.add(addMedicalRecordButton);
        buttonPanel.add(addFamilyRelationButton);

        displayArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayArea);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.CENTER);
        contentPane.add(scrollPane, BorderLayout.SOUTH);
    }

    private void addVictim() {
        String firstName = firstNameField.getText();
        String dateOfBirth = dateOfBirthField.getText();
        int age = Integer.parseInt(ageField.getText());
        String entryDate = entryDateField.getText();
        String comments = commentsField.getText();

        DisasterVictim victim = new DisasterVictim(firstName, entryDate, age);
        victim.setDateOfBirth(dateOfBirth);
        victim.setComments(comments);
        victims.add(victim);

        displayArea.append("Victim added: " + firstName + "\n");
        clearFields();
    }

    private void viewVictims() {
        displayArea.setText("");
        for (DisasterVictim victim : victims) {
            displayArea.append("Name: " + victim.getFirstName() + "\n");
            displayArea.append("Date of Birth: " + victim.getDateOfBirth() + "\n");
            displayArea.append("Age: " + victim.getAge() + "\n");
            displayArea.append("Entry Date: " + victim.getEntryDate() + "\n");
            displayArea.append("Comments: " + victim.getComments() + "\n\n");
        }
    }

    private void addMedicalRecord() {
        String treatmentDetails = treatmentDetailsField.getText();
        String dateOfTreatment = dateOfTreatmentField.getText();
        Location location = new Location("Location Name", "Location Address");

        try {
            MedicalRecord medicalRecord = new MedicalRecord(location, treatmentDetails, dateOfTreatment);
            displayArea.append("Medical Record added: " + treatmentDetails + "\n");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        clearFields();
    }

    private void addFamilyRelation() {
        String firstNameOne = firstNameField.getText();
        String relationshipTo = relationshipToField.getText();
        String firstNameTwo = firstNameField.getText();

        // Assuming the DisasterVictim objects for personOne and personTwo are already created and available in the victims list
        DisasterVictim personOne = null;
        DisasterVictim personTwo = null;
        for (DisasterVictim victim : victims) {
            if (victim.getFirstName().equals(firstNameOne)) {
                personOne = victim;
            }
            if (victim.getFirstName().equals(firstNameTwo)) {
                personTwo = victim;
            }
        }

        if (personOne == null || personTwo == null) {
            JOptionPane.showMessageDialog(this, "One or both persons not found", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        FamilyRelation familyRelation = new FamilyRelation(personOne, relationshipTo, personTwo);
        displayArea.append("Family Relation added: " + firstNameOne + " - " + firstNameTwo + "\n");
        clearFields();
    }

    private void clearFields() {
        firstNameField.setText("");
        dateOfBirthField.setText("");
        ageField.setText("");
        entryDateField.setText("");
        commentsField.setText("");
        treatmentDetailsField.setText("");
        dateOfTreatmentField.setText("");
        relationshipToField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DisasterVictimGUI().setVisible(true);
            }
        });
    }
}
