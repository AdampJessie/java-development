package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Create 2 instances of CellPhone - cellPhone1 and cellPhone2
        CellPhone cellPhone1 = cellPhoneNew(scanner);
        CellPhone cellPhone2 = cellPhoneNew(scanner);

        // Close the scanner
        scanner.close();

        // Display cellPhone1 and cellPhone2
        cellPhoneDisplay(cellPhone1);
        cellPhoneDisplay(cellPhone2);

        // Display dial method (cellPhone1 dials cellPhone2's number then vice versa)
        cellPhone1.dial(cellPhone2.getPhoneNumber());
        cellPhone2.dial(cellPhone1.getPhoneNumber());
    }
    private static CellPhone cellPhoneNew(Scanner scanner) {

        // Create new CellPhone object
        CellPhone cellPhone = new CellPhone();

        // Prompt user for cell phone information and set the properties
        System.out.print("What is the serial number? ");
        int serialNumber = scanner.nextInt();  // Read integer value
        cellPhone.setSerialNumber(serialNumber);
        scanner.nextLine();  // Consume newline

        System.out.print("What model is the phone? ");
        String model = scanner.nextLine();  // Read entire line till newline
        cellPhone.setModel(model);

        System.out.print("Who is the carrier? ");
        String carrier = scanner.nextLine();
        cellPhone.setCarrier(carrier);

        System.out.print("What is the phone number? ");
        String phoneNumber = scanner.nextLine();
        cellPhone.setPhoneNumber(phoneNumber);

        System.out.print("Who is the owner of the phone? ");
        String owner = scanner.nextLine();
        cellPhone.setOwner(owner);

        System.out.println("+-----------------------------------+");

        return cellPhone;
    }
    private static void cellPhoneDisplay(CellPhone cellPhone) {
        // Display the properties of the phone using getters
        System.out.println("CellPhone Details:");
        System.out.println("Serial Number: " + cellPhone.getSerialNumber());
        System.out.println("Model: " + cellPhone.getModel());
        System.out.println("Carrier: " + cellPhone.getCarrier());
        System.out.println("Phone Number: " + cellPhone.getPhoneNumber());
        System.out.println("Owner: " + cellPhone.getOwner());
        System.out.println("+-----------------------------------+");
    }
}