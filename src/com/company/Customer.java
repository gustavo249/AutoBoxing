package com.company;

import java.util.ArrayList;

/**
 * Created by Gustavo on 17/02/2016.
 */
public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<>();
        addNewTransaction(initialAmount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addNewTransaction(double sum) {
        this.transactions.add(sum);
    }
}
