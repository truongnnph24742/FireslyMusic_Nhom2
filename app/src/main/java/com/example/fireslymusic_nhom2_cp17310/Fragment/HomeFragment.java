package com.example.fireslymusic_nhom2_cp17310.Fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fireslymusic_nhom2_cp17310.Activity.BaiHatActivity;
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
import com.example.fireslymusic_nhom2_cp17310.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

    ArrayList<Song> songlist;
    ArrayList<Everyday> listMoiNgay;
    Handler mainHandel = new Handler();
    Handler mainHandel2 = new Handler();
    ProgressDialog progressDialog;
    ProgressDialog progressDialog2;
    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        // Xử lí code list bài hát trending hiển thị lên rcv
        rcv_baihattrending = view.findViewById(R.id.rcv_songtrending);
        txt_moingay = view.findViewById(R.id.txt_moingay);
        rcv_every = view.findViewById(R.id.rcv_every);
        initializeSongList();
        new fetchData().start();

        nhacmoi();
        new nhacmoiData().start();

        txt_tatca = view.findViewById(R.id.txt_tatca);
        txt_tatca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBaiHatTD(songlist);
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
        txt_moingay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBaiHatMoi(listMoiNgay);
            }
        });



        return view;
    }
    private void clickBaiHatMoi(List<Everyday> moi1){
        Intent intent = new Intent(getContext(), DsEveyDayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("moi", (Serializable) moi1);
        intent.putExtras(bundle);
        getContext().startActivity(intent);
    }
    private void clickBaiHatTD(List<Song> song1){
        Intent intent = new Intent(getContext(), DsBaihatTrendingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", (Serializable) song1);
        intent.putExtras(bundle);
        getContext().startActivity(intent);


    }
    private void initializeSongList(){
        songlist = new ArrayList<>();
        adapter = new SongAdapter(getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rcv_baihattrending.setLayoutManager(manager);
        adapter.setData(songlist);
        rcv_baihattrending.setAdapter(adapter);
    }
    class fetchData extends Thread{
        String data="";
        @Override
        public void run() {
            super.run();

            mainHandel.post(new Runnable() {
                @Override
                public void run() {
                    progressDialog = new ProgressDialog(getContext());
                    progressDialog.setMessage("lấy dữ liệu");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                }
            });
            try {
                URL url = new URL("http://638b3fb17220b45d228b915b.mockapi.io/song");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    data = data+line;
                }
                if (!data.isEmpty()){
                    JSONArray songs = new JSONArray(data);
                    songlist.clear();
                    for (int i = 0;i< songs.length();i++){
                        JSONObject songss = songs.getJSONObject(i);
                        Song song = new Song();
                        song.setId(songss.getInt("id"));
                        song.setId_ns(songss.getInt("id_ns"));
                        song.setName(songss.getString("name"));
                        song.setSinger(songss.getString("singer"));
                        song.setImgsong(songss.getString("imgsong"));
                        song.setFilesong(songss.getString("filesong"));
                        songlist.add(song);
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mainHandel.post(new Runnable() {
                @Override
                public void run() {
                    if (progressDialog.isShowing()){
                        progressDialog.dismiss();
                    }
                    adapter.notifyDataSetChanged();
                }
            });
        }
    }
    private void nhacmoi(){
        listMoiNgay = new ArrayList<>();
        everydayAdapter = new EverydayAdapter(getContext());
        LinearLayoutManager manager5 = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rcv_every.setLayoutManager(manager5);
        everydayAdapter.setData(listMoiNgay);
        rcv_every.setAdapter(everydayAdapter);
    }
    class nhacmoiData extends Thread{
        String data="";
        @Override
        public void run() {
            super.run();

            mainHandel2.post(new Runnable() {
                @Override
                public void run() {
                    progressDialog2 = new ProgressDialog(getContext());
                    progressDialog2.setMessage("lấy dữ liệu");
                    progressDialog2.setCancelable(false);
                    progressDialog2.show();
                }
            });
            try {
                URL url = new URL("http://638de830aefc455fb2af375b.mockapi.io/nhacmoi/everyday");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    data = data+line;
                }
                if (!data.isEmpty()){
                    JSONArray songs = new JSONArray(data);
                    songlist.clear();
                    for (int i = 0;i< songs.length();i++){
                        JSONObject songss = songs.getJSONObject(i);
                        Everyday moi = new Everyday();
                        moi.setId(songss.getInt("id"));
                        moi.setId_ns(songss.getInt("id_ns"));
                        moi.setName(songss.getString("name"));
                        moi.setSinger(songss.getString("singer"));
                        moi.setImgsong(songss.getString("imgsong"));
                        moi.setFilesong(songss.getString("filesong"));
                        listMoiNgay.add(moi);
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mainHandel2.post(new Runnable() {
                @Override
                public void run() {
                    if (progressDialog2.isShowing()){
                        progressDialog2.dismiss();
                    }
                    everydayAdapter.notifyDataSetChanged();
                }
            });
        }
    }
    private List<Singer> listSinger(){
        List<Singer> list = new ArrayList<>();
        list.add(new Singer("KARIK",R.drawable.karik,1));
        list.add(new Singer("SƠN TÙNG MTP",R.drawable.sontung,2));
        list.add(new Singer("MONO",R.drawable.mono,3));
        list.add(new Singer("CHARLIE PUTH",R.drawable.img_1,4));
        list.add(new Singer("BINZ",R.drawable.binz,5));
        list.add(new Singer("BẢO ANH",R.drawable.baoanh,6));
        list.add(new Singer("HOÀNG THÙY LINH",R.drawable.hoangthuylinh,7));
        list.add(new Singer("JACK",R.drawable.jack,8));
        list.add(new Singer("TĂNG PHÚC",R.drawable.tangphuc,9));
        return list;
    }
    private List<TheLoai> listTheLoai() {
        List<TheLoai> listtl = new ArrayList<>();
        listtl.add(new TheLoai(1,"POP",R.drawable.img_6));
        listtl.add(new TheLoai(2,"BALLAD",R.drawable.img_7));
        listtl.add(new TheLoai(3,"NHẠC TRẺ",R.drawable.img_5));
        listtl.add(new TheLoai(4,"RAP",R.drawable.img_2));
        listtl.add(new TheLoai(5,"US-UK",R.drawable.img_1));
        return listtl;
    }


}