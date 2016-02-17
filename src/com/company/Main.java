package com.company;
import java.util.Scanner;

/**
 * Created by Gustavo on 17/02/2016.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        printOptions();
        boolean quit = false;
        while (!quit) {
          int option = scanner.nextInt();
            switch (option) {
                case 1:
                    printOptions();
                    break;
                case 2:
                    createBranch();
                    break;
                case 3:
                    createNewCustomer();
                    break;
                case 4:
                    addTransaction();
                    break;
                case 5:
                    listDatabaseInformation();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        }

    }

    public static void printOptions() {
        System.out.println("Press a key to choose one of the following options :" + "\n" +
                "1.Print options" + "\n" +
                "2.Create a new branch" + "\n" +
                "3.Create and Add a new customer to a branch" + "\n" +
                "4.Add a transaction for a customer from a particular branch" + "\n" +
                "5.Print customers from a branch and optionally print their transactions" + "\n" +
                "6.Quit");
    }


    public static void createBranch() {
        System.out.println("Enter branch name : ");
        String branchName = scanner.next();
        if (bank.createNewBranch(branchName) == true) {
            System.out.println("branch " + branchName + " has been created");
        } else {
            System.out.println("Branch already exists");
        }
    }

    public static void createNewCustomer() {
        System.out.print("Enter customer name: ");
        String customerName = scanner.next();
        System.out.println("\n" + "Branch name where you want to add the customer: ");
        String branchName = scanner.next();
        System.out.println("Initial deposit ammount for the customer: ");
        double initialAmount = scanner.nextDouble();
        if (bank.addCustomerToBranch(customerName, branchName, initialAmount)) {
            System.out.println("Customer " + customerName + " added to " + branchName +
                    " with a deposit of " + initialAmount);
        } else {
            System.out.println("Error encountered when creating the customer");
        }
    }

    public static void addTransaction() {
        System.out.println("For what customer do you want to add a transaction ? ");
        String customerName = scanner.next();
        System.out.println("From what branch this customer belongs ?");
        String branchName = scanner.next();
        System.out.println("What is the deposit amount ?");
        double amount = scanner.nextDouble();
        if (bank.addBranchCustomerNewTransaction(branchName, customerName, amount)) {
            System.out.println("Transaction processed succesfully");
        } else {
            System.out.println("Error when processing the transaction ( maybe the customer or the branch " +
                    "does not exist in the database)");
        }
    }

    public static void listDatabaseInformation() {
        System.out.println("From what branch do you want to see the customers ?");
        String branchName = scanner.next();
        System.out.println("Do you want to see also their transactions (yes/no) ?");
        String answer = scanner.next();
        boolean showTransactions;
        if (answer.equals("yes")) {
            showTransactions = true;
        } else
            showTransactions = false;
        if (bank.printCustomersFromBranch(branchName, showTransactions)) {
            System.out.println("Customers printed succesfully");
        } else
            System.out.println("Branch not found");
    }
}
