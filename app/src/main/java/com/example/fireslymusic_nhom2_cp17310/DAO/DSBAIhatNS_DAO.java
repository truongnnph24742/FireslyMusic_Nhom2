package com.example.fireslymusic_nhom2_cp17310.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fireslymusic_nhom2_cp17310.DTO.Song;
import com.example.fireslymusic_nhom2_cp17310.Mydbhelper.Data;

import java.util.ArrayList;

public class DSBAIhatNS_DAO {
    Data data;
    static SQLiteDatabase database;
    public DSBAIhatNS_DAO(Context context){
        data = new Data(context);
        database = data.getWritableDatabase();
    }
    public ArrayList<Song> SecletALL(int id_ns){
        ArrayList<Song> list = new ArrayList<>();
        String [] dk = new String[]{
                String.valueOf(id_ns)
        };
        Cursor cursor = database.rawQuery("SELECT * FROM BAIHAT WHERE manghesi =?  ",dk);
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Song song = new Song();
                song.setId_m(cursor.getInt(0));
                song.setSong_name(cursor.getString(1));
                song.setImg(cursor.getInt(2));
                song.setFile(Integer.parseInt(cursor.getString(3)));
                list.add(song);
                cursor.moveToNext();
            }
        }
        return list;

    }
}
