package com.example.fireslymusic_nhom2_cp17310.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fireslymusic_nhom2_cp17310.Adapter.ChiTietCaSiAdapter;
import com.example.fireslymusic_nhom2_cp17310.Adapter.MoNoAdapter;
import com.example.fireslymusic_nhom2_cp17310.DTO.Casi;
import com.example.fireslymusic_nhom2_cp17310.DTO.Singer;
import com.example.fireslymusic_nhom2_cp17310.R;
import com.example.fireslymusic_nhom2_cp17310.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MonoActivity extends AppCompatActivity {
    ImageView img_anh;
    TextView tv_charlies;
    int position ;
    List<Singer> listv1 = new ArrayList<>();
    List<Singer> list;

    RecyclerView rcv_mono;
    ArrayList<Casi> songlist;
    MoNoAdapter adapter;
    ActivityMainBinding binding;
    Handler mainHandel = new Handler();

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mono);
        rcv_mono = findViewById(R.id.rcv_mono);
        Bundle bundle = getIntent().getExtras();
        if (bundle==null){
            return;
        }
        listv1 = (List<Singer>) bundle.getSerializable("list");
        position = bundle.getInt("index");
        list = new ArrayList<>();
        list.addAll(listv1);
        img_anh = findViewById(R.id.img_mono);
        tv_charlies = findViewById(R.id.tv_mono);
        Glide.with(this).load(list.get(position).getImg_singer()).into(img_anh);
        tv_charlies.setText(list.get(position).getSinger_name());
        initializeSongList();
        new fetchData().start();
    }
    private void initializeSongList(){
        songlist = new ArrayList<>();
        adapter = new MoNoAdapter(MonoActivity.this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcv_mono.setLayoutManager(manager);
        adapter.setData(songlist);
        rcv_mono.setAdapter(adapter);
    }
    class fetchData extends Thread{
        String data="";
        @Override
        public void run() {
            super.run();

            mainHandel.post(new Runnable() {
                @Override
                public void run() {
                    progressDialog = new ProgressDialog(MonoActivity.this);
                    progressDialog.setMessage("lấy dữ liệu");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                }
            });
            try {
                URL url = new URL("http://638f85414ddca317d7fb8bbd.mockapi.io/api/singer");
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
                        Casi casi = new Casi();
                        casi.setId(songss.getInt("id"));
                        casi.setId_ns(songss.getInt("id_ns"));
                        casi.setName(songss.getString("name"));
                        casi.setSinger(songss.getString("singer"));
                        casi.setImgsong(songss.getString("imgsong"));
                        casi.setFilesong(songss.getString("filesong"));
                        if(casi.getId_ns()==3){
                            songlist.add(casi);
                        }
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
}