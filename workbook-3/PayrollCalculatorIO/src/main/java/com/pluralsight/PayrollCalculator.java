package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {

    public static void main(String[] args) {

        Scanner payrollInput = new Scanner(System.in);

        try {

            System.out.print("Please enter the input file: "); // User enters file to read from
            String fileInputName = payrollInput.nextLine();
            BufferedReader reader = new BufferedReader(new FileReader(fileInputName));

            System.out.print("Please enter the output file: "); // User inputs file to write to
            String fileOutputName = payrollInput.nextLine();
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutputName));

            String line;
            while ((line = reader.readLine()) != null) {

                String[] employeeArray = line.split("[|]+"); // Splitting array by "|"

                int fileID = Integer.parseInt(employeeArray[0]); // Defining each attribute, pulling from the array
                String fileEmployeeName = employeeArray[1];
                double fileHoursWorked = Double.parseDouble(employeeArray[2]);
                double filePayRate = Double.parseDouble(employeeArray[3]);
                Employee employee = new Employee(fileID, fileEmployeeName,fileHoursWorked, filePayRate);


                writer.write(String.format("Employee ID: %d\nName: %s\nGross Pay: $%.2f\n\n",
                        employee.getEmployeeID(), employee.getName(), employee.getGrossPay()));
            }

            reader.close(); // Closing reader and writer to flush data/save resources
            writer.close();

        } catch (Exception e) {
            System.err.println("Something went wrong!");
            throw new RuntimeException(e);
        }







    }
}

