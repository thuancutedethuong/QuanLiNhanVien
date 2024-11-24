package fit.iuh.ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhSachQuanLi {
    private List<NhanVien> ds;

    public DanhSachQuanLi(){
        ds = new ArrayList<>();
    }

    public boolean themNhanVien(NhanVien nhanvien){
        if(nhanvien == null)
            throw new RuntimeException("Nhân viên đang rỗng");

        for(NhanVien nv: ds){
            if(nv.getMaSo().equalsIgnoreCase(nhanvien.getHoTen()))
                throw new RuntimeException("Trùng mã số nhân viên");
        }

        ds.add(nhanvien);
        return true;
    }

    public List<NhanVien> getDsNhanVien(){
        return ds;
    }

    public Map<String, Double> thongKeLuongTrungBinh(){
        Map<String, Double> statistics = new HashMap<>();

        double tongLuongBanHang = 0.0;
        double tongLuongVanPhong = 0.0;
        int countBanHang = 0;
        int countVanPhong = 0;

        for(NhanVien nv: ds){
            if(nv instanceof NhanVienBanHang){
                tongLuongBanHang += nv.getTienLuong();
                countBanHang++;
            }else if(nv instanceof NhanVienVanPhong){
                tongLuongVanPhong += nv.getTienLuong();
                countVanPhong++;
            }

        }

        double tienLuongTrungBinhBanHang = (countBanHang > 0) ? tongLuongBanHang/countBanHang : 0.0;
        double tienLuongTrungBinhVanPhong = (countVanPhong > 0) ? tongLuongVanPhong/countVanPhong : 0.0;
        statistics.put("Lương trung bình của nhân viên bán hàng", tienLuongTrungBinhBanHang);
        statistics.put("Lương trung bình của nhân viên văn phòng", tienLuongTrungBinhVanPhong);
        return statistics;
    }

    public List<NhanVien> getDSNhanVienUuTu1(){
//        List<NhanVien> temp = new ArrayList<>();
//        for(NhanVien nv: ds){
//            if(nv instanceof NhanVienBanHang){
//                if(((NhanVienBanHang) nv).getDoanhSoBanHang() < 20000000)
//                    temp.add(nv);
//            }
//        }
//
//        temp.sort((h1,h2)->Double.compare(((NhanVienBanHang) h1).getDoanhSoBanHang() , ((NhanVienBanHang) h2).getDoanhSoBanHang()));
//        return temp;

        // dùng stream
        return ds.stream()
                .filter(nv -> nv  instanceof NhanVienBanHang && ((NhanVienBanHang)nv).getDoanhSoBanHang() < 20000000)
                .sorted((h1,h2)->Double.compare(((NhanVienBanHang) h1).getDoanhSoBanHang(), ((NhanVienBanHang) h2).getDoanhSoBanHang()))
                .toList();
    }

    public List<NhanVien> getDSNhanVienUuTu2(){
//        double maxDoanhSo = ds.stream()
//                .filter(nv -> nv instanceof NhanVienBanHang)
//                .mapToDouble(nv -> ((NhanVienBanHang) nv).getDoanhSoBanHang())
//                .max().orElse(0);
//
//        return ds.stream()
//                .filter(nv -> nv instanceof NhanVienBanHang && ((NhanVienBanHang) nv).getDoanhSoBanHang() == maxDoanhSo)
//                .toList();

        // cách 2: cách dùng thông thường
        double maxDoanhSo = 0.0;

        for(NhanVien nv: ds){
            if(nv instanceof NhanVienBanHang){
                if(((NhanVienBanHang) nv).getDoanhSoBanHang() > maxDoanhSo)
                    maxDoanhSo = ((NhanVienBanHang) nv).getDoanhSoBanHang();
            }
        }

        List<NhanVien> temp = new ArrayList<>();
        for (NhanVien nv : ds){
            if(nv instanceof NhanVienBanHang){
                if(((NhanVienBanHang) nv).getDoanhSoBanHang() == maxDoanhSo)
                    temp.add(nv);
            }
        }
        return temp;
    }

    public boolean capNhapNhanVien(String maSo, float heSoLuongMoi) {
        for (NhanVien nv : ds) {
            if (nv instanceof NhanVienVanPhong) {
                if (nv.getMaSo().equalsIgnoreCase(maSo)) {
                    ((NhanVienVanPhong) nv).setHeSoLuong(heSoLuongMoi);
                    return true;
                }
            }
        }
        return false;
    }





}
