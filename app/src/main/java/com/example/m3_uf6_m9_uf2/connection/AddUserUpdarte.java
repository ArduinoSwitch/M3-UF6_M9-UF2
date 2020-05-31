package com.example.m3_uf6_m9_uf2.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddUserUpdarte extends Thread {
    public String name;
    public String date;

    public void run() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver" );
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://35.168.156.4:5432/recu",
                    "postgres",
                    "Sendo123."
            );
            Statement st = conn.createStatement();
            st.executeUpdate("Insert into personas(birthday, name) values (" + "'" + date + "'," + "'" + name + "'" + ");");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert conn != null;
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
