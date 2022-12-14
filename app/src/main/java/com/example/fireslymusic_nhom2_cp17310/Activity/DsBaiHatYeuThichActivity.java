package com.example.fireslymusic_nhom2_cp17310.Activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fireslymusic_nhom2_cp17310.Adapter.DsBaiHatTrendingAdapter;
import com.example.fireslymusic_nhom2_cp17310.Adapter.DsBaiHatYeuThichAdapter;
import com.example.fireslymusic_nhom2_cp17310.DAO.YeuThichDao;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.DTO.YeuThich;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.List;

public class DsBaiHatYeuThichActivity extends AppCompatActivity {

    RecyclerView rcv_dsbaihattrending;
    DsBaiHatYeuThichAdapter adapter;
    List<YeuThich> listythich = new ArrayList<>();
    List<YeuThich> yeuThichList;
    YeuThichDao dao ;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_bai_hat_yeu_thich);
        rcv_dsbaihattrending = findViewById(R.id.rcv_baihatyeuthich);
//        Bundle bundle = getIntent().getExtras();
//        if (bundle==null){
//            return;
//        }
//        listythich = (List<YeuThich>) bundle.getSerializable("listyt");
//        position = bundle.getInt("index");
//
//        yeuThichList = new ArrayList<>();
//        yeuThichList.addAll(listythich);

        dao = new YeuThichDao(this);
        listythich= dao.selectAll();
        adapter = new DsBaiHatYeuThichAdapter(listythich,this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rcv_dsbaihattrending.setLayoutManager(manager);
//        adapter.setData(listythich);
        rcv_dsbaihattrending.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

//    private List<Song> dsBaiHatTrending() {
//        List<Song> list = new ArrayList<>();
//        list.add(new Song(1,"Cu???i C??ng Th??", R.drawable.cuoicungthi,"Jack"));
//        list.add(new Song(2,"Beautiful Monster", R.drawable.beautifumonster,"Binz & Soobin"));
//        list.add(new Song(3,"C?? ????n Tr??n Sofa", R.drawable.codontrensofa,"H??? Ng???c H??"));
//        list.add(new Song(4,"C?? Ch??i C?? ch???u", R.drawable.cochoicochiu,"Karik"));
//        list.add(new Song(5,"T???ng L?? C???a Nhau", R.drawable.tunglacuanhau,"Ph????ng Anh"));
//        list.add(new Song(6,"???! Em Xin L???i", R.drawable.uemxinloi,"Ho??ng Y???n ChiBi"));
//
//        return list;
//    }
}