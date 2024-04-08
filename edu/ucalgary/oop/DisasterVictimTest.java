package edu.ucalgary.oop;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DisasterVictimTest {

    private DisasterVictim victim;

    @Before
    public void setUp() {
        victim = new DisasterVictim("John", "2024-03-12", 30);
        public DisasterVictim(String firstName, String ENTRY_DATE, int age) {
    super(firstName, "");
    if (age < 0) {
        throw new IllegalArgumentException("Age cannot be negative");
    }
    this.age = age;
    this.ENTRY_DATE = ENTRY_DATE;
    this.medicalRecords = new ArrayList<>();
    this.familyConnections = new ArrayList<>(); // Initialize familyConnections ArrayList
    this.personalBelongings = new ArrayList<>();
}

public DisasterVictim(String firstName, String ENTRY_DATE, String dateOfBirth) {
    super(firstName, "");
    this.dateOfBirth = dateOfBirth;
    this.ENTRY_DATE = ENTRY_DATE;
    this.medicalRecords = new ArrayList<>();
    this.familyConnections = new ArrayList<>(); // Initialize familyConnections ArrayList
    this.personalBelongings = new ArrayList<>();
}

    }

    @Test
    public void testConstructorWithAge() {
        assertEquals("John", victim.getFirstName());
        assertEquals("2024-03-12", victim.getEntryDate());
        assertEquals("30", victim.getAge());
    }

    @Test
    public void testConstructorWithDateOfBirth() {
        DisasterVictim victimWithDOB = new DisasterVictim("Jane", "2024-03-12", "1994-01-01");
        assertEquals("Jane", victimWithDOB.getFirstName());
        assertEquals("2024-03-12", victimWithDOB.getEntryDate());
        assertEquals("1994-01-01", victimWithDOB.getDateOfBirth());
    }

    @Test
    public void testSetAndGetComments() {
        victim.setComments("Some comments");
        assertEquals("Some comments", victim.getComments());
    }

    @Test
    public void testSetAndGetMedicalRecords() {
        // Create a Location object
        Location location = new Location("John", "Canada");
        MedicalRecord record = new MedicalRecord(location, "Some condition", "2024-03-12");
        ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();
        medicalRecords.add(record);
        victim.setMedicalRecords(medicalRecords);
        assertEquals(1, victim.getMedicalRecords().length);
        assertEquals("Some condition", victim.getMedicalRecords()[0].getTreatmentDetails());
    }    

    @Test
    public void testSetAndGetPersonalBelongings() {
        ArrayList<Supply> personalBelongings = new ArrayList<>();
        Supply supply = new Supply("Water", 10);
        personalBelongings.add(supply);
        victim.setPersonalBelongings(personalBelongings);
        assertEquals(1, victim.getPersonalBelongings().size());
        assertEquals("Water", victim.getPersonalBelongings().get(0).getType());
        assertEquals(10, victim.getPersonalBelongings().get(0).getQuantity());
    }

    @Test
    public void testSetAndGetFamilyConnections() {
        DisasterVictim personOne = new DisasterVictim("John", "2024-03-12", 30);
        DisasterVictim personTwo = new DisasterVictim("Alice", "2024-03-12", 25);
        FamilyRelation relation = new FamilyRelation(personOne, "Sibling", personTwo);
        ArrayList<FamilyRelation> familyConnections = new ArrayList<>();
        familyConnections.add(relation);
        victim.setFamilyConnections(familyConnections);
        assertEquals(1, victim.getFamilyConnections().size());
        assertEquals("Sibling", victim.getFamilyConnections().get(0).getRelationshipTo());
        assertEquals("John", victim.getFamilyConnections().get(0).getPersonOne().getFirstName());
        assertEquals("Alice", victim.getFamilyConnections().get(0).getPersonTwo().getFirstName());
    }
    
    @Test
    public void testRemovePersonalBelonging() {
        ArrayList<Supply> personalBelongings = new ArrayList<>();
        Supply supply = new Supply("Water", 10);
        personalBelongings.add(supply);
        victim.setPersonalBelongings(personalBelongings);
        victim.removePersonalBelonging(supply);
        assertEquals(0, victim.getPersonalBelongings().size());
    }

    @Test
    public void testAddPersonalBelonging() {
        Supply supply = new Supply("Food", 5);
        victim.addPersonalBelonging(supply);
        assertEquals(1, victim.getPersonalBelongings().size());
        assertEquals("Food", victim.getPersonalBelongings().get(0).getType());
        assertEquals(5, victim.getPersonalBelongings().get(0).getQuantity());
    }

    @Test
    public void testAddFamilyConnection() {
        DisasterVictim person = new DisasterVictim("Alice", "2024-03-12", 25);
        FamilyRelation relation = new FamilyRelation(person, "Sibling", victim);
        victim.addFamilyConnection(relation);

        assertEquals(1, victim.getFamilyConnections().size());
        assertEquals("Sibling", victim.getFamilyConnections().get(0).getRelationshipTo());
        assertEquals("Alice", victim.getFamilyConnections().get(0).getPersonOne().getFirstName());
        assertEquals("John", victim.getFamilyConnections().get(0).getPersonTwo().getFirstName());
    }
    

    @Test
    public void testRemoveFamilyConnection() {
        FamilyRelation relation = new FamilyRelation(victim, "Sibling", new DisasterVictim("Alice", "2024-03-12", 25));
        victim.addFamilyConnection(relation);
        victim.removeFamilyConnection(relation);
        assertEquals(0, victim.getFamilyConnections().size());
    }


    @Test
    public void testAddMedicalRecord() {
        Location location = new Location("John", "Canada");
        MedicalRecord record = new MedicalRecord(location, "Broken leg", "2024-03-12");
        victim.addMedicalRecord(record);
        assertEquals(1, victim.getMedicalRecords().length);
        assertEquals("Broken leg", victim.getMedicalRecords()[0].getTreatmentDetails());
        assertEquals("2024-03-12", victim.getMedicalRecords()[0].getDateOfTreatment());
    }


    @Test
    public void testSetAndGetSupply() {
        victim.setSupply("Water");
        assertEquals("Water", victim.getSupply());
    }

    @Test
    public void testSetAndGetAge() {
        victim.setAge(35);
        assertEquals("35", victim.getAge());
    }

    @Test
    public void testSetAndGetDateOfBirth() {
        victim.setDateOfBirth("1994-01-01");
        assertEquals("1994-01-01", victim.getDateOfBirth());
    }

    @Test
    public void testSetAndGetFirstName() {
        victim.setFirstName("Jack");
        assertEquals("Jack", victim.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        victim.setLastName("Doe");
        assertEquals("Doe", victim.getLastName());
    }

    @Test
    public void testDietRestriction() {
        victim.dietRestriction(DisasterVictim.Diet.AVML);
    }

    @Test
    public void testDecreaseSupplyQuantity() {
        ArrayList<Supply> supplies = new ArrayList<>();
        supplies.add(new Supply("Water", 10));
        victim.setPersonalBelongings(supplies);

        Supply waterSupply = new Supply("Water", 5);
        victim.decreaseSupplyQuantity(waterSupply);

        assertEquals(5, victim.getPersonalBelongings().get(0).getQuantity());
    }

    @Test
    public void testSetEntryDate() {
        String newEntryDate = "2024-03-15";
        victim.setEntryDate(newEntryDate);
        assertEquals(newEntryDate, victim.getEntryDate());
    }

}
