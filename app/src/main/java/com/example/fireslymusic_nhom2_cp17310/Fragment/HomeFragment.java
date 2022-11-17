package com.example.fireslymusic_nhom2_cp17310.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fireslymusic_nhom2_cp17310.Activity.DsBaihatTrendingActivity;
import com.example.fireslymusic_nhom2_cp17310.Adapter.DSsingerAdapter;
import com.example.fireslymusic_nhom2_cp17310.Adapter.SongAdapter;
import com.example.fireslymusic_nhom2_cp17310.Adapter.TheLoaiAdapter;
import com.example.fireslymusic_nhom2_cp17310.DTO.Singer;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.DTO.TheLoai;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    RecyclerView rcv_baihattrending,rcv_singer,rcv_theloai,rcv_singer2;
    DSsingerAdapter dSsingerAdapter;
    TheLoaiAdapter theLoaiAdapter;
    SongAdapter adapter;
    TextView txt_tatca;
    @SuppressLint({"MissingInflatedId", "ResourceType"})
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
        // Xử lí code list ca sĩ hiển thị lên rcv
        rcv_singer = view.findViewById(R.id.rcv_singer);
        dSsingerAdapter = new DSsingerAdapter(getContext());
        LinearLayoutManager manager1 = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rcv_singer.setLayoutManager(manager1);
        dSsingerAdapter.setData(listSinger());
        rcv_singer.setAdapter(dSsingerAdapter);



        // Xử lí code list thể loại hiển thị  lên rcv
        rcv_theloai = view.findViewById(R.id.rcv_theloainhac);
        theLoaiAdapter = new TheLoaiAdapter(getContext());
        LinearLayoutManager manager2 = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rcv_theloai.setLayoutManager(manager2);
        theLoaiAdapter.setData(listTheLoai());
        rcv_theloai.setAdapter(theLoaiAdapter);





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
    private List<Singer> listSinger(){
        List<Singer> list = new ArrayList<>();
        list.add(new Singer("Karik",R.drawable.karik));
        list.add(new Singer("Sơn Tùng MTP",R.drawable.sontung));
        list.add(new Singer("Mono",R.drawable.mono));
        list.add(new Singer("Charlie puth",R.drawable.img_1));
        list.add(new Singer("Binz",R.drawable.binz));
        list.add(new Singer("Bảo Anh",R.drawable.baoanh));
        list.add(new Singer("Hoàng Yến Chibi",R.drawable.hoangyenchibi));
        list.add(new Singer("Jack",R.drawable.jack));
        list.add(new Singer("Hồ Ngọc Hà",R.drawable.hongocha));


        return list;

    }
    private List<TheLoai> listTheLoai() {
        List<TheLoai> listtl = new ArrayList<>();
        listtl.add(new TheLoai(1,"Pop",R.drawable.img_6));
        listtl.add(new TheLoai(2,"Ballad",R.drawable.img_7));
        listtl.add(new TheLoai(3,"NhạcTrẻ",R.drawable.img_5));
        listtl.add(new TheLoai(4,"Rap",R.drawable.img_2));
        listtl.add(new TheLoai(5,"Us-Uk",R.drawable.img_1));

        return listtl;
    }

}