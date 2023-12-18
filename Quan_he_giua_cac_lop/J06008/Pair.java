package Quan_he_giua_cac_lop.J06008;

public class Pair<T1, T2> {
    private T1 monHoc;
    private T2 soGioChuan;

    public Pair(T1 monHoc, T2 soGioChuan) {
        this.monHoc = monHoc;
        this.soGioChuan = soGioChuan;
    }

    public T2 getSoGioChuan() {
        return soGioChuan;
    }

    public T1 getMonHoc() {
        return monHoc;
    }
}
