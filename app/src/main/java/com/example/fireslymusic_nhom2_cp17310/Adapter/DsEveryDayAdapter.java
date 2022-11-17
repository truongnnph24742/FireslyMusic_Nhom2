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
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

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
    public void onBindViewHolder(@NonNull DsEveryDayAdapter.BaiHatTrendingViewHolder holder, int position) {
        Everyday song = listtd.get(position);
        if (song == null) {
            return;
        }
        holder.img_baihattrending.setImageResource(song.getImg());
        holder.txt_namesongtd.setText(song.getEveryday_name());
        holder.txt_singertd.setText(song.getSinger());
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
            img_baihattrending = itemView.findViewById(R.id.img_baihattd);
            txt_namesongtd = itemView.findViewById(R.id.tv_tenbaihattd);
            txt_singertd = itemView.findViewById(R.id.tv_tencasitd);
            yeuthich = itemView.findViewById(R.id.yeuthich);
        }
    }
}
