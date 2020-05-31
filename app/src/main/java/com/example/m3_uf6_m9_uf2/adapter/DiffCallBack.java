package com.example.m3_uf6_m9_uf2.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.m3_uf6_m9_uf2.models.UserModel;

public class DiffCallBack extends DiffUtil.ItemCallback<UserModel> {

    @Override
    public boolean areItemsTheSame(@NonNull UserModel oldItem, @NonNull UserModel newItem) {
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull UserModel oldItem, @NonNull UserModel newItem) {
        return oldItem == newItem;
    }
}
