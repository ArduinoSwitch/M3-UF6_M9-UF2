package com.example.m3_uf6_m9_uf2.connection;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.m3_uf6_m9_uf2.models.UserModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FetchUsers extends Thread {
    public String name;
    public String date;
    public MutableLiveData<ArrayList<UserModel>> userList = new MutableLiveData<>();
    private ArrayList<UserModel> users = new ArrayList<>();

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
            //st.executeUpdate("Insert into personas(birthday, name) values (" + "'" + date + "'," + "'" + name + "'" + ");");
            ResultSet resultSet = st.executeQuery("select * from personas;" );
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String birthday = resultSet.getString("birthday");
                String name = resultSet.getString("name");
                UserModel user = new UserModel(id, birthday,name);
                assert users != null;
                users.add(user);
            }
            userList.postValue(users);
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
