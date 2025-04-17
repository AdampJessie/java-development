package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BoxOffice {

    public static void main(String[] args) {

        Scanner ticketInput = new Scanner(System.in);

        // Collect name from user and separate first name from last name.
        System.out.print("Please enter your name: ");
        String nameFull = ticketInput.nextLine();
        String ticketFirstName = nameFull.substring(0, nameFull.indexOf(" "));
        String ticketLastName = nameFull.substring(nameFull.indexOf(" ") + 1);

        // Collect ticket amount from user, define ticket(s) formatting for final output message.
        System.out.print("Please enter the amount of tickets: ");
        int tickets = ticketInput.nextInt();
        ticketInput.nextLine();
        String ticketString = (tickets < 2) ? "ticket" : "tickets";

        // Collect date from user as string, convert to formatted date type.
        DateTimeFormatter ticketDateFormat;
        System.out.print("Please enter a date: ");
        String userDate = ticketInput.nextLine();
        ticketDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate ticketReservation = LocalDate.parse(userDate, ticketDateFormat);

        ticketInput.close();

        // Print formatted message containing ticket count, ticket(s), date, first name, and last name.
        System.out.println("+-------------------------------------------------------------------+");
        System.out.printf("Hello, %d %s reserved for %s under %s, %s.", tickets, ticketString, ticketReservation, ticketLastName, ticketFirstName);


    }

}
