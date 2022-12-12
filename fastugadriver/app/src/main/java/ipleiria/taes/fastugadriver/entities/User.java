package ipleiria.taes.fastugadriver.entities;

import java.util.Hashtable;

public class User {
    private String firstName, lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String licensePlate;
    private int balance;
    private int totalDeliveries;
    private long totalDeliveryMinutes;
    private Hashtable<Integer, Integer> customersServed;
    private double totalAverageSpeed;

    public User(String firstName, String lastName, String email, String password, String phoneNumber, int balance, int totalDeliveries, long totalDeliveryTime, double totalAverageSpeed, String licensePlate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.licensePlate = licensePlate;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.totalDeliveries = totalDeliveries;
        this.totalDeliveryMinutes = totalDeliveryTime;
        this.totalAverageSpeed = totalAverageSpeed;
        customersServed = new Hashtable<>();
    }

    public User() {
    }

    public void addCustomerServed(int customer_id){
        customersServed.put(customer_id, 1);
    }

    public int getDistinctCustomers() {
        return customersServed.size();
    }

    public long getTotalDeliveryMinutes() {
        return totalDeliveryMinutes;
    }

    public void setTotalDeliveryMinutes(long totalDeliveryMinutes) {
        this.totalDeliveryMinutes = totalDeliveryMinutes;
    }

    public void incrementDeliveryTime(long time){
        totalDeliveryMinutes += time;
    }

    public int getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(int totalDeliveries) {
        this.totalDeliveries = totalDeliveries;
    }

    public void incrementDeliveries(){
        totalDeliveries++;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void updateBalance(int balance){
        this.balance += balance;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getTotalAverageSpeed() {
        return totalAverageSpeed;
    }

    public void setTotalAverageSpeed(double totalAverageSpeed) {
        this.totalAverageSpeed = totalAverageSpeed;
    }

    public void incrementTotalAverageSpeed(double averageSpeed){
        this.totalAverageSpeed += averageSpeed;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}