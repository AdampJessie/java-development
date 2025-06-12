package com.pluralsight;

import com.pluralsight.db.DataManager;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DataManager dataManager = null;
        try {
            DataSource dataSource = connectData(args[0], args[1]);
            dataManager = new DataManager(dataSource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (Scanner scanner = new Scanner(System.in))
        {
            System.out.println("Please enter a last name to search for:");
            String searchLastName = scanner.nextLine();
            List<Actor> actors = dataManager.searchActors(searchLastName);

            System.out.println("-".repeat(30));
            System.out.println("Actors: ");
            System.out.println("-".repeat(30));
            actors.forEach(actor -> System.out.println(actor + "\n" + "-".repeat(30)));


            System.out.println("Please enter an ActorID to search films:");
            int searchID = Integer.parseInt(scanner.nextLine());
            List<Film> films = dataManager.searchFilms(searchID);

            System.out.println("-".repeat(30));
            System.out.println("Actors: ");
            System.out.println("-".repeat(30));
            films.forEach(film -> System.out.println(film + "\n" + "-".repeat(30)));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private static BasicDataSource connectData(String username, String password) {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

}
