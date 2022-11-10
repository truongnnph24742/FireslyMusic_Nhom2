package com.example.fireslymusic_nhom2_cp17310.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fireslymusic_nhom2_cp17310.DAO.DAO_TK;
import com.example.fireslymusic_nhom2_cp17310.MainActivity;
import com.example.fireslymusic_nhom2_cp17310.R;

public class ManHinhDangNhapActivity extends AppCompatActivity {
    EditText ed_name, ed_pass;
    Button btn_sing;
    TextView txt_login;
    DAO_TK dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_nhap);
        ed_name = findViewById(R.id.ed_ten);
        ed_pass = findViewById(R.id.ed_pass);
        btn_sing = findViewById(R.id.btn_sing);
        txt_login = findViewById(R.id.txt_login);
        dao = new DAO_TK(this);
        btn_sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = ed_name.getText().toString();
                String passs = ed_pass.getText().toString();
                if(dao.checkDangNhap(user, passs)){
                    SharedPreferences sharedPreferences = getSharedPreferences("TaiKhoan", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("matk",user);
                    editor.putString("matkhau", passs);
                    editor.commit();
                    //MainActivity là màn hình chính
                    startActivity(new Intent(ManHinhDangNhapActivity.this, MainActivity.class));
                    Toast.makeText(ManHinhDangNhapActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ManHinhDangNhapActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ic = new Intent(getBaseContext(), ManHinhDangKiActivity.class);
                startActivity(ic);
            }
        });
    }
}