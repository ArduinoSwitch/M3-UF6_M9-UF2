package com.example.m3_uf6_m9_uf2.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.m3_uf6_m9_uf2.R;
import com.example.m3_uf6_m9_uf2.viewModel.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddUserActivity extends AppCompatActivity {

    private FloatingActionButton add;
    private MainActivityViewModel viewModel = new MainActivityViewModel();
    private EditText name, birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        add = findViewById(R.id.addUser);
        birthday = findViewById(R.id.birthday);
        name = findViewById(R.id.name);
        add.setOnClickListener(v -> {
            viewModel.addUser(birthday.getText().toString(), name.getText().toString());
            finish();
        });
    }
}
