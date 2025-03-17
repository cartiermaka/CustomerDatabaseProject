//NAME: Grace Okoro
//PROJECT: DATABASE MANAGER
//DATE: 10/25/2024



import java.time.LocalDate;

public class Customer {
    private int customerId;
    private String name;
    private String address;
    private String accountStatus; // "Active" or "Inactive"
    private String serviceRequest; // Things like "New Service", "Disconnect"
    private double deposit;
    private LocalDate lastUpdate; // Keeps track of date of inputs

    public Customer(int customerId, String name, String address, String serviceRequest, double deposit) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.accountStatus = "Active";
        this.serviceRequest = serviceRequest;
        this.deposit = deposit;
        this.lastUpdate = LocalDate.now();
    }

    // Getters and setters
    public int getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getAccountStatus() { return accountStatus; }
    public String getServiceRequest() { return serviceRequest; }
    public double getDeposit() { return deposit; }
    public LocalDate getLastUpdate() { return lastUpdate; }

    public void setAccountStatus(String status) { this.accountStatus = status; }
    public void setServiceRequest(String request) { this.serviceRequest = request; }
    public void setDeposit(double deposit) { this.deposit = deposit; }
    public void setLastUpdate(LocalDate date) { this.lastUpdate = date; }

    @Override
    public String toString() {
        return "ID: " + customerId + ", Name: " + name + ", Address: " + address +
               ", Status: " + accountStatus + ", Request: " + serviceRequest +
               ", Deposit: $" + deposit + ", Last Update: " + lastUpdate;
    }
}