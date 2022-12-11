package com.example.fireslymusic_nhom2_cp17310.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.fireslymusic_nhom2_cp17310.DTO.DK;
import com.example.fireslymusic_nhom2_cp17310.Mydbhelper.Data;

public class DAO_TK {
    Data data;
    static SQLiteDatabase sql;
    public DAO_TK(Context context){
        data = new Data(context);
        sql = data.getWritableDatabase();
    }
    public boolean checkDangNhap(String matk, String matkhau){
        Cursor c = sql.rawQuery("SELECT * FROM TAIKHOAN WHERE matk = ? AND matkhau = ?", new String[]{matk,matkhau});
        if(c.getCount()!=0){
            return true;
        }else {
            return false;
        }
    }
    public int capNhatPass(String username, String oldPass, String newPass){
        Cursor c = sql.rawQuery("SELECT * FROM TAIKHOAN WHERE matk= ? AND matkhau = ?", new String[]{username, oldPass});
        if (c.getCount() > 0){
            ContentValues contentValues = new ContentValues();
            contentValues.put("matkhau", newPass);
            long check = sql.update("TAIKHOAN",contentValues,"matk = ?", new String[]{username} );
            if(check == -1){
                return -1;
            }
            return 1;
        }
        return 0;
    }


    public boolean themTK(String matk,String matKhau){
        ContentValues contentValues = new ContentValues();
        contentValues.put("matk",matk);
        contentValues.put("matKhau",matKhau);
        long check = sql.insert("TAIKHOAN",null,contentValues);
        if(check==-1){
            return false;
        }
        return true;
    }
    public boolean capNhatMatKhau(String matk, String oldPass, String newPass){
        sql = this.data.getWritableDatabase();
        Cursor cursor = sql.rawQuery("SELECT * FROM TAIKHOAN WHERE matk = ? and matkhau = ?", new String[]{matk,oldPass});
        Log.d("TAG", "capNhatMatKhau: "+""+cursor );
        if (cursor.getCount() > 0 ){
            ContentValues contentValues = new ContentValues();
            contentValues.put("matkhau", newPass);
            long check = sql.update("TAIKHOAN", contentValues, "matk = ?", new String[]{matk});
            if (check == -1){
                return false;
            }
            return true;
        }
        return false;
    }
}
