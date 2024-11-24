package fit.iuh.ex1;

import java.text.DecimalFormat;

public class NhanVienBanHang extends NhanVien{
    private int doanhSoBanHang;

    public NhanVienBanHang(){
        this("", "", "", 0.0, 0);
    }

    public NhanVienBanHang(String maSo, String hoTen, String soDienThoai, double luongCanBan, int doanhSoBanHang) {
        super(maSo, hoTen, soDienThoai, luongCanBan);
        this.setDoanhSoBanHang(doanhSoBanHang);
    }

    public int getDoanhSoBanHang() {
        return doanhSoBanHang;
    }

    public void setDoanhSoBanHang(int doanhSoBanHang) {
        if(doanhSoBanHang < 0)
            throw new RuntimeException("Doanh số bán hàng >= 0");
        this.doanhSoBanHang = doanhSoBanHang;
    }

    @Override
    public double getTienLuong() {
        double thuNhapTangThem = (doanhSoBanHang >= 20000000) ? doanhSoBanHang * 0.03 : 0.0;
        return luongCanBan + thuNhapTangThem;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###.0 VND");
        return super.toString() + " | " + df.format(getTienLuong());
    }
}
