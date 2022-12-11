package com.example.fireslymusic_nhom2_cp17310.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fireslymusic_nhom2_cp17310.Activity.ChangePassword;
import com.example.fireslymusic_nhom2_cp17310.Activity.DsBaiHatYeuThichActivity;
import com.example.fireslymusic_nhom2_cp17310.Activity.ManHinhDangNhapActivity;
import com.example.fireslymusic_nhom2_cp17310.R;



public class ProfileFragment extends Fragment {
    ImageView anh ;
    TextView doimatkhau,dangxuat,doianh;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        anh.setImageURI(data.getData());
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        anh = view.findViewById(R.id.anhnguoidung);
        dangxuat=view.findViewById(R.id.dangxuat);
        doianh=view.findViewById(R.id.doianhdaidien);
        doimatkhau=view.findViewById(R.id.doimatkhau);
        doianh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermissions();
            }
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView ccc= view.findViewById(R.id.anhnguoidung);
        ccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermissions();
            }
        });

        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ManHinhDangNhapActivity.class));
            }
        });


        doimatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ChangePassword.class));
            }
        });

        return  view;
    }
    public void  requestPermissions(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(intent,"Sellect Picture"),1);
    }

}