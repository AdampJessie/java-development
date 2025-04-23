package com.pluralsight;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStories {

    public static void main(String[] args) {

        Scanner fileInput = new Scanner(System.in);

        try {
            System.out.print("Please enter a story/file name: ");
            String fileName = fileInput.nextLine();

            FileInputStream fileStream = new FileInputStream(fileName);
            Scanner fileScan = new Scanner(fileStream);

            while (fileScan.hasNextLine()) {
                System.out.println(fileScan.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
