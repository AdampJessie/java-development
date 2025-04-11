package com.pluralsight;

import java.util.Scanner;

public class PayCalc {
    public static void main(String[] args) {

        Scanner payScan = new Scanner(System.in);

        // Prompt and store user input for name, hoursWorked, and payRate.
        System.out.print("What's your name?: ");
        String name = payScan.nextLine();

        System.out.print("How many hours have you worked?: ");
        double hoursWorked = payScan.nextFloat();

        System.out.print("How much $ do you make an hour?: ");
        double payRate = payScan.nextFloat();

        // Calculate gross pay
        double payGross = (hoursWorked * payRate);

        // Print formatted message containing all user input and calculated gross pay
        System.out.printf("Hello, %s, you have worked %.0f hours at a rate of $%.2f per hour.\nYour gross pay is %.2f",
                name, hoursWorked, payRate, payGross);

    }
}
