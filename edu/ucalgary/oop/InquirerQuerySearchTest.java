package edu.ucalgary.oop;

import static org.junit.Assert.*;
import org.junit.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InquirerQuerySearchTest {

    @Test
    public void testLogNewInquiry() throws SQLException {
        // Mock user input
        String input = "John\nDoe\n1234567890\nDetails\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Establish a connection
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ensf380project", "oop", "ucalgary");

        // Log a new inquiry
        assertTrue(InquirerQuerySearch.logNewInquiry(connection, "John", "Doe", "1234567890", "Details"));
    }

    @Test
    public void testSearchForInquirer() throws SQLException {
        // Establish a connection
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ensf380project", "oop", "ucalgary");

        // Search for an existing inquirer
        String searchTerm = "John";
        String result = InquirerQuerySearch.searchForInquirer(connection, searchTerm);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }


}
