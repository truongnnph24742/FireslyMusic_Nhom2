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
import com.example.fireslymusic_nhom2_cp17310.Adapter.NhacTreAdapter;
import com.example.fireslymusic_nhom2_cp17310.Adapter.PopAdapter;
import com.example.fireslymusic_nhom2_cp17310.DTO.Category;
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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PopActivity extends AppCompatActivity {
    ImageView img_anh;
    TextView tv_listbaoanh;
    int position ;
    List<TheLoai> listv1 = new ArrayList<>();
    List<TheLoai> list;

    RecyclerView rcv_pop;
    ArrayList<Category> songlist;
    PopAdapter adapter;
    ActivityMainBinding binding;
    Handler mainHandel = new Handler();
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        rcv_pop = findViewById(R.id.rcv_pop);
        Bundle bundle = getIntent().getExtras();
        if (bundle==null){
            return;
        }
        listv1 = (List<TheLoai>) bundle.getSerializable("list");
        position = bundle.getInt("index");
        list = new ArrayList<>();
        list.addAll(listv1);
        img_anh = findViewById(R.id.img_pop);
        tv_listbaoanh = findViewById(R.id.tv_pop);
        Glide.with(this).load(list.get(position).getImgTheLoai()).into(img_anh);
        tv_listbaoanh.setText(list.get(position).getTenTheLoai());

        initializeSongList();
        new fetchData().start();
    }

    private void initializeSongList(){
        songlist = new ArrayList<>();
        adapter = new PopAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcv_pop.setLayoutManager(manager);
        adapter.setData(songlist);
        rcv_pop.setAdapter(adapter);
    }
    class fetchData extends Thread{
        String data="";
        @Override
        public void run() {
            super.run();

            mainHandel.post(new Runnable() {
                @Override
                public void run() {
                    progressDialog = new ProgressDialog(PopActivity.this);
                    progressDialog.setMessage("lấy dữ liệu");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                }
            });
            try {
                URL url = new URL("https://638f87879cbdb0dbe32a70c6.mockapi.io/api/category");
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
                        Category cates = new Category();
                        cates.setId(songss.getInt("id"));
                        cates.setId_tl(songss.getInt("id_tl"));
                        cates.setName(songss.getString("name"));
                        cates.setSinger(songss.getString("singer"));
                        cates.setImgsong(songss.getString("imgsong"));
                        cates.setFilesong(songss.getString("filesong"));
                        if(cates.getId_tl()==1){
                            songlist.add(cates);
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