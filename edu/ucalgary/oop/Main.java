package edu.ucalgary.oop;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Main Menu");
        System.out.println("Choose the system you want to access:");
        System.out.println("1. Disaster Victim Information System");
        System.out.println("2. Inquiry Management System");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                DisasterVictimInfoInterface disasterVictimSystem = new DisasterVictim("John", "2024-01-01", 30);
                disasterVictimSystem.start();
                break;
            case 2:
                // Instantiate Inquirer class with parameters
                System.out.print("Enter your first name: ");
                String firstName = scanner.nextLine();
                System.out.print("Enter your last name: ");
                String lastName = scanner.nextLine();
                System.out.print("Enter your services phone number: ");
                String servicesPhoneNum = scanner.nextLine();
                System.out.print("Enter additional info: ");
                String info = scanner.nextLine();

                InquirerQuerySearchInterface inquirerSystem = new Inquirer(firstName, lastName, servicesPhoneNum, info);
                inquirerSystem.start();
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
        }
    }
}
