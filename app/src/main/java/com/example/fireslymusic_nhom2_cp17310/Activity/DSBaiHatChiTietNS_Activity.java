package com.example.fireslymusic_nhom2_cp17310.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fireslymusic_nhom2_cp17310.Adapter.DS_baihat_nghesi;
import com.example.fireslymusic_nhom2_cp17310.Adapter.DsBaiHatTrendingAdapter;
import com.example.fireslymusic_nhom2_cp17310.DAO.DSBAIhatNS_DAO;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.util.ArrayList;

public class DSBaiHatChiTietNS_Activity extends AppCompatActivity {
    RecyclerView rcv_dsbaihatNS;
    DS_baihat_nghesi adapter;
    DSBAIhatNS_DAO dsbaIhatNS_dao;
    ArrayList<Song> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsbai_hat_chi_tiet_ns);
         rcv_dsbaihatNS = findViewById(R.id.rcv_dsbaichitiet);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rcv_dsbaihatNS.setLayoutManager(manager);
        adapter = new DS_baihat_nghesi(this);
        dsbaIhatNS_dao = new DSBAIhatNS_DAO(this);
        rcv_dsbaihatNS.setAdapter(adapter);

    }
}