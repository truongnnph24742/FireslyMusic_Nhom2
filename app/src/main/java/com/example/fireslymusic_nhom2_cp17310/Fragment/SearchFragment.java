package com.example.fireslymusic_nhom2_cp17310.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fireslymusic_nhom2_cp17310.Adapter.SearchAdapter;
import com.example.fireslymusic_nhom2_cp17310.Adapter.SongAdapter;
import com.example.fireslymusic_nhom2_cp17310.DTO.Everyday;
import com.example.fireslymusic_nhom2_cp17310.DTO.Search;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
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


public class SearchFragment extends Fragment {
    RecyclerView rec_search;
    SearchAdapter adapter;
    SearchView searchView1;
    LinearLayout tuychon;

    ArrayList<Search> songlist;

    Handler mainHandel = new Handler();

    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_search, container, false);
         return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rec_search = view.findViewById(R.id.rec_search);
        tuychon = view.findViewById(R.id.tuychon);
        tuychon.setVisibility(View.VISIBLE);
        searchView1 = view.findViewById(R.id.search_view);
        searchView1.clearFocus();
        searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.toLowerCase().isEmpty()){
                    tuychon.setVisibility(View.VISIBLE);
                }else {
                    tuychon.setVisibility(View.GONE);
                    filterList(newText);
                }

                return true;
            }


        });
        initializeSongList();
        new fetchData().start();


    }
    private void initializeSongList(){
        songlist = new ArrayList<>();
        adapter = new SearchAdapter(getContext());
        adapter.setData(songlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rec_search.setLayoutManager(linearLayoutManager);
        rec_search.setAdapter(adapter);
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
                        Search search1 = new Search();
                        search1.setId(songss.getInt("id"));
                        search1.setId_ns(songss.getInt("id_ns"));
                        search1.setName(songss.getString("name"));
                        search1.setSinger(songss.getString("singer"));
                        search1.setImgsong(songss.getString("imgsong"));
                        search1.setFilesong(songss.getString("filesong"));
                        songlist.add(search1);
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
    private void filterList(String text) {
        List<Search> filteredList = new ArrayList<>();
        for (Search search : songlist){
            if (search.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(search);
            }
        }
        if (filteredList.isEmpty()){
//            Toast.makeText(getContext(), "Không có bài hát cần tìm", Toast.LENGTH_SHORT).show();

        }else {
            adapter.setData(filteredList);
        }
    }
}