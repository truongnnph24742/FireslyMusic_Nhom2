package com.example.fireslymusic_nhom2_cp17310.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.fireslymusic_nhom2_cp17310.Adapter.DsBaiHatTrendingAdapter;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.util.ArrayList;
import java.util.List;

public class DsBaihatTrendingActivity extends AppCompatActivity {
    RecyclerView rcv_dsbaihattrending;
    DsBaiHatTrendingAdapter adapter;
    List<Song> listv1 = new ArrayList<>();
    List<Song> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_baihat_trending);
        rcv_dsbaihattrending = findViewById(R.id.rcv_dsbaihattrending);
        Bundle bundle = getIntent().getExtras();
        if (bundle==null){
            return;
        }
        listv1 = (List<Song>) bundle.getSerializable("list");
        list = new ArrayList<>();
        list.addAll(listv1);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rcv_dsbaihattrending.setLayoutManager(manager);
        adapter = new DsBaiHatTrendingAdapter(this);
        adapter.setData(list);
        rcv_dsbaihattrending.setAdapter(adapter);


    }
}