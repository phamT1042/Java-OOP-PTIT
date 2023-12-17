package J07060;

public class CaThi {
    private String ma, gioThi, phongThi, ngayThi;

    public CaThi(int i, String ngayThi, String gioThi, String phongThi) {
        this.ma = String.format("C%03d", i);
        this.gioThi = gioThi;
        this.phongThi = phongThi;
        this.ngayThi = ngayThi;
    }

    public String getMa() {
        return ma;
    }

    public String getGioThi() {
        return gioThi;
    }

    public String getPhongThi() {
        return phongThi;
    }

    public String getNgayThi() {
        return ngayThi;
    }
}
