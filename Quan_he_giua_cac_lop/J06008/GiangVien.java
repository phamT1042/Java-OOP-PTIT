package Quan_he_giua_cac_lop.J06008;

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
        String res = "Giang vien: " + this.tenGV + "\n";
        for (Pair x : this.lopHP) 
            res += ((MonHoc) x.getMonHoc()).getTenMon() + " " + x.getSoGioChuan() + "\n";
        res += String.format("Tong: %.2f", this.tongGioChuan);
        return res;
    }
}
