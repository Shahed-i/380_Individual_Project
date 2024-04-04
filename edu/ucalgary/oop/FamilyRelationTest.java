package edu.ucalgary.oop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class FamilyRelationTest {

    private DisasterVictim personOne;
    private DisasterVictim personTwo;
    private String relationshipTo;
    private FamilyRelation testFamilyRelationObject;
 
    @Before
    public void setup() {
        personOne = new DisasterVictim("John", "2024-01-19", 30);
        personTwo = new DisasterVictim("Jane", "2024-02-20", 25);
        relationshipTo = "Sibling";
        testFamilyRelationObject = new FamilyRelation(personOne, relationshipTo, personTwo);
    }
 
    @Test
    public void testObjectCreation() {
        assertNotNull(testFamilyRelationObject);
    }
   
    @Test
    public void testSetAndGetPersonOne() {
        DisasterVictim newPersonOne = new DisasterVictim("New Person", "2024-03-21", 35); //arrange
        testFamilyRelationObject.setPersonOne(newPersonOne); //act
        assertEquals("setPersonOne should update personOne", newPersonOne, testFamilyRelationObject.getPersonOne());//assert
    }
 
    @Test
    public void testSetAndGetPersonTwo() {
        DisasterVictim newPersonTwo = new DisasterVictim("Another Person", "2024-04-22", 40); //arrange
        testFamilyRelationObject.setPersonTwo(newPersonTwo); //act
        assertEquals("setPersonTwo should update personTwo", newPersonTwo, testFamilyRelationObject.getPersonTwo()); //assert
    }
 
    @Test
    public void testSetAndGetRelationshipTo() {
        String newRelationship = "Parent"; //arrange
        testFamilyRelationObject.setRelationshipTo(newRelationship); //act
        assertEquals("setRelationshipTo should update the relationship", newRelationship, testFamilyRelationObject.getRelationshipTo()); //assert
    }
 
    @Test
    public void testDuplicationCheck() {
        DisasterVictim personThree = new DisasterVictim("Jane", "2024-02-20", 25); // Same as personTwo, arrange
       
        //act and assert:
        assertTrue("testDuplicationCheck should return true if both persons are the same",
                    testFamilyRelationObject.duplicationCheck(personOne, personTwo));
        assertFalse("testDuplicationCheck should return false if both persons are different",
                    testFamilyRelationObject.duplicationCheck(personOne, personThree));
    }

    @Test
    public void testDeleteRelationship() {
        testFamilyRelationObject.deleteRelationship();
        assertNull(testFamilyRelationObject.getPersonOne());
        assertNull(testFamilyRelationObject.getPersonTwo());
        assertNull(testFamilyRelationObject.getRelationshipTo());
    }

    @Test
    public void testCheckExistingRelationship() {
        assertTrue(testFamilyRelationObject.checkExistingRelationship());
    }

    @Test
    // tests that if A and B are related and B and C are related, A and C are also related
    public void testTransitiveRelation() {
        DisasterVictim personThree = new DisasterVictim("Jack", "2024-03-21", 35);
        String relationshipAB = "Parent";
        String relationshipBC = "Child";
        FamilyRelation relationAB = new FamilyRelation(personOne, relationshipAB, personTwo);
        FamilyRelation relationBC = new FamilyRelation(personTwo, relationshipBC, personThree);
        boolean isRelatedAC = relationAB.checkExistingRelationship() && relationBC.checkExistingRelationship();
        System.out.println("Is A related to B: " + relationAB.checkExistingRelationship());
        System.out.println("Is B related to C: " + relationBC.checkExistingRelationship());
        assertTrue(isRelatedAC);
    }


}
