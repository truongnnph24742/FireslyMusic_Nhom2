package com.example.fireslymusic_nhom2_cp17310.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fireslymusic_nhom2_cp17310.Activity.BaiHatActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.BaiHatMoiActivity;
import com.example.fireslymusic_nhom2_cp17310.DTO.Everyday;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.io.Serializable;
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
    public void onBindViewHolder(@NonNull EveryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Everyday everyday = listEvery.get(position);
        if (everyday == null) {
            return;
        }
        Glide.with(context).load(everyday.getImgsong()).into(holder.img_every);
        holder.txt_nameEvery.setText(everyday.getName());
        holder.layout_moi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBaiHatTD(listEvery,position);
            }
        });

    }
    private void clickBaiHatTD(List<Everyday> song1, int index){
        Intent intent = new Intent(context, BaiHatMoiActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("moi", (Serializable) song1);
        bundle.putInt("index",index);
        intent.putExtras(bundle);
        context.startActivity(intent);


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
        LinearLayout layout_moi;

        public EveryViewHolder(@NonNull View itemView) {
            super(itemView);
            img_every = itemView.findViewById(R.id.img_every);
            txt_nameEvery = itemView.findViewById(R.id.txt_nameEvery);
            layout_moi = itemView.findViewById(R.id.layout_moi);
        }
    }
}