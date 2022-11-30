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

import com.example.fireslymusic_nhom2_cp17310.DTO.Everyday;
import com.example.fireslymusic_nhom2_cp17310.DTO.Search;
import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BaiHatSearchActivity extends AppCompatActivity {
    TextView txt_tenbaihet, txt_tgbatdau, txt_tgketthuc,txt_tencasi;
    SeekBar tgianchay;
    ImageButton btnPrevious,btnPlay,btnNext, btnrandom, btnrepost;
    ImageView cd;
    List<Search> list;
    List<Everyday>listt;
    MediaPlayer mediaPlayer;
    int position ;
    Animation animation;
    boolean checkrandom = false, repeat = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_hat_search);
        Bundle bundle = getIntent().getExtras();
        if(bundle==null){
            return;
        }
        Search search = (Search) bundle.get("tim");
        //ánh xạ view
        position = (search.getId_m()-1);
        txt_tenbaihet = findViewById(R.id.txt_tenbaihat1);
        txt_tgbatdau = findViewById(R.id.txt_tgbatdau1);
        txt_tgketthuc = findViewById(R.id.txt_tgketthuc1);
        txt_tencasi = findViewById(R.id.txt_cassi1);
        tgianchay = findViewById(R.id.thoi_gian_chay1);
        btnPrevious = findViewById(R.id.btn_previous1);
        btnPlay = findViewById(R.id.btn_pause1);
        btnNext = findViewById(R.id.btn_skip1);
        btnrandom = findViewById(R.id.btn_random1);
        btnrepost = findViewById(R.id.btn_reptot1);
        cd = findViewById(R.id.cd1);
        // tạo danh sách bài hát
        list = new ArrayList<>();
        list.add(new Search(1,"Cuối Cùng Thì",R.drawable.cuoicungthi,"Jack",R.raw.cuoicungthi));
        list.add(new Search(2,"Beautiful Monster",R.drawable.beautifumonster,"Binz & Soobin",R.raw.beatifullmonster));
        list.add(new Search(3,"Cô Đơn Trên Sofa",R.drawable.codontrensofa,"Hồ Ngọc Hà",R.raw.codontrensofa));
        list.add(new Search(4,"Có Chơi Có chịu",R.drawable.cochoicochiu,"Karik",R.raw.con_mua_cuoi));
        list.add(new Search(5,"Từng Là Của Nhau",R.drawable.tunglacuanhau,"Phương Anh",R.raw.loi_xin_loi_vung_ve));
        list.add(new Search(6,"Ừ! Em Xin Lỗi",R.drawable.uemxinloi,"Hoàng Yến ChiBi",R.raw.uemxinloi));

        list.add(new Search(7,"See you again",R.drawable.see_you,"Wiz Khalifa",R.raw.see_you_agan));
        list.add(new Search(8,"Sao cũng được",R.drawable.sao_cung_dc,"Thành Đạt",R.raw.ngannam));
        list.add(new Search(9,"Tòng Phu",R.drawable.tong_phu,"KEYO",R.raw.tongphu));
        list.add(new Search(10,"Cưới không chốt nha",R.drawable.cuoi_hong,"Út Nhị",R.raw.cuoikhong));
        list.add(new Search(11,"Pháo Hồng",R.drawable.phao_hong,"Đạt Long Vinh",R.raw.phaohong));
        list.add(new Search(12,"Waiting for you",R.drawable.wai_ting,"MONO",R.raw.waiting_for_you));
        list.add(new Search(13,"A y mạc",R.drawable.aymac1,"阿衣莫",R.raw.aymac));
        list.add(new Search(14,"Thuyền quyên",R.drawable.thuyenquyen1,"Diệu kiên",R.raw.thuyquyen));
        list.add(new Search(15,"Đốt lửa",R.drawable.dotlua,"Thế Hưng",R.raw.dotluamusic));


        //khởi tạo
        listt = new ArrayList<>();
        listt.add(new Everyday(1,"See you agani","Charlie puth",R.drawable.see_you,R.raw.see_you_agan));
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