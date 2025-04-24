package com.pluralsight;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormat {
    public static void main(String[] args) {

        ZonedDateTime dateCurrent = ZonedDateTime.now();
        DateTimeFormatter format;

        format = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Formatted date - mm/dd/yyyy
        System.out.println(dateCurrent.format(format));

        System.out.println(LocalDate.now()); // Default formatted date - yyyy-mm-dd

        format = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println(dateCurrent.format(format));
        System.out.println();

        ZonedDateTime dateGMT = ZonedDateTime.now(ZoneId.of("GMT")); // Zones current time to GMT
        format = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy h:mm z"); // Formatted output to Full Day, Month day number
        System.out.println(dateGMT.format(format));

        format = DateTimeFormatter.ofPattern("h:mm 'on' dd-E-yyyy 'in local time'"); // Formats time with a message
        System.out.println(dateCurrent.format(format));
    }
}