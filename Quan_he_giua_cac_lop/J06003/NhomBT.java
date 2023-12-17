import java.util.ArrayList;

public class NhomBT {
    private int stt;
    private String tenBT;
    private ArrayList<SinhVien> dsNhom;

    public NhomBT(int stt, String tenBT) {
        this.stt = stt;
        this.tenBT = tenBT;
        dsNhom = new ArrayList<>();
    }

    public void addSinhVien(SinhVien a) {
        dsNhom.add(a);
    }

    @Override
    public String toString() {
        String res = String.format("DANH SACH NHOM %d:\n", stt);
        for (SinhVien x : dsNhom)
            res += x.toString() + "\n";
        res += String.format("Bai tap dang ky: %s", tenBT);
        return res;
    }
}