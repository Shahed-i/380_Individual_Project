package edu.ucalgary.oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DisasterVictim extends Person {
    private String dateOfBirth;
    private int age;
    private String comments;
    private int ASSIGNED_SOCIAL_ID;
    private ArrayList<MedicalRecord> medicalRecords;
    private ArrayList<FamilyRelation> familyConnections;
    private String ENTRY_DATE;
    private ArrayList<Supply> personalBelongings;
    private String supply;
    private String gender; // New field for gender
    public enum Diet {
        AVML, DBML, GFML, KSML, LSML, MOML, PFML, VGML, VJML
    }

    public DisasterVictim(String firstName, String ENTRY_DATE, int age) {
        super(firstName, "");
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
        this.ENTRY_DATE = ENTRY_DATE;
        this.medicalRecords = new ArrayList<>();
        this.familyConnections = new ArrayList<>();
        this.personalBelongings = new ArrayList<>();
    }

    public DisasterVictim(String firstName, String ENTRY_DATE, String dateOfBirth) {
        super(firstName, "");
        this.dateOfBirth = dateOfBirth;
        this.ENTRY_DATE = ENTRY_DATE;
        this.medicalRecords = new ArrayList<>();
        this.familyConnections = new ArrayList<>();
        this.personalBelongings = new ArrayList<>();
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getComments() {
        return comments;
    }

    public MedicalRecord[] getMedicalRecords() {
        return medicalRecords.toArray(new MedicalRecord[0]);
    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }

    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }

    public ArrayList<Supply> getPersonalBelongings() {
        return personalBelongings;
    }

    public ArrayList<FamilyRelation> getFamilyConnections() {
        return familyConnections;
    }

    public String getSupply() {
        return supply;
    }

    public String getAge() {
        return Integer.toString(age);
    }

    public String getGender() {
        return gender;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public void setEntryDate(String entryDate) {
        this.ENTRY_DATE = entryDate;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setMedicalRecords(ArrayList<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public void setPersonalBelongings(ArrayList<Supply> personalBelongings) {
        this.personalBelongings = personalBelongings;
    }

    public void setFamilyConnections(ArrayList<FamilyRelation> familyConnections) {
        this.familyConnections = familyConnections;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public void setGender(String gender) {
        try {
            boolean valid = false;
            File genderFile = new File("GenderOptions.txt");
            Scanner genderVerifier = new Scanner(genderFile);
            while (genderVerifier.hasNextLine()) {
                if (gender.toLowerCase().equals(genderVerifier.nextLine().replaceAll("[\r\n]", ""))) {
                    valid = true;
                    break; // Exit loop once valid gender found
                }
            }
            genderVerifier.close();

            if (!valid) {
                throw new IllegalArgumentException("Invalid gender. Acceptable values are male, female, or other.");
            }
            this.gender = gender.toLowerCase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removePersonalBelonging(Supply supply) {
        personalBelongings.remove(supply);
    }

    public void addPersonalBelonging(Supply supply) {
        personalBelongings.add(supply);
    }

    public void addFamilyConnection(FamilyRelation familyConnection) {
        familyConnections.add(familyConnection);
    }

    public void removeFamilyConnection(FamilyRelation familyConnection) {
        familyConnections.remove(familyConnection);
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
    }

    public void decreaseSupplyQuantity(Supply supply) {
        for (Supply originalSupply : personalBelongings) {
            if (originalSupply.getType().equals(supply.getType())) {
                int remainingQuantity = originalSupply.getQuantity() - supply.getQuantity();
                originalSupply.setQuantity(Math.max(remainingQuantity, 0));
                break;
            }
        }
    }

    public void dietRestriction(Diet victimDiet) {
        switch (victimDiet) {
            case AVML:
                System.out.println("Applying Asian vegetarian meal restriction");
                break;
            case DBML:
                System.out.println("Applying diabetic meal restriction");
                break;
            case GFML:
                System.out.println("Applying gluten intolerant meal restriction");
                break;
            case KSML:
                System.out.println("Applying kosher meal restriction");
                break;
            case LSML:
                System.out.println("Applying low salt meal restriction");
                break;
            case MOML:
                System.out.println("Applying Muslim meal restriction");
                break;
            case PFML:
                System.out.println("Applying peanut-free meal restriction");
                break;
            case VGML:
                System.out.println("Applying vegan meal restriction");
                break;
            case VJML:
                System.out.println("Applying vegetarian Jain meal restriction");
                break;
            default:
                // Handle unexpected diet restriction
                System.out.println("Unknown diet restriction");
                break;
        }
    }
}
