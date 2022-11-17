package com.example.fireslymusic_nhom2_cp17310.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fireslymusic_nhom2_cp17310.DTO.Singer;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.util.List;

public class DSsingerAdapter extends RecyclerView.Adapter<DSsingerAdapter.SingerViewHolder> {
    List<Singer> listSinger;
    Context context;

    public DSsingerAdapter(Context context){
        this.context = context;
    }
    public void setData(List<Singer> listSinger){
        this.listSinger = listSinger;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public SingerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_singer,parent,false);
        return new SingerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingerViewHolder holder, int position) {
        Singer singer = listSinger.get(position);
        if(singer==null){
            return ;
        }
        holder.txt_namesinger.setText(singer.getSinger_name());
        holder.img_singer.setImageResource(singer.getImg_singer());
    }

    @Override
    public int getItemCount() {
        if(listSinger!= null){
            return listSinger.size();
        }
        return 0;
    }

    public class SingerViewHolder extends RecyclerView.ViewHolder{
        ImageView img_singer;
        TextView txt_namesinger;
        public SingerViewHolder(@NonNull View itemView) {
            super(itemView);
            img_singer = itemView.findViewById(R.id.img_singer);
            txt_namesinger = itemView.findViewById(R.id.txt_namesinger);
        }
    }
}
