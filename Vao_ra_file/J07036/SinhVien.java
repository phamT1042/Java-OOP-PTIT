package J07036;

public class SinhVien {
    private String maSV, tenSV, lop, email;

    public SinhVien(String maSV, String tenSV, String lop, String email) {
        this.maSV = maSV;
        this.tenSV = chuanHoa(tenSV);
        this.lop = lop;
        this.email = email;
    }

    private static String chuanHoa(String name) {
        String tach[] = name.trim().split("\\s+");
        String res = "";
        for (String x : tach) 
            res += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        return res.trim();
    }

    public String getMaSV() {
        return maSV;
    }

    public String getLop() {
        return lop;
    }

    public String getTenSV() {
        return tenSV;
    }
}
