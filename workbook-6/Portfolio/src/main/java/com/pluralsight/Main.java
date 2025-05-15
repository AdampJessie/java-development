package com.pluralsight;

import com.pluralsight.finance.BankAccount;
import com.pluralsight.finance.IValuable;

public class Main {

    public static void main(String[] args) {

        BankAccount account1 = new BankAccount("Pam", "123", 12500);
        IValuable account2 = new BankAccount("Pam", "123", 12500);

        System.out.println("Value of bank account 123: "+account1.getValue());

        account1.deposit(100);

        System.out.println("-".repeat(50));
        System.out.println("Value of bank account 123: "+account1.getValue());

    }

}
