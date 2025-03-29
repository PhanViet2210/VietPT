package org.example;
import java.util.Scanner; // Import thư viện Scanner để nhập dữ liệu

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập Họ và Tên: ");
        String hoVaTen = scanner.nextLine(); // Dùng nextLine() để nhập cả họ và tên

        System.out.print("Nhập Ngày tháng năm sinh (dd/MM/yyyy): ");
        String ngaySinh = scanner.nextLine(); // Nhập ngày tháng năm sinh dưới dạng chuỗi

        System.out.println("\n===== Thông tin cá nhân =====");
        System.out.println("Họ và Tên: " + hoVaTen);
        System.out.println("Ngày sinh: " + ngaySinh);

        scanner.close();
    }
}
