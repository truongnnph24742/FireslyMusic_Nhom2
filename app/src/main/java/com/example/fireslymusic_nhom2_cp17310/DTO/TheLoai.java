package com.example.fireslymusic_nhom2_cp17310.DTO;

public class TheLoai {
    private  int id;
    private  String tenTheLoai;
    private int imgTheLoai;

    public TheLoai() {
    }

    public TheLoai(int id, String tenTheLoai, int imgTheLoai) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
        this.imgTheLoai = imgTheLoai;
    }

    public int getImgTheLoai() {
        return imgTheLoai;
    }

    public void setImgTheLoai(int imgTheLoai) {
        this.imgTheLoai = imgTheLoai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }
}
