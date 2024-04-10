package edu.ucalgary.oop;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;

public class Inquirer extends Person implements InquirerQuerySearchInterface {
    private static final Scanner scanner = new Scanner(System.in);

    private String info;
    private String servicesPhoneNum;

    // Constructor
    public Inquirer(String firstName, String lastName, String servicesPhoneNum, String info) {
        super(firstName, lastName);
        this.servicesPhoneNum = servicesPhoneNum;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public String getServicesPhoneNum() {
        return servicesPhoneNum;
    }

    public class Database {
        private static final String URL = "jdbc:postgresql://localhost:5432/ensf380project";
        private static final String USERNAME = "oop";
        private static final String PASSWORD = "ucalgary";
    
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
    }

    public void start() {
        System.out.println("Welcome to the Inquiry Management System");

        try (Connection connection = Database.getConnection()) {
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Log a new inquiry");
                System.out.println("2. Search for an inquiry");
                System.out.println("3. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        System.out.println("\nEnter details for the new inquiry:");

                        System.out.print("First Name: ");
                        String firstName = scanner.nextLine();

                        System.out.print("Last Name: ");
                        String lastName = scanner.nextLine();

                        System.out.print("Phone Number: ");
                        String phoneNumber = scanner.nextLine();

                        System.out.print("Details: ");
                        String details = scanner.nextLine();

                        boolean success = logNewInquiry(connection, firstName, lastName, phoneNumber, details);
                        if (success) {
                            System.out.println("Inquiry logged successfully.");
                        } else {
                            System.out.println("Failed to log the inquiry.");
                        }
                        break;
                    case 2:
                        System.out.println("\nEnter a part of the name to search for:");

                        System.out.print("Name: ");
                        String searchTerm = scanner.nextLine();
                        String searchResult = searchForInquirer(connection, searchTerm);
                        System.out.println("\nSearch Results:");
                        System.out.println(searchResult);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean logNewInquiry(Connection connection, String firstName, String lastName, String phoneNumber, String details) throws SQLException {
        String insertInquirerQuery = "INSERT INTO INQUIRER (firstname, lastname, phonenumber) VALUES (?, ?, ?)";
        String insertInquiryQuery = "INSERT INTO INQUIRY_LOG (inquirer, calldate, details) VALUES (?, current_date, ?)";
    
        try (PreparedStatement insertInquirerStatement = connection.prepareStatement(insertInquirerQuery, PreparedStatement.RETURN_GENERATED_KEYS);
             PreparedStatement insertInquiryStatement = connection.prepareStatement(insertInquiryQuery)) {
            insertInquirerStatement.setString(1, firstName);
            insertInquirerStatement.setString(2, lastName);
            insertInquirerStatement.setString(3, phoneNumber);
    
            int affectedRows = insertInquirerStatement.executeUpdate();
            if (affectedRows == 0) {
                return false;
            }
    
            try (ResultSet generatedKeys = insertInquirerStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int inquirerId = generatedKeys.getInt(1);
                    insertInquiryStatement.setInt(1, inquirerId);
                    insertInquiryStatement.setString(2, details);
    
                    int inquiryRows = insertInquiryStatement.executeUpdate();
                    return inquiryRows > 0;
                } else {
                    return false;
                }
            }
        }
    }
    
    @Override
    public String searchForInquirer(Connection connection, String searchTerm) throws SQLException {
        String searchQuery = "SELECT * FROM INQUIRER WHERE LOWER(firstname) LIKE ? OR LOWER(lastname) LIKE ?";
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            preparedStatement.setString(1, "%" + searchTerm.toLowerCase() + "%");
            preparedStatement.setString(2, "%" + searchTerm.toLowerCase() + "%");
    
            StringBuilder searchResults = new StringBuilder();
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("firstname");
                    String lastName = resultSet.getString("lastname");
                    String phoneNumber = resultSet.getString("phonenumber");
    
                    searchResults.append("ID: ").append(id).append(", Name: ").append(firstName).append(" ").append(lastName)
                            .append(", Phone Number: ").append(phoneNumber).append("\n");
                }
            }
            return searchResults.toString();
        }
    }
    
}
