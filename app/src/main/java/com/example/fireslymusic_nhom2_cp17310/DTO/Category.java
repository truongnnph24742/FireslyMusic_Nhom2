package com.example.fireslymusic_nhom2_cp17310.DTO;

import java.io.Serializable;

public class Category implements Serializable {
    int id;
    int id_tl;
    String name;
    String singer;
    String imgsong;
    String filesong;

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_tl() {
        return id_tl;
    }

    public void setId_tl(int id_tl) {
        this.id_tl = id_tl;
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
