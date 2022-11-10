package com.example.fireslymusic_nhom2_cp17310.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fireslymusic_nhom2_cp17310.DAO.DAO_TK;
import com.example.fireslymusic_nhom2_cp17310.DTO.DK;
import com.example.fireslymusic_nhom2_cp17310.R;

public class ManHinhDangKiActivity extends AppCompatActivity {
    EditText name, pass, repass;
    Button btn_dk;
    DAO_TK dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_ki);
        name = findViewById(R.id.ed_ten_dk);
        pass = findViewById(R.id.ed_pass_dk);
        repass = findViewById(R.id.ed_repass_dk);
        btn_dk = findViewById(R.id.btn_dk);
        dao = new DAO_TK(this);

        btn_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mk = pass.getText().toString();
                String remk = repass.getText().toString();
                String namee = name.getText().toString();
                if (mk.equals(remk)) {
                    boolean check = dao.themTK(namee, mk);
                    if (check) {
                        Toast.makeText(ManHinhDangKiActivity.this, "Đăng kí tài khoản thành công", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(ManHinhDangKiActivity.this, ManHinhDangNhapActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(ManHinhDangKiActivity.this, "Lỗi không đăng kí được", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(ManHinhDangKiActivity.this, "Mật khẩu phải trùng nhau", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}