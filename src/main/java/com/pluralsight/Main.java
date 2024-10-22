package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    // Create an ArrayList to store transaction objects
    static ArrayList <Transactions> transactions = new ArrayList<Transactions>();


    public static void main(String[] args) {
        // Read existing transactions from the file
        readTransactions();
        int option ;

        // Display main menu
        do {
            System.out.println("Howdy! Welcome to your Financial Tracker");
            System.out.println("Select an option");
            System.out.println("1) Add Deposit");
            System.out.println("2) Make Payment (Debit)");
            System.out.println("3) Ledger");
            System.out.println("4) Exit");

            option = scanner.nextInt();
            scanner.nextLine();

            // Handle user selection and call methods
            switch (option) {
                case 1:
                    addDeposit();
                    break;
                case 2:
                    addPayment();
                    break;
                case 3:
                    ledgerMenu();
                    break;
                case 4:
                    System.out.println("Exiting..");
                    break;
                default:
                    System.out.println("Please try again: ");
            }

        } while (option != 4);


    }


    // Method to read transactions from the CSV file
    public static void readTransactions() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("transactions.csv"));

            String firstLine = br.readLine();
            String input;

            // Read each line of the CSV file
            while ((input = br.readLine()) != null) {
                String[] transactionArr = input.split("\\|");
                String date = transactionArr[0];
                String time = transactionArr[1];
                String description = transactionArr[2];
                String vendor = transactionArr[3];
                double amount = Double.parseDouble(transactionArr[4]);


                transactions.add(new Transactions(date, time, description, vendor, amount));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to add a deposit transaction
    public static void addDeposit () {
        // Get current date and time
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        // Prompt user for transaction details
        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        // Create a new Transactions object
        Transactions transaction = new Transactions(date, time, description, vendor, amount);

        // Add transaction to the list
        transactions.add(transaction);

        // Write the transaction to the CSV file
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Transactions.csv", true));
            bw.write(String.format("\n%s|%s|%s|%s|%.2f",
                    transaction.getDate(),
                    transaction.getTime(),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount()));

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Method to add a payment transaction
        public static void addPayment () {
            // Get current date and time
            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            // Prompt user for transaction details
            System.out.print("Description: ");
            String description = scanner.nextLine();

            System.out.print("Vendor: ");
            String vendor = scanner.nextLine();

            System.out.print("Amount: $");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            amount = amount * -1;

            // Create a new Transactions object
            Transactions transaction = new Transactions(date, time, description, vendor, amount);

            transactions.add(transaction);

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("Transactions.csv", true));
                bw.write(String.format("\n%s|%s|%s|%s|%.2f",
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount()));

                bw.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

    }
    // Method to display the ledger menu
    public static void ledgerMenu (){

    int option ;
    do {
        System.out.println("1) Display All Entries");
        System.out.println("2) Only Negative Entries");
        System.out.println("3) Display Deposit Only ");
        System.out.println("4) New Screen");
        System.out.println("5) Exit");

        System.out.print("Select an option: ");



        option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                allEntries(); // Display all entries
                break;
            case 2:
                allPayments(); // Display only negative entries (payments)
                break;
            case 3:
                allDeposits(); // Display only positive entries (deposits
                break;
            case 4:
                System.out.println("Reports"); // Placeholder for reports
                break;
            case 5: System.out.println("Home"); // Return to home
                break;
            default:
                System.out.println("Please try again: ");
        }

    } while (option != 5); // Repeat until user chooses to exit

}
public static void allEntries(){

    for (Transactions t : transactions )
        if (t != null)
            System.out.println(t); // Print each transaction



    }

    public static void allPayments(){
        for (Transactions t : transactions )
            if (t != null&&t.getAmount()<0)
                System.out.println(t); // Print each payment transaction

    }
public static void allDeposits(){
    for (Transactions t : transactions )
        if (t != null&&t.getAmount()>0)
            System.out.println(t); // Print each deposit transaction


}

}
















