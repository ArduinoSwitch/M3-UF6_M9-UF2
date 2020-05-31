package com.example.m3_uf6_m9_uf2.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.m3_uf6_m9_uf2.connection.AddUserUpdarte;
import com.example.m3_uf6_m9_uf2.connection.DeleteUser;
import com.example.m3_uf6_m9_uf2.connection.FetchUsers;
import com.example.m3_uf6_m9_uf2.connection.UpdateUser;
import com.example.m3_uf6_m9_uf2.models.UserModel;

import java.util.ArrayList;

public class MainActivityViewModel extends ViewModel {
    public MutableLiveData<ArrayList<UserModel>> userList;
    private FetchUsers usersQuery = new FetchUsers();

    public MainActivityViewModel() {
        userList = usersQuery.userList;
        usersQuery.start();
    }

    public void addUser(String birthday, String name) {
        AddUserUpdarte addUser = new AddUserUpdarte();
        addUser.name = name;
        addUser.date = birthday;
        addUser.start();
    }

    public void deleteUser(int id) {
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.id = id;
        deleteUser.start();
    }

    public void updateUser(int id, String birthday, String name) {
        UpdateUser updateUser = new UpdateUser();
        updateUser.date = birthday;
        updateUser.id = id;
        updateUser.name = name;
        updateUser.start();
    }
}