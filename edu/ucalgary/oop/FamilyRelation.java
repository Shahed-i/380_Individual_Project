package edu.ucalgary.oop;

public class FamilyRelation {

    private DisasterVictim personOne;
    private DisasterVictim personTwo;
    private String relationshipTo;

    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        this.personOne = personOne;
        this.relationshipTo = relationshipTo;
        this.personTwo = personTwo;
    }

    public DisasterVictim getPersonOne() {
        return personOne;
    }

    public void setPersonOne(DisasterVictim personOne) {
        this.personOne = personOne;
    }

    public DisasterVictim getPersonTwo() {
        return personTwo;
    }

    public void setPersonTwo(DisasterVictim personTwo) {
        this.personTwo = personTwo;
    }

    public String getRelationshipTo() {
        return relationshipTo;
    }

    public void setRelationshipTo(String relationshipTo) {
        this.relationshipTo = relationshipTo;
    }

    public boolean duplicationCheck(DisasterVictim personOne, DisasterVictim personTwo) {
        return this.personOne.equals(personOne) && this.personTwo.equals(personTwo);
    }

    public void deleteRelationship() {
        this.personOne = null;
        this.personTwo = null;
        this.relationshipTo = null;
    }

    public boolean checkExistingRelationship() {
        return personOne != null && personTwo != null && relationshipTo != null;
    }
    
}
