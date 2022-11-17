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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_evey_day);
        rcv_dsmoingyatrending = findViewById(R.id.rcv_dsmoingay);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rcv_dsmoingyatrending.setLayoutManager(manager);
        adapter = new DsEveryDayAdapter(this);
        adapter.setData(dsEveryTrending());
        rcv_dsmoingyatrending.setAdapter(adapter);
    }
    private List<Everyday> dsEveryTrending() {
        List<Everyday> listt1 = new ArrayList<>();
        listt1.add(new Everyday(1,"Sao cũng được",R.drawable.sao_cung_dc));
        listt1.add(new Everyday(2,"Tòng Phu",R.drawable.tong_phu));
        listt1.add(new Everyday(3,"Cưới không chốt nha",R.drawable.cuoi_hong));
        listt1.add(new Everyday(4,"Pháo Hồng",R.drawable.phao_hong));
        listt1.add(new Everyday(5,"Waiting for you",R.drawable.wai_ting));
        listt1.add(new Everyday(6,"See you again",R.drawable.see_you));


        return listt1;
    }
}