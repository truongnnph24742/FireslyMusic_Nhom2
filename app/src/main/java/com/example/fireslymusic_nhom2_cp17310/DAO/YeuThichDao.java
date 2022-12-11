package com.example.fireslymusic_nhom2_cp17310.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fireslymusic_nhom2_cp17310.DTO.YeuThich;
import com.example.fireslymusic_nhom2_cp17310.Mydbhelper.Data;

import java.util.ArrayList;

public class YeuThichDao {
    Data data;
    SQLiteDatabase database;

    public YeuThichDao(Context context) {
        data = new Data(context);
        database = data.getWritableDatabase();
    }

    public ArrayList<YeuThich> selectAll() {
        ArrayList<YeuThich> list = new ArrayList<>();
        String select = "SELECT * FROM YEUTHICH";
        Cursor c = database.rawQuery(select, null);
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                YeuThich yeuThich = new YeuThich();
                yeuThich.setId(c.getInt(0));
                yeuThich.setId_ns(c.getInt(1));
                yeuThich.setName(c.getString(2));
                yeuThich.setSinger(c.getString(3));
                yeuThich.setImgsong(c.getString(4));
                yeuThich.setFilesong(c.getString(5));
                list.add(yeuThich);
                c.moveToNext();
            }

        }
        return list;
    }
    public long addBaiHat(YeuThich yeuThich){
        database= data.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
//        contentValues.put("id",yeuThich.getId());
        contentValues.put("id_ns",yeuThich.getId_ns());
        contentValues.put("name",yeuThich.getName());
        contentValues.put("singer",yeuThich.getSinger());
        contentValues.put("anhbaihat",yeuThich.getImgsong());
        contentValues.put("filesong",yeuThich.getFilesong());
        long check =database.insert("YEUTHICH",null,contentValues);
        return check;
    }
    public long deleteYeuThich(String name){
        database= data.getWritableDatabase();
        String [] dk = new String[]{name};

        long check =database.delete("YEUTHICH","name=?",dk);
        return  check;
    }
}
