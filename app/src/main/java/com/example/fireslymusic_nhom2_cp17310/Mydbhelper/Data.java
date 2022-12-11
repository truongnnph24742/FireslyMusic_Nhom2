package com.example.fireslymusic_nhom2_cp17310.Mydbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Data extends SQLiteOpenHelper {
    final  static  String NameDB = "music.1";
    final static  int Inte = 1;

    public Data(Context context){
        super(context, NameDB, null, Inte);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TaiKhoan = " CREATE TABLE TAIKHOAN ( matk text primary key , hoTen text , matkhau text ) " ;
        db.execSQL ( TaiKhoan ) ;
        db.execSQL ( " INSERT INTO TAIKHOAN VALUES  ( 'admin' , 'abc123' , 'a1234567' ) " ) ;
        String NgheSi = "CREATE TABLE NGHESI(manghesi integer primary key autoincrement , tennghesi text ,anhnghesi integer )";
        db.execSQL(NgheSi);
        String YeuThich = "CREATE TABLE YEUTHICH(id integer  ,id_ns integer, name text,singer text , anhbaihat text , filesong text)";
        db.execSQL(YeuThich);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS TAIKHOAN");
            onCreate(db);

        }
    }
}
