package mydairy;

import java.util.Scanner;

public class Main {
    private static Dairies dairies = new Dairies();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    createNewdairy();
                    break;
                case 2:
                    accessdairy();
                    break;
                case 3:
                    deletedairy();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the dairy App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n--- dairy Management System ---");
        System.out.println("1. Create New dairy");
        System.out.println("2. Access dairy");
        System.out.println("3. Delete dairy");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void createNewdairy() {
        System.out.print("Enter dairy username: ");
        String username = scanner.nextLine();

        System.out.print("Create a PIN for your dairy: ");
        String pin = scanner.nextLine();

        try {
            dairies.addDairy(username, pin);
            System.out.println("dairy created successfully!");
        } catch (Exception e) {
            System.out.println("Error creating dairy: " + e.getMessage());
        }
    }

    private static void accessdairy() {
        System.out.print("Enter dairy username: ");
        String username = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        try {
            Dairy dairy = Dairies.findDairyByName(username);
            dairy.unlockDairy(pin);
            manageDairyMenu(dairy);
        } catch (Exception e) {
            System.out.println("Access denied: " + e.getMessage());
        }
    }

    private static void manageDairyMenu(Dairy dairy) {
        boolean managing = true;
        while (managing) {
            System.out.println("\n--- " + dairy.getName() + "'s dairy ---");
            System.out.println("1. Create Entry");
            System.out.println("2. View Entries");
            System.out.println("3. Update Entry");
            System.out.println("4. Delete Entry");
            System.out.println("5. Lock dairy");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    createEntry(dairy);
                    break;
                case 2:
                    viewEntries(dairy);
                    break;
                case 3:
                    updateEntry(dairy);
                    break;
                case 4:
                    deleteEntry(dairy);
                    break;
                case 5:
                    dairy.lockDairy("1234");
                    managing = false;
                    break;
                case 6:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createEntry(Dairy dairy) {
        System.out.print("Enter entry title: ");
        String title = scanner.nextLine();

        System.out.print("Enter entry body: ");
        String body = scanner.nextLine();

        try {
            dairy.createDairyEntry(title, body);
            System.out.println("Entry created successfully!");
        } catch (Exception e) {
            System.out.println("Error creating entry: " + e.getMessage());
        }
    }

    private static void viewEntries(Dairy dairy) {


    }

    private static void updateEntry(Dairy dairy) {
        System.out.print("Enter entry ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter new title: ");
        String title = scanner.nextLine();

        System.out.print("Enter new body: ");
        String body = scanner.nextLine();

        try {
            dairy.updateEntryById(id, title, body);
            System.out.println("Entry updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating entry: " + e.getMessage());
        }
    }

    private static void deleteEntry(Dairy dairy) {
        System.out.print("Enter entry ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Please enter your pin");
        String pin = scanner.nextLine();

        try {
            dairy.deleteDairyEntryById(pin, id);
            System.out.println("Entry deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error deleting entry: " + e.getMessage());
        }
    }

    private static void deletedairy() {
        System.out.print("Enter dairy username to delete: ");
        String username = scanner.nextLine();

        System.out.print("Enter PIN to confirm deletion: ");
        String pin = scanner.nextLine();

        try {
            dairies.deleteDairy(username, pin);
            System.out.println("dairy deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error deleting dairy: " + e.getMessage());
        }
    }
}