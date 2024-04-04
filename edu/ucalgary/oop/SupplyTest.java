package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class SupplyTest {
    String expectedType = "Blanket";
	int expectedQuantity = 10;
    private Supply supply = new Supply(expectedType, expectedQuantity);

    @Test
    public void testObjectCreation() {
        assertNotNull(supply);
    }
	
    @Test
    public void testGetType() {
        assertEquals("getType should return the correct type", expectedType, supply.getType());
        }

    @Test
    public void testSetType() {
        supply.setType("Food");
        assertEquals("setType should update the type", "Food", supply.getType());
    }

    @Test
    public void testGetQuantity() {
        assertEquals("getQuantity should return the correct quantity", expectedQuantity, supply.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        supply.setQuantity(20);
        assertEquals("setQuantity should update the quantity", 20, supply.getQuantity());
    }

    @Test
    public void testIncreaseQuantity() {
        supply.increaseQuantity();
        assertEquals(11, supply.getQuantity()); 
    }

    @Test
    public void testDecreaseQuantity() {
        supply.decreaseQuantity();
        assertEquals(9, supply.getQuantity());
    }
}
