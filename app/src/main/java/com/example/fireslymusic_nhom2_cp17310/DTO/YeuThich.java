package com.example.fireslymusic_nhom2_cp17310.DTO;

import java.io.Serializable;

public class YeuThich implements Serializable {
    int id;
    int id_ns;
    String name;
    String singer;
    String imgsong;
    String filesong;

    public YeuThich(int id, int id_ns, String name, String singer, String imgsong, String filesong) {
        this.id = id;
        this.id_ns = id_ns;
        this.name = name;
        this.singer = singer;
        this.imgsong = imgsong;
        this.filesong = filesong;
    }

    public YeuThich() {
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
