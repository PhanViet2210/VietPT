package OOP;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class HangHoa {
    private final String maHang;
    protected String tenHang;
    protected int soLuongTon;
    protected double donGia;

    public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTon = Math.max(0, soLuongTon);
        this.donGia = Math.max(0, donGia);
    }

    public String getMaHang() {
        return maHang;
    }

    public abstract double tinhVAT();

    public abstract String danhGiaMucDoBanHang();

    public abstract void hienThiThongTin();
}


// Class ThucPham
class ThucPham extends HangHoa {
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private String nhaCungCap;

    public ThucPham(String maHang, String tenHang, int soLuongTon, double donGia,
                    LocalDate ngaySanXuat, LocalDate ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        if (ngayHetHan.isAfter(ngaySanXuat)) {
            this.ngaySanXuat = ngaySanXuat;
            this.ngayHetHan = ngayHetHan;
        } else {
            throw new IllegalArgumentException("Ngày hết hạn phải sau ngày sản xuất");
        }
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.08;
    }

    @Override
    public String danhGiaMucDoBanHang() {
        if (soLuongTon > 0 && LocalDate.now().isAfter(ngayHetHan)) {
            return "Hàng khó bán";
        }
        return "";
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Thực phẩm: " + tenHang + " | Mã: " + getMaHang() +
                " | SL tồn: " + soLuongTon + " | Giá: " + donGia +
                " | SX: " + ngaySanXuat + " | HSD: " + ngayHetHan +
                " | NCC: " + nhaCungCap + " | VAT: " + tinhVAT() +
                " | Đánh giá: " + danhGiaMucDoBanHang());
    }
}

// Class DienMay
class DienMay extends HangHoa {
    private int thoiGianBaoHanh;
    private double congSuat;

    public DienMay(String maHang, String tenHang, int soLuongTon, double donGia,
                   int thoiGianBaoHanh, double congSuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.thoiGianBaoHanh = Math.max(0, thoiGianBaoHanh);
        this.congSuat = Math.max(0, congSuat);
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.15;
    }

    @Override
    public String danhGiaMucDoBanHang() {
        return soLuongTon < 3 ? "Bán được hàng" : "";
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Điện máy: " + tenHang + " | Mã: " + getMaHang() +
                " | SL tồn: " + soLuongTon + " | Giá: " + donGia +
                " | BH: " + thoiGianBaoHanh + " tháng | CS: " + congSuat + " KW" +
                " | VAT: " + tinhVAT() + " | Đánh giá: " + danhGiaMucDoBanHang());
    }
}

// Class QuanAo
class QuanAo extends HangHoa {
    private String nhaSanXuat;
    private LocalDate ngayNhapKho;

    public QuanAo(String maHang, String tenHang, int soLuongTon, double donGia,
                  String nhaSanXuat, LocalDate ngayNhapKho) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.15;
    }

    @Override
    public String danhGiaMucDoBanHang() {
        long ngayLuuKho = ChronoUnit.DAYS.between(ngayNhapKho, LocalDate.now());
        if (soLuongTon > 60 && ngayLuuKho > 20) {
            return "Hàng bán chậm";
        }
        return "";
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Quần áo: " + tenHang + " | Mã: " + getMaHang() +
                " | SL tồn: " + soLuongTon + " | Giá: " + donGia +
                " | NSX: " + nhaSanXuat + " | Nhập kho: " + ngayNhapKho +
                " | VAT: " + tinhVAT() + " | Đánh giá: " + danhGiaMucDoBanHang());
    }
}

// Class QuanLyKho
class QuanLyKho {
    private List<HangHoa> danhSachHangHoa;

    public QuanLyKho() {
        danhSachHangHoa = new ArrayList<>();
    }

    public boolean themHangHoa(HangHoa hang) {
        for (HangHoa h : danhSachHangHoa) {
            if (h.getMaHang().equalsIgnoreCase(hang.getMaHang())) {
                return false;
            }
        }
        danhSachHangHoa.add(hang);
        return true;
    }

    public List<HangHoa> getDanhSachHangHoa() {
        return danhSachHangHoa;
    }

    public void inDanhSachHangHoa() {
        for (HangHoa h : danhSachHangHoa) {
            h.hienThiThongTin();
        }
    }
}