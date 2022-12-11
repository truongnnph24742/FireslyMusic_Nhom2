package com.example.fireslymusic_nhom2_cp17310.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fireslymusic_nhom2_cp17310.DAO.DAO_TK;
import com.example.fireslymusic_nhom2_cp17310.R;

public class ChangePassword extends AppCompatActivity {
    DAO_TK dao_tk;
    EditText matkhaucu, matkhaumoi, nhaplaimatkhaumoi;
    Button btndoi;
    SQLiteDatabase database;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doimatkhau);
        matkhaucu = findViewById(R.id.oldpass);
        matkhaumoi = findViewById(R.id.newpass);
        nhaplaimatkhaumoi = findViewById(R.id.cfpassword);
        btndoi = findViewById(R.id.change);
        btndoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPass = matkhaucu.getText().toString();
                String newPass = matkhaumoi.getText().toString();
                String rePass = nhaplaimatkhaumoi.getText().toString();
                if (newPass.equals(rePass)) {
                    SharedPreferences sharedPreferences = getSharedPreferences("TaiKhoan", MODE_PRIVATE);
                    String matk = sharedPreferences.getString("matk", "");
                    Log.d("zzzzzzzzzzzzz", "onClick: "+""+matk);
                    //cập nhật
                    DAO_TK dao_tk = new DAO_TK(ChangePassword.this);
                    boolean check = dao_tk.capNhatMatKhau(matk, oldPass, newPass);
                    if (check) {
                        Toast.makeText(ChangePassword.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ChangePassword.this, ManHinhDangNhapActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ChangePassword.this, "Thất bại! Mật khẩu cũ không đúng!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ChangePassword.this, "Mật khẩu mới chưa khớp!!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}