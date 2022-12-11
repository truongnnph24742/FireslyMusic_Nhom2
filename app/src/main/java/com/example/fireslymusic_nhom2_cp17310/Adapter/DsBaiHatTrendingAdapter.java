package com.example.fireslymusic_nhom2_cp17310.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fireslymusic_nhom2_cp17310.Activity.BaiHatActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.DsBaiHatYeuThichActivity;
import com.example.fireslymusic_nhom2_cp17310.DAO.YeuThichDao;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.DTO.YeuThich;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DsBaiHatTrendingAdapter extends RecyclerView.Adapter<DsBaiHatTrendingAdapter.BaiHatTrendingViewHolder>{
    List<Song> listtd;
    List<YeuThich> listYeuThich= new ArrayList<>();
    Context context;
    YeuThichDao dao;
    public void setData(List<Song> list){
        this.listtd = list;
        notifyDataSetChanged();
    }

    public DsBaiHatTrendingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public BaiHatTrendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dsbaihattrending,parent,false);

        return new BaiHatTrendingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaiHatTrendingViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Song song = listtd.get(position);
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

        holder.yeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                YeuThich yeuThich = new YeuThich();
                yeuThich.setId(listtd.get(position).getId());
                yeuThich.setId_ns(listtd.get(position).getId_ns());
                yeuThich.setName(listtd.get(position).getName());
                yeuThich.setSinger(listtd.get(position).getSinger());
                yeuThich.setImgsong(listtd.get(position).getImgsong());
                yeuThich.setFilesong(listtd.get(position).getFilesong());


                dao = new YeuThichDao(context);
                listYeuThich.addAll(dao.selectAll());
                if(listYeuThich.size()==0){
                    long res =dao.addBaiHat(yeuThich);
                    if(res>0){
                        Toast.makeText(context, "Đã thêm vào yêu thích", Toast.LENGTH_SHORT).show();
                        Glide.with(context).load(R.drawable.ic_baseline_favorite_24).into(holder.yeuthich);
                        return;
                    }else {
                        Toast.makeText(context, "Không thêm được", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Log.d("zzzzzzzzzz", "onClick: "+yeuThich.getName());
                    for(int i = 0; i<listYeuThich.size(); i++){
                        if(yeuThich.getName().equals(listYeuThich.get(i).getName())){
                            Log.d("zzzzzzzzzz", "onClick: "+listYeuThich.get(i).getName());
                            long check = dao.deleteYeuThich(yeuThich.getName());
                            if(check>0){
                                holder.yeuthich.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                                Toast.makeText(context, "Đã xóa", Toast.LENGTH_SHORT).show();
                                return;

                            }else {
                                Toast.makeText(context, "Không xóa được", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
                    dao = new YeuThichDao(context);
                    Log.d("zzzzzzzzzzzzzzzz", "onClick: "+yeuThich.getName());
                    long res =dao.addBaiHat(yeuThich);
                    if(res>0){
                        Toast.makeText(context, "Đã thêm vào yêu thích", Toast.LENGTH_SHORT).show();
                        Glide.with(context).load(R.drawable.ic_baseline_favorite_24).into(holder.yeuthich);
                    }else {
                        Toast.makeText(context, "Không thêm được", Toast.LENGTH_SHORT).show();
                    }


//                listYeuThich.add(yeuThich);
//                Intent intent = new Intent(context, DsBaiHatYeuThichActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("listyt", (Serializable) listYeuThich);
//                bundle.putInt("index",position);
//                intent.putExtras(bundle);
//                context.startActivity(intent);

            }
        });
        dao = new YeuThichDao(context);
        listYeuThich.addAll(dao.selectAll());
        for(int i = 0; i<listYeuThich.size(); i++){
            if(listtd.get(position).getName().equals(listYeuThich.get(i).getName())){
                holder.yeuthich.setImageResource(R.drawable.ic_baseline_favorite_24);
            }
        }




    }
    private void clickBaiHatTD(List<Song> song1,int index){
        Intent intent = new Intent(context, BaiHatActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", (Serializable) song1);
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

    public class BaiHatTrendingViewHolder extends RecyclerView.ViewHolder {
        ImageView img_baihattrending;
        TextView txt_namesongtd;
        TextView txt_singertd;
        ImageView yeuthich;
        LinearLayout layout_ln;

        public BaiHatTrendingViewHolder(@NonNull View itemView) {
            super(itemView);
            img_baihattrending = itemView.findViewById(R.id.img_baihattd);
            txt_namesongtd = itemView.findViewById(R.id.tv_tenbaihattd);
            txt_singertd = itemView.findViewById(R.id.tv_tencasitd);
            yeuthich = itemView.findViewById(R.id.yeuthich);
            layout_ln = itemView.findViewById(R.id.layout_ln);
        }
    }
}
