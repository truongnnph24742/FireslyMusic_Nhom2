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
import com.example.fireslymusic_nhom2_cp17310.Activity.BaiHatYeuThichActivity;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.DTO.YeuThich;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.io.Serializable;
import java.util.List;

public class DsBaiHatYeuThichAdapter extends RecyclerView.Adapter<DsBaiHatYeuThichAdapter.BaiHatYeuThichViewHolder> {
    List<YeuThich> listtd;
    Context context;
    public void setData(List<YeuThich> list){
        this.listtd = list;
        notifyDataSetChanged();
    }

    public DsBaiHatYeuThichAdapter(List<YeuThich> listtd, Context context) {
        this.listtd = listtd;
        this.context = context;
    }

    @NonNull
    @Override
    public BaiHatYeuThichViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_baihatyeuthich,parent,false);

        return new BaiHatYeuThichViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaiHatYeuThichViewHolder holder,  @SuppressLint("RecyclerView") int position) {
        YeuThich song = listtd.get(position);
        if(song==null){
            return;
        }
        Glide.with(context).load(song.getImgsong()).into(holder.img_baihattrending);
        holder.txt_namesongtd.setText(song.getName());
        holder.txt_singertd.setText(song.getSinger());
        holder.img_baihattrending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBaiHatTD(listtd, position);
            }
        });
    }
    private void clickBaiHatTD(List<YeuThich> song1,int index){
        Intent intent = new Intent(context, BaiHatYeuThichActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("listyt", (Serializable) song1);
        bundle.putInt("index",index);
        intent.putExtras(bundle);
        context.startActivity(intent);


    }
    @Override
    public int getItemCount() {
        if(listtd!=null){
            return listtd.size();
        }
        return 0;
    }

    public class BaiHatYeuThichViewHolder extends RecyclerView.ViewHolder {
        ImageView img_baihattrending;
        TextView txt_namesongtd;
        TextView txt_singertd;
        ImageView yeuthich;
        LinearLayout layout_ln;

        public BaiHatYeuThichViewHolder(@NonNull View itemView) {
            super(itemView);
            img_baihattrending = itemView.findViewById(R.id.img_baihattd);
            txt_namesongtd = itemView.findViewById(R.id.tv_tenbaihattd);
            txt_singertd = itemView.findViewById(R.id.tv_tencasitd);
            yeuthich = itemView.findViewById(R.id.yeuthich);
            layout_ln = itemView.findViewById(R.id.layout_ln);
        }
    }
}
