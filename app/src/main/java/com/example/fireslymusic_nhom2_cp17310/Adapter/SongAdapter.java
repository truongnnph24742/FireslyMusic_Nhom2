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

import com.example.fireslymusic_nhom2_cp17310.Activity.BaiHatActivity;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.nio.BufferUnderflowException;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    List<Song> listSong;
    Context context;

    public SongAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Song> list){
        this.listSong = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song,parent,false);

        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Song song = listSong.get(position);
            if(song==null){
                return;
            }
        holder.img_song.setImageResource(song.getImg());
        holder.txt_namesong.setText(song.getSong_name());
        holder.layout_bhtd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBaiHatTD(position);
            }
        });
    }
    private void clickBaiHatTD(int position){
        Intent intent = new Intent(context, BaiHatActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("vitri",position);
        intent.putExtras(bundle);
        context.startActivity(intent);


    }

    @Override
    public int getItemCount() {
        if(listSong!=null){
            return listSong.size();
        }
        return 0;
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {
        ImageView  img_song;
        TextView txt_namesong;
        LinearLayout layout_bhtd;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            img_song = itemView.findViewById(R.id.img_song);
            txt_namesong = itemView.findViewById(R.id.txt_namesong);
            layout_bhtd = itemView.findViewById(R.id.layout_bhtd);
        }
    }
}
