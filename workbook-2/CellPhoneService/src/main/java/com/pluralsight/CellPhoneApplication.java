package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {

    public static void main(String[] args) {
        Scanner phoneInput = new Scanner(System.in);


        CellPhone phone1 = new CellPhone(); // Creating a new CellPhone class object.
        StringBuilder phoneInfo = new StringBuilder("+-------------------------------------------------+"); // Creates a StringBuilder for final output display and separator for format.

        System.out.print("What is the serial number? "); // Prompts user for information
        phone1.setSerialNumber(phoneInput.nextInt()); // Assigns user submitted information to class object
        phoneInfo.append(String.format("\nSerial Number: %d \n", phone1.getSerialNumber())); // Adds user information to String Builder
        phoneInput.nextLine(); // Consumes new line

        System.out.print("What model is the phone? ");
        phone1.setModel(phoneInput.nextLine());
        phoneInfo.append(String.format("Model: %s \n", phone1.getModel()));

        System.out.print("Who is the carrier? ");
        phone1.setCarrier(phoneInput.nextLine());
        phoneInfo.append(String.format("Carrier: %s \n", phone1.getCarrier()));

        System.out.print("What is the phone number? ");
        phone1.setPhoneNumber(phoneInput.nextLine());
        phoneInfo.append(String.format("Phone Number: %s \n", phone1.getPhoneNumber()));

        System.out.print("Who is the owner of the phone? ");
        phone1.setOwner(phoneInput.nextLine());
        phoneInfo.append(String.format("Owner: %s \n", phone1.getOwner()));
        phoneInfo.append("+-------------------------------------------------+\n");

        phoneInput.close(); // Closes scanner.
        System.out.println(phoneInfo); // Print formatted finalized completed string.


    }

}
