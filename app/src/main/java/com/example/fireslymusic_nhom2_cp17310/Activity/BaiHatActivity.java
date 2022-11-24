package com.example.fireslymusic_nhom2_cp17310.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BaiHatActivity extends AppCompatActivity {
    TextView txt_tenbaihet, txt_tgbatdau, txt_tgketthuc,txt_tencasi;
    SeekBar tgianchay;
    ImageButton btnPrevious,btnPlay,btnNext;
    ImageView cd;
    List<Song> list;
    MediaPlayer mediaPlayer;
    int position ;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_hat);
        Bundle bundle = getIntent().getExtras();
        position = (int) bundle.get("vitri");
        //ánh xạ view
        txt_tenbaihet = findViewById(R.id.txt_tenbaihat);
        txt_tgbatdau = findViewById(R.id.txt_tgbatdau);
        txt_tgketthuc = findViewById(R.id.txt_tgketthuc);
        txt_tencasi = findViewById(R.id.txt_cassi);
        tgianchay = findViewById(R.id.thoi_gian_chay);
        btnPrevious = findViewById(R.id.btn_previous);
        btnPlay = findViewById(R.id.btn_pause);
        btnNext = findViewById(R.id.btn_skip);
        cd = findViewById(R.id.cd);
        // tạo danh sách bài hát
        list = new ArrayList<>();
        list.add(new Song(1,"Cuối Cùng Thì",R.drawable.cuoicungthi,"Jack",R.raw.cuoicungthi));
        list.add(new Song(2,"Beautiful Monster",R.drawable.beautifumonster,"Binz & Soobin",R.raw.beatifullmonster));
        list.add(new Song(3,"Cô Đơn Trên Sofa",R.drawable.codontrensofa,"Hồ Ngọc Hà",R.raw.codontrensofa));
        list.add(new Song(4,"Có Chơi Có chịu",R.drawable.cochoicochiu,"Karik",R.raw.con_mua_cuoi));
        list.add(new Song(5,"Từng Là Của Nhau",R.drawable.tunglacuanhau,"Phương Anh",R.raw.loi_xin_loi_vung_ve));
        list.add(new Song(6,"Ừ! Em Xin Lỗi",R.drawable.uemxinloi,"Hoàng Yến ChiBi",R.raw.uemxinloi));
        //khởi tạo
        khoitao();
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
                khoitao();
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
                khoitao();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
                SetTimeToal();
                capNhapthoigian();
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
    public void khoitao(){
        mediaPlayer = MediaPlayer.create(this,list.get(position).getFile());
        txt_tenbaihet.setText(list.get(position).getSong_name());
        txt_tencasi.setText(list.get(position).getSinger());
        cd.setImageResource(list.get(position).getImg());
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
                        khoitao();
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
}