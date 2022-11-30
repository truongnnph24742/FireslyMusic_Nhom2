package com.example.fireslymusic_nhom2_cp17310.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fireslymusic_nhom2_cp17310.Adapter.SearchAdapter;
import com.example.fireslymusic_nhom2_cp17310.DTO.Search;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {
    RecyclerView rec_search;
    SearchAdapter adapter;
    SearchView searchView1;
    LinearLayout tuychon;

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
        adapter = new SearchAdapter(getContext());
        adapter.setData(listsearch());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rec_search.setLayoutManager(linearLayoutManager);
        rec_search.setAdapter(adapter);

    }

    //data
    private List<Search> listsearch() {
        List<Search> list = new ArrayList<>();
        //int id_m, String song_name, String singer, int file, int img

        list.add(new Search(1,"Cuối Cùng Thì","Jack",8,R.drawable.cuoicungthi));
        list.add(new Search(2,"Beautiful Monster","Binz & Soobin",5,R.drawable.beautifumonster));
        list.add(new Search(3,"Cô Đơn Trên Sofa","Hồ Ngọc Hà",9,R.drawable.codontrensofa));
        list.add(new Search(4,"Có Chơi Có chịu","Karik",1,R.drawable.cochoicochiu));
        list.add(new Search(5,"Từng Là Của Nhau","Bảo Anh",6,R.drawable.tunglacuanhau));
        list.add(new Search(6,"Ừ! Em Xin Lỗi","Hoàng Yến ChiBi",7,R.drawable.uemxinloi));

        list.add(new Search(7,"See you again","Wiz Khalifa",4,R.drawable.see_you));
        list.add(new Search(8,"Sao cũng được","Thành Đạt",2,R.drawable.sao_cung_dc));
        list.add(new Search(9,"Tòng Phu","KEYO",3,R.drawable.tong_phu));
        list.add(new Search(10,"Cưới không chốt nha","Út Nhị",10,R.drawable.cuoi_hong));
        list.add(new Search(11,"Pháo Hồng","Đạt Long Vinh",11,R.drawable.phao_hong));
        list.add(new Search(12,"Waiting for you","MONO",12,R.drawable.wai_ting));
        list.add(new Search(13,"A y mạc","阿衣莫",12,R.drawable.aymac1));
        list.add(new Search(14,"Thuyền quyên","Diệu kiên",12,R.drawable.thuyenquyen1));
        list.add(new Search(15,"Đốt lửa","Thế Hưng",12,R.drawable.dotlua));

        return list;
    }
    private void filterList(String text) {
        List<Search> filteredList = new ArrayList<>();
        for (Search search : listsearch()){
            if (search.getSong_name().toLowerCase().contains(text.toLowerCase())){
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