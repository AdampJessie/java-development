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

        // Calculate gross pay and overtime using simple if statement. Store a string displaying whether user worked overtime.
        double payGross;
        String checkOT;

        if (hoursWorked > 40) {
            double hoursOver = hoursWorked - 40;
            payGross = (40 * payRate) + (hoursOver * (payRate*1.5));
            checkOT = String.format("You worked %.0f hours of overtime.", hoursOver);
        }
        else {
            payGross = (hoursWorked * payRate);
            checkOT = ("You did not work any overtime.");
        }

        // Format message containing all user input, overtime, and calculated gross pay - then output message.

        String payRoll = """
                +---------------------------------------+
                | Hello, %s!\t\t\t\t\t\t\t|
                | Worked %.0f hours at $%.2f per hour.\t|
                | %s\t\t|
                +---------------------------------------+
                | Your gross pay is $%.2f\t\t\t|
                +---------------------------------------+
            """.formatted(name, hoursWorked, payRate, checkOT, payGross);
        System.out.println(payRoll);


    }
}