package com.example.fireslymusic_nhom2_cp17310.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.util.List;

public class DS_baihat_nghesi extends RecyclerView.Adapter<DS_baihat_nghesi.BaiHatNSViewHolder> {
    List<Song> listtd;
    Context context;

    public void setData(List<Song> list) {
        this.listtd = list;
        notifyDataSetChanged();
    }

    public DS_baihat_nghesi(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public BaiHatNSViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_dsbai_hat_chi_tiet_ns, parent, false);

        return new BaiHatNSViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaiHatNSViewHolder holder, int position) {
        Song song = listtd.get(position);
        if (song == null) {
            return;
        }
        holder.img_baihatNS.setImageResource(song.getImg());
        holder.txt_namesongNS.setText(song.getSong_name());
        holder.txt_singerNS.setText(song.getSinger());
    }

    @Override
    public int getItemCount() {
        if (listtd != null) {
            return listtd.size();
        }
        return 0;
    }

    public class BaiHatNSViewHolder extends RecyclerView.ViewHolder {
        ImageView img_baihatNS;
        TextView txt_namesongNS;
        TextView txt_singerNS;
        ImageView yeuthichNS;

        public BaiHatNSViewHolder(@NonNull View itemView) {
            super(itemView);
            img_baihatNS = itemView.findViewById(R.id.img_baihatNS);
            txt_namesongNS = itemView.findViewById(R.id.tv_tenbaihatNS);
            txt_singerNS = itemView.findViewById(R.id.tv_tencasiNS);
            yeuthichNS = itemView.findViewById(R.id.yt_baihat_nghesi);
        }
    }
}
