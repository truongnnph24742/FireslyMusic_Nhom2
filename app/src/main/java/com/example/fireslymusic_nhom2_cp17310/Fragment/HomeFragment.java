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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fireslymusic_nhom2_cp17310.Activity.DsBaihatTrendingActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.DsEveyDayActivity;
import com.example.fireslymusic_nhom2_cp17310.Adapter.DSsingerAdapter;
import com.example.fireslymusic_nhom2_cp17310.Adapter.EverydayAdapter;
import com.example.fireslymusic_nhom2_cp17310.Adapter.SongAdapter;
import com.example.fireslymusic_nhom2_cp17310.Adapter.TheLoaiAdapter;
import com.example.fireslymusic_nhom2_cp17310.DTO.Everyday;
import com.example.fireslymusic_nhom2_cp17310.DTO.Singer;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.DTO.TheLoai;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    RecyclerView rcv_baihattrending,rcv_singer,rcv_theloai,rcv_every;
    DSsingerAdapter dSsingerAdapter;
    TheLoaiAdapter theLoaiAdapter;
    SongAdapter adapter;
    EverydayAdapter everydayAdapter;
    TextView txt_tatca, txt_moingay;
    Animation animation;

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

        //xử lí code list nhạc mới mỗi ngày
        rcv_every = view.findViewById(R.id.rcv_every);
        everydayAdapter = new EverydayAdapter(getContext());
        LinearLayoutManager manager3 = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rcv_every.setLayoutManager(manager3);
        everydayAdapter.setData(listMoiNgay());
        rcv_every.setAdapter(everydayAdapter);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.dis_cd);
        txt_moingay = view.findViewById(R.id.txt_moingay);
        txt_moingay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im = new Intent(getContext(), DsEveyDayActivity.class);
                startActivity(im);
            }
        });



        return view;
    }

    private List<Song> listSongTrending() {
        List<Song> list = new ArrayList<>();

        list.add(new Song(1,"Cuối Cùng Thì",R.drawable.cuoicungthi,"Jack",8));
        list.add(new Song(2,"Beautiful Monster",R.drawable.beautifumonster,"Binz & Soobin",5));
        list.add(new Song(3,"Cô Đơn Trên Sofa",R.drawable.codontrensofa,"Hồ Ngọc Hà",9));
        list.add(new Song(4,"Có Chơi Có chịu",R.drawable.cochoicochiu,"Karik",1));
        list.add(new Song(5,"Từng Là Của Nhau",R.drawable.tunglacuanhau,"Bảo Anh",6));
        list.add(new Song(6,"Ừ! Em Xin Lỗi",R.drawable.uemxinloi,"Hoàng Yến ChiBi",7));

        return list;
    }
    private List<Singer> listSinger(){
        List<Singer> list = new ArrayList<>();
        list.add(new Singer("Karik",R.drawable.karik,1));
        list.add(new Singer("Sơn Tùng MTP",R.drawable.sontung,2));
        list.add(new Singer("Mono",R.drawable.mono,3));
        list.add(new Singer("Charlie puth",R.drawable.img_1,4));
        list.add(new Singer("Binz",R.drawable.binz,5));
        list.add(new Singer("Bảo Anh",R.drawable.baoanh,6));
        list.add(new Singer("Hoàng Yến Chibi",R.drawable.hoangyenchibi,7));
        list.add(new Singer("Jack",R.drawable.jack,8));
        list.add(new Singer("Hồ Ngọc Hà",R.drawable.hongocha,9));


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
    private List<Everyday> listMoiNgay() {
        List<Everyday> listt1 = new ArrayList<>();
        listt1.add(new Everyday(1,"See you again",R.drawable.see_you));
        listt1.add(new Everyday(2,"Sao cũng được",R.drawable.sao_cung_dc));
        listt1.add(new Everyday(3,"Tòng Phu",R.drawable.tong_phu));
        listt1.add(new Everyday(4,"Cưới không chốt nha",R.drawable.cuoi_hong));
        listt1.add(new Everyday(5,"Pháo Hồng",R.drawable.phao_hong));
        listt1.add(new Everyday(6,"Waiting for you",R.drawable.wai_ting));



        return listt1;
    }

}