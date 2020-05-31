package com.example.m3_uf6_m9_uf2.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.m3_uf6_m9_uf2.R;
import com.example.m3_uf6_m9_uf2.connection.AddUserUpdarte;
import com.example.m3_uf6_m9_uf2.models.UserModel;
import com.example.m3_uf6_m9_uf2.viewModel.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel = new MainActivityViewModel();
    private TextView name, birthday;
    private FloatingActionButton delete, edit;
    private UserModel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        user = (UserModel) Objects.requireNonNull(getIntent().getExtras()).getSerializable("test");
        name = findViewById(R.id.name);
        birthday = findViewById(R.id.birthday);
        delete = findViewById(R.id.delete);
        edit = findViewById(R.id.edit);
        assert user != null;
        name.setText(user.getName());
        birthday.setText(user.getBirthday());
        delete.setOnClickListener(v -> {
            viewModel.deleteUser(user.getId());
            finish();
        });
        edit.setOnClickListener(v-> {
            Intent intent = new Intent(this, EditActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("test", user);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}
