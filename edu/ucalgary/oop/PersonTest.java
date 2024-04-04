package edu.ucalgary.oop;

import org.junit.*;
import static org.junit.Assert.*;

public class PersonTest {
    private String expectedFirstName = "Joseph";
    private String expectedLastName = "Bouillon";
    private Person person = new Person(expectedFirstName, expectedLastName);

    // Test Constructor 
    @Test
    public void testObjectCreation() {
        assertNotNull(person);
    }

    // Test Getters 
    @Test
    public void testGetFirstName() {
        Person person = new Person(expectedFirstName, expectedLastName);
        assertEquals(expectedFirstName, person.getFirstName());
    }

    @Test
    public void testGetLastName() {
        Person person = new Person(expectedFirstName, expectedLastName);
        assertEquals(expectedLastName, person.getLastName());
    }

    // Test setters 
    @Test
    public void testSetFirstName() {
        Person person = new Person(expectedFirstName, expectedLastName);
        person.setFirstName("John");
        assertEquals("John", person.getFirstName());
    }

    @Test
    public void testSetLastName() {
        Person person = new Person(expectedFirstName, expectedLastName);
        person.setLastName("Smith");
        assertEquals("Smith", person.getLastName());
    }
}
