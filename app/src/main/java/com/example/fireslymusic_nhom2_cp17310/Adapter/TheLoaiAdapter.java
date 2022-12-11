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
import com.example.fireslymusic_nhom2_cp17310.Activity.NhacTreActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.PopActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.RapActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.USUKActivity;
import com.example.fireslymusic_nhom2_cp17310.DTO.TheLoai;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.io.Serializable;
import java.util.List;


public class TheLoaiAdapter extends RecyclerView.Adapter<TheLoaiAdapter.TheLoaiViewHolder> {
    List<TheLoai> listtd;
    Context context;


    public TheLoaiAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<TheLoai> list){
        this.listtd = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TheLoaiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_theloai,parent,false);

        return new TheLoaiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheLoaiViewHolder holder,@SuppressLint("RecyclerView") int position) {
        TheLoai song = listtd.get(position);
        int index = position;
        if (song == null) {
            return;
        }
        holder.imgtheloai.setImageResource(song.getImgTheLoai());
        holder.txt_namesong.setText(song.getTenTheLoai());
        holder.imgtheloai.setOnClickListener(new View.OnClickListener() {
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
                    case 4:
                        Intent intent4 = new Intent(context, USUKActivity.class);
                        Bundle bundle4 = new Bundle();
                        bundle4.putSerializable("list", (Serializable) listtd);
                        bundle4.putInt("index",index);
                        intent4.putExtras(bundle4);
                        context.startActivity(intent4);
                        break;

                }


            }
        });


    }

    @Override
    public int getItemCount() {
        if(listtd!=null){
            return listtd.size();
        }
        return 0;
    }

    public class TheLoaiViewHolder extends RecyclerView.ViewHolder {
        ImageView imgtheloai;
        TextView txt_namesong;
        public TheLoaiViewHolder(@NonNull View itemView) {
            super(itemView);
            imgtheloai = itemView.findViewById(R.id.img_theloai);
            txt_namesong = itemView.findViewById(R.id.txt_tentheloai);
        }
    }
}
