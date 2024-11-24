package fit.iuh.ex1;

import java.util.HashMap;
import java.util.Map;

public class LopKiemNghiem {
    public static void main(String[] args) {
        DanhSachQuanLi dsNV = new DanhSachQuanLi();

        NhanVien nv1 = new NhanVienBanHang("A101","Nguyen Hieu Thien", "0175927452", 1800000, 25000000);
        NhanVien nv2 = new NhanVienBanHang("A102","Nguyen Duc Thuan", "0868523289", 1900000, 15000000);
        NhanVien nv3 = new NhanVienVanPhong("B101", "Nguyen Van Truong", "0137927491", 2800000, 2.5f);
        NhanVien nv4 = new NhanVienVanPhong("B102", "Tran Bich Thuan", "0137927861", 1500000, 4.5f);

        dsNV.themNhanVien(nv1);
        dsNV.themNhanVien(nv2);
        dsNV.themNhanVien(nv3);
        dsNV.themNhanVien(nv4);

        System.out.println("Danh sách các nhân viên: ");
        dsNV.getDsNhanVien().forEach(h1-> System.out.println(h1));

        Map<String, Double> statistics = dsNV.thongKeLuongTrungBinh();
        System.out.println("\nThong ke luong trung binh của nhân viên bán hàng: " + statistics.get("Lương trung bình của nhân viên bán hàng"));
        System.out.println("Thong ke luong trung binh của nhân viên văn phòng: " + statistics.get("Lương trung bình của nhân viên văn phòng"));

        System.out.println("\nDanh sách các nhân viên không có thu nhập tăng thêm: ");
        dsNV.getDSNhanVienUuTu1().forEach(h1-> System.out.println(h1));

        System.out.println("\nDanh sách các nhân viên có doanh số bán lớn nhất: ");
        dsNV.getDSNhanVienUuTu2().forEach(h1-> System.out.println(h1));

        System.out.println("\nCập nhật hệ số lương mới của nhân viên văn phòng A101: ");
        boolean kq = dsNV.capNhapNhanVien("B101", 2.8f);
        System.out.println(kq);




    }


}
