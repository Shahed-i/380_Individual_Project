package edu.ucalgary.oop;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DisasterVictimTest {
    private DisasterVictim victim;
    private String relationshipType;
    private int relativeId;
    private String recordDetails;
    private String treatmentDate;
    private String locationName;
    private String address;

    @Before
    public void setUp() {
        victim = new DisasterVictim("Freda", "2024-01-18");
    }

    @Test
    public void testEnterPersonalInfo() {
        DisasterVictim victim = new DisasterVictim("Bob", "2024-03-13");
        assertEquals("getFirstName() should return Bob", "Bob", victim.getFirstName());
        assertEquals("getEntryDate() should return 2024-03-13", "2024-03-13", victim.getEntryDate());
    }

    @Test
    public void testAddFamilyRelatiob() {
        int victimId = 2;
        int relativeId = 6;
        String relationshipType = "Sisters";
        victim.addFamilyRelation(victimId, relationshipType, relativeId);
        assertTrue("enterDisasterVictimFamilyLink() should have successfully established this relation", victim.isRelated(victimId, relationshipType, relativeId));
    }

    @Test
    public void testAddMedicalRecord() {
        int victimId = 19;
        String recordDetails = "Concussion";
        String treatmentDate = "2023-01-01";
        victim.addMedicalRecord(victimId, recordDetails, treatmentDate);
        assertTrue("enterDisasterVictimMedicalRecord() should", victim.hasMedicalRecord(victimId, recordDetails, treatmentDate));
    }

    @Test
    public void testSelectocation() {
        String locationName = "The Shelter";
        String address = "56 Shelter Place";
        victim.selectLocation(locationName, address);
        assertEquals("locationAddress() should return the address", "56 Shelter Place", victim.locationAddress());
    }
}
