package com.example.fireslymusic_nhom2_cp17310.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fireslymusic_nhom2_cp17310.Activity.DsBaihatTrendingActivity;
import com.example.fireslymusic_nhom2_cp17310.Adapter.SongAdapter;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    RecyclerView rcv_baihattrending;
    SongAdapter adapter;
    TextView txt_tatca;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        // Xử lí code list bài hát trending hiển thị lên rcv
        rcv_baihattrending = view.findViewById(R.id.rcv_songtrending);
        adapter = new SongAdapter(getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rcv_baihattrending.setLayoutManager(manager);
        adapter.setData(listSongTrending());
        rcv_baihattrending.setAdapter(adapter);
        txt_tatca = view.findViewById(R.id.txt_tatca);
        txt_tatca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), DsBaihatTrendingActivity.class));
            }
        });





        return view;
    }

    private List<Song> listSongTrending() {
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