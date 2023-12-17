package J07060;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LichThi implements Comparable<LichThi> {
    private String maCaThi, maMonThi, maNhomLop, soSinhVien;
    private MonThi monThi;
    private CaThi caThi;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public LichThi(String maCaThi, String maMonThi, String maNhomLop, String soSinhVien) {
        this.maCaThi = maCaThi;
        this.maMonThi = maMonThi;
        this.maNhomLop = maNhomLop;
        this.soSinhVien = soSinhVien;
    }

    public String getMaCaThi() {
        return maCaThi;
    }

    public String getMaMonThi() {
        return maMonThi;
    }

    public void setMonThi(MonThi monThi) {
        this.monThi = monThi;
    }

    public void setCaThi(CaThi caThi) {
        this.caThi = caThi;
    }

    @Override
    public int compareTo(LichThi o) {
        if (this.caThi.getNgayThi().equals(o.caThi.getNgayThi())) {
            if (this.caThi.getGioThi().equals(o.caThi.getGioThi())) {
                return this.caThi.getMa().compareTo(o.caThi.getMa());
            }
            return this.caThi.getGioThi().compareTo(o.caThi.getGioThi());
        }
        
        try {
            Date d1 = sdf.parse(this.caThi.getNgayThi());
            Date d2 = sdf.parse(this.caThi.getNgayThi());
            return d1.compareTo(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s", this.caThi.getNgayThi(), this.caThi.getGioThi(), this.caThi.getPhongThi(), this.monThi.getTen(), this.maNhomLop, this.soSinhVien);
    }
    
}
