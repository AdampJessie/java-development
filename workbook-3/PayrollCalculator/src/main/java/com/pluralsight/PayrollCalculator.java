package com.pluralsight;


import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {

    public static void main(String[] args) {

        String fileName = "employees.csv";
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = bufReader.readLine()) != null) {

                String[] employeeArray = line.split("[|]+");

                int fileID = Integer.parseInt(employeeArray[0]); // Defining each attribute, pulling from the array
                String fileEmployeeName = employeeArray[1];
                double fileHoursWorked = Double.parseDouble(employeeArray[2]);
                double filePayRate = Double.parseDouble(employeeArray[3]);
                Employee employee = new Employee(fileID, fileEmployeeName,fileHoursWorked, filePayRate);

                System.out.printf("Employee ID: %d\nName: %s\nHours Worked: %.2f\nPay Rate: %.2f\nGross Pay: %.2f\n" // Prints formatted message
                    , employee.getEmployeeID(), employee.getName(), employee.getHoursWorked(), employee.getPayRate(), employee.getGrossPay());
                System.out.println("============================");
            }
            bufReader.close();

        } catch (FileNotFoundException e) {
            System.err.println("Wrong file name!");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println("Something went wrong!");
            throw new RuntimeException(e);
        }
    }
}

