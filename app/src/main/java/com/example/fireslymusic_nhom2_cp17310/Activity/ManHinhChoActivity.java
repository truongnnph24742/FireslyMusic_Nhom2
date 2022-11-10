package com.example.fireslymusic_nhom2_cp17310.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.fireslymusic_nhom2_cp17310.MainActivity;
import com.example.fireslymusic_nhom2_cp17310.R;

public class ManHinhChoActivity extends AppCompatActivity {
    ImageView logo_mch;
    Animation animation;
    private String check="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_cho);
        logo_mch = findViewById(R.id.logo_mhc);
        overridePendingTransition(R.anim.anim_intent_in, R.anim.anim_intent_out);
        animation = AnimationUtils.loadAnimation(ManHinhChoActivity.this,R.anim.anim_intent_in_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logo_mch.setVisibility(View.VISIBLE);
                logo_mch.startAnimation(animation);

            }
        },1500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(check.isEmpty()){
                    startActivity(new Intent(ManHinhChoActivity.this, ManHinhDangNhapActivity.class));//chuyển vào màn hình đăng nhập

                }
            }
        },5000);

    }
}