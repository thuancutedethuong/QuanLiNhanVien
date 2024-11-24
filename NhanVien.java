package fit.iuh.ex1;

import java.text.DecimalFormat;

public abstract class NhanVien {
    protected final String maSo;
    protected String hoTen;
    protected String soDienThoai;
    protected double luongCanBan;

    public NhanVien(){
        this("", "", "", 0.0);
    }

    public NhanVien(String maSo, String hoTen, String soDienThoai, double luongCanBan) {
        this.maSo = maSo;
        this.setHoTen(hoTen);
        this.setSoDienThoai(soDienThoai);
        this.setLuongCanBan(luongCanBan);
    }

    public String getMaSo() {
        return maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        if(hoTen == null || hoTen.trim().length()==0)
            throw new RuntimeException("Ho va ten not null");
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        if(soDienThoai == null|| soDienThoai.trim().length()==0)
            throw new RuntimeException("So dien thoai not null");
        this.soDienThoai = soDienThoai;
    }

    public double getLuongCanBan() {
        return luongCanBan;
    }

    public void setLuongCanBan(double luongCanBan) {
        if(luongCanBan < 0.0)
            throw new RuntimeException("Luong can ban >= 0.0");
        this.luongCanBan = luongCanBan;
    }

    public abstract double getTienLuong();

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,#00.0 VND");
        return String.format("%s | %s | %s | %s", maSo, hoTen, soDienThoai, df.format(luongCanBan));
    }
}
