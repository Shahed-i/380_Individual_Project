package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class InquirerQuerySearchTest {

    @Test
    public void testLogInquirerQuery() {
        ReliefService reliefService = new ReliefService();
        InquiryDetails inquiryDetails = new InquiryDetails("Test inquiry");
        reliefService.logInquiry(inquiryDetails);
        assertEquals("logInquiry() should correctly log 'Test inquiry'", "Test inquiry", reliefService.getInquiryDetails());
    }

    @Test
    public void testSearchByName() {
        ReliefService reliefService = new ReliefService();
        DisasterVictim victim = new DisasterVictim("Mark Loren", "2024-01-23");
        String partialName = "Mark";
        List<DisasterVictim> missingPersons = reliefService.searchDisasterVictim(partialName);

        assertFalse("The missingPersons list should not be empty", missingPersons.isEmpty());

        boolean containsPartialName = false;
        for (DisasterVictim missingPerson : missingPersons) {
            if (missingPerson.getFullName().contains(partialName)) {
                containsPartialName = true;
                break;
            }
        }
        assertTrue("searchDisasterVictim() should have found a match if it exists", containsPartialName);
    }
}
