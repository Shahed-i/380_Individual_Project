package edu.ucalgary.oop;

import java.util.Scanner;
import java.util.List;

public interface DisasterVictimInfoInterface {
    Scanner scanner = new Scanner(System.in);

    void start();

    default void enterNewDisasterVictim() {
        System.out.println("\nEnter details for the new Disaster Victim:");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Entry Date (YYYY-MM-DD): ");
        String entryDate = scanner.nextLine();

        DisasterVictim victim;

        System.out.print("Do you want to enter Date of Birth (Y/N): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String dateOfBirth = scanner.nextLine();
            victim = new DisasterVictim(firstName, entryDate, dateOfBirth);
        } else {
            victim = new DisasterVictim(firstName, entryDate, 0);
        }

        System.out.print("Last Name: ");
        victim.setLastName(scanner.nextLine());

        System.out.print("Gender: ");
        victim.setGender(scanner.nextLine());

        System.out.print("Comments: ");
        victim.setComments(scanner.nextLine());

        addVictim(victim);
        System.out.println("Disaster Victim information entered successfully.");
    }

    default void viewAllDisasterVictims() {
        if (getVictims().isEmpty()) {
            System.out.println("No Disaster Victims entered yet.");
            return;
        }

        System.out.println("\nAll Entered Disaster Victims:");
        for (int i = 0; i < getVictims().size(); i++) {
            System.out.println("Victim #" + (i + 1) + ":");
            displayVictimDetails(getVictims().get(i));
        }
    }

    default void displayVictimDetails(DisasterVictim victim) {
        System.out.println("First Name: " + victim.getFirstName());
        System.out.println("Last Name: " + victim.getLastName());
        System.out.println("Date of Birth: " + victim.getDateOfBirth());
        System.out.println("Gender: " + victim.getGender());
        System.out.println("Entry Date: " + victim.getEntryDate());
        System.out.println("Comments: " + victim.getComments());
    }

    List<DisasterVictim> getVictims();

    void addVictim(DisasterVictim victim);

    void closeScanner();
}
