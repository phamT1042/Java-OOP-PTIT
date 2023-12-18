package Quan_he_giua_cac_lop.J06007;

import java.util.ArrayList;

public class GiangVien {
    private String maGV, tenGV;
    private Float tongGioChuan;
    private ArrayList<Pair<MonHoc, Float>> lopHP;

    public GiangVien(String maGV, String tenGV) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.tongGioChuan = 0f;
        this.lopHP = new ArrayList<>();
    }

    public String getMaGV() {
        return maGV;
    }

    public void addLopHP(Pair<MonHoc, Float> lopHP) {
        this.lopHP.add(lopHP);
        this.tongGioChuan += lopHP.getSoGioChuan();
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", tenGV, tongGioChuan);
    }
}
