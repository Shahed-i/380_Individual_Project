package edu.ucalgary.oop;

import java.util.ArrayList;

public class Location {
    private String name;
    private String address;
    private ArrayList<DisasterVictim> occupants = new ArrayList<>(); // Initialized
    private ArrayList<Supply> supplies = new ArrayList<>(); // Initialized

    // Constructor
    public Location(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for occupants
    public ArrayList<DisasterVictim> getOccupants() {
        return new ArrayList<>(occupants); // Return a copy to maintain encapsulation
    }

    // Setter for occupants
    public void setOccupants(ArrayList<DisasterVictim> occupants) {
        this.occupants = new ArrayList<>(occupants); // Clear and addAll in one step, maintains encapsulation
    }

    // Getter for supplies
    public ArrayList<Supply> getSupplies() {
        return new ArrayList<>(supplies); // Return a copy to maintain encapsulation
    }

    // Setter for supplies
    public void setSupplies(ArrayList<Supply> supplies) {
        this.supplies = new ArrayList<>(supplies); // Clear and addAll in one step, maintains encapsulation
    }

    // Add an occupant to occupants
    public void addOccupant(DisasterVictim occupant) {
        occupants.add(occupant);
    }

    // Remove an occupant from occupants
    public void removeOccupant(DisasterVictim occupant) {
        occupants.remove(occupant);
    }

    // Add a supply to supplies
    public void addSupply(Supply supply) {
        supplies.add(supply);
    }

    // Remove a supply from supplies
    public void removeSupply(Supply supply) {
        supplies.remove(supply);
    }
}
