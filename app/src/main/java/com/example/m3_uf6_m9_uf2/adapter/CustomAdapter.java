package com.example.m3_uf6_m9_uf2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.m3_uf6_m9_uf2.R;
import com.example.m3_uf6_m9_uf2.interfaces.OnClick;
import com.example.m3_uf6_m9_uf2.models.UserModel;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ItemListViewHolder> {

    private ArrayList<UserModel> userList;
    private static OnClick onClick;

    public CustomAdapter(ArrayList<UserModel> data, OnClick onClick){
        userList = data;
        this.onClick = onClick;
    }

    static class ItemListViewHolder extends RecyclerView.ViewHolder {

        private TextView id, birthday, name;

        ItemListViewHolder(View v) {
            super(v);
            this.id = v.findViewById(R.id.id);
            this.birthday = v.findViewById(R.id.birthday);
            this.name = v.findViewById(R.id.name);
        }
        void listener(UserModel userA) {
            itemView.setOnClickListener(v -> {
                onClick.onClick(userA);
            });
        }
        void bind(UserModel user){
            this.id.setText(String.valueOf(user.getId()));
            this.birthday.setText(user.getBirthday());
            this.name.setText(user.getName());
        }
    }

    @NonNull
    @Override
    public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutInflater = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        return new ItemListViewHolder(layoutInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListViewHolder holder, int position) {
        holder.listener(userList.get(position));
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
