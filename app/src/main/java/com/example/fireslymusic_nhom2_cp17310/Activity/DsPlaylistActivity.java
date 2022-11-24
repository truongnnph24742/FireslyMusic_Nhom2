package com.example.fireslymusic_nhom2_cp17310.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fireslymusic_nhom2_cp17310.Adapter.DsTheLoaiAdapter;
import com.example.fireslymusic_nhom2_cp17310.DTO.TheLoai;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.util.ArrayList;
import java.util.List;

public class DsPlaylistActivity extends AppCompatActivity {
    ImageView addplaylist;
    RecyclerView rcv_dstheloai;
    DsTheLoaiAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_playlist);
        rcv_dstheloai = findViewById(R.id.rcv_dsplaylist);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rcv_dstheloai.setLayoutManager(manager);
        adapter = new DsTheLoaiAdapter(this);
        adapter.setData(dsEveryTrending());
        rcv_dstheloai.setAdapter(adapter);
        addplaylist=findViewById(R.id.addplaylist);
        addplaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getLayoutInflater();
                View view1= inflater.inflate(R.layout.dialog_themplaylist, null);
                builder.setView(view1);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }

    private List<TheLoai> dsEveryTrending() {
        List<TheLoai> listt1 = new ArrayList<>();
        listt1.add(new TheLoai(1, "Nhac buon", R.drawable.sao_cung_dc));
        listt1.add(new TheLoai(2, "Phuong", R.drawable.tong_phu));
        listt1.add(new TheLoai(3, "Kien", R.drawable.cuoi_hong));
        listt1.add(new TheLoai(4, "Truong", R.drawable.phao_hong));
        listt1.add(new TheLoai(5, "Hung", R.drawable.wai_ting));

        return listt1;
    }
}