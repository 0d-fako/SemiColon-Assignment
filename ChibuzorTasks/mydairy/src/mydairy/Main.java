package mydairy.src.mydairy;

import java.util.Scanner;

public class Main {
    private static Dairies dairies = new Dairies();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        dairies = FileManager.loadDairies();

        if(dairies == null) {
            dairies = new Dairies();
        }

        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    createNewDairy();
                    break;
                case 2:
                    accessDairy();
                    break;
                case 3:
                    deleteDairy();
                    break;
                case 4:
                    FileManager.saveDairies(dairies);
                    running = false;
                    System.out.println("Saving Dairies and exiting the Dairy App.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        SCANNER.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n--- Dairy Management System ---");
        System.out.println("1. Create New Dairy");
        System.out.println("2. Access Dairy");
        System.out.println("3. Delete Dairy");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void createNewDairy() {
        System.out.print("Enter dairy username: ");
        String username = SCANNER.nextLine();

        System.out.print("Create a PIN for your dairy: ");
        String pin = SCANNER.nextLine();

        try {
            dairies.addDairy(username, pin);
            FileManager.saveDairies(dairies);
            System.out.println("Dairy created successfully!");
        } catch (Exception e) {
            System.out.println("Error creating dairy: " + e.getMessage());
        }
    }

    public static void accessDairy() {
        System.out.print("Enter dairy username: ");
        String username = SCANNER.nextLine();

        System.out.print("Enter PIN: ");
        String pin = SCANNER.nextLine();

        try {
            Dairy dairy = dairies.findDairyByName(username);
            dairy.unlockDairy(pin);
            manageDairyMenu(dairy);
        } catch (Exception e) {
            System.out.println("Access denied: " + e.getMessage());
        }
    }

    private static void manageDairyMenu(Dairy dairy) {
        boolean managing = true;
        while (managing) {
            System.out.println("\n--- " + dairy.getName() + "'s Dairy ---");
            System.out.println("1. Create Entry");
            System.out.println("2. View Entries");
            System.out.println("3. Update Entry");
            System.out.println("4. Delete Entry");
            System.out.println("5. Lock Dairy");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    createEntry(dairy);
                    FileManager.saveDairies(dairies);
                    break;
                case 2:
                    viewEntries(dairy);
                    break;
                case 3:
                    updateEntry(dairy);
                    FileManager.saveDairies(dairies);
                    break;
                case 4:
                    deleteEntry(dairy);
                    FileManager.saveDairies(dairies);
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
        String title = SCANNER.nextLine();

        System.out.print("Enter entry body: ");
        String body = SCANNER.nextLine();

        try {
            dairy.createDairyEntry(title, body);
            FileManager.saveDairies(dairies);
            System.out.println("Entry created successfully!");
        } catch (Exception e) {
            System.out.println("Error creating entry: " + e.getMessage());
        }
    }

    private static void viewEntries(Dairy dairy) {
        System.out.print("Enter your pin: ");
        String pin = SCANNER.nextLine();

        try {
            System.out.println(dairy.viewDairyEntry(pin));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateEntry(Dairy dairy) {
        System.out.print("Enter entry ID to update: ");
        int id = Integer.parseInt(SCANNER.nextLine());

        System.out.print("Enter new title: ");
        String title = SCANNER.nextLine();

        System.out.print("Enter new body: ");
        String body = SCANNER.nextLine();

        try {
            dairy.updateEntryById(id, title, body);
            System.out.println("Entry updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating entry: " + e.getMessage());
        }
    }

    private static void deleteEntry(Dairy dairy) {
        System.out.print("Enter entry ID to delete: ");
        int id = Integer.parseInt(SCANNER.nextLine());

        System.out.print("Please enter your pin: ");
        String pin = SCANNER.nextLine();

        try {
            dairy.deleteDairyEntryById(pin, id);
            System.out.println("Entry deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error deleting entry: " + e.getMessage());
        }
    }

    private static void deleteDairy() {
        System.out.print("Enter dairy username to delete: ");
        String username = SCANNER.nextLine();

        System.out.print("Enter PIN to confirm deletion: ");
        String pin = SCANNER.nextLine();

        try {
            dairies.deleteDairy(username, pin);
            System.out.println("Dairy deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error deleting dairy: " + e.getMessage());
        }
    }
}