package fit.iuh.ex1;

import java.text.DecimalFormat;

public class NhanVienVanPhong extends NhanVien{
    private float heSoLuong;

    public NhanVienVanPhong(){
        this("", "", "", 0.0, 0.0f);
    }

    public NhanVienVanPhong(String maSo, String hoTen, String soDienThoai, double luongCanBan, float heSoLuong) {
        super(maSo, hoTen, soDienThoai, luongCanBan);
        this.setHeSoLuong(heSoLuong);
    }

    public float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        if(heSoLuong < 1.86 || heSoLuong > 8.69)
            throw new RuntimeException("Hệ số lương phải >= 1.86 và <= 8.69");
        this.heSoLuong = heSoLuong;
    }

    @Override
    public double getTienLuong() {
        return luongCanBan*heSoLuong;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,#00.0 VND");
        return super.toString() + " | " + df.format(getTienLuong());
    }
}
