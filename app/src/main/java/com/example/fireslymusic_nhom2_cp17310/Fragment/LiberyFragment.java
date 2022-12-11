package com.example.fireslymusic_nhom2_cp17310.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fireslymusic_nhom2_cp17310.Activity.DsBaiHatYeuThichActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.DsPlaylistActivity;
import com.example.fireslymusic_nhom2_cp17310.R;


public class LiberyFragment extends Fragment {

    TextView playlist,favourite;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_libery, container, false);

        favourite=view.findViewById(R.id.ds_favourite);

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DsBaiHatYeuThichActivity.class));
            }
        });
        return view;
    }
}