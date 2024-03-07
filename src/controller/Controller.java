/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.ConexionMySQL;
import exceptions.NullConnectionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Sebastián Cruz
 */
public class Controller {

    public ConexionMySQL conexion = new ConexionMySQL();

    public Controller() {
        this.conexion = new ConexionMySQL();

    }

    //This method establishes the connection to database, which is necessary to execute the other methods.
    //If connection is null, throws a NullConnectionException
    public Connection connect() { 
        Connection conn = conexion.conectarMySQL();
        if (conn != null) {
            return conn;
        }
        throw new NullConnectionException();
    }

    public void Insert(String manufacturer, float screen_size, float weight, String technology, String operative_system) {
        String insertSQL = "INSERT INTO tvs (manufacturer,screen_size,weight,technology,operative_system) VALUES (?,?,?,?,?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, manufacturer);
            pstmt.setFloat(2, screen_size);
            pstmt.setFloat(3, weight);
            pstmt.setString(4, technology);
            pstmt.setString(5, operative_system);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successful insertion");
            } else {
                System.out.println("No insertion was made");
            }
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for data insertion");
            e.printStackTrace();
        }
    }

    public void select() {
        String selectSQL = "SELECT * FROM tvs";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("id") + ", manufacturer: " + rs.getString("manufacturer") + ", screen_size: " + rs.getFloat("screen_size") + ", weight: " + rs.getFloat("weight") + ", technology: " + rs.getString("technology") + " operative_system: " + rs.getString("operative_system"));
            }

        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for selection");
            e.printStackTrace();
        }
    }
}
