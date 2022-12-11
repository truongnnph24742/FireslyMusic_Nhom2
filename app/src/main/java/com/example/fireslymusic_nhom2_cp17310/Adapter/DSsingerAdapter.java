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

import com.example.fireslymusic_nhom2_cp17310.Activity.BaiHatActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.BaoAnhActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.BinzActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.CharliesActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.DSBaiHatChiTietNS_Activity;
import com.example.fireslymusic_nhom2_cp17310.Activity.HoNgocHaActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.HoangYenActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.JackActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.KaricActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.MonoActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.SonTungActivity;
import com.example.fireslymusic_nhom2_cp17310.DTO.Singer;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.io.Serializable;
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
    public void onBindViewHolder(@NonNull SingerViewHolder holder,@SuppressLint("RecyclerView") int position) {
        Singer singer = listSinger.get(position);
        if(singer==null){
            return ;
        }
        int index = position;
        holder.txt_namesinger.setText(singer.getSinger_name());
        holder.img_singer.setImageResource(singer.getImg_singer());
        holder.img_singer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(context, KaricActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("list", (Serializable) listSinger);
                        bundle.putInt("index",index);
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(context, SonTungActivity.class);
                        Bundle bundle1 = new Bundle();
                        bundle1.putSerializable("list", (Serializable) listSinger);
                        bundle1.putInt("index",index);
                        intent1.putExtras(bundle1);
                        context.startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(context, MonoActivity.class);
                        Bundle bundle2 = new Bundle();
                        bundle2.putSerializable("list", (Serializable) listSinger);
                        bundle2.putInt("index",index);
                        intent2.putExtras(bundle2);
                        context.startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(context, CharliesActivity.class);
                        Bundle bundle3 = new Bundle();
                        bundle3.putSerializable("list", (Serializable) listSinger);
                        bundle3.putInt("index",index);
                        intent3.putExtras(bundle3);
                        context.startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(context, BinzActivity.class);
                        Bundle bundle4 = new Bundle();
                        bundle4.putSerializable("list", (Serializable) listSinger);
                        bundle4.putInt("index",index);
                        intent4.putExtras(bundle4);
                        context.startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(context, BaoAnhActivity.class);
                        Bundle bundle5 = new Bundle();
                        bundle5.putSerializable("list", (Serializable) listSinger);
                        bundle5.putInt("index",index);
                        intent5.putExtras(bundle5);
                        context.startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(context, HoangYenActivity.class);
                        Bundle bundle6 = new Bundle();
                        bundle6.putSerializable("list", (Serializable) listSinger);
                        bundle6.putInt("index",index);
                        intent6.putExtras(bundle6);
                        context.startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(context, JackActivity.class);
                        Bundle bundle7 = new Bundle();
                        bundle7.putSerializable("list", (Serializable) listSinger);
                        bundle7.putInt("index",index);
                        intent7.putExtras(bundle7);
                        context.startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(context, HoNgocHaActivity.class);
                        Bundle bundle8 = new Bundle();
                        bundle8.putSerializable("list", (Serializable) listSinger);
                        bundle8.putInt("index",index);
                        intent8.putExtras(bundle8);
                        context.startActivity(intent8);
                        break;
                }


            }
        });
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
