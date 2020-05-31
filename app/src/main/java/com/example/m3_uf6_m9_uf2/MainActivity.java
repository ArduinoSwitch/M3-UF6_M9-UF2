package com.example.m3_uf6_m9_uf2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import com.example.m3_uf6_m9_uf2.activitys.AddUserActivity;
import com.example.m3_uf6_m9_uf2.activitys.DetailActivity;
import com.example.m3_uf6_m9_uf2.adapter.CustomAdapter;
import com.example.m3_uf6_m9_uf2.interfaces.OnClick;
import com.example.m3_uf6_m9_uf2.models.UserModel;
import com.example.m3_uf6_m9_uf2.viewModel.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements OnClick {

    private MainActivityViewModel viewModel = new MainActivityViewModel();
    private RecyclerView recyclerView;
    private FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list_view);
        add = findViewById(R.id.add);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        viewModel.userList.observe(this, userModels -> {
            recyclerView.setAdapter(new CustomAdapter(userModels, this));
        });
        add.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddUserActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onClick(UserModel user) {
        Intent intent = new Intent(this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("test", user);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
