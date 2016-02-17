package com.company;

import java.util.ArrayList;

/**
 * Created by Gustavo on 17/02/2016.
 */
public class Bank {
    private ArrayList<Branch> branches;

    public Bank() {
        this.branches = new ArrayList<>();
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public boolean createNewBranch(String branchName) {
        if (findBranch(branchName) == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomerToBranch(String customerName, String branchName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addNewCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addBranchCustomerNewTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    public boolean printCustomersFromBranch(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            ArrayList<Customer> customers = branch.getCustomers();
            System.out.println("Customers from branch " + branch.getName());
            for (int i = 0; i < customers.size(); i++) {
                System.out.println(customers.get(i).getName());
                if (showTransactions == true)
                    printCustomerTransactions(customers.get(i));
            }
            return true;
        }
        return false;
    }

    private void printCustomerTransactions(Customer customer) {
        ArrayList<Double> transactions = customer.getTransactions();

        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(transactions.get(i).doubleValue());
        }
    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(branchName)) {
                return branches.get(i);
            }
        }
        return null;
    }
}
