package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (
                Scanner scanner = new Scanner(System.in);
                BasicDataSource dataSource = connectData(args[0], args[1]
                )) {

            System.out.println("Please enter the last name of an actor to search:");
            String lastName = scanner.nextLine();
            searchActors(dataSource, lastName);

            System.out.println("Please enter an actor's first and last name to search their movies (First Last): ");
            String[] inputName = scanner.nextLine().trim().split(" ");
            String firstName = inputName[0];
            lastName = inputName[1];
            searchFilms(dataSource, firstName, lastName);

        } catch (SQLException e) {
            System.out.println("Something went wrong!\n" + e);
        }
    }

    private static BasicDataSource connectData(String username, String password) {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    private static void searchActors(BasicDataSource dataSource, String lastName) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     """
                             SELECT First_Name, Last_Name
                             FROM actor
                             WHERE Last_Name LIKE ?;
                             """)) {

            preparedStatement.setString(1, lastName);

            try (ResultSet results = preparedStatement.executeQuery()) {
                while (results.next()) {
                    System.out.printf("First Name = %s, Last Name = %s\n",
                            results.getString(1),
                            results.getString(2));
                }
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong!\n"+ ex);
        }
    }

    private static void searchFilms(BasicDataSource dataSource, String firstName, String lastName) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     """
                            SELECT f.title
                            FROM actor a
                            JOIN film_actor fa ON a.actor_id = fa.actor_id
                            JOIN film f ON fa.film_id = f.film_id
                            WHERE a.first_name = ? AND a.last_name = ?;
                            """)) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            try (ResultSet results = preparedStatement.executeQuery()) {
                while (results.next()) {
                    System.out.printf("Title = %s\n",
                            results.getString(1));
                }
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong!\n"+ ex);
        }
    }
}