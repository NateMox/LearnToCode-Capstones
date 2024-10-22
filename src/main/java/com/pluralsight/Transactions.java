package com.pluralsight;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transactions {

    private String date ;
    private String time;
    private String description;
    private String vendor;
    private double amount;



    // Get the current date and time
    LocalDateTime now = LocalDateTime.now();
    // Define format for date
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    // Define format for time
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    // Constructor to initialize a Transactions object
    public Transactions (String date, String time, String description, String vendor, double amount) {

        this.date = now.format(dateFormatter);
        this.time = now.format(timeFormatter);
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;



    } // Override toString method for formatted output of the transaction
    @Override
    public String toString() {
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;

    }
    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}


