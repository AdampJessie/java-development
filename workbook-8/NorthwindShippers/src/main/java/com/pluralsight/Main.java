package com.pluralsight;
import com.pluralsight.db.DataManager;
import com.pluralsight.model.Shipper;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("User and Password are needed!");
            System.exit(1);
        }
        DataManager dataManager = null;
        try {
            BasicDataSource dataSource = connectData(args[0], args[1]);
            dataManager = new DataManager(dataSource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Please enter the name of a shipper you'd like to add:");
            String newName = scanner.nextLine();
            System.out.println("Please enter the phone number of a shipper you'd like to add:");
            String newPhone = scanner.nextLine();

            dataManager.insertRecord(newName, newPhone);

            //Display added shippers
            displayQuery(dataManager);


            System.out.println("Please enter the ID of a shipper you'd like to update:");
            int updateID = Integer.parseInt(scanner.nextLine());
            System.out.println("Please enter new phone number of the shipper you'd like to update:");
            String updatePhone = scanner.nextLine();

            dataManager.updateRecord(updatePhone, updateID);

            //Display updated shippers
            displayQuery(dataManager);

            System.out.println("Please enter the ID of a shipper you'd like to delete:");
            int deleteID = Integer.parseInt(scanner.nextLine());

            dataManager.deleteRecord(deleteID);

            //Display (deleted) shippers
            displayQuery(dataManager);


        }

    }

    private static BasicDataSource connectData(String username, String password) {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    private static void displayQuery(DataManager dataManager){

        List<Shipper> shippers = dataManager.queryAll();
        System.out.println("Shippers: ");
        shippers.forEach(shipper -> {
            System.out.println(shipper + "\n");
            System.out.println("-".repeat(30));
        });

    }



}
