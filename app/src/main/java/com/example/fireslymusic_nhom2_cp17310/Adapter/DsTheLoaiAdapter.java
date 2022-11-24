package com.example.fireslymusic_nhom2_cp17310.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fireslymusic_nhom2_cp17310.DTO.TheLoai;
import com.example.fireslymusic_nhom2_cp17310.R;

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
    public void onBindViewHolder(@NonNull TheLoaiAdapterViewHolder holder, int position) {
        TheLoai song = listtd.get(position);
        if (song == null) {
            return;
        }
        holder.img_baihattrending.setImageResource(song.getImgTheLoai());
        holder.txt_namesongtd.setText(song.getTenTheLoai());

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