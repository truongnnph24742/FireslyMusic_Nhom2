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

import com.example.fireslymusic_nhom2_cp17310.Activity.BalladActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.BaoAnhActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.BinzActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.CharliesActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.HoNgocHaActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.HoangYenActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.JackActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.KaricActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.MonoActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.NhacTreActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.PopActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.RapActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.SonTungActivity;
import com.example.fireslymusic_nhom2_cp17310.DTO.TheLoai;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.io.Serializable;
import java.util.List;

public class DsTheLoaiAdapter extends RecyclerView.Adapter<DsTheLoaiAdapter.TheLoaiAdapterViewHolder> {
    List<TheLoai> listtd;
    Context context;

    public void setData(List<TheLoai> list) {
        this.listtd = list;
        notifyDataSetChanged();
    }

    public DsTheLoaiAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TheLoaiAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist, parent, false);

        return new TheLoaiAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TheLoaiAdapterViewHolder holder,@SuppressLint("RecyclerView") int position) {
        TheLoai song = listtd.get(position);
        int index = position;
        if (song == null) {
            return;
        }
        holder.img_baihattrending.setImageResource(song.getImgTheLoai());
        holder.txt_namesongtd.setText(song.getTenTheLoai());
        holder.img_baihattrending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(context, PopActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("list", (Serializable) listtd);
                        bundle.putInt("index",index);
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(context, BalladActivity.class);
                        Bundle bundle1 = new Bundle();
                        bundle1.putSerializable("list", (Serializable) listtd);
                        bundle1.putInt("index",index);
                        intent1.putExtras(bundle1);
                        context.startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(context, NhacTreActivity.class);
                        Bundle bundle2 = new Bundle();
                        bundle2.putSerializable("list", (Serializable) listtd);
                        bundle2.putInt("index",index);
                        intent2.putExtras(bundle2);
                        context.startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(context, RapActivity.class);
                        Bundle bundle3 = new Bundle();
                        bundle3.putSerializable("list", (Serializable) listtd);
                        bundle3.putInt("index",index);
                        intent3.putExtras(bundle3);
                        context.startActivity(intent3);
                        break;

                }


            }
        });

    }

    @Override
    public int getItemCount() {
        if (listtd != null) {
            return listtd.size();
        }
        return 0;
    }

    public class TheLoaiAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView img_baihattrending;
        TextView txt_namesongtd;


        public TheLoaiAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            img_baihattrending = itemView.findViewById(R.id.img_playlist);
            txt_namesongtd = itemView.findViewById(R.id.txt_playlist);

        }
    }
}