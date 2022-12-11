package com.example.fireslymusic_nhom2_cp17310.DTO;

import android.os.Parcel;

import java.io.Serializable;

public class Search implements Serializable {
    int id;
    int id_ns;
    String name;
    String singer;
    String imgsong;
    String filesong;

    public Search() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ns() {
        return id_ns;
    }

    public void setId_ns(int id_ns) {
        this.id_ns = id_ns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getImgsong() {
        return imgsong;
    }

    public void setImgsong(String imgsong) {
        this.imgsong = imgsong;
    }

    public String getFilesong() {
        return filesong;
    }

    public void setFilesong(String filesong) {
        this.filesong = filesong;
    }
}
