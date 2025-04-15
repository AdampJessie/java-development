package com.pluralsight;

import java.util.Scanner;

public class SandShop {

    public static void main(String[] args) {
        Scanner sandwichScan = new Scanner(System.in);

        System.out.print("1: Regular: base price $5.45\n2: Large: base price $8.95\n(1/2): ");
        int size = sandwichScan.nextInt();

        double discount = discountCheck(sandwichScan);

        if (size < 2) {
            double price = 5.45 * discount;
            System.out.printf("Cart: Regular Sandwich 5.45\nTotal due: %.2f", price);
        }else {
            double price = 8.95 * discount;
            System.out.printf("Cart: Large Sandwich 8.95\n Total due: %.2f", price);

        }

    }

    public static double discountCheck(Scanner sandwichScan) {
        System.out.print("Please enter age: ");
        int age = sandwichScan.nextInt();

        double discount;
        if (age >= 65) {
            discount = .8;
        } else if (age <= 17) {
              discount = .9;
        } else discount = 1;

        return discount;
        }

    }


