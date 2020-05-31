package com.example.m3_uf6_m9_uf2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.m3_uf6_m9_uf2.adapter.CustomAdapter;
import com.example.m3_uf6_m9_uf2.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel = new MainActivityViewModel();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView = findViewById(R.id.list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        viewModel.userList.observe(this, userModels -> {
            recyclerView.setAdapter(new CustomAdapter(userModels));
        });
    }
}
