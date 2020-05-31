package com.example.m3_uf6_m9_uf2.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.m3_uf6_m9_uf2.R;
import com.example.m3_uf6_m9_uf2.models.UserModel;
import com.example.m3_uf6_m9_uf2.viewModel.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class EditActivity extends AppCompatActivity {

    private UserModel user;
    private EditText name, birthday;
    private FloatingActionButton add;
    private MainActivityViewModel viewModel = new MainActivityViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        user = (UserModel) Objects.requireNonNull(getIntent().getExtras()).getSerializable("test");
        birthday = findViewById(R.id.birthday);
        name = findViewById(R.id.name);
        birthday.setText(user.getBirthday());
        name.setText(user.getName());
        add = findViewById(R.id.addUser);
        add.setOnClickListener(v -> {
            viewModel.updateUser(user.getId(),birthday.getText().toString(), name.getText().toString());
            finish();
        });
    }
}
