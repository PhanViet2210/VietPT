package OOP;

import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        QuanLyKho kho = new QuanLyKho();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Thêm Thực Phẩm");
            System.out.println("2. Thêm Điện Máy");
            System.out.println("3. Thêm Quần Áo");
            System.out.println("4. In danh sách hàng hóa");
            System.out.print("Chọn: ");
            int chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    themThucPham(sc, kho);
                    break;
                case 2:
                    themDienMay(sc, kho);
                    break;
                case 3:
                    themQuanAo(sc, kho);
                    break;
                case 4:
                    kho.inDanhSachHangHoa();
                    System.exit(0);
                default:
                    System.out.println("Sai lựa chọn, nhập lại.");
            }
        }
    }

    private static String nhapMaHang(Scanner sc, QuanLyKho kho) {
        while (true) {
            System.out.print("Nhập mã hàng: ");
            String ma = sc.nextLine();
            boolean tonTai = kho.getDanhSachHangHoa().stream()
                    .anyMatch(h -> h.getMaHang().equalsIgnoreCase(ma));
            if (!tonTai) return ma;
            System.out.println("Mã hàng đã tồn tại, nhập lại.");
        }
    }

    private static void themThucPham(Scanner sc, QuanLyKho kho) {
        try {
            String ma = nhapMaHang(sc, kho);
            System.out.print("Tên hàng: ");
            String ten = sc.nextLine();
            System.out.print("Số lượng tồn: ");
            int sl = sc.nextInt();
            System.out.print("Đơn giá: ");
            double gia = sc.nextDouble();
            sc.nextLine();
            System.out.print("Ngày sản xuất (yyyy-MM-dd): ");
            LocalDate nsx = LocalDate.parse(sc.nextLine());
            System.out.print("Ngày hết hạn (yyyy-MM-dd): ");
            LocalDate nhh = LocalDate.parse(sc.nextLine());
            System.out.print("Nhà cung cấp: ");
            String ncc = sc.nextLine();

            ThucPham tp = new ThucPham(ma, ten, sl, gia, nsx, nhh, ncc);
            kho.themHangHoa(tp);
            System.out.println("Đã thêm thực phẩm.");
        } catch (Exception e) {
            System.out.println("Giá trị nhập không hợp lệ: " + e.getMessage());
        }
    }

    private static void themDienMay(Scanner sc, QuanLyKho kho) {
        try {
            String ma = nhapMaHang(sc, kho);
            System.out.print("Tên hàng: ");
            String ten = sc.nextLine();
            System.out.print("Số lượng tồn: ");
            int sl = sc.nextInt();
            System.out.print("Đơn giá: ");
            double gia = sc.nextDouble();
            System.out.print("Thời gian bảo hành (tháng): ");
            int bh = sc.nextInt();
            System.out.print("Công suất (KW): ");
            double cs = sc.nextDouble();
            sc.nextLine();

            DienMay dm = new DienMay(ma, ten, sl, gia, bh, cs);
            kho.themHangHoa(dm);
            System.out.println("Đã thêm điện máy.");
        } catch (Exception e) {
            System.out.println("Giá trị nhập không hợp lệ: " + e.getMessage());
        }
    }

    private static void themQuanAo(Scanner sc, QuanLyKho kho) {
        try {
            String ma = nhapMaHang(sc, kho);
            System.out.print("Tên hàng: ");
            String ten = sc.nextLine();
            System.out.print("Số lượng tồn: ");
            int sl = sc.nextInt();
            System.out.print("Đơn giá: ");
            double gia = sc.nextDouble();
            sc.nextLine();
            System.out.print("Nhà sản xuất: ");
            String nsx = sc.nextLine();
            System.out.print("Ngày nhập kho (yyyy-MM-dd): ");
            LocalDate ngayNhap = LocalDate.parse(sc.nextLine());

            QuanAo qa = new QuanAo(ma, ten, sl, gia, nsx, ngayNhap);
            kho.themHangHoa(qa);
            System.out.println("Đã thêm quần áo.");
        } catch (Exception e) {
            System.out.println("Giá trị nhập không hợp lệ: " + e.getMessage());
        }
    }
}
