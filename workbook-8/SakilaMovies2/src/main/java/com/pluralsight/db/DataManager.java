package com.pluralsight.db;

import com.pluralsight.Actor;
import com.pluralsight.Film;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataManager {

    private DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Actor> searchActors(String lastName) {

        List<Actor> actors = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     """
                             SELECT Actor_ID, First_Name, Last_Name
                             FROM actor
                             WHERE Last_Name LIKE ?;
                             """)) {

            preparedStatement.setString(1, lastName);

            try (ResultSet results = preparedStatement.executeQuery()) {

                if (results.next()) {
                    do {
                        actors.add(new Actor(
                                results.getInt(1),
                                results.getString(2),
                                results.getString(3)));
                    } while (results.next());
                } else System.out.println("No matches!");
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong!\n" + ex);
        }

        return actors;
    }

    public List<Film> searchFilms(int searchID) {


        List<Film> films = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     """
                             SELECT f.title
                             FROM actor a
                             JOIN film_actor fa ON a.actor_id = fa.actor_id
                             JOIN film f ON fa.film_id = f.film_id
                             WHERE a.actor_id = ?;
                             """)) {

            preparedStatement.setInt(1, searchID);

            try (ResultSet results = preparedStatement.executeQuery()) {

                if (results.next()) {
                    do {
                        System.out.printf("Title = %s\n",
                                results.getString(1));
                    } while (results.next());
                } else System.out.println("No matches!");
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong!\n" + ex);
        }

        return films;

    }
}

