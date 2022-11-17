package com.example.fireslymusic_nhom2_cp17310.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fireslymusic_nhom2_cp17310.DTO.Everyday;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.util.List;

public class EverydayAdapter extends RecyclerView.Adapter<EverydayAdapter.EveryViewHolder> {
    List<Everyday> listEvery;
    Context context;

    public EverydayAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Everyday> listEvery) {
        this.listEvery = listEvery;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EveryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_every, parent, false);
        return new EveryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EveryViewHolder holder, int position) {
        Everyday everyday = listEvery.get(position);
        if (everyday == null) {
            return;
        }
        holder.txt_nameEvery.setText(everyday.getEveryday_name());
        holder.img_every.setImageResource(everyday.getImg());
    }

    @Override
    public int getItemCount() {
        if (listEvery != null) {
            return listEvery.size();
        }
        return 0;
    }

    public class EveryViewHolder extends RecyclerView.ViewHolder {
        ImageView img_every;
        TextView txt_nameEvery;

        public EveryViewHolder(@NonNull View itemView) {
            super(itemView);
            img_every = itemView.findViewById(R.id.img_every);
            txt_nameEvery = itemView.findViewById(R.id.txt_nameEvery);
        }
    }
}