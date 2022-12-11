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
import com.example.fireslymusic_nhom2_cp17310.Activity.BaiHatCaSiActivity;
import com.example.fireslymusic_nhom2_cp17310.DTO.Casi;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaoAnhAdapter extends RecyclerView.Adapter<BaoAnhAdapter.BaoAnhViewHolder> {
    List<Casi> listSong;
    Context context;
    List<Casi> listv1 = new ArrayList<>();

    public BaoAnhAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Casi> list){
        this.listSong = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaoAnhAdapter.BaoAnhViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_baoanh,parent,false);
        return new BaoAnhViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaoAnhAdapter.BaoAnhViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Casi song = listSong.get(position);
        if(song==null){
            return;
        }
        for (int i = 0; i<listSong.size();i++){
            if(song.getId_ns()==6){
                Glide.with(context).load(song.getImgsong()).into(holder.img_song);
                holder.tv_namesong.setText(song.getName());
                holder.tv_casi.setText(song.getSinger());
                Casi st = new Casi();
                st.setFilesong(song.getFilesong());
                st.setImgsong(song.getImgsong());
                st.setName(song.getName());
                st.setSinger(song.getSinger());
                listv1.add(song);
                holder.img_song.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clickBaiHatTD(listv1, position);
                    }
                });
            }else{
                holder.img_song.setVisibility(View.GONE);
                holder.tv_namesong.setVisibility(View.GONE);
                holder.tv_casi.setVisibility(View.GONE);
            }
        }


    }
    private void clickBaiHatTD(List<Casi> song1,int index){
        Intent intent = new Intent(context, BaiHatCaSiActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("singer", (Serializable) song1);
        bundle.putInt("index",index);
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

    public class BaoAnhViewHolder extends RecyclerView.ViewHolder {
        ImageView img_song;
        TextView tv_namesong,tv_casi;
        LinearLayout layout_casi;


        public BaoAnhViewHolder(@NonNull View itemView) {
            super(itemView);
            img_song = itemView.findViewById(R.id.img_baoanh);
            tv_namesong = itemView.findViewById(R.id.ten_baoanh);
            tv_casi = itemView.findViewById(R.id.casi_baoanh);
            layout_casi = itemView.findViewById(R.id.layout_baoanh);
        }
    }
}
