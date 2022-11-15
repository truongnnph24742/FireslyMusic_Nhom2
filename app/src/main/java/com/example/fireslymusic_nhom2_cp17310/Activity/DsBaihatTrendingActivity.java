package com.example.fireslymusic_nhom2_cp17310.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fireslymusic_nhom2_cp17310.Adapter.DsBaiHatTrendingAdapter;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.util.ArrayList;
import java.util.List;

public class DsBaihatTrendingActivity extends AppCompatActivity {
    RecyclerView rcv_dsbaihattrending;
    DsBaiHatTrendingAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_baihat_trending);
        rcv_dsbaihattrending = findViewById(R.id.rcv_dsbaihattrending);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rcv_dsbaihattrending.setLayoutManager(manager);
        adapter = new DsBaiHatTrendingAdapter(this);
        adapter.setData(dsBaiHatTrending());
        rcv_dsbaihattrending.setAdapter(adapter);


    }

    private List<Song> dsBaiHatTrending() {
        List<Song> list = new ArrayList<>();
        list.add(new Song(1,"Cuối Cùng Thì",R.drawable.cuoicungthi,"Jack"));
        list.add(new Song(2,"Beautiful Monster",R.drawable.beautifumonster,"Binz & Soobin"));
        list.add(new Song(3,"Cô Đơn Trên Sofa",R.drawable.codontrensofa,"Hồ Ngọc Hà"));
        list.add(new Song(4,"Có Chơi Có chịu",R.drawable.cochoicochiu,"Karik"));
        list.add(new Song(5,"Từng Là Của Nhau",R.drawable.tunglacuanhau,"Phương Anh"));
        list.add(new Song(6,"Ừ! Em Xin Lỗi",R.drawable.uemxinloi,"Hoàng Yến ChiBi"));

        return list;
    }
}