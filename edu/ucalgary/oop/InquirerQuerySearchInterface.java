package edu.ucalgary.oop;

import java.sql.Connection;
import java.sql.SQLException;

public interface InquirerQuerySearchInterface {
    boolean logNewInquiry(Connection connection, String firstName, String lastName, String phoneNumber, String details) throws SQLException;
    String searchForInquirer(Connection connection, String searchTerm) throws SQLException;
    void start();
}
