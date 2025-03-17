//NAME: Grace Okoro
//PROJECT: DATABASE MANAGER
//DATE: 10/25/2024



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class CustomerDatabase {
    private ArrayList<Customer> customers;
// Sets up an empty to hold customers
    public CustomerDatabase() {
        customers = new ArrayList<>();
    }

    // Add a new customer
    public void addCustomer(int id, String name, String address, String serviceRequest, double deposit) {
        Customer customer = new Customer(id, name, address, serviceRequest, deposit);
        customers.add(customer);
        System.out.println("Added: " + customer);
    }

    // Finds customer by ID
    public Customer findCustomer(int id) {
        for (Customer c : customers) {
            if (c.getCustomerId() == id) {
                return c;
            }
        }
        return null;
    }

    // Update customer details if they exist in the database
    public void updateCustomer(int id, String serviceRequest, double deposit) {
        Customer c = findCustomer(id);
        if (c != null) {
            c.setServiceRequest(serviceRequest);
            c.setDeposit(deposit);
            c.setLastUpdate(LocalDate.now());
            System.out.println("Updated: " + c);
        } else {
            System.out.println("Customer ID " + id + " not found.");
        }
    }

    // Purge inactive or old records (older than 12 months)
    public void purgeOldRecords() {
        LocalDate oneYearAgo = LocalDate.now().minusMonths(12);
        customers.removeIf(c -> c.getLastUpdate().isBefore(oneYearAgo));
        System.out.println("Purged records older than 12 months.");
    }

    // Display all customers
    public void displayAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers in database.");
        } else {
            for (Customer c : customers) {
                System.out.println(c);
            }
        }
    }

    // Generate a simple procedure manual
    public void generateManual() {
        try (PrintWriter writer = new PrintWriter(new File("procedures.txt"))) {
            writer.println("Customer Database Management Procedures");
            writer.println("=======================================");
            writer.println("1. Add Customer:");
            writer.println("   - Input: ID, Name, Address, Service Request, Deposit");
            writer.println("   - Example: Add 1, John Doe, 123 Main St, New Service, 50.0");
            writer.println("2. Update Customer:");
            writer.println("   - Input: ID, New Service Request, New Deposit");
            writer.println("   - Example: Update 1, Disconnect, 0.0");
            writer.println("3. Purge Old Records:");
            writer.println("   - Automatically removes records older than 12 months.");
            writer.println("4. Display All:");
            writer.println("   - Shows all current customer records.");
            System.out.println("Procedure manual generated as 'procedures.txt'.");
        } catch (Exception e) {
            System.out.println("Error generating manual: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CustomerDatabase db = new CustomerDatabase();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nOptions: 1=Add, 2=Update, 3=Purge, 4=Display, 5=Generate Manual, 6=Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Customer
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Service Request: ");
                    String request = scanner.nextLine();
                    System.out.print("Enter Deposit: ");
                    double deposit = scanner.nextDouble();
                    db.addCustomer(id, name, address, request, deposit);
                    break;

                case 2: // Update Customer
                    System.out.print("Enter Customer ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Service Request: ");
                    String newRequest = scanner.nextLine();
                    System.out.print("Enter New Deposit: ");
                    double newDeposit = scanner.nextDouble();
                    db.updateCustomer(updateId, newRequest, newDeposit);
                    break;

                case 3: // Purge Old Records
                    db.purgeOldRecords();
                    break;

                case 4: // Display All
                    db.displayAllCustomers();
                    break;

                case 5: // Generate Manual
                    db.generateManual();
                    break;

                case 6: // Exit
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}