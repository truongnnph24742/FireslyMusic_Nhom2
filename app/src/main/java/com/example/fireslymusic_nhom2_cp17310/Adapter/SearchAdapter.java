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

import com.example.fireslymusic_nhom2_cp17310.Activity.BaiHatActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.BaiHatSearchActivity;
import com.example.fireslymusic_nhom2_cp17310.DTO.Search;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.DssearchAdapter>{
    List<Search> list;
    Context context;

    public SearchAdapter( Context context) {
        this.context = context;
    }
    public void setData(List<Search> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DssearchAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search,parent,false);
        return new DssearchAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DssearchAdapter holder,@SuppressLint("RecyclerView") int position) {
        Search search = list.get(position);
        if(search==null){
            return;
        }
        holder.img_search.setImageResource(search.getImg());
        holder.tenbai.setText(search.getSong_name());
        holder.tenCasi.setText(search.getSinger());
        holder.layout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBaiHatTD(search);
            }
        });
    }

    private void clickBaiHatTD(Search search){
        Intent intent = new Intent(context, BaiHatSearchActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("tim",search);
        intent.putExtras(bundle);
        context.startActivity(intent);


    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();
        }
        return 0;
    }

    public class DssearchAdapter extends RecyclerView.ViewHolder{
        LinearLayout layout_item;
        ImageView img_search;
        TextView tenbai;
        TextView tenCasi;
        public DssearchAdapter(@NonNull View itemView) {
            super(itemView);
            img_search = itemView.findViewById(R.id.img_baihatsearch);
            tenbai = itemView.findViewById(R.id.ten_baihatsearch);
            tenCasi = itemView.findViewById(R.id.casi_baihatsearch);
            layout_item = itemView.findViewById(R.id.layout_item);
        }
    }
}
