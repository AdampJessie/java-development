package com.pluralsight.finance;

public class BankAccount  implements IValuable{

    private String name, accountNumber;
    private double balance;

    public BankAccount(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public void deposit(double amount){
        balance += amount;
    }

    @Override
    public double getValue() {
        return balance;
    }
}

