package com.example.m3_uf6_m9_uf2.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.m3_uf6_m9_uf2.connection.FetchUsers;
import com.example.m3_uf6_m9_uf2.models.UserModel;
import java.util.ArrayList;

public class MainActivityViewModel extends ViewModel {
    public MutableLiveData<ArrayList<UserModel>> userList;

    public MainActivityViewModel () {
        FetchUsers usersQuery = new FetchUsers();
        usersQuery.start();
        userList = usersQuery.userList;
    }
}