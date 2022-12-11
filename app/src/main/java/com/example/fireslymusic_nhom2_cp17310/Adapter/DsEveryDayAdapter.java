package com.example.fireslymusic_nhom2_cp17310.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fireslymusic_nhom2_cp17310.Activity.BaiHatMoiActivity;
import com.example.fireslymusic_nhom2_cp17310.DTO.Everyday;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.io.Serializable;
import java.util.List;

public class DsEveryDayAdapter extends RecyclerView.Adapter<DsEveryDayAdapter.BaiHatTrendingViewHolder> {
    List<Everyday> listtd;
    Context context;

    public void setData(List<Everyday> list) {
        this.listtd = list;
        notifyDataSetChanged();
    }

    public DsEveryDayAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DsEveryDayAdapter.BaiHatTrendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dsnhacmoingay, parent, false);

        return new DsEveryDayAdapter.BaiHatTrendingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DsEveryDayAdapter.BaiHatTrendingViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Everyday song = listtd.get(position);
        if (song == null) {
            return;
        }
        Glide.with(context).load(song.getImgsong()).into(holder.img_baihattrending);
        holder.txt_namesongtd.setText(song.getName());
        holder.txt_singertd.setText(song.getSinger());
        holder.img_baihattrending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBaiHatTD(listtd,position);
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
        if (listtd != null) {
            return listtd.size();
        }
        return 0;
    }

    public class BaiHatTrendingViewHolder extends RecyclerView.ViewHolder {
        ImageView img_baihattrending;
        TextView txt_namesongtd;
        TextView txt_singertd;
        ImageView yeuthich;

        public BaiHatTrendingViewHolder(@NonNull View itemView) {
            super(itemView);
            img_baihattrending = itemView.findViewById(R.id.img_baihatmoi);
            txt_namesongtd = itemView.findViewById(R.id.tv_baihatmoi);
            txt_singertd = itemView.findViewById(R.id.tv_tencasimoi);
            yeuthich = itemView.findViewById(R.id.yeuthichmoi);
        }
    }
}
