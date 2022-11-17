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


public class TheLoaiAdapter extends RecyclerView.Adapter<TheLoaiAdapter.TheLoaiViewHolder> {
    List<TheLoai> listTheLoai;
    Context context;


    public TheLoaiAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<TheLoai> list){
        this.listTheLoai = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TheLoaiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_theloai,parent,false);

        return new TheLoaiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheLoaiViewHolder holder, int position) {
        TheLoai theLoai = listTheLoai.get(position);
        if(theLoai==null){
            return;
        }
        holder.imgtheloai.setImageResource(theLoai.getImgTheLoai());
        holder.txt_namesong.setText(theLoai.getTenTheLoai());

    }

    @Override
    public int getItemCount() {
        if(listTheLoai!=null){
            return listTheLoai.size();
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
