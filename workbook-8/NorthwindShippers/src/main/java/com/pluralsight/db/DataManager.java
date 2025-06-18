package com.pluralsight.db;

import com.pluralsight.model.Shipper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Shipper> queryAll() {

        List<Shipper> shippers = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Shippers")) {

            try (ResultSet results = preparedStatement.executeQuery()) {
                if (results.next()) {

                    do {
                        shippers.add(new Shipper(
                                results.getInt(1),
                                results.getString(2),
                                results.getString(3)));
                    } while (results.next());

                } else System.out.println("No matches!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return shippers;
    }


    public void insertRecord(String companyName, String phoneNumber) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO `northwind`.`shippers` (`CompanyName`,`Phone`) VALUES (?,?);", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, phoneNumber);

            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows Inserted: " + rows);

            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                if (keys.next()) {
                    System.out.println("A new key was added: " + keys.getInt(1));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateRecord(String newPhone, int shipperId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE Shippers SET Phone = ? WHERE ShipperID = ?")) {
            preparedStatement.setString(1, newPhone);
            preparedStatement.setInt(2, shipperId);

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows Updated: " + rows);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteRecord(int shipperID) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM shippers WHERE shipperID = ?")) {
            preparedStatement.setInt(1, shipperID);

            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows Deleted: " + rows);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
