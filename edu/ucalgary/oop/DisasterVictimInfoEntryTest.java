package edu.ucalgary.oop;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DisasterVictimInfoEntryTest {
    private DisasterVictim victim;

    @Before
    public void setUp() {
        victim = new DisasterVictim("Freda", "2024-01-18", 0);
    }

    @Test
    public void testEnterPersonalInfo() {
        DisasterVictim victim = new DisasterVictim("Bob", "2024-03-13", 25);
        assertEquals("getFirstName() should return Bob", "Bob", victim.getFirstName());
        assertEquals("getEntryDate() should return 2024-03-13", "2024-03-13", victim.getEntryDate());
    }

    @Test
    public void testAddFamilyRelation() {
        int relativeId = 6;
        String relationshipType = "Sisters";
        victim.addFamilyConnection(new FamilyRelation(victim, relationshipType, relativeId));
        assertTrue("addFamilyConnection() should have successfully established this relation",
                victim.getFamilyConnections().stream()
                        .anyMatch(connection -> connection.getRelativeId() == relativeId && connection.getRelationshipType().equals(relationshipType)));
    }

    @Test
    public void testAddMedicalRecord() {
        String recordDetails = "Concussion";
        String treatmentDate = "2023-01-01";
        victim.addMedicalRecord(new MedicalRecord(null, recordDetails, treatmentDate));
        assertTrue("addMedicalRecord() should have added a medical record with details 'Concussion' and treatment date '2023-01-01'",
                victim.getMedicalRecords().stream()
                        .anyMatch(record -> record.getTreatmentDetails().equals(recordDetails) && record.getDateOfTreatment().equals(treatmentDate)));
    }

    @Test
    public void testSelectLocation() {
        String locationName = "The Shelter";
        String address = "56 Shelter Place";
        victim.selectLocation(locationName, address);
        assertEquals("selectLocation() should set the location address", address, victim.getLocationAddress());
    }
}
