package org.example;
import java.util.Scanner; // Import thư viện để nhập từ bàn phím

public class Bai2 {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập hai số nguyên a và b
        System.out.print("Nhập số nguyên a: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số nguyên b: ");
        int b = scanner.nextInt();

        // Tính toán
        int tong = a + b;
        int hieu = a - b;
        int tich = a * b;
        int thuong = (b != 0) ? (a / b) : 0; // Kiểm tra b khác 0 để tránh lỗi chia cho 0
        int phanDu = (b != 0) ? (a % b) : 0;

        // Hiển thị kết quả
        System.out.println("Tổng: " + tong);
        System.out.println("Hiệu: " + hieu);
        System.out.println("Tích: " + tich);

        if (b != 0) {
            System.out.println("Thương: " + thuong);
            System.out.println("Phần dư: " + phanDu);
        } else {
            System.out.println("Không thể chia cho 0!");
        }

        // Đóng Scanner
        scanner.close();
    }
}
