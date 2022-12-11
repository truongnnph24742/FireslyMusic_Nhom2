package com.example.fireslymusic_nhom2_cp17310.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fireslymusic_nhom2_cp17310.DTO.Everyday;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BaiHatMoiActivity extends AppCompatActivity {

    TextView txt_tenbaihet, txt_tgbatdau, txt_tgketthuc,txt_tencasi;
    SeekBar tgianchay;
    ImageButton btnPrevious,btnPlay,btnNext, btnrandom, btnrepost;
    ImageView cd;
    List<Everyday> listv1 = new ArrayList<>();
    List<Everyday> list;
    MediaPlayer mediaPlayer;
    int position ;
    Animation animation;
    boolean checkrandom = false, repeat = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_hat);
        Bundle bundle = getIntent().getExtras();
        if (bundle==null){
            return;
        }
        listv1 = (List<Everyday>) bundle.getSerializable("moi");
        Log.d("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz ", "onCreate: "+listv1.size());
        position = bundle.getInt("index");
        Log.d("ccccccccccccccc", "onCreate: " +position);
        list = new ArrayList<>();
        list.addAll(listv1);
        //ánh xạ view
        txt_tenbaihet = findViewById(R.id.txt_tenbaihat);
        txt_tgbatdau = findViewById(R.id.txt_tgbatdau);
        txt_tgketthuc = findViewById(R.id.txt_tgketthuc);
        txt_tencasi = findViewById(R.id.txt_cassi);
        tgianchay = findViewById(R.id.thoi_gian_chay);
        btnPrevious = findViewById(R.id.btn_previous);
        btnPlay = findViewById(R.id.btn_pause);
        btnNext = findViewById(R.id.btn_skip);
        btnrandom = findViewById(R.id.btn_random);
        btnrepost = findViewById(R.id.btn_reptot);
        cd = findViewById(R.id.cd);
        // tạo danh sách bài hát
//        Log.d("zzzzzzzzzzzz", list.get(position).getName());
        //khởi tạo

        try {
            khoitao();
        } catch (IOException e) {
            e.printStackTrace();
        }
        animation = AnimationUtils.loadAnimation(this, R.anim.dis_cd);
        //gán sự kiện cho các nút bấm

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);
                    cd.clearAnimation();


                }else {
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
                    cd.startAnimation(animation);
                }
                SetTimeToal();
                capNhapthoigian();

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if(position > list.size() - 1){
                    position = 0;
                }

                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                try {
                    khoitao();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
                SetTimeToal();
                capNhapthoigian();
            }
        });
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                if(position < 0){
                    position = list.size() - 1;
                }

                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                try {
                    khoitao();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
                SetTimeToal();
                capNhapthoigian();
            }
        });
        btnrandom.setOnClickListener(view -> {
            if (!checkrandom){
                if (repeat){
                    repeat = false;
                    btnrandom.setImageResource(R.drawable.ic_baseline_shuffle_24);
                    btnrandom.setImageResource(R.drawable.ic_baseline_repeat_24);
                }else {
                    btnrandom.setImageResource(R.drawable.ic_baseline_shuffle_24);
                }
                checkrandom = true;
            }else {
                btnrandom.setImageResource(R.drawable.ic_baseline_shuffle_24);
                checkrandom = false;
            }

        });
        btnrepost.setOnClickListener(view -> {
            if (!repeat){
                if (checkrandom){
                    checkrandom = false;
                    btnrepost.setImageResource(R.drawable.ic_baseline_repeat_24);
                    btnrepost.setImageResource(R.drawable.ic_baseline_shuffle_24);
                }else {
                    btnrepost.setImageResource(R.drawable.ic_baseline_repeat_24);
                }
                repeat = true;
            }else {
                btnrepost.setImageResource(R.drawable.ic_baseline_repeat_24);
                repeat = false;
            }

        });
        tgianchay.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                mediaPlayer.seekTo(tgianchay.getProgress());
            }
        });




    }
    public void khoitao() throws IOException {
        Log.d("aaaaaaaaaa", list.get(position).getName());
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(list.get(position).getFilesong());
        mediaPlayer.prepare();
        txt_tenbaihet.setText(list.get(position).getName());
        txt_tencasi.setText(list.get(position).getSinger());
        Glide.with(this).load(list.get(position).getImgsong()).into(cd);

    }
    public void SetTimeToal(){
        SimpleDateFormat dinhgio = new SimpleDateFormat("mm:ss");
        txt_tgketthuc.setText(dinhgio.format(mediaPlayer.getDuration()));
        tgianchay.setMax(mediaPlayer.getDuration());
    }
    public void  capNhapthoigian(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhgio = new SimpleDateFormat("mm:ss");
                txt_tgbatdau.setText(dinhgio.format(mediaPlayer.getCurrentPosition()));

                tgianchay.setProgress(mediaPlayer.getCurrentPosition());

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++;
                        if(position > list.size() - 1){
                            position = 0;
                        }

                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        try {
                            khoitao();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        mediaPlayer.start();
                        btnPlay.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
                        SetTimeToal();
                        capNhapthoigian();
                    }
                });
                handler.postDelayed(this, 500);
            }
        }, 100);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}