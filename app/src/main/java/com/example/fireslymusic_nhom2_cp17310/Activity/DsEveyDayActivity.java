package com.example.fireslymusic_nhom2_cp17310.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fireslymusic_nhom2_cp17310.Adapter.DsBaiHatTrendingAdapter;
import com.example.fireslymusic_nhom2_cp17310.Adapter.DsEveryDayAdapter;
import com.example.fireslymusic_nhom2_cp17310.DTO.Everyday;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.util.ArrayList;
import java.util.List;

public class DsEveyDayActivity extends AppCompatActivity {
    RecyclerView rcv_dsmoingyatrending;
    DsEveryDayAdapter adapter;
    List<Everyday> listv1 = new ArrayList<>();
    List<Everyday> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_evey_day);
        Bundle bundle = getIntent().getExtras();
        if (bundle==null){
            return;
        }
        listv1 = (List<Everyday>) bundle.getSerializable("moi");
        list = new ArrayList<>();
        list.addAll(listv1);
        rcv_dsmoingyatrending = findViewById(R.id.rcv_dsmoingay);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rcv_dsmoingyatrending.setLayoutManager(manager);
        adapter = new DsEveryDayAdapter(this);
        adapter.setData(list);
        rcv_dsmoingyatrending.setAdapter(adapter);
    }

}