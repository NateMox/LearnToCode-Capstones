package com.pluralsight;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    String userInput;
    String filePath = "src/main/resources/Transactions.csv";

    do {
        System.out.println("Howdy! Welcome to your Financial Tracker");
        System.out.println("Select an option");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment (Debit)");
        System.out.println("L) Ledger");
        System.out.println("E) Exit");

        String choice = scanner.nextLine().toUpperCase();

        String option = "";
        switch (option) {
            case "D":
                addTransaction(true);
                break;
            case "P":
                addTransaction(false);
                break;
            case "E":
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Please try again: ");
        }
    }

    private void addTransaction(boolean b) {
    }
}














}
