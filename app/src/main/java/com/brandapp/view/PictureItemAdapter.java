package com.brandapp.view;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PictureItemAdapter extends RecyclerView.Adapter<PictureItemAdapter.PictureViewHolder> {
    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class PictureViewHolder extends RecyclerView.ViewHolder {
        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
