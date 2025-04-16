package com.pluralsight;

import java.util.Scanner;

public class FullName {


    public static void main(String[] args) {

        Scanner inputName = new Scanner(System.in);

        // Gather first name from user input
        System.out.print("Enter first name: ");
        String nameFirst = inputName.nextLine();

        // Gather middle name from user input
        System.out.print("Enter middle name (Full or initial): ");
        String nameMiddle = inputName.nextLine();

        // Gather last name from user input
        System.out.print("Enter last name: ");
        String nameLast = inputName.nextLine();

        // Gather title from user input
        System.out.print("Enter title (PHD, MD, etc): ");
        String nameTitle = inputName.nextLine();
        inputName.close();

        // Print full name using the String method - format. Catch lack of middle name/title.
        nameCheckNDisplay(nameFirst, nameMiddle, nameLast, nameTitle);

    }
    public static void nameCheckNDisplay(String nameFirst, String nameMiddle, String nameLast, String nameTitle) {
        String nameFull = String.format("%s %s" , nameFirst.trim(), nameMiddle);

        // Checks presence of middle name and title, and adds them accordingly.
        if (!nameMiddle.isEmpty()) {
            nameFull = String.format("%s %s %s", nameFirst.trim(), nameMiddle.trim(), nameLast.trim());
        }if (!nameTitle.isEmpty()) {
            nameFull = String.format("%s %s %s, %s", nameFirst.trim(), nameMiddle.trim(), nameLast.trim(), nameTitle.trim());
        }
        System.out.println("Hello "+ nameFull +"!");
    }
}
